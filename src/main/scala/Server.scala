package org.john.shopping

import database.{PostgresProfile, Tables}
import graphql.SchemaFactory
import repositories.ProductRepository
import utilities.CorsSupport

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.StatusCodes._
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.stream.alpakka.slick.scaladsl.SlickSession
import sangria.execution.{ErrorWithResolver, Executor, QueryReducingError}
import sangria.http.akka.circe.CirceHttpSupport
import sangria.marshalling.circe._
import sangria.slowlog.SlowLog
import slick.basic.DatabaseConfig
import slick.jdbc.JdbcProfile

import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

object Server extends App with CorsSupport with CirceHttpSupport {
  implicit val system: ActorSystem = ActorSystem("sangria-system")
  val slickSession = SlickSession.forConfig {
    DatabaseConfig.forConfig[JdbcProfile]("slick")
  }
  val tables = new Tables(slickSession.profile.asInstanceOf[PostgresProfile])

  val route: Route =
    optionalHeaderValueByName("X-Apollo-Tracing") { tracing =>
      path("graphql") {
        graphQLPlayground ~
          prepareGraphQLRequest {
            case Success(req) =>
              val middleware = if (tracing.isDefined) SlowLog.apolloTracing :: Nil else Nil
//              val deferredResolver = DeferredResolver.fetchers(SchemaFactory.characters)
              val graphQLResponse = Executor.execute(
                schema = SchemaFactory.ShoppingSchema,
                queryAst = req.query,
                userContext = new ProductRepository(slickSession=slickSession, tables = tables),
                variables = req.variables,
                operationName = req.operationName,
                middleware = middleware,
//                deferredResolver = deferredResolver
              ).map(OK -> _)
                .recover {
                  case error: QueryReducingError => BadRequest -> error.resolveError
                  case error: ErrorWithResolver => InternalServerError -> error.resolveError
                }
              complete(graphQLResponse)
            case Failure(preparationError) => complete(BadRequest, formatError(preparationError))
          }
      }
    } ~
      (get & pathEndOrSingleSlash) {
        redirect("/graphql", PermanentRedirect)
      }

  val PORT = sys.props.get("http.port").fold(8080)(_.toInt)
  val INTERFACE = "0.0.0.0"
  println("Server running on port 8080")
  Http().newServerAt(INTERFACE, PORT).bindFlow(corsHandler(route))
}

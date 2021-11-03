package org.john.shopping
package graphql

import graphql.CommonArguments._
import graphql.modules._
import graphql.types.ProductDefinition.ProductType
import repositories.ProductRepository

import akka.stream.Materializer
import com.google.inject.{Inject, Singleton}
import sangria.schema._

import scala.concurrent.ExecutionContext


@Singleton
class SchemaFactory @Inject()(executionContext: ExecutionContext, materializer: Materializer) {
  def get(): Schema[Ctx, Unit] = {
    val modules = List(User, Product)
    val QueryType = ObjectType("Query", modules.flatMap(_.queryFields))
    Schema(QueryType)
  }

  /*val Query: ObjectType[ProductRepository, Unit] =
    ObjectType("Query", fields[ProductRepository, Unit](
      Field(
        "products",
        ListType(ProductType),
        resolve = req => req.ctx.getProducts
      ),
      Field(
        "product",
        OptionType(ProductType),
        arguments = idArg :: Nil,
        resolve = req => req.ctx.getProduct(req.arg(idArg))
      ),
  ))*/

//  val ShoppingSchema: Schema[ProductRepository, Unit] = Schema(Query)
}

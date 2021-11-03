package org.john.shopping
package graphql

import akka.stream.Materializer
import com.google.inject.Injector
import org.john.shopping.models.timezone.Timezone
import org.john.shopping.repositories.{ProductRepository, UserRepository}
import org.john.shopping.services.Configuration

import scala.concurrent.ExecutionContext

trait Ctx {
  val injector: Injector
  implicit val materializer: Materializer
  implicit val executionContext: ExecutionContext

  def timezone: Timezone
}

trait UserCtx extends Ctx {
  implicit val userRepository: UserRepository
  implicit val productRepository: ProductRepository
  implicit val configuration: Configuration

  override def timezone: Timezone = configuration.getTimezone
}

case class AnonymousUserCtx(injector: Injector, userRepository: UserRepository,
                            productRepository: ProductRepository,
                            configuration: Configuration)
                           (implicit val materializer: Materializer, val executionContext: ExecutionContext) extends Ctx {
  override def timezone: Timezone = configuration.getTimezone
}


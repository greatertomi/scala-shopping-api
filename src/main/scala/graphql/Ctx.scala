package org.john.shopping
package graphql

import models.timezone.Timezone
import repositories.{ProductRepository, UserRepository}
import services.Configuration

import akka.stream.Materializer
import com.google.inject.Injector

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

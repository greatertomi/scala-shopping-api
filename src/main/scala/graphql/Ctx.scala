package org.john.shopping
package graphql

import akka.stream.Materializer
import com.google.inject.Injector

import java.util.TimeZone
import scala.concurrent.ExecutionContext

trait Ctx {
  val injector: Injector
  implicit val materializer: Materializer
  implicit val executionContext: ExecutionContext

  def timezone: TimeZone
}

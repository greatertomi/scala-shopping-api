package org.john.shopping
package services

import akka.stream.Materializer
import com.google.inject.{Inject, Injector}
import io.circe.Json
import org.john.shopping.models.timezone.Timezone

import scala.concurrent.ExecutionContext

trait HasTimeZone {
  def getTimezone: Timezone
}

class Configuration @Inject()(injector: Injector)
                             (implicit materializer: Materializer, executionContext: ExecutionContext) extends HasTimeZone {
  private var configuration: Option[Json] = None

  def getTimezone: Timezone =
    Timezone.fromTimezoneId(configuration.flatMap(_.hcursor.downField("timezoneId").as[String].toOption).getOrElse(Configuration.defaultTimezoneId))
}

object Configuration {
  val defaultTimezoneId: String = "US/Pacific"
}

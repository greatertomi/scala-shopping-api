package org.john.shopping
package models.timezone

import org.joda.time.DateTimeZone

import java.time.ZoneId

case class Timezone(id: String, name: String, offset: Option[Long]) {
  lazy val dateTimeZone: DateTimeZone = DateTimeZone.forID(id);
}

object Timezone {
  private val allowed = "Etc" :: "UTC" :: "US" :: "Europe" :: Nil
  def fromTimezoneId(timezoneId: String): Timezone = Timezone(timezoneId, timezoneId, None)
  def getAvailableZones: List[Timezone] = {
    val ids = ZoneId.getAvailableZoneIds
    ids.toArray
      .map(_.asInstanceOf[String])
      .filter(id => allowed.exists(id.startsWith))
      .sorted
      .map(id => Timezone(id, id, None))
      .toList
  }
}

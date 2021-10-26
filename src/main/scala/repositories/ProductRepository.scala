package org.john.shopping
package repositories

import akka.stream.alpakka.slick.scaladsl.SlickSession
import com.google.inject.Inject
import database.Tables
import database.Product

import scala.concurrent.Future

class ProductRepository @Inject()(slickSession: SlickSession, tables: Tables) {
  import slick.jdbc.PostgresProfile.api._
  import tables._

  def getProducts: Future[Seq[Product]] = slickSession.db run {
    Products.result
  }
}


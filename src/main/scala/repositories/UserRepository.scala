package org.john.shopping
package repositories

import akka.stream.alpakka.slick.scaladsl.SlickSession
import database.{Tables, User}

import javax.inject.Inject
import scala.concurrent.Future

class UserRepository @Inject() (slickSession: SlickSession, tables: Tables) {
  import slick.jdbc.PostgresProfile.api._
  import tables._

  def getUsers: Future[Seq[User]] = slickSession.db run {
    Users.result
  }
}

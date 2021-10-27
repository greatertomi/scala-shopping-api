package org.john.shopping
package database
import slick.jdbc.PostgresProfile

case class Product (id: Int, name: String, description: String, status: String, price: Int,
                    currentQuantity: Int, createdBy: Option[String], createdDate: String)

case class User (id: Int, name: String, email: String, password: String, userType: String,
                 createdDate: String, active: Boolean)

class Tables (val jdbcProfile: PostgresProfile) {
  import jdbcProfile.api._

  object schema {
    class Products(tag: Tag) extends Table[Product](tag, "products") {
      def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
      def name = column[String]("name")
      def description = column[String]("description")
      def status = column[String]("status")
      def price = column[Int]("price")
      def currentQuantity = column[Int]("currentQuantity")
      def createdBy = column[Option[String]]("createdBy")
      def createdDate = column[String]("createdDate")

      def * = (id, name, description, status, price, currentQuantity, createdBy, createdDate) <> (Product.tupled, Product.unapply)
    }

    class Users(tag: Tag) extends Table[User](tag, "users") {
      def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
      def name = column[String]("name")
      def email = column[String]("email")
      def password = column[String]("password")
      def userType = column[String]("userType")
      def createdDate = column[String]("createdDate")
      def active = column[Boolean]("active")

      def * = (id, name, email, password, userType, createdDate, active) <> (User.tupled, User.unapply)
    }
  }

  val Products = TableQuery[schema.Products]
  val Users = TableQuery[schema.Users]
}

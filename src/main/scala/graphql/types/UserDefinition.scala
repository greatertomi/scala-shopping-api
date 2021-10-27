package org.john.shopping
package graphql.types

import database.User
import sangria.schema._

object UserDefinition {
  val UserType: ObjectType[Unit, User] = ObjectType(
    "User",
    "The user of the app",
    fields[Unit, User](
      Field("id", IntType, resolve = _.value.id),
      Field("name", StringType, resolve = _.value.name),
      Field("email", StringType, resolve = _.value.email),
      Field("password", StringType, resolve = _.value.password),
      Field("userType", StringType, resolve = _.value.userType),
      Field("createdDate", StringType, resolve = _.value.createdDate),
      Field("active", BooleanType, resolve = _.value.active),
    )
  )
}

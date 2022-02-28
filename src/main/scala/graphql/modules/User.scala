package org.john.shopping
package graphql.modules

import graphql.types.UserDefinition.UserType
import graphql.{Ctx, Module}

import sangria.schema._

object User extends Module {
  import graphql.CtxImplicits._
  override val queryFields: List[Field[Ctx, Unit]] = fields(
    Field(
      "users",
      ListType(UserType),
      // TODO Update Ctx so that is has user repository which can get users from the db
      resolve = implicit req => ???, // ctx.userRepository.getUsers
    )
  )
}

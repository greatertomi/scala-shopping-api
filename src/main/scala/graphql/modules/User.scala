package org.john.shopping
package graphql.modules

import graphql.types.UserDefinition.UserType
import repositories.UserRepository

import graphql.Module

import sangria.schema._

class User extends Module {
  override val queryFields: List[Field[UserRepository, Unit]] = fields(
    Field(
      "users",
      ListType(UserType),
      resolve = req => req.ctx.getUsers
    )
  )
}

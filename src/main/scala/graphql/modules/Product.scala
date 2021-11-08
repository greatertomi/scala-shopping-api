package org.john.shopping
package graphql.modules

import graphql.{Ctx, Module}

import sangria.schema._

object Product extends Module {

  override val queryFields: List[Field[Ctx, Unit]] = fields(
    Field(
      "products",
      StringType,
      resolve = req => "Hello from graphQL"
    )
  )
}

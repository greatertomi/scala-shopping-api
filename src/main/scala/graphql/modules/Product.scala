package org.john.shopping
package graphql.modules

import graphql.Module

import sangria.schema._

class Product extends Module {
  override val queryFields: List[Field[Unit, Unit]] = fields(
    Field(
      "products",
      StringType,
      resolve = req => "Hello from graphQL"
    )
  )
}

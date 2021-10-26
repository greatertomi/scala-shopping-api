package org.john.shopping
package graphql

import graphql.types.ProductDefinition.ProductType
import repositories.ProductRepository

import sangria.schema._


object SchemaFactory {
  val Query: ObjectType[ProductRepository, Unit] =
    ObjectType("Query", fields[ProductRepository, Unit](
    Field(
      "products",
      ListType(ProductType),
      resolve = req => req.ctx.getProducts
    )
  ))

  val ShoppingSchema: Schema[ProductRepository, Unit] = Schema(Query)
}

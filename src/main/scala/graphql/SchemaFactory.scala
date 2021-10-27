package org.john.shopping
package graphql

import graphql.types.ProductDefinition.ProductType
import repositories.ProductRepository

import graphql.CommonArguments._
import sangria.schema._

object SchemaFactory {
  val Query: ObjectType[ProductRepository, Unit] =
    ObjectType("Query", fields[ProductRepository, Unit](
      Field(
        "products",
        ListType(ProductType),
        resolve = req => req.ctx.getProducts
      ),
      Field(
        "product",
        OptionType(ProductType),
        arguments = idArg :: Nil,
        resolve = req => req.ctx.getProduct(req.arg(idArg))
      ),
  ))

  val ShoppingSchema: Schema[ProductRepository, Unit] = Schema(Query)
}

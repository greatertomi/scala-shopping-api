package org.john.shopping
package graphql

import sangria.schema._

object SchemaFactory {
  val Query: ObjectType[Ctx, Unit] = ObjectType("Query", fields[Ctx, Unit](
    Field(
      "products",
      StringType,
      resolve = req => "Hello from graphQL"
    )
  ))

  val ShoppingSchema: Schema[Unit, Unit] = Schema(Query)
}

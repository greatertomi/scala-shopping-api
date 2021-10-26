package org.john.shopping
package graphql

import sangria.schema._

object SchemaFactory {
  val Query: ObjectType[Any, Unit] = ObjectType("Query", fields[Any, Unit](
    Field(
      "products",
      StringType,
      resolve = req => "Hello from graphQL"
    )
  ))

  val ShoppingSchema: Schema[Any, Unit] = Schema(Query)
}

package org.john.shopping
package graphql.types

import sangria.schema._
import org.john.shopping.database.Product

object ProductDefinition {
  val Product: ObjectType[Unit, Product] = ObjectType(
    "Product",
    "Products in the store",
    fields[Unit, Product](
      Field("id", IntType, resolve = _.value.id),
      Field("name", StringType, resolve = _.value.name),
      Field("description", StringType, resolve = _.value.description),
      Field("status", StringType, resolve = _.value.status),
      Field("price", IntType, resolve = _.value.price),
      Field("currentQuantity", IntType, resolve = _.value.currentQuantity),
      Field("createdBy", OptionType(StringType), resolve = _.value.createdBy),
      Field("createdBy", StringType, resolve = _.value.createdDate),
    )
  )
}

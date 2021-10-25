package org.john.shopping
package graphql

import sangria.schema._

trait CommonArguments {
  val idArg = Argument("id", IntType)
  val nameArg = Argument("name", StringType)
  val descriptionArg = Argument("description", StringType)
  val statusArg = Argument("status", StringType)
  val priceArg = Argument("price", IntType)
  val currentQuantityArg = Argument("currentQuantity", IntType)
  val createdByArg = Argument("createdBy", OptionInputType(StringType))
  val createdDateArg = Argument("createdDate", StringType)
}

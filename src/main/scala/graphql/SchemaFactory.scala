package org.john.shopping
package graphql

import graphql.modules._

import sangria.schema._

object SchemaFactory {
  def get(): Schema[Ctx, Unit] = {
    val modules = List(User, Product)
    val QueryType = ObjectType("Query", modules.flatMap(_.queryFields))
    Schema(QueryType)
  }
}

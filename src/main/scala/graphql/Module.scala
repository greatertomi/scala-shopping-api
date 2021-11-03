package org.john.shopping
package graphql

import sangria.schema._

trait Module {
  def queryFields: List[Field[Ctx, Unit]] = Nil
  def mutationFields: List[Field[Ctx, Unit]] = Nil
  def subscriptionFields: List[Field[Ctx, Unit]] = Nil
}

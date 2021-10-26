package org.john.shopping
package graphql

import sangria.schema._

trait Module {
  def queryFields: List[Field[Unit, Unit]] = Nil
  def mutationFields: List[Field[Unit, Unit]] = Nil
  def subscriptionFields: List[Field[Unit, Unit]] = Nil
}

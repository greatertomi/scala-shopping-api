package org.john.shopping
package graphql

import org.john.shopping.repositories.UserRepository
import sangria.schema._

trait Module {
  def queryFields: List[Field[UserRepository, Unit]] = Nil
  def mutationFields: List[Field[Unit, Unit]] = Nil
  def subscriptionFields: List[Field[Unit, Unit]] = Nil
}

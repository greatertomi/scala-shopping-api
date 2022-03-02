package org.john.shopping
package graphql

import org.joda.time.DateTime
import org.john.shopping.repositories.UserRepository

case class Ctx(now: DateTime, userRepository: UserRepository)

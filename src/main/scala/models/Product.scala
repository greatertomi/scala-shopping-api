package org.john.shopping
package models

case class Product (id: Int, name: String, description: String, status: String, price: Int,
                    currentQuantity: Int, createdBy: Option[String], createdDate: String)

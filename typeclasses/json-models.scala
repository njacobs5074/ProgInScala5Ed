/*
 * Copyright (C) 2007-2019 Artima, Inc. All rights reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Example code from:
 *
 * Programming in Scala, Fifth Edition
 * by Martin Odersky, Lex Spoon, Bill Venners, and Frank Sommers
 *
 * http://booksites.artima.com/programming_in_scala_5ed
 */

package org.stairwaybook.typeclasses.json

case class Address(
  street: String,
  city: String,
  state: String,
  zip: Int
)

case class Phone(
  countryCode: Int,
  phoneNumber: Long
)

case class Contact(
  name: String,
  addresses: List[Address],
  phones: List[Phone]
)

case class AddressBook(contacts: List[Contact])

object Contact:
  given contactSerializer: JsonSerializer[Contact] with
    def serialize(c: Contact) =
      import ToJsonMethods.{toJson as asJson}
      s"""|{
          |  "name": ${c.name.asJson},
          |  "addresses": ${c.addresses.asJson},
          |  "phones": ${c.phones.asJson}
          |}""".stripMargin

object AddressBook:
  given addressBookSerializer: JsonSerializer[AddressBook] with
    def serialize(a: AddressBook) =
      import ToJsonMethods.{toJson as asJson}
      s"""|{
          |  "contacts": ${a.contacts.asJson}
          |}""".stripMargin

object Address:
  given addressSerializer: JsonSerializer[Address] with
    def serialize(a: Address) =
      import ToJsonMethods.{toJson as asJson}
      s"""|{
          |  "street": ${a.street.asJson},
          |  "city": ${a.city.asJson},
          |  "state": ${a.state.asJson},
          |  "zip": ${a.zip.asJson}
          |}""".stripMargin

object Phone:
  given phoneSerializer: JsonSerializer[Phone] with
    def serialize(p: Phone) =
      import ToJsonMethods.{toJson as asJson}
      s"""|{
          |  "countryCode": ${p.countryCode.asJson},
          |  "phoneNumber": ${p.phoneNumber.asJson}
          |}""".stripMargin

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

package org.stairwaybook.currencies

abstract class CurrencyZone:
  type Currency <: AbstractCurrency
  def make(x: Long): Currency
  abstract class AbstractCurrency:
    val amount: Long
    def designation: String 
    def + (that: Currency): Currency = 
      make(this.amount + that.amount)
    def * (x: Double): Currency = 
      make((this.amount * x).toLong)
      def -(that: Currency): Currency =
        make(this.amount - that.amount)
      def /(that: Double) =
        make((this.amount / that).toLong)
      def /(that: Currency) =
        this.amount.toDouble / that.amount
      def from(other: CurrencyZone#AbstractCurrency): Currency = 
        make(math.round(
          other.amount.toDouble * Converter.exchangeRate
            (other.designation)(this.designation)))
      private def decimals(n: Long): Int = 
        if n == 1 then 0 else 1 + decimals(n / 10)
      override def toString = 
        ((amount.toDouble / CurrencyUnit.amount.toDouble)
          .formatted(s"%.${decimals(CurrencyUnit.amount)}f")
          + " " + designation)

    val CurrencyUnit: Currency

object US extends CurrencyZone:
  abstract class Dollar extends AbstractCurrency:
    def designation = "USD"
  type Currency = Dollar
  def make(cents: Long) =
    new Dollar:
      val amount = cents
  val Cent = make(1)
  val Dollar = make(100)
  val CurrencyUnit = Dollar

object Europe extends CurrencyZone:
  abstract class Euro extends AbstractCurrency:
    def designation = "EUR"

  type Currency = Euro
  def make(cents: Long) =
    new Euro:
      val amount = cents

  val Cent = make(1)
  val Euro = make(100)
  val CurrencyUnit = Euro

object Japan extends CurrencyZone:
  abstract class Yen extends AbstractCurrency:
    def designation = "JPY"

  type Currency = Yen
  def make(yen: Long) =
    new Yen:
      val amount = yen

  val Yen = make(1)
  val CurrencyUnit = Yen

object Converter:
  var exchangeRate =
    Map(
      "USD" -> Map("USD" -> 1.0, "EUR" -> 0.8498,
                 "JPY" -> 1.047, "CHF" -> 0.9149),
      "EUR" -> Map("USD" -> 1.177, "EUR" -> 1.0,
                 "JPY" -> 1.232, "CHF" -> 1.0765),
      "JPY" -> Map("USD" -> 0.9554, "EUR" -> 0.8121,
                 "JPY" -> 1.0, "CHF" -> 0.8742),
      "CHF" -> Map("USD" -> 1.093, "EUR" -> 0.9289,
                 "JPY" -> 1.144, "CHF" -> 1.0)
    )

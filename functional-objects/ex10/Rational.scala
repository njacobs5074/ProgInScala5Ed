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

package org.stairwaybook.functionalobjects.ex10

import scala.language.implicitConversions

class Rational(n: Int, d: Int):

  require(d != 0)

  private val g = gcd(n.abs, d.abs)
  val numer = n / g
  val denom = d / g

  def this(n: Int) = this(n, 1)

  def + (that: Rational): Rational =
    Rational(
      numer * that.denom + that.numer * denom,
      denom * that.denom
    )

  def + (i: Int): Rational =
    Rational(numer + i * denom, denom)

  def - (that: Rational): Rational =
    Rational(
      numer * that.denom - that.numer * denom,
      denom * that.denom
    )

  def - (i: Int): Rational =
    Rational(numer - i * denom, denom)

  def * (that: Rational): Rational =
    Rational(numer * that.numer, denom * that.denom)

  def * (i: Int): Rational =
    Rational(numer * i, denom)

  def / (that: Rational): Rational =
    Rational(numer * that.denom, denom * that.numer)

  def / (i: Int): Rational =
    Rational(numer, denom * i)

  override def toString = s"$numer/$denom"

  private def gcd(a: Int, b: Int): Int = 
    if b == 0 then a else gcd(b, a % b)

object Main {
  def main(args: Array[String]): Unit = {
    val x = new Rational(2, 3)
    println("x [" + x + "]")
    println("x * x [" + (x * x) + "]")
    println("x * 2 [" + (x * 2) + "]")

    implicit def intToRational(x: Int): Rational = new Rational(x)
    val r = new Rational(2,3)
    println("2 * r [" + (2 * r) + "]")
  }
}

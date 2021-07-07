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

package org.stairwaybook.compositionandinheritance

object Ex2 {
  abstract class Element:
    def contents: Vector[String]
    val height = contents.length
    val width = if height == 0 then 0 else contents(0).length

  class VectorElement(conts: Vector[String]) extends Element:
    def contents: Vector[String] = conts

  def main(args: Array[String]): Unit = {
    val arrayElem = new VectorElement(Vector("foo"))
    println("arrayElem [" + arrayElem + "]")

    val a123 =
      Array(1, 2, 3).toString
    val abcLen =
      "abc".length
    val helloLen =
      "hello".length  // no () because no side-effect
      println()       // better to not drop the ()
    val e: Element = VectorElement(Vector("hello"))

    println("a123 [" + a123 + "]")
    println("abcLen [" + abcLen + "]")
    println("helloLen [" + helloLen + "]")
    println("e [" + e + "]")
  }
}

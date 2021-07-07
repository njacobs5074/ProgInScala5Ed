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

object Ex10  {
  abstract class Element:
    def contents: Vector[String]
    def height: Int = contents.length
    def width: Int = if height == 0 then 0 else contents(0).length

    def above(that: Element): Element =
      VectorElement(this.contents ++ that.contents)

    def beside(that: Element): Element =
      val newContents = new Array[String](this.contents.length)
      for i <- 0 until this.contents.length do 
        newContents(i) = this.contents(i) + that.contents(i)
      VectorElement(newContents.toVector)

    def beside2(that: Element): Element = 
      VectorElement(
        for (line1, line2) <- this.contents.zip(that.contents)
        yield line1 + line2)

    override def toString = contents.mkString("\n")


  class LineElement(s: String) extends Element:
    val contents = Vector(s)
    override def width = s.length
    override def height = 1

  class VectorElement(conts: Vector[String]) extends Element:
    def contents: Vector[String] = conts

  def main(args: Array[String]): Unit = {
    val lineElem = new LineElement("foo")
    println("lineElem [" + lineElem + "]")

    val zip1 =
      Vector(1, 2, 3).zip(Vector("a", "b"))
    val zip2 =
      Vector((1, "a"), (2, "b"))
    println("zip1 [" + zip1 + "]")
    println("zip2 [" + zip2 + "]")
  }
}

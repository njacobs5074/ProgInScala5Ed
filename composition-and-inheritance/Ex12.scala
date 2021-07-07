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

object Ex12  {
  import Element.elem
  
  abstract class Element:
  
    def contents: Vector[String]
  
    def width: Int =
      if height == 0 then 0 else contents(0).length
  
    def height: Int = contents.length
  
    def above(that: Element): Element =
      elem(this.contents ++ that.contents)
  
    def beside(that: Element): Element =
      elem(
        for (line1, line2) <- this.contents.zip(that.contents)
        yield line1 + line2
      )
  
    override def toString = contents.mkString("\n")
  
  end Element

  object Element:
  
    def elem(contents: Vector[String]): Element = 
      VectorElement(contents)
  
    def elem(chr: Char, width: Int, height: Int): Element = 
      UniformElement(chr, width, height)
  
    def elem(line: String): Element = 
      LineElement(line)

  class VectorElement(conts: Vector[String]) extends Element:
    def contents: Vector[String] = conts

  // Extends VectorElement shown in Listing 10.5
  class LineElement(s: String) extends VectorElement(Vector(s)):
    override def width = s.length
    override def height = 1

  // Extends Element shown in Listing 10.2
  class UniformElement(
    ch: Char, 
    override val width: Int,
    override val height: Int 
  ) extends Element:
    private val line = ch.toString * width
    def contents = Vector.fill(height)(line)

  def main(args: Array[String]): Unit = {
    val lineElem = new LineElement("foo")
    println("lineElem [" + lineElem + "]")
  }
}

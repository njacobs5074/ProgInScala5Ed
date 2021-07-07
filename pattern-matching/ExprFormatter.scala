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

//compile this along with ../composition-and-inheritance/LayoutElement.scala

package org.stairwaybook.expr
import org.stairwaybook.layout.Element.elem

sealed abstract class Expr
case class Var(name: String) extends Expr
case class Num(number: Double) extends Expr
case class UnOp(operator: String, arg: Expr) extends Expr
case class BinOp(operator: String, 
    left: Expr, right: Expr) extends Expr

class ExprFormatter:

  // Contains operators in groups of increasing precedence
  private val opGroups =
    Vector(
      Set("|", "||"),
      Set("&", "&&"),
      Set("^"),
      Set("==", "!="),
      Set("<", "<=", ">", ">="),
      Set("+", "-"),
      Set("*", "%")
    )

  // A mapping from operators to their precedence
  private val precedence = {
    val assocs =
      for
        i <- 0 until opGroups.length
        op <- opGroups(i)
      yield op -> i
    assocs.toMap
  }

  private val unaryPrecedence = opGroups.length
  private val fractionPrecedence = -1

  // continued in Listing 13.21...

  // ...continued from Listing 13.20

  import org.stairwaybook.layout.Element

  private def format(e: Expr, enclPrec: Int): Element =

    e match

      case Var(name) =>
        elem(name)

      case Num(number) =>
        def stripDot(s: String) = 
          if s endsWith ".0" then s.substring(0, s.length - 2)
          else s
        elem(stripDot(number.toString))

      case UnOp(op, arg) =>
        elem(op) beside format(arg, unaryPrecedence)

      case BinOp("/", left, right) =>
        val top = format(left, fractionPrecedence)
        val bot = format(right, fractionPrecedence)
        val line = elem('-', top.width.max(bot.width), 1)
        val frac = top above line above bot
        if enclPrec != fractionPrecedence then frac
        else elem(" ") beside frac beside elem(" ")

      case BinOp(op, left, right) => 
        val opPrec = precedence(op)
        val l = format(left, opPrec) 
        val r = format(right, opPrec + 1)
        val oper = l beside elem(" " + op + " ") beside r 
        if enclPrec <= opPrec then oper
        else elem("(") beside oper beside elem(")")

    end match

  def format(e: Expr): Element = format(e, 0)

end ExprFormatter

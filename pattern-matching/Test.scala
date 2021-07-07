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

package org.stairwaybook.pattern_matching

//compile this along with ../composition-and-inheritance/LayoutElement.scala

import org.stairwaybook.layout.Element
import Element.elem


import org.stairwaybook.expr.*

object Express:

  def main(args: Array[String]): Unit =

    val f = new ExprFormatter

    val e1 = BinOp("*", BinOp("/", Num(1), Num(2)),
                        BinOp("+", Var("x"), Num(1)))

    val e2 = BinOp("+", BinOp("/", Var("x"), Num(2)),
                        BinOp("/", Num(1.5), Var("x")))

    val e3 = BinOp("/", e1, e2)

    def show(e: Expr) = println(s"${f.format(e)}\n\n")

    for e <- Vector(e1, e2, e3) do show(e)


  

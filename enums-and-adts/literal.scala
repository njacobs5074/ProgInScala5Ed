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

package org.stairwaybook.enums_and_adts.literal

enum Literal[T]:
case IntLit(value: Int) extends Literal[Int]
case LongLit(value: Long) extends Literal[Long]
case CharLit(value: Char) extends Literal[Char]
case FloatLit(value: Float) extends Literal[Float]
case DoubleLit(value: Double) extends Literal[Double]
case BooleanLit(value: Boolean) extends Literal[Boolean]
case StringLit(value: String) extends Literal[String]

@main def LiteralTest(args: String*): Unit = {

  import Literal.*
  
  def valueOfLiteral[T](lit: Literal[T]): T =
  lit match
    case IntLit(n) => n
    case LongLit(m) => m
    case CharLit(c) => c
    case FloatLit(f) => f
    case DoubleLit(d) => d
    case BooleanLit(b) => b
    case StringLit(s) => s

  valueOfLiteral(BooleanLit(true)) // true: Boolean
  valueOfLiteral(IntLit(42))       // 42: Int

}

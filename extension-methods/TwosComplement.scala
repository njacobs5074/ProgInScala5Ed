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

package org.stairwaybook.extension_methods.twoscomplement

trait TwosComplement[N]:

  def equalsMinValue(n: N): Boolean
  def absOf(n: N): N
  def negationOf(n: N): N

object TwosComplement:

  given tcOfByte: TwosComplement[Byte] with
    def equalsMinValue(n: Byte) = n == Byte.MinValue
    def absOf(n: Byte) = n.abs
    def negationOf(n: Byte) = (-n).toByte

  given tcOfShort: TwosComplement[Short] with
    def equalsMinValue(n: Short) = n == Short.MinValue
    def absOf(n: Short) = n.abs
    def negationOf(n: Short) = (-n).toShort

  given tcOfInt: TwosComplement[Int] with
    def equalsMinValue(n: Int) = n == Int.MinValue
    def absOf(n: Int) = n.abs
    def negationOf(n: Int) = -n

  given tcOfLong: TwosComplement[Long] with
    def equalsMinValue(n: Long) = n == Long.MinValue
    def absOf(n: Long) = n.abs
    def negationOf(n: Long) = -n

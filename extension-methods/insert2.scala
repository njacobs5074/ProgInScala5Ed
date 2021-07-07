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

package org.stairwaybook.extension_methods.insert2

trait Ord[T]:

  def compare(x: T, y: T): Int
  def lt(x: T, y: T): Boolean = compare(x, y) < 0
  def lteq(x: T, y: T): Boolean = compare(x, y) <= 0
  def gt(x: T, y: T): Boolean = compare(x, y) > 0
  def gteq(x: T, y: T): Boolean = compare(x, y) >= 0

  // (This is the best design)
  extension (lhs: T)
    def < (rhs: T): Boolean = lt(lhs, rhs)
    def <= (rhs: T): Boolean = lteq(lhs, rhs)
    def > (rhs: T): Boolean = gt(lhs, rhs)
    def >= (rhs: T): Boolean = gteq(lhs, rhs)

// (Not yet the best design)
object OrdOps:
  extension [T](lhs: T)(using ord: Ord[T])
    def < (rhs: T): Boolean = ord.lt(lhs, rhs)
    def <= (rhs: T): Boolean = ord.lteq(lhs, rhs)
    def > (rhs: T): Boolean = ord.gt(lhs, rhs)
    def >= (rhs: T): Boolean = ord.gteq(lhs, rhs)

def insert[T](x: T, xs: List[T])(using Ord[T]): List[T] =
  import OrdOps.*
  if xs.isEmpty || x <= xs.head then x :: xs
  else xs.head :: insert(x, xs.tail)

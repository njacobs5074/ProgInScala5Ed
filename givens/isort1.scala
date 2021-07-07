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

package org.stairwaybook.givens.isort1

def isort[T](xs: List[T])(lteq: (T, T) => Boolean): List[T] =
  if xs.isEmpty then Nil
  else insert(xs.head, isort(xs.tail)(lteq))(lteq)

def insert[T](x: T, xs: List[T])
    (lteq: (T, T) => Boolean): List[T] =
  if xs.isEmpty || lteq(x, xs.head) then x :: xs
  else xs.head :: insert(x, xs.tail)(lteq)

@main def Isort1Test(args: String*): Unit = {

  import org.stairwaybook.givens.Rational

  isort(List(4, -10, 10))((x: Int, y: Int) => x <= y)
  // List(-10, 4, 10)
  
  isort(List("cherry", "blackberry", "apple", "pear"))
      ((x: String, y: String) => x.compareTo(y) <= 0)
  // List(apple, blackberry, cherry, pear)
  
  isort(List(Rational(7, 8), Rational(5, 6), Rational(1, 2)))
      ((x: Rational, y: Rational) =>
          x.numer * y.denom <= x.denom * y.numer)
  // List(1/2, 5/6, 7/8)

  isort(List(4, -10, 10))((x, y) => x <= y)
  // List(-10, 4, 10)
  
  isort(List("cherry", "blackberry", "apple", "pear"))
      ((x, y) => x.compareTo(y) < 1)
  // List(apple, blackberry, cherry, pear)
  
  isort(List(Rational(7, 8), Rational(5, 6), Rational(1, 2)))
      ((x, y) => x.numer * y.denom <= x.denom * y.numer)
  // List(1/2, 5/6, 7/8)
}

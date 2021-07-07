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

package org.stairwaybook.enums_and_adts.eastwood_2

enum Eastwood[+G, +B]:

  def map[G2](f: G => G2): Eastwood[G2, B] =
    this match
      case Good(g) => Good(f(g))
      case Bad(b) => Bad(b)
      case Ugly(ex) => Ugly(ex)

  case Good(g: G)
  case Bad(b: B)
  case Ugly(ex: Throwable)

@main def EastwoodTest(args: String*): Unit = {

  import Eastwood.{Good, Bad, Ugly}  
  
  val eastWood = Good(41)
  eastWood.map(n => n + 1) // Good(42)

}

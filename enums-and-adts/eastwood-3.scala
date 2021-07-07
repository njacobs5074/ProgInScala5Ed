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

package org.stairwaybook.enums_and_adts.eastwood_3

// Generated sealed trait (the "enum type")
sealed trait Eastwood[+G, +B]

object Eastwood: // Generated companion object

  // Generated case classes
  case class Good[+G, +B](g: G) extends Eastwood[G, B]
  case class Bad[+G, +B](b: B) extends Eastwood[G, B]
  case class Ugly[+G, +B](ex: Throwable) extends Eastwood[G, B]

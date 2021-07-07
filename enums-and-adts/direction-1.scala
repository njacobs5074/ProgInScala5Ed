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

package org.stairwaybook.enums_and_adts.direction_1

enum Direction:
case North, East, South, West

@main def DirectionTest(args: String*): Unit = {
  import Direction.{North, South, East, West}
  
  North.ordinal // 0
  East.ordinal  // 1
  South.ordinal // 2
  West.ordinal  // 3

  Direction.values // Array(North, East, South, West)

  Direction.valueOf("North") // North
  Direction.valueOf("East")  // East
  Direction.valueOf("Up")
  // IllegalArgumentException: enum case not found: Up
}

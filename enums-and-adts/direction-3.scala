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

package org.stairwaybook.enums_and_adts.direction_3

enum Direction(val degrees: Int):

  def invert: Direction =
    this match
      case North => South
      case East => West
      case South => North
      case West => East

  case North extends Direction(0)
  case East extends Direction(90)
  case South extends Direction(180)
  case West extends Direction(270)

object Direction:
  def nearestTo(degrees: Int): Direction =
    val rem = degrees % 360
    val angle = if rem < 0 then rem + 360 else rem
    val (ne, se, sw, nw) = (45, 135, 225, 315)
    angle match
      case a if a > nw || a <= ne => North
      case a if a > ne && a <= se => East
      case a if a > se && a <= sw => South
      case a if a > sw && a <= nw => West

def allButNearest(degrees: Int): List[Direction] =
  val nearest = Direction.nearestTo(degrees)
  Direction.values.toList.filter(_ != nearest)

@main def DirectionTest(args: String*): Unit = {
  import Direction.{North, South, East, West}
  
  North.invert // South
  East.invert  // West

  allButNearest(42) // List(East, South, West)
}

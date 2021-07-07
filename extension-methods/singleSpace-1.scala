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

package org.stairwaybook.extension_methods.single_space_1

def singleSpace(s: String): String =
  s.trim.split("\\s+").mkString(" ")

@main def SingleSpace1Test(args: String*): Unit = {
  
  singleSpace("A  Tale\tof Two   Cities")
  // "A Tale of Two Cities"
  singleSpace("  It was  the\t\tbest\nof times. ")
  // "It was the best of times."

  val s = "One  Fish, Two\tFish "
  val t = " One Fish,  Two Fish"
  singleSpace(s) == singleSpace(t) // true

}

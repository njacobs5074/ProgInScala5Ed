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

package org.stairwaybook.builtincontrolstructures

object Breakless1 {
  def main(args: Array[String]): Unit = {
    var i = 0
    var foundIt = false
    
    while i < args.length && !foundIt do
      if !args(i).startsWith("-") then
        if args(i).endsWith(".scala") then
          foundIt = true
        else 
          i = i + 1
      else 
        i = i + 1

    println("foundIt = " + foundIt)
    println("i = " + i)
  }
}

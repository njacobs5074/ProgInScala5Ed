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

object MultiTable2 {
  def main(args: Array[String]): Unit = {
    // Returns a row as a sequence
    def makeRowSeq(row: Int) =
      for col <- 1 to 10 yield
        val prod = (row * col).toString
        val padding = " " * (4 - prod.length)
        padding + prod
    
    // Returns a row as a string
    def makeRow(row: Int) = makeRowSeq(row).mkString
    
    // Returns table as a string with one row per line
    def multiTable() =
    
      val tableSeq = // a sequence of row strings
        for row <- 1 to 10
        yield makeRow(row)
    
      tableSeq.mkString("\n")

    println("multiTable [" + multiTable() + "]")
  }
}

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

object Misc {
  var loopcounter = 2

  def ifVariations(args: Array[String]): Unit = {
    println("args [" + args.toList + "]")

    {
      var filename = "default.txt"
      if !args.isEmpty then
        filename = args(0)
      println("filename [" + filename + "]")
    }

    {
      val filename =
        if !args.isEmpty then args(0)
        else "default.txt"
      println("filename [" + filename + "]")
    }

    println(if (!args.isEmpty) args(0) else "default.txt")
  }

  def gcdLoop(x: Long, y: Long): Long =
    var a = x
    var b = y
    while a != 0 do
      val temp = a
      a = b % a
      b = temp
    b

  def gcd(x: Long, y: Long): Long =
    if y == 0 then x else gcd(y, x % y)

  def whileLoop(): Unit = {
    def readLine() = {
      if (loopcounter > 0) {
        loopcounter -= 1
        "a line"
      } else
        ""
    }

    import scala.io.StdIn.readLine
    while
      val line = readLine()
      println(s"Read: $line")
      line != ""
    do ()
  }

  def shadowing(): Unit = {
    val a = 1
    if a == 1 then
      val a = 2 // Compiles just fine
      println(a)
    println(a)
  }

  def main(args: Array[String]): Unit = {
    Misc.ifVariations(Array("foo"))
    Misc.ifVariations(Array())
    println("gcdLoop(2, 4) [" + Misc.gcdLoop(2, 4) + "]")
    println("gcdLoop(3, 4) [" + Misc.gcdLoop(3, 4) + "]")
    println("gcd(2, 4) [" + Misc.gcd(2, 4) + "]")
    println("gcd(3, 4) [" + Misc.gcd(3, 4) + "]")
    Misc.whileLoop()
    Misc.shadowing()
  }
}


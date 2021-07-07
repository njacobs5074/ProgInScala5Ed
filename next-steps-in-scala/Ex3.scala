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

package org.stairwaybook.nextstepsinscala

object Ex3 {
  def main(args: Array[String]): Unit = {
    val greetStrings = new Array[String](3)
    
    greetStrings.update(0, "Hello")
    greetStrings.update(1, ", ")
    greetStrings.update(2, "world!\n")
    
    for i <- 0.to(2) do
      print(greetStrings.apply(i))

    val numNames = Array("zero", "one", "two")
    println("numNames.toList [" + numNames.toList + "]")

    val numNames2 = Array.apply("zero", "one", "two")
    println("numNames2.toList [" + numNames2.toList + "]")

    val oneTwoThree = List(1, 2, 3)
    println("oneTwoThree [" + (oneTwoThree) + "]")

    {
      val oneTwo = List(1, 2)
      val threeFour = List(3, 4)
      val oneTwoThreeFour = oneTwo ::: threeFour
    }

    {
      val twoThree = List(2, 3)
      val oneTwoThree = 1 :: twoThree
    }

    {
      val oneTwoThree = 1 :: 2 :: 3 :: Nil
    }

    val pair = (99, "Luftballons")
    val num = pair(0)  // type Int, value 99
    val what = pair(1) // type String, value "Luftballons"

    var jetSet = Set("Boeing", "Airbus")
    jetSet += "Lear"
    val query = jetSet.contains("Cessna") // false

    jetSet = jetSet + "Lear"
    println("jetSet [" + (jetSet) + "]")

    import scala.collection.mutable
    
    val movieSet = mutable.Set("Spotlight", "Moonlight")
    movieSet += "Parasite"
    // movieSet now contains: "Spotlight", "Moonlight", "Parasite"

    import scala.collection.immutable.HashSet
    
    val hashSet = HashSet("Tomatoes", "Chilies")
    val ingredients = hashSet + "Coriander"
    // ingredients contains "Tomatoes", "Chilies", "Coriander"

    import scala.collection.mutable
    
    val treasureMap = mutable.Map.empty[Int, String]
    treasureMap += (1 -> "Go to island.")
    treasureMap += (2 -> "Find big X on ground.")
    treasureMap += (3 -> "Dig.")
    val step2 = treasureMap(2) // "Find big X on ground."

    val romanNumeral = Map(
      1 -> "I", 2 -> "II", 3 -> "III", 4 -> "IV", 5 -> "V"
    )
    val four = romanNumeral(4) // "IV"

    def printArgs(args: List[String]): Unit =
      var i = 0
      while i < args.length do
        println(args(i))
        i += 1
    printArgs(List("zero", "one", "two"))

    {
      def printArgs(args: List[String]): Unit =
        for arg <- args do
          println(arg)
      printArgs(List("three", "four", "five"))
    }

    {
      def printArgs(args: List[String]): Unit =
        args.foreach(println)
      printArgs(List("six", "seven", "eight"))
    }

    def formatArgs(args: List[String]) = args.mkString("\n")
    val args = List("nine", "ten")

    println(formatArgs(args))

    val res = formatArgs(List("zero", "one", "two"))
    assert(res == "zero\none\ntwo")
    println("whew")
  }
}

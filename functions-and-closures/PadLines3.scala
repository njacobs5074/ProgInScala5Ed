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

package org.stairwaybook.functionsandclosures

import scala.io.Source

object PadLines3 {
  object Padding:
  
    def padLines(text: String, minWidth: Int): String =
  
      def padLine(line: String): String =
        if line.length >= minWidth then line
        else line + " " * (minWidth - line.length)
  
      val paddedLines =
        for line <- text.linesIterator yield
          padLine(line)
  
      paddedLines.mkString("\n")

  object PadLines {
    def main(args: Array[String]) = {
      val width = args(0).toInt
      for (arg <- args.drop(1)) {
        val source = scala.io.Source.fromFile(arg)
        val content = try source.getLines.mkString("\n") finally source.close()
        print(Padding.padLines(content, width))
      }
    } 
  } 


  def main(args: Array[String]) = PadLines.main(args)
}


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

package org.stairwaybook.typeparameterization

class Publication(val title: String)
class Book(title: String) extends Publication(title)

object Library:
val books: Set[Book] =
 Set(
   Book("Programming in Scala"),
   Book("Walden")
 )
def printBookList(info: Book => AnyRef) =
 for book <- books do println(info(book))

object Customer:
def getTitle(p: Publication): String = p.title
def main(args: Array[String]): Unit =
 Library.printBookList(getTitle)

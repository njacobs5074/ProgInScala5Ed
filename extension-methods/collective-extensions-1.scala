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

package org.stairwaybook.extension_methods.collective_extensions_1

extension (n: Int)
  def absOption: Option[Int] =
    if n != Int.MinValue then Some(n.abs) else None

@main def TailOptionExtensionTest(args: String*): Unit = {

  Int.MaxValue // 2147483647
  Int.MinValue // -2147483648

  Int.MinValue.abs // -2147483648 (overflow)

  42.absOption           // Some(42)
  -42.absOption          // Some(42)
  Int.MaxValue.absOption // Some(2147483647)
  Int.MinValue.absOption // None

  -Int.MinValue // -2147483648 (overflow)

}

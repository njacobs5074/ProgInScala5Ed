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

package org.stairwaybook.collections_in_depth

@main def ViewExample: Unit = 
val v = Vector((1 to 10)*)
  // Vector(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

v.map(_ + 1).map(_ * 2)
  // Vector(4, 6, 8, 10, 12, 14, 16, 18, 20, 22)
(v.view.map(_ + 1).map(_ * 2)).toVector
  // Vector(4, 6, 8, 10, 12, 14, 16, 18, 20, 22)

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

@main def ArrayExample2: Unit = 
val a1 = Array(1, 2, 3)
val a2 = a1.map(_ * 3)         // Array(3, 6, 9)
val a3 = a2.filter(_ % 2 != 0) // Array(3, 9)
a3.reverse                     // Array(9, 3)
val seq: collection.Seq[Int] = a1 // ArraySeq(1, 2, 3)
seq.reverse // ArraySeq(3, 2, 1)
val ops: collection.ArrayOps[Int] = a1 // Array(1, 2, 3)
ops.reverse // Array(3, 2, 1)

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

package org.stairwaybook.typeclasses.json

trait JsonSerializer[T]:
def serialize(o: T): String

extension (a: T)
  def toJson: String = serialize(a)

object JsonSerializer:

given stringSerializer: JsonSerializer[String] with
  def serialize(s: String) = s"\"$s\""

given intSerializer: JsonSerializer[Int] with
  def serialize(n: Int) = n.toString

given longSerializer: JsonSerializer[Long] with
  def serialize(n: Long) = n.toString

given booleanSerializer: JsonSerializer[Boolean] with
  def serialize(b: Boolean) = b.toString

given listSerializer[T](using
    JsonSerializer[T]): JsonSerializer[List[T]] with
  def serialize(ts: List[T]) =
    s"[${ts.map(t => t.toJson).mkString(", ")}]"

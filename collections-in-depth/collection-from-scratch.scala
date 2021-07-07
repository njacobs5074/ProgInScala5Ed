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

import scala.collection.immutable.HashSet

// For demostration purpose
trait Animal
class Dog extends Animal
class Cat extends Animal
class Bird extends Animal

val dog = new Dog
val cat = new Cat
val bird = new Bird

@main def CollectionFromScratch: Unit = 
  Iterable()              // An empty collection
  List()                  // The empty list
  List(1.0, 2.0)          // A list with elements 1.0, 2.0
  Vector(1.0, 2.0)        // A vector with elements 1.0, 2.0
  Iterator(1, 2, 3)       // An iterator returning three integers.
  Set(dog, cat, bird)     // A set of three animals
  HashSet(dog, cat, bird) // A hash set of the same animals
  Map('a' -> 7, 'b' -> 0) // A map from characters to integers

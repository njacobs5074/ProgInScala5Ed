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

package org.stairwaybook.packagesandimports.ex4

package bobsrockets:
  package navigation:

    class Navigator:
      // No need to say bobsrockets.navigation.StarMap
      val map = new StarMap

    class StarMap

  class Ship:
    // No need to say bobsrockets.navigation.Navigator
    val nav = new navigation.Navigator

  package fleets:

    class Fleet:
      // No need to say bobsrockets.Ship
      def addShip = new Ship

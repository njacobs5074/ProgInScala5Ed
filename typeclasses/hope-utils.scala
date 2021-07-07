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

package org.stairwaybook.typeclasses

import org.stairwaybook.enums_and_adts.hope.Hope

object HopeUtils:

  given hopeOrdering[T](using
      ord: Ordering[T]): Ordering[Hope[T]] with

    def compare(lh: Hope[T], rh: Hope[T]): Int =
      import Hope.{Glad, Sad}
      (lh, rh) match
        case (Sad, Sad) => 0
        case (Sad, _) => -1
        case (_, Sad) => +1
        case (Glad(lhv), Glad(rhv)) =>
          ord.compare(lhv, rhv)

// SPDX-License-Identifier: Apache-2.0
// Source: Stainless documentation
//   https://github.com/epfl-lara/stainless/blob/fc81ec612135c651e2fad46f905d288b2f8ccc41/README.md?plain=1#L21-L32

import stainless.collection.*
object HelloStainless:
  def myTail(xs: List[BigInt]): BigInt =
    require(xs.nonEmpty)
    (xs: @unchecked) match
      case Cons(h, _) => h
      // Match provably exhaustive

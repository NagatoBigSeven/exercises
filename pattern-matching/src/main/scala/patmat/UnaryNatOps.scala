package patmat

import UnaryNat.*

object UnaryNatOps:
  def fromInt(n: Int): UnaryNat =
    n match
      case n if n <= 0 => Zero
      case _ => Succ(fromInt(n - 1))

  def toInt(n: UnaryNat): Int =
    n match
      case Zero => 0
      case Succ(n0) => 1 + toInt(n0)

  def add(n: UnaryNat, m: UnaryNat): UnaryNat =
    m match
      case Zero => n
      case Succ(m0) => Succ(add(n, m0))

  def multiply(n: UnaryNat, m: UnaryNat): UnaryNat =
    m match
      case Zero => Zero
      case Succ(Zero) => n
      case Succ(m0) => add(n, multiply(n, m0))

  def minus(n: UnaryNat, m: UnaryNat): UnaryNat =
    n match
      case Zero => Zero
      case Succ(n0) =>
        m match
          case Zero => n
          case Succ(m0) => minus(n0, m0)

  def isEven(n: UnaryNat): Boolean =
    n match
      case Zero => true
      case Succ(Zero) => false
      case Succ(Succ(n0)) => isEven(n0)

  def isOdd(n: UnaryNat): Boolean =
    n match
      case Zero => false
      case Succ(Zero) => true
      case Succ(Succ(n0)) => isOdd(n0)

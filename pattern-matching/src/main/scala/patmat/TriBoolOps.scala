package patmat

object TriBoolOps:
  import TriBool.*

  def neg(b: TriBool): TriBool =
    b match
      case Yes => No
      case No => Yes
      case Maybe => Maybe

  def and(b1: TriBool, b2: TriBool): TriBool =
    b1 match
      case Yes => b2
      case No => No
      case Maybe =>
        b2 match
          case Yes => Maybe
          case No => No
          case Maybe => Maybe

  def or(b1: TriBool, b2: TriBool): TriBool =
    b1 match
      case Yes => Yes
      case No => b2
      case Maybe =>
        b2 match
          case Yes => Yes
          case No => Maybe
          case Maybe => Maybe

  def nand(b1: TriBool, b2: TriBool): TriBool =
    b1 match
      case Yes => neg(b2)
      case No => Yes
      case Maybe =>
        b2 match
          case Yes => Maybe
          case No => Yes
          case Maybe => Maybe

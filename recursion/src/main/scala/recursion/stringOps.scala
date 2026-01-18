package recursion

def stringLength(s: String): Int =
  s match
    case "" => 0
    case _ => 1 + stringLength(s.tail)

def capitalizeString(s: String): String =
  s match
    case "" => ""
    case _ =>
      val capHead = s.head.toUpper
      capHead.toString + capitalizeString(s.tail)

def discardWord(s: String): String =
  s match
    case "" => ""
    case _ =>
      if s.head.isWhitespace then s
      else discardWord(s.tail)

def wordCount(s: String): Int =
  s match
    case "" => 0
    case _ =>
      if s.head.isWhitespace then wordCount(s.tail)
      else 1 + wordCount(discardWord(s.tail))

def isBlank(s: String): Boolean =
  s match
    case "" => true
    case _ =>
      if s.head.isWhitespace then isBlank(s.tail)
      else false

def caesarCipher(s: String, shift: Int): String =
  s match
    case "" => ""
    case _ =>
      val aCode = 'a'.toInt
      val headCode = s.head.toInt
      val numLetters = 26
      val headPlusShift = (headCode + shift - aCode) % numLetters + aCode
      headPlusShift.toChar.toString + caesarCipher(s.tail, shift)

def reverseString(s: String): String =
  s match
    case "" => ""
    case _ => reverseString(s.tail) + s.head.toString
  

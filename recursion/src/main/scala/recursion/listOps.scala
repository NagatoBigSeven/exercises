package recursion

def length(l: IntList): Int =
  l match
    case IntNil() => 0
    case IntCons(head, tail) => 1 + length(tail)

def allPositiveOrZero(l: IntList): Boolean =
  l match
    case IntNil() => true
    case IntCons(head, tail) =>
      if head < 0 then false
      else allPositiveOrZero(tail)

def countPositive(l: IntList): Int =
  l match
    case IntNil() => 0
    case IntCons(head, tail) =>
      if head > 0 then 1 + countPositive(tail)
      else countPositive(tail)

def sum(l: IntList): Int =
  l match
    case IntNil() => 0
    case IntCons(head, tail) => head + sum(tail)
  
def product(l: IntList): Int =
  l match
    case IntNil() => 1
    case IntCons(head, tail) => head * product(tail)

def anyOdd(l: IntList): Boolean =
  l match
    case IntNil() => false
    case IntCons(head, tail) =>
      if head % 2 != 0 then true
      else anyOdd(tail)

def decrement(l: IntList): IntList =
  l match
    case IntNil() => IntNil()
    case IntCons(head, tail) => IntCons(head - 1, decrement(tail))

def collectEven(l: IntList): IntList =
  l match
    case IntNil() => IntNil()
    case IntCons(head, tail) =>
      if head % 2 == 0 then IntCons(head, collectEven(tail))
      else collectEven(tail)

def min(l: IntList): Int =
  l match
    case IntNil() => throw IllegalArgumentException("Empty List!")
    case IntCons(head, tail) =>
      if tail.isEmpty then head
      else
        val tailMin = min(tail)
        if head < tailMin then head else tailMin

def increment(l: IntList): IntList =
  l match
    case IntNil() => IntNil()
    case IntCons(head, tail) => IntCons(head + 1, increment(tail))

def subtract(l: IntList): Int =
  l match
    case IntNil() => throw IllegalArgumentException("Empty List!")
    case IntCons(head, tail) =>
      if tail.isEmpty then head
      else head - subtract(tail)

def removeOdd(l: IntList): IntList =
  l match
    case IntNil() => IntNil()
    case IntCons(head, tail) =>
      if head % 2 == 0 then IntCons(head, removeOdd(tail))
      else removeOdd(tail)

def countEven(l: IntList): Int =
  l match
    case IntNil() => 0
    case IntCons(head, tail) =>
      if head % 2 == 0 then 1 + countEven(tail)
      else countEven(tail)

/** `countEven` using `collectEven` and `length` */
def countEven2(l: IntList): Int =
  length(collectEven(l))

def multiplyBy2(l: IntList): IntList =
  l match
    case IntNil() => IntNil()
    case IntCons(head, tail) => IntCons(head * 2, multiplyBy2(tail))

def anyNegative(l: IntList): Boolean =
  l match
    case IntNil() => false
    case IntCons(head, tail) =>
      if head < 0 then true
      else anyNegative(tail)

def allEven(l: IntList): Boolean =
  l match
    case IntNil() => true
    case IntCons(head, tail) =>
      if head % 2 != 0 then false
      else allEven(tail)

def multiplyOdd(l: IntList): Int =
  l match
    case IntNil() => 1
    case IntCons(head, tail) =>
      if head % 2 != 0 then head * multiplyOdd(tail)
      else multiplyOdd(tail)

def horner(x: Int, l: IntList): Int =
  l match
    case IntNil() => 0
    case IntCons(head, tail) => head + x * horner(x, tail)

def capAtZero(l: IntList): IntList =
  l match
    case IntNil() => IntNil()
    case IntCons(head, tail) =>
      if head > 0 then IntCons(0, capAtZero(tail))
      else IntCons(head, capAtZero(tail))

def removeZeroes(l: IntList): IntList =
  l match
    case IntNil() => IntNil()
    case IntCons(head, tail) =>
      if head == 0 then removeZeroes(tail)
      else IntCons(head, removeZeroes(tail))

def reverseAppend(l1: IntList, l2: IntList): IntList =
  l1 match
    case IntNil() => l2
    case IntCons(head, tail) => reverseAppend(tail, IntCons(head, l2))

def reverse(l: IntList): IntList =
  reverseAppend(l, IntNil())
def takeWhilePositive(l: IntList): IntList =
  l match
    case IntNil() => IntNil()
    case IntCons(head, tail) =>
      if head > 0 then IntCons(head, takeWhilePositive(tail))
      else IntNil()

def append(l1: IntList, l2: IntList): IntList =
  reverseAppend(reverse(l1), l2)

def collectMultiples(d: Int, l: IntList): IntList =
  l match
    case IntNil() => IntNil()
    case IntCons(head, tail) =>
      if head % d == 0 then IntCons(head, collectMultiples(d, tail))
      else collectMultiples(d, tail)

def last(l: IntList): Int =
  l match
    case IntNil() => throw IllegalArgumentException("Empty List!")
    case IntCons(head, tail) =>
      if tail.isEmpty then head
      else last(tail)

def init(l: IntList): IntList =
  l match
    case IntNil() => throw IllegalArgumentException("Empty List!")
    case IntCons(head, tail) =>
      if tail.isEmpty then IntNil()
      else IntCons(head, init(tail))

def contains(l: IntList, n: Int): Boolean =
  l match
    case IntNil() => false
    case IntCons(head, tail) =>
      if head == n then true
      else contains(tail, n)

def isSubset(l: IntList, L: IntList): Boolean =
  l match
    case IntNil() => true
    case IntCons(head, tail) =>
      if contains(L, head) then isSubset(tail, L)
      else false

def intersection(l: IntList, L: IntList): IntList =
  l match
    case IntNil() => IntNil()
    case IntCons(head, tail) =>
      if contains(L, head) then IntCons(head, intersection(tail, L))
      else intersection(tail, L)

def difference(l: IntList, L: IntList): IntList =
  l match
    case IntNil() => IntNil()
    case IntCons(head, tail) =>
      if contains(L, head) then difference(tail, L)
      else IntCons(head, difference(tail, L))

def minMax(l: IntList): (Int, Int) =
  l match
    case IntNil() => throw IllegalArgumentException("Empty List!")
    case IntCons(head, tail) =>
      if tail.isEmpty then (head, head)
      else
        val (tailMin, tailMax) = minMax(tail)
        val minValue = scala.math.min(head, tailMin)
        val maxValue = scala.math.max(head, tailMax)
        (minValue, maxValue)

val Add = -1
val Multiply = -2

def polishEval(l: IntList): (Int, IntList) =
  l match
    case IntNil() => throw EmptyListException()
    case IntCons(head, tail) =>
      if head == Add then
        val (operand1, rest1) = polishEval(tail)
        val (operand2, rest2) = polishEval(rest1)
        (operand1 + operand2, rest2)
      else if head == Multiply then
        val (operand1, rest1) = polishEval(tail)
        val (operand2, rest2) = polishEval(rest1)
        (operand1 * operand2, rest2)
      else if head >= 0 then (head, tail)
      else throw InvalidOperatorException(head)

package patmat

import IntList.*
import IntIntList.*

def zipWith(l1: IntList, l2: IntList, op: (Int, Int) => Int): IntList =
  l1 match
    case IntNil => IntNil
    case IntCons(head1, tail1) =>
      l2 match
        case IntNil => IntNil
        case IntCons(head2, tail2) =>
          IntCons(op(head1, head2), zipWith(tail1, tail2, op))

def zip(l1: IntList, l2: IntList): IntIntList =
  l1 match
    case IntNil => IntIntNil
    case IntCons(head1, tail1) =>
      l2 match
        case IntNil => IntIntNil
        case IntCons(head2, tail2) =>
          IntIntCons((head1, head2), zip(tail1, tail2))  

def unzip(l: IntIntList): (IntList, IntList) =
  l match
    case IntIntNil => (IntNil, IntNil)
    case IntIntCons(xy, xs) =>
      val (l1, l2) = unzip(xs)
      (IntCons(xy._1, l1), IntCons(xy._2, l2))  

def map2to1(op: (Int, Int) => Int)(l: IntIntList): IntList =
  l match
    case IntIntNil => IntNil
    case IntIntCons(xy, xs) =>
      IntCons(op(xy._1, xy._2), map2to1(op)(xs))  

def zipThenWith(l1: IntList, l2: IntList, op: (Int, Int) => Int): IntList =
  map2to1(op)(zip(l1, l2))

def movingWindow(l: IntList): IntIntList =
  l match
    case IntNil => IntIntNil
    case IntCons(_, tail) => zip(l, tail)

enum ExtractResult:
  case SecondElem(i: Int)
  case NotLongEnough
  case EmptyList
import ExtractResult.*

def extractSecond(l: IntList): ExtractResult =
  l match
    case IntNil => EmptyList
    case IntCons(_, IntNil) => NotLongEnough
    case IntCons(_, IntCons(second, _)) => SecondElem(second)

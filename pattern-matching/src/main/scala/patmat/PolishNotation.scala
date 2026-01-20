package patmat

// Replace these types with `enum`s
enum PolishNotationAtom:
  case Number(n: Int)
  case Plus
  case Times
enum PolishNotation:
  case Nil
  case Cons(head: PolishNotationAtom, tail: PolishNotation)

def plusOneTwo: PolishNotation = // + 1 2
  PolishNotation.Cons(PolishNotationAtom.Plus, PolishNotation.Cons(PolishNotationAtom.Number(1), PolishNotation.Cons(PolishNotationAtom.Number(2), PolishNotation.Nil)))

def plusTwoTimesThreeFour: PolishNotation = // + 2 * 3 4
  PolishNotation.Cons(PolishNotationAtom.Plus, PolishNotation.Cons(PolishNotationAtom.Number(2), PolishNotation.Cons(PolishNotationAtom.Times, PolishNotation.Cons(PolishNotationAtom.Number(3), PolishNotation.Cons(PolishNotationAtom.Number(4), PolishNotation.Nil)))))

class InvalidExpression extends RuntimeException

def polishEval(l: PolishNotation): (Int, PolishNotation) =
  l match
    case PolishNotation.Nil => throw new InvalidExpression
    case PolishNotation.Cons(head, tail) =>
      head match
        case PolishNotationAtom.Number(n) => (n, tail)
        case PolishNotationAtom.Plus =>
          val (left, rest1) = polishEval(tail)
          val (right, rest2) = polishEval(rest1)
          (left + right, rest2)
        case PolishNotationAtom.Times =>
          val (left, rest1) = polishEval(tail)
          val (right, rest2) = polishEval(rest1)
          (left * right, rest2)

package comprehensions

def filter_traced(l: Seq[Int]): Seq[Int] =
  for
    n <- l
    if n % 5 == 0
    _ = println(f"$n is a multiple of 5!")
    if n % 3 == 0
    _ = println(f"  $n is also a multiple of 3!")
    if n >= 10
    _ = println(f"    $n is also greater than 10!")
  yield n

def traceIfTrue(b: Boolean, label: String) =
  if b then println(label)
  b

def filter_tracedIfTrue(l: Seq[Int]): Seq[Int] =
  for
    n <- l
    if traceIfTrue(n % 5 == 0, f"$n is a multiple of 5!")
    if traceIfTrue(n % 3 == 0, f"  $n is also a multiple of 3!")
    if traceIfTrue(n >= 10, f"    $n is also greater than 10!")
  yield n

def badZip[T1, T2](l1: List[T1], l2: List[T2]): Seq[(T1, T2)] =
  for i <- (0 to math.min(l1.length, l2.length) - 1)
  yield (l1(i), l2(i))

enum Operand[+T]:
  case Add extends Operand[Nothing]
  case Mul extends Operand[Nothing]
  case Num(t: T)

type OpStack[T] = List[Operand[T]]

def polishEval(ops: OpStack[Int]): (Int, OpStack[Int]) =
  ops match
    case Nil => throw IllegalArgumentException()
    case op :: afterOp =>
      op match
        case Operand.Num(n) =>
          (n, afterOp)
        case Operand.Add =>
          val (l, afterL) = polishEval(afterOp)
          val (r, afterR) = polishEval(afterL)
          (l + r, afterR)
        case Operand.Mul =>
          val (l, afterL) = polishEval(afterOp)
          val (r, afterR) = polishEval(afterL)
          (l * r, afterR)

def mc(n: Int): Int =
  if n > 100 then n - 10
  else mc(mc(n + 11))

extension [T](l: List[T])
  def pairs(op: (T, T) => T): List[T] = l match
    case a :: b :: tl => op(a, b) :: tl.pairs(op)
    case _            => l
  def foldt(z: T)(op: (T, T) => T): T = l match
    case Nil       => z
    case List(t)   => t
    case _ :: tail => l.pairs(op).foldt(z)(op)

extension (l: List[Int])
  def ms: List[Int] =
    l.map(List(_)).foldt(Nil)(merge)

def t(x: Int, y: Int, z: Int): Int =
  if x <= y then y
  else
    t(
      t(x - 1, y, z),
      t(y - 1, z, x),
      t(z - 1, x, y)
    )

def badReverse[T](l: List[T], acc: List[T] = Nil): List[T] =
  l match
    case Nil    => acc.reverse
    case h :: t => badReverse(t, acc ++ List(h))

def badMap[T1, T2](l: List[T1], f: T1 => T2): List[T2] =
  if l.length == 0 then Nil
  else f(l.head) :: badMap(l.tail, f)

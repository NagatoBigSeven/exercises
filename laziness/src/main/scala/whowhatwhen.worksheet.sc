
class List1[+A](val state: List1State[A])

enum List1State[+A]:
  case Cons(head: A, tail: List1[A])
  case Nil

class List2[+A](init: => List2State[A]):
  lazy val state: List2State[A] = init

enum List2State[+A]:
  case Cons(head: A, tail: List2[A])
  case Nil

class List3[+A](val state: () => List3State[A])

enum List3State[+A]:
  case Cons(head: () => A, tail: () => List3[A])
  case Nil

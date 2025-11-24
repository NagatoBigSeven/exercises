package memo

object FixpointCombinator:
  def fixpoint[A, B](f: (A, A => B) => B)(a: A): B =
    ???

object Memo:
  import scala.collection.mutable

  def memo[A, B](f: (A, A => B) => B)(a: A): B =
    ???

  val fib = memo: (n: Int, f: Int => Int) =>
    if n <= 1 then 1 else f(n - 1) + f(n - 2)

  val choose = memo[(Int, Int), Int] {
    case ((n, k), f) =>
      if k <= 0 || k >= n then 1
      else f((n - 1, k - 1)) + f((n - 1, k))
  }

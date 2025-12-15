import stainless.lang.*

object Find:
  // abbreviation expanded by the compiler
  inline def interval(a: Array[Int], lo: Int, hi: Int): Boolean =
    0 <= lo && lo <= hi && hi <= a.size

  def existsIn(a: Array[Int], lo: Int, hi: Int, x: Int): Boolean =
    require(interval(a, lo, hi))
    decreases(hi - lo)
    !(lo == hi) &&
    ((a(hi - 1) == x) || existsIn(a, lo, hi - 1, x))

  def find(a: Array[Int], lo: Int, hi: Int, x: Int): Int = {
    require(interval(a, lo, hi))
    var i = lo
    (while i < hi && a(i) != x do
      decreases(hi - i)
      i = i + 1
    )
    .invariant(lo <= i && i <= hi && !existsIn(a, lo, i, x))
    if i < hi then i
    else -1
  }.ensuring(res =>
    (lo <= res && res < hi && a(res) == x) ||
      (res == -1 && !existsIn(a, lo, hi, x))
  )

  def search1(a: Array[Int], lo: Int, hi: Int, x: Int): Int = {
    require(interval(a, lo, hi))
    if lo < hi then
      val i = (lo + hi) / 2
      val seeing = a(i)
      if x == seeing then i
      else if x < seeing then search1(a, lo, i, x)
      else search1(a, i, hi, x)
    else
      -1
  }.ensuring(res =>
    (lo <= res && res < hi && a(res) == x) ||
      (res == -1)
  )

  def search2(a: Array[Int], lo: Int, hi: Int, x: Int): Int = {
    require(interval(a, lo, hi))
    var lo0 = lo
    var hi0 = hi
    var res = -1
    (while res == -1 && lo0 < hi0 do
      (??? : Unit)
    ).invariant(true)
    if res == -1 then
      assert(lo0 == hi0)
    else
      assert(a(res) == x)
    res
  }.ensuring(res =>
    (lo <= res && res < hi && a(res) == x) ||
      (res == -1)
  )


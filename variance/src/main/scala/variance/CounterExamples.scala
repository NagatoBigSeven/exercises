import scala.annotation.unchecked.uncheckedVariance

// The @uncheckedVariance annotation disables variance checks for a given use of
// a type parameter.  The `oops` functions below show what can go wrong when
// these checks are bypassed.

object ContravariantField:
  case class C[-A](a: A @uncheckedVariance)

  def oops =
    ???

object DoubleNegation:
  trait C[-A]:
    def app(f: A @uncheckedVariance => Int): Int

  def oops =
    ???

object FreeAndBound:
  trait F[+A]:
    def f(a: A @uncheckedVariance): A

  def oops =
    ???

  def oops2 =
    ???

object TraitsAndExtensions:
  trait Foldable1[+A]: // Rejected, thankfully
    def fold(a: A @uncheckedVariance)(f: (A, A) => A @uncheckedVariance): A

  def oops =
    ???

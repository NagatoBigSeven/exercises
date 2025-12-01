package pbt

import scala.language.adhocExtensions
import org.scalacheck.*
import Gen.*
import Prop.*

object QuadTreeSpecification extends Properties("QuadTree"):
  override def overrideParameters(p: Test.Parameters): Test.Parameters =
    p.withMinSuccessfulTests(500)

  case class PosBounds(xMin: Double, xMax: Double, yMin: Double, yMax: Double):
    val xRange = xMax - xMin
    val yRange = yMax - yMin
    def transformX(x: Double): Double = x * xRange + xMin
    def transformY(y: Double): Double = y * yRange + yMin
  given PosBounds(-100, 100, -100, 100)

  def position(using bounds: PosBounds): Gen[Vector2] =
    for
      x <- Gen.double
      y <- Gen.double
    yield Vector2(bounds.transformX(x), bounds.transformY(y))

  def withPos(using bounds: PosBounds): Gen[WithPos[Double]] =
    ???

  val genEmpty: Gen[QuadTree[Double]] =
    ???

  def genLeaves(using bounds: PosBounds): Gen[QuadTree[Double]] =
    ???

  def genQuads(using bounds: PosBounds): Gen[QuadTree[Double]] =
    ???

  val genQuadTree: Gen[QuadTree[Double]] =
    ???

  given Arbitrary[Vector2] = Arbitrary(position)
  given Arbitrary[QuadTree[Double]] = Arbitrary(genQuadTree)
  given Arbitrary[WithPos[Double]] = Arbitrary(withPos)

  // Implement the properties here

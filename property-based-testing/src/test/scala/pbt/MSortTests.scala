package pbt

import scala.language.adhocExtensions
import org.scalacheck.*
import Gen.*
import Prop.*

object MSortSpecification extends Properties("MSort"):
  override def overrideParameters(p: Test.Parameters): Test.Parameters =
    p.withMinSuccessfulTests(500)

  property("Property 1") =
    ???

  property("Property 2") =
    ???

  property("Property 3") =
    ???

  property("Property 4") =
    ???

  property("Property 5") =
    ???

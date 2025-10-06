class CounterExamplesSuite extends munit.FunSuite:
  test("ContravariantField"):
    intercept[ClassCastException]:
      ContravariantField.oops
  test("DoubleNegation"):
    intercept[ClassCastException]:
      DoubleNegation.oops
  test("FreeAndBound"):
    intercept[ClassCastException]:
      FreeAndBound.oops
    intercept[ClassCastException]:
      FreeAndBound.oops2
  test("TraitsAndExtensions"):
    intercept[ClassCastException]:
      TraitsAndExtensions.oops

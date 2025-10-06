package comprehensions

class TracingSuite extends munit.FunSuite:
  test("Sort"):
    assertEquals(ms(List()), List())
    assertEquals(ms(List(1)), List(1))
    assertEquals(ms(List(1, 3, 1, 2, 1, -1)), List(-1, 1, 1, 1, 2, 3))

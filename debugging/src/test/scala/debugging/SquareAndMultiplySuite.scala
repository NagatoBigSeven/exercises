package debugging
import debugging.squareAndMultiply

class DebuggingTests extends munit.FunSuite:
  test("squareAndMultiply: correctness"):
    assertEquals(squareAndMultiply(1, 0), 1.0)
    assertEquals(squareAndMultiply(1, 1), 1.0)
    assertEquals(squareAndMultiply(1, 2), 1.0)
    assertEquals(squareAndMultiply(1, 3), 1.0)
    assertEquals(squareAndMultiply(2, 10), 1024.0)
    assertEquals(squareAndMultiply(2, 0), 1.0)
    assertEquals(squareAndMultiply(2, 1), 2.0)
    assertEquals(squareAndMultiply(2, 2), 4.0)
    assertEquals(squareAndMultiply(2, 3), 8.0)
    assertEquals(squareAndMultiply(3, 0), 1.0)
    assertEquals(squareAndMultiply(3, 1), 3.0)
    assertEquals(squareAndMultiply(3, 2), 9.0)
    assertEquals(squareAndMultiply(3, 3), 27.0)
    assertEquals(squareAndMultiply(2, -1), 0.5)
    assertEquals(squareAndMultiply(2, -2), 0.25)
    assertEquals(squareAndMultiply(2, -3), 0.125)
    assertEquals(squareAndMultiply(3, -1), 1.0 / 3)
    assertEquals(squareAndMultiply(3, -2), 1.0 / 9)
    assertEquals(squareAndMultiply(3, -3), 1.0 / 27)

package debugging

class PrintListTests extends munit.FunSuite:
  def testPrintList[A](expectedOutput: String, list: List[A]) =
    val stdout = java.io.ByteArrayOutputStream()
    Console.withOut(stdout) {
      printList(list)
    }
    assertNoDiff(stdout.toString(), expectedOutput.trim())

  val threeElement = """
<start>
1st element: 1
2nd element: 2
3rd element: 3
<end>
"""

  test("printList: List(1, 2, 3)"):
    testPrintList(threeElement, List(1, 2, 3))


package debugging

class ListOpsTests extends munit.FunSuite:

  test("removeDuplicates: on an empty list"):
    assertEquals(removeDuplicates(IntNil()), IntNil())

  test("removeDuplicates: on list [1, 2, 2, 3]"):
    val l: IntList = IntCons(1, IntCons(2, IntCons(2, IntCons(3, IntNil()))))
    val rl: IntList = IntCons(1, IntCons(2, IntCons(3, IntNil())))
    assertEquals(removeDuplicates(l), rl)

  test("removeDuplicates: on list [1, 2, 2, 3, 1]"):
    val l: IntList = IntCons(1, IntCons(2, IntCons(2, IntCons(3, IntCons(1, IntNil())))))
    val rl: IntList = IntCons(1, IntCons(2, IntCons(3, IntNil())))
    assertEquals(removeDuplicates(l), rl)

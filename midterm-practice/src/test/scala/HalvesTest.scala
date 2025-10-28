package halvesAndInterleavings

class HalvesAndInterleavingsTest extends munit.FunSuite:
  test("halves: empty list"):
    assertEquals(halves(Nil), (Nil, Nil))

  test("halves: singleton list"):
    assertEquals(halves(List(1)), (List(1), Nil))

  test("halves: two-elements list"):
    assertEquals(halves(List('a', 'b')), (List('a'), List('b')))

  test("halves: long odd list (example provided in the handout)"):
    assertEquals(halves(List("a", "b", "c", "d", "e", "f", "g")), (List("a", "c", "e", "g"), List("b", "d", "f")))

  test("halves: long even list"):
    assertEquals(halves(List(1, 2, 3, 4, 5, 6)), (List(1, 3, 5), List(2, 4, 6)))

  test("foldHalvesWithHelper: empty list"):
    assertEquals(foldHalvesWithHelper(Nil), (Nil, Nil))

  test("foldHalvesWithHelper: singleton list"):
    assertEquals(foldHalvesWithHelper(List(1)), (List(1), Nil))

  test("foldHalvesWithHelper: two-elements list"):
    assertEquals(foldHalvesWithHelper(List('a', 'b')), (List('a'), List('b')))

  test("foldHalvesWithHelper: long odd list"):
    assertEquals(
      foldHalvesWithHelper(List("a", "b", "c", "d", "e", "f", "g")),
      (List("a", "c", "e", "g"), List("b", "d", "f"))
    )

  test("foldHalvesWithHelper: long even list"):
    assertEquals(foldHalvesWithHelper(List(1, 2, 3, 4, 5, 6)), (List(1, 3, 5), List(2, 4, 6)))

  test("foldHalvesSwap: empty list"):
    assertEquals(foldHalvesSwap(Nil), (Nil, Nil))

  def testSwapped[T](f: List[T] => (List[T], List[T]))(input: List[T], expected: (List[T], List[T])): Unit =
    val (first, second) = f(input)
    assert(first == expected._1 || first == expected._2)
    assert(second == expected._1 || second == expected._2)
    assertEquals((first ++ second).toSet, input.toSet)

  test("foldHalvesSwap: singleton list"):
    testSwapped(foldHalvesSwap)(List(1), (List(1), Nil))

  test("foldHalvesSwap: two-elements list"):
    testSwapped(foldHalvesSwap)(List('a', 'b'), (List('a'), List('b')))

  test("foldHalvesSwap: long odd list"):
    testSwapped(foldHalvesSwap)(
      List("a", "b", "c", "d", "e", "f", "g"),
      (List("a", "c", "e", "g"), List("b", "d", "f"))
    )

  test("foldHalvesSwap: long even list"):
    testSwapped(foldHalvesSwap)(List(1, 2, 3, 4, 5, 6), (List(1, 3, 5), List(2, 4, 6)))

  test("foldHalvesSwapSuccinct: empty list"):
    testSwapped(foldHalvesSwapSuccinct)(Nil, (Nil, Nil))

  test("foldHalvesSwapSuccinct: singleton list"):
    testSwapped(foldHalvesSwapSuccinct)(List(1), (List(1), Nil))

  test("foldHalvesSwapSuccinct: two-elements list"):
    testSwapped(foldHalvesSwapSuccinct)(List('a', 'b'), (List('a'), List('b')))

  test("foldHalvesSwapSuccinct: long odd list"):
    testSwapped(foldHalvesSwapSuccinct)(
      List("a", "b", "c", "d", "e", "f", "g"),
      (List("a", "c", "e", "g"), List("b", "d", "f"))
    )

  test("foldHalvesSwapSuccinct: long even list"):
    testSwapped(foldHalvesSwapSuccinct)(List(1, 2, 3, 4, 5, 6), (List(1, 3, 5), List(2, 4, 6)))

  test("interleave: two empty lists"):
    assertEquals(interleave((Nil, Nil)), Nil)

  test("interleave: second list empty"):
    assertEquals(interleave((List(1, 2, 3), Nil)), List(1, 2, 3))

  test("interleave: first list empty"):
    assertEquals(interleave((Nil, List("a", "b", "c"))), List("a", "b", "c"))

  test("interleave: two non-empty lists of the same length"):
    assertEquals(interleave((List(1, 2, 3), List("a", "b", "c"))), List(1, "a", 2, "b", 3, "c"))

  test("interleave: two non-empty lists, first longer"):
    assertEquals(interleave((List(1, 2, 3, 4), List("a", "b", "c"))), List(1, "a", 2, "b", 3, "c", 4))

  test("interleaveUnfold: two empty lists"):
    assertEquals(interleaveUnfold((Nil, Nil)), Nil)

  test("interleaveUnfold: second list empty"):
    assertEquals(interleaveUnfold((List(1, 2, 3), Nil)), List(1, 2, 3))

  test("interleaveUnfold: first list empty"):
    assertEquals(interleaveUnfold((Nil, List("a", "b", "c"))), List("a", "b", "c"))

  test("interleaveUnfold: two non-empty lists of the same length"):
    assertEquals(interleaveUnfold((List(1, 2, 3), List("a", "b", "c"))), List(1, "a", 2, "b", 3, "c"))

  test("interleaveUnfold: two non-empty lists, first longer"):
    assertEquals(interleaveUnfold((List(1, 2, 3, 4), List("a", "b", "c"))), List(1, "a", 2, "b", 3, "c", 4))

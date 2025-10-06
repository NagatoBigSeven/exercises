package comprehensions

import collection.immutable.List

class ForCompTest extends munit.FunSuite:
  val twoLetterWords: List[String] =
    List("at", "or", "be", "in", "to", "by")

  val threeLetterWords: List[String] =
    List("and", "tea", "ate", "for", "six", "try", "sin", "see")

  val fourLetterWords: List[String] =
    List("name", "tree", "list", "like")

  test("onlyThreeLetterWords: empty list returns empty list"):
    assertEquals(onlyThreeLetterWords(Nil), Nil)

  test("onlyThreeLetterWords: return the correct words in the right order"):
    assertEquals(onlyThreeLetterWords(threeLetterWords ++ twoLetterWords ++ fourLetterWords), threeLetterWords)

  test("onlyThreeLetterWords: returns empty list if no three letter words"):
    assert(onlyThreeLetterWords(twoLetterWords ++ fourLetterWords).isEmpty)

  test("louder: empty list returns empty list"):
    assertEquals(louder(Nil), Nil)

  test("louder: non-empty list returns non-empty list"):
    assertEquals(louder(List("a", "bc", "def", "ghij")), List("A", "BC", "DEF", "GHIJ"))

  test("echo(0): empty list returns empty list"):
    assertEquals(echo(Nil, 0), Nil)

  test("echo(1): empty list returns empty list"):
    assertEquals(echo(Nil, 1), Nil)

  test("echo(0): non-empty list returns non-empty list"):
    assertEquals(echo(List("a", "bc", "def", "ghij"), 0), List())

  test("echo(1): non-empty list returns non-empty list"):
    assertEquals(echo(List("a", "bc", "def", "ghij"), 1), List("a", "bc", "def", "ghij"))

  test("echo(2): non-empty list returns non-empty list"):
    assertEquals(echo(List("a", "bc", "def", "ghij"), 2), List("a", "a", "bc", "bc", "def", "def", "ghij", "ghij"))

  test("allTogether(0): empty list returns empty list"):
    assertEquals(allTogether(Nil, 0), Nil)

  test("allTogether(1): empty list returns empty list"):
    assertEquals(allTogether(Nil, 1), Nil)

  test("allTogether(0): non-empty list returns non-empty list"):
    assertEquals(allTogether(List("All", "together", "now"), 0), List())

  test("allTogether(1): non-empty list returns non-empty list"):
    assertEquals(allTogether(List("All", "together", "now"), 1), List("ALL", "NOW"))

  test("allTogether(2): non-empty list returns non-empty list"):
    assertEquals(allTogether(List("All", "together", "now"), 2), List("ALL", "ALL", "NOW", "NOW"))

  test("crossProduct: generate menu"):
    val mains = List("Burger", "Pizza", "Pasta")
    val sides = List("Salad", "Soup")
    val meals = List(
      ("Burger", "Salad"),
      ("Burger", "Soup"),
      ("Pizza", "Salad"),
      ("Pizza", "Soup"),
      ("Pasta", "Salad"),
      ("Pasta", "Soup")
    )
    assertEquals(crossProduct(mains, sides), meals)

  test("permutations of 'abc'"):
    val res = distinctPairs("abc".toCharArray().toSeq)
    assertEquals(res.toSet, Seq(('a', 'b'), ('a', 'c'), ('b', 'a'), ('b', 'c'), ('c', 'a'), ('c', 'b')).toSet)

  test("permutations of ''"):
    assertEquals(distinctPairs(Nil), Nil)

  test("permutations of AaBb"):
    val res = distinctPairs("AaBb".toCharArray().toSeq)
    val expected = Seq(
      ('A', 'a'),
      ('A', 'B'),
      ('A', 'b'),
      ('a', 'A'),
      ('a', 'B'),
      ('a', 'b'),
      ('B', 'A'),
      ('B', 'a'),
      ('B', 'b'),
      ('b', 'A'),
      ('b', 'a'),
      ('b', 'B')
    )
    assertEquals(res.toSet, expected.toSet)

  test("validInts: empty list returns empty list"):
    assertEquals(validInts(Nil), Nil)

  test("validInts: list with no valid integers returns empty list"):
    assertEquals(validInts(List("a", "b", "c")), Nil)

  test("validInts: list with some valid integers returns list of valid integers"):
    assertEquals(validInts(List("1", "a", "2", "b", "3")), List(1, 2, 3))

  test("validInts: list with all valid integers returns list of valid integers"):
    assertEquals(validInts(List("1", "2", "3")), List(1, 2, 3))

  test("validInts: list with negative and positive valid integers returns list of valid integers"):
    assertEquals(validInts(List("-1", "2", "-3", "4")), List(-1, 2, -3, 4))

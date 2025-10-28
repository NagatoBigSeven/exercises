package mutualRecursion

import MutualRecursion.*

abstract class MutualRecursionSuite(impl: TreeFns) extends munit.FunSuite:
  import MutualRecursion.Tree.*
  import MutualRecursion.TreeList.*

  val emptyTree: Tree[Int] = Node(Nil)
  val exampleTree: Tree[Int] = Node(
    Cons(
      Leaf(1),
      Cons(
        Node(Cons(Leaf(2), Cons(Leaf(3), Nil))),
        Cons(Node(Cons(Leaf(4), Cons(Leaf(5), Cons(Leaf(6), Nil)))), Nil)
      )
    )
  )
  val singleLeaf: Tree[Int] = Leaf(7)
  val fiveAryTree: Tree[Int] = Node(
    Cons(
      Node(Cons(Leaf(10), Cons(Leaf(11), Cons(Leaf(12), Cons(Leaf(13), Cons(Leaf(14), Nil)))))),
      Cons(
        Node(Cons(Leaf(20), Cons(Leaf(21), Cons(Leaf(22), Cons(Leaf(23), Cons(Leaf(24), Nil)))))),
        Cons(
          Node(Cons(Leaf(30), Cons(Leaf(31), Cons(Leaf(32), Cons(Leaf(33), Cons(Leaf(34), Nil)))))),
          Cons(
            Node(Cons(Leaf(40), Cons(Leaf(41), Cons(Leaf(42), Cons(Leaf(43), Cons(Leaf(44), Nil)))))),
            Cons(
              Node(Cons(Leaf(50), Cons(Leaf(51), Cons(Leaf(52), Cons(Leaf(53), Cons(Leaf(54), Nil)))))),
              Nil
            )
          )
        )
      )
    )
  )
  val unevenTree: Tree[Int] =
    Node(
      Cons(
        fiveAryTree,
        Cons(
          exampleTree,
          Cons(
            singleLeaf,
            Nil
          )
        )
      )
    )

  test("treeSum: empty tree"):
    assertEquals(impl.treeSum(emptyTree), 0)

  test("treeSum: example tree"):
    assertEquals(impl.treeSum(exampleTree), 21)

  test("treeSum: single leaf"):
    assertEquals(impl.treeSum(singleLeaf), 7)

  test("treeSum: five-ary tree"):
    assertEquals(
      impl.treeSum(fiveAryTree),
      (10 to 14).sum + (20 to 24).sum + (30 to 34).sum + (40 to 44).sum + (50 to 54).sum
    )

  test("treeSum: uneven tree"):
    assertEquals(
      impl.treeSum(unevenTree),
      0 + 21 + 7 + ((10 to 14).sum + (20 to 24).sum + (30 to 34).sum + (40 to 44).sum + (50 to 54).sum)
    )

  test("treeMax: empty tree"):
    intercept[java.lang.IllegalArgumentException]:
      impl.treeMax(emptyTree)

  test("treeMax: example tree"):
    assertEquals(impl.treeMax(exampleTree), 6)

  test("treeMax: single leaf"):
    assertEquals(impl.treeMax(singleLeaf), 7)

  test("treeMax: five-ary tree"):
    assertEquals(impl.treeMax(fiveAryTree), 54)

  test("treeMax: uneven tree"):
    assertEquals(impl.treeMax(unevenTree), 54)

class SideBySideSuite extends MutualRecursionSuite(SideBySide)


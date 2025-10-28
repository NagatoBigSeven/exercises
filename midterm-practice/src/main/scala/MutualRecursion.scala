package mutualRecursion

object MutualRecursion:
  enum Tree[+V]:
    case Leaf(value: V)
    case Node(subtrees: TreeList[V])

  enum TreeList[+V]:
    case Nil
    case Cons(t: Tree[V], ts: TreeList[V])

  import Tree.*
  import TreeList.*

  trait TreeFns:
    def treeSum(t: Tree[Int]): Int
    def treeMax(t: Tree[Int]): Int

  object SideBySide extends TreeFns:
    def listSum(ts: TreeList[Int]): Int =
      ???

    def treeSum(t: Tree[Int]): Int =
      ???

    def listMax(ts: TreeList[Int]): Int =
      ???

    def treeMax(t: Tree[Int]): Int =
      ???


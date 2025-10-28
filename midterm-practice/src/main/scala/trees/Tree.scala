package trees

case class Tree(val value: String, val children: Seq[Tree])

/** Utility function to define a Tree with no children (a leaf) */
def Leaf(value: String): Tree = Tree(value, Nil)

type Forest = Seq[Tree]

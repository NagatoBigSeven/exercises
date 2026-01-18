package recursion

def treeSize(t: IntTree): Int =
  t match
    case IntEmptyTree() => 0
    case IntBranch(_, left, right) => 1 + treeSize(left) + treeSize(right)

def treeDepth(t: IntTree): Int =
  t match
    case IntEmptyTree() => 0
    case IntBranch(_, left, right) =>
      val leftDepth = treeDepth(left)
      val rightDepth = treeDepth(right)
      1 + scala.math.max(leftDepth, rightDepth)

def treeSum(t: IntTree): Int =
  t match
    case IntEmptyTree() => 0
    case IntBranch(value, left, right) => value + treeSum(left) + treeSum(right)
  
def treeAllEven(t: IntTree): Boolean =
  t match
    case IntEmptyTree() => true
    case IntBranch(value, left, right) => (value % 2 == 0) && treeAllEven(left) && treeAllEven(right)

def treeIncrement(t: IntTree): IntTree =
  t match
    case IntEmptyTree() => IntEmptyTree()
    case IntBranch(value, left, right) => IntBranch(value + 1, treeIncrement(left), treeIncrement(right))

def treeShow(t: IntTree): String =
  t match
    case IntEmptyTree() => ""
    case IntBranch(value, left, right) =>
      val leftStr = treeShow(left)
      val rightStr = treeShow(right)
      value.toString + "\n" + leftStr + rightStr

def treeShowPostOrder(t: IntTree): String =
  t match
    case IntEmptyTree() => ""
    case IntBranch(value, left, right) =>
      val leftStr = treeShowPostOrder(left)
      val rightStr = treeShowPostOrder(right)
      leftStr + rightStr + value.toString + "\n"

def treeShowInOrder(t: IntTree): String =
  t match
    case IntEmptyTree() => ""
    case IntBranch(value, left, right) =>
      val leftStr = treeShowInOrder(left)
      val rightStr = treeShowInOrder(right)
      leftStr + value.toString + "\n" + rightStr

package patmat

import BSTContext.*

object BSTOps:
  import EnumContext.LookupResult
  import LookupResult.*

  def lookup(bst: BSTContext, key: String): LookupResult =
    bst match
      case Leaf => NotFound
      case Branch(k, v, l, r) =>
        if key == k then Ok(v)
        else if key < k then lookup(l, key)
        else lookup(r, key)

  def insert(bst: BSTContext, key: String, v: Int): BSTContext =
    bst match
      case Leaf => Branch(key, v, Leaf, Leaf)
      case Branch(k, value, l, r) =>
        if key == k then Branch(k, v, l, r)
        else if key < k then Branch(k, value, insert(l, key, v), r)
        else Branch(k, value, l, insert(r, key, v))

  def rotateLeft(tree: BSTContext): BSTContext =
    tree match
      case Leaf => Leaf
      case Branch(k1, v1, p, Leaf) => tree
      case Branch(k1, v1, p, Branch(k2, v2, q, r)) => Branch(k2, v2, Branch(k1, v1, p, q), r)

  def rotateRight(tree: BSTContext): BSTContext =
    tree match
      case Leaf => Leaf
      case Branch(k2, v2, Leaf, r) => tree
      case Branch(k2, v2, Branch(k1, v1, p, q), r) => Branch(k1, v1, p, Branch(k2, v2, q, r))

package debugging

def contains(l: IntList, n: Int): Boolean =
  !l.isEmpty && (l.head == n || contains(l.tail, n))

def removeDuplicates(l: IntList): IntList =
  l match
    case IntNil() => IntNil()
    case IntCons(hd, tl) =>
      if contains(tl, hd) then removeDuplicates(tl)
      else IntCons(hd, removeDuplicates(tl))

def remove(l: IntList, n: Int): IntList =
  l match
    case IntNil()         => IntNil()
    case IntCons(`n`, tl) => remove(tl, n)
    case IntCons(m, tl)   => IntCons(m, remove(tl, n))

def removeDuplicates_alt(l: IntList): IntList =
  l match
    case IntNil() => IntNil()
    case IntCons(hd, tl) =>
      IntCons(hd, removeDuplicates_alt(remove(tl, hd)))

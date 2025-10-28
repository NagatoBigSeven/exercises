package halvesAndInterleavings

def halves[A](l: List[A]): (List[A], List[A]) =
  ???

enum HalvesHelper[A]:
  case ExpectingEven(evens: List[A], odds: List[A])
  case ExpectingOdd(evens: List[A], odds: List[A])
import HalvesHelper.*

def foldHalvesWithHelper[A](l: List[A]): (List[A], List[A]) =
  ???

def foldHalvesSwap[A](l: List[A]): (List[A], List[A]) =
  l.foldRight[(List[A], List[A])]((Nil, Nil))((h, acc) =>
    (acc._2, h :: acc._1)
  )

def foldHalvesSwapSuccinct[A](l: List[A]): (List[A], List[A]) =
  l.foldRight[(List[A], List[A])]((Nil, Nil)) {
    case (h, (l, r)) => (r, h :: l)
  }

def interleave[A](ls: (List[A], List[A])): List[A] =
  ???

def interleaveUnfold[A](ls: (List[A], List[A])): List[A] =
  List.unfold[A, (List[A], List[A])](ls) { // See List.unfold in the docs
    // Case anonymous function
    case (Nil, Nil)     => None
    case (x :: t1, t2)  => Some((x, (t2, t1))) // Flip lists
    case (Nil, x :: t2) => Some((x, (Nil, t2)))
  }

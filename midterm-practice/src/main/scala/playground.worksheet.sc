import halvesAndInterleavings.*
import mutualRecursion.*
import sudoku.*
import trees.*

halves(List())
halves(List(1, 2, 3))
halves(List(1, 2, 3, 4))

foldHalvesWithHelper(List())
foldHalvesWithHelper(List(1, 2, 3))
foldHalvesWithHelper(List(1, 2, 3, 4))

foldHalvesSwap(List())
foldHalvesSwap(List(1, 2, 3))
foldHalvesSwap(List(1, 2, 3, 4))

foldHalvesSwapSuccinct(List())
foldHalvesSwapSuccinct(List(1, 2, 3))
foldHalvesSwapSuccinct(List(1, 2, 3, 4))

interleave(List(1, 2, 3), List("a", "b", "c"))
interleaveUnfold(List(1, 2, 3), List("a", "b", "c"))

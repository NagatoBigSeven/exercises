package sudoku

type Sudoku = Vector[Vector[Int]]

def columnHas(grid: Sudoku, col: Int, num: Int): Boolean =
  ???

def rowHas(grid: Sudoku, row: Int, num: Int): Boolean =
  ???

def regionHas(grid: Sudoku, row: Int, col: Int, num: Int): Boolean =
  ???

def isSafe(grid: Sudoku, row: Int, col: Int, num: Int): Boolean =
      ???

def updateCell(grid: Sudoku, row: Int, col: Int, num: Int): Sudoku =
      ???

def solveFrom(currentGrid: Sudoku, row: Int, col: Int): Option[Sudoku] =
  val N = 9

  if row == N - 1 && col == N then ???
  else if col == N then ???
  else if currentGrid(row)(col) != 0 then ???
  else
    val solutions =
      for
        num <- 1 to N
      yield ???
    if solutions.isEmpty then None else Some(solutions.head)

def sudoku(grid: Sudoku): Option[Sudoku] =
      ???

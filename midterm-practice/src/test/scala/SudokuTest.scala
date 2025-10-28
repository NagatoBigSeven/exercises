package sudoku

import munit.FunSuite
import munit.Clue.generate
import scala.collection.immutable.StringOps

def sudokuParser(linearGrids: String): List[(Sudoku, Option[Sudoku])] =
  def parseGrid(linearGrid: Vector[Int]): Sudoku =
    require(linearGrid.length == 81)
    (0 until 9).map(i => (0 until 9).map(j => linearGrid(i * 9 + j)).toVector).toVector

  def char2int(linearGrid: String): Vector[Int] =
    linearGrid.toVector.map(c => if c == '.' then 0 else c.asDigit)

  linearGrids.trim().split("\n").map(_.trim().split(":")).map(seq =>
    require(seq.length > 0)
    val query = parseGrid(char2int(seq.head))
    val tail: List[String] = seq.tail.toList
    tail match
      case Nil           => (query, None)
      case target :: Nil => (query, Some(parseGrid(char2int(target))))
      case _             => throw new Exception("Invalid input")
  ).toList

class SudokuTest extends FunSuite:

  val sudokuString: String = """
    .5..83.17...1..4..3.4..56.8....3...9.9.8245....6....7...9....5...729..861.36.72.4:652483917978162435314975628825736149791824563436519872269348751547291386183657294
    2.6.3......1.65.7..471.8.5.5......29..8.194.6...42...1....428..6.93....5.7.....13:256734198891265374347198652514683729728519436963427581135942867689371245472856913
    ..45.21781...9..3....8....46..45.....7.9...128.12.35..4.......935..6.8.7.9.3..62.:964532178187694235235817964629451783573986412841273596416728359352169847798345621
    59....147...9....8.72....3.7...4.29..2..3.8.68..17..5...5764..9.36..5...1..8....2:598326147314957628672481935753648291421539876869172453285764319936215784147893562
    9...84.6.6.4..52.7.3..7..8.76...15...53.....1...4.96.31.5.26.9...2.4....8....371.:927384165684915237531672489769231548453768921218459673175826394392147856846593712
    68.9.5.....3...5.84.21.87.339.72.8.........1..45..69...6.8.4..2..1..2.757...13...:687935241913247568452168793396721854278459316145386927569874132831692475724513689
    ...34...2..6.82.737..1..45..82..5.14....983..67......514.7.....9.5.3..2..3....8.6:851347692496582173723169458382675914514298367679413285148726539965834721237951846
    6...5.....73..8.2.854.27...2.17..53.4...69..7.8....9...273.1.84.6.54...93.......1:612453798973618425854927163291784536435269817786135942527391684168542379349876251
    ..75..9.4....823.5..16....28...36.7..16..42..43.19..5.54...8....29.71.3.......6.9:287513964964782315351649782895236471716854293432197856543968127629471538178325649
    28751396496478231535164978289523647171685429343219785654396812762947153817832564.:287513964964782315351649782895236471716854293432197856543968127629471538178325649
    287513964964782315351649782895236471716854293432197856543968127629471538.........:287513964964782315351649782895236471716854293432197856543968127629471538178325649
    2.75139649.47823153.16497828.52364717.68542934.21978565.39681276.94715381.8325649:287513964964782315351649782895236471716854293432197856543968127629471538178325649
    91.6..2..687.32159.2.9178.6.7..6.32116.3.49..53.12.647..1743.62..65.14..34.2.6.1.
    """

  val sudokus: List[(Sudoku, Option[Sudoku])] = sudokuParser(sudokuString)

  test("columnHas: finds element in first column"):
    assertEquals(columnHas(sudokus(1)._1, 0, 2), true)

  test("columnHas: sees there is no element in first column"):
    assertEquals(columnHas(sudokus(1)._1, 0, 3), false)

  test("columnHas: finds element in middle column"):
    assertEquals(columnHas(sudokus(1)._1, 4, 1), true)

  test("columnHas: sees there is no element in middle column"):
    assertEquals(columnHas(sudokus(1)._1, 4, 5), false)

  test("rowHas: finds element in first row"):
    assertEquals(rowHas(sudokus(0)._1, 0, 7), true)

  test("rowHas: sees there is no element in first row"):
    assertEquals(rowHas(sudokus(0)._1, 0, 4), false)

  test("rowHas: finds element in middle row"):
    assertEquals(rowHas(sudokus(0)._1, 4, 2), true)

  test("rowHas: sees there is no element in middle row"):
    assertEquals(rowHas(sudokus(0)._1, 4, 1), false)

  test("regionHas: finds element in top-left region"):
    assertEquals(regionHas(sudokus(7)._1, 0, 0, 7), true)

  test("regionHas: finds element in center region"):
    assertEquals(regionHas(sudokus(0)._1, 5, 5, 2), true)

  test("regionHas: finds element in center-right region"):
    assertEquals(regionHas(sudokus(2)._1, 5, 6, 1), true)

  test("regionHas: finds element in bottom-right region"):
    assertEquals(regionHas(sudokus(0)._1, 7, 7, 8), true)

  test("regionHas: sees there is no element in center-right region"):
    assertEquals(regionHas(sudokus(0)._1, 5, 6, 1), false)

  test("isSafe: returns false for element already in column"):
    assertEquals(isSafe(sudokus(0)._1, 1, 0, 3), false)

  test("isSafe: returns false for element already in row"):
    assertEquals(isSafe(sudokus(1)._1, 0, 5, 6), false)

  test("isSafe: returns false for element already in region"):
    assertEquals(isSafe(sudokus(0)._1, 1, 1, 3), false)

  test("isSafe: returns true for safe position"):
    assertEquals(isSafe(sudokus(0)._1, 4, 0, 7), true)

  test("updateCell: updates cell correctly"):
    val (grid, _) = sudokus(0)
    val updatedGrid = updateCell(grid, 0, 0, 9)
    assertEquals(updatedGrid(0)(0), 9)
    assertEquals(updatedGrid(0)(1), grid(0)(1))
    assertEquals(updatedGrid(1)(0), grid(1)(0))

  test("solveFrom: solves last empty cell successfully"):
    val (grid, solution) = sudokus(9)
    assertEquals(solveFrom(grid, 8, 8), solution)

  test("solveFrom: solves last empty row successfully"):
    val (grid, solution) = sudokus(10)
    assertEquals(solveFrom(grid, 8, 0), solution)

  test("solveFrom: solves empty second column successfully"):
    val (grid, solution) = sudokus(11)
    assertEquals(solveFrom(grid, 0, 1), solution)

  test("solveFrom: solves arbitrary sudoku grid successfully"):
    val (grid, solution) = sudokus(5)
    assertEquals(solveFrom(grid, 0, 2), solution)

  for (grid, solution) <- sudokus do
    solution match
      case Some(groundtruth) =>
        test("sudoku: solves valid sudoku puzzle"):
          assertEquals(sudoku(grid), Some(groundtruth))
      case None =>
        test("sudoku: returns None when no solution exists"):
          assertEquals(sudoku(grid), None)

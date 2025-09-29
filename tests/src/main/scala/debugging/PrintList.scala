package debugging

def printList[T](list: List[T]): Unit =
  if list.isEmpty then
    println("<empty>")
  println("<start>")
  println("1st element: " + list(0))
  println("2nd element: " + list(1))
  println("3rd element: " + list(2))
  for (item, i) <- list.zipWithIndex.drop(3) do
    println(f"${i}th element: $item")
  println("<end>")

package debugging

def squareAndMultiply(x: Double, n: Int): Double =
  if n < 0 then
    squareAndMultiply(1 / x, -n)
  else if x == 1 then
    1
  else if n == 0 then
    0
  else if n % 2 == 0 then
    squareAndMultiply(x * x, n / 2)
  else
    x * squareAndMultiply(x, n - 1)

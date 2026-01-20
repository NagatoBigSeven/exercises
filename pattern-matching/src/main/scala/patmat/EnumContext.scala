package patmat

object EnumContext:
  enum LookupResult:
    case Ok(v: Int)
    case NotFound

  import LookupResult.*
  enum Context:
    case Empty
    case Cons(name: String, value: Int, tail: Context)

  import Context.*

  def empty: Context =
    Empty

  def cons(name: String, value: Int, rem: Context) =
    Cons(name, value, rem)

  def lookup(ctx: Context, name: String): LookupResult =
    ctx match
      case Empty => NotFound
      case Cons(`name`, value, _) => Ok(value)
      case Cons(_, _, tail) => lookup(tail, name)

  def erase(ctx: Context, name: String): Context =
    ctx match
      case Empty => Empty
      case Cons(`name`, _, tail) => erase(tail, name)
      case Cons(n, value, tail) => Cons(n, value, erase(tail, name))

  def filter(ctx: Context, pred: (String, Int) => Boolean): Context =
    ctx match
      case Empty => Empty
      case Cons(name, value, tail) => 
        if pred(name, value) then
          Cons(name, value, filter(tail, pred))
        else
          filter(tail, pred)
    

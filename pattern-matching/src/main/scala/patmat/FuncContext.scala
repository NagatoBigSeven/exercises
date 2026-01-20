package patmat

object FuncContext:
  import EnumContext.LookupResult
  import LookupResult.*

  type Context =
    String => LookupResult

  def empty: Context =
    _ => NotFound

  def cons(name: String, value: Int, rem: Context): Context =
    _ match
      case `name` => Ok(value)
      case n => rem(n)

  def lookup(ctx: Context, name: String): LookupResult =
    ctx(name)

  def erase(ctx: Context, name: String): Context =
    _ match
      case `name` => NotFound
      case n => ctx(n)

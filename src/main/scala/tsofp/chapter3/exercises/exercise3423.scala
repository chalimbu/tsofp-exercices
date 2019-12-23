package tsofp.chapter3.exercises

object exercise3423 extends App{
  sealed trait RootOfLinear //ax + b = 0 (for arbitrary real a,b)
  case class NoRoots() extends RootOfLinear //if a=0
  case class OneRoot(x: Double) extends RootOfLinear // the rest
  case class AllXRoot() extends RootOfLinear //if a=b=0

  def solve1:((Double,Double)) => RootOfLinear = {
    case (0,_) => NoRoots()
    case (0,0) => AllXRoot()
    case (a,b) => OneRoot(-b/a)
  }

  println(Seq((0D,0D),(3D,4D)).map(solve1(_)))
}

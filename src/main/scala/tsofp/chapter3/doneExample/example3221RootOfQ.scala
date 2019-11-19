package tsofp.chapter3.doneExample

object example3221RootOfQ extends App{
  sealed trait RootsOfQ
  final case class NoRoots() extends RootsOfQ
  final case class OneRoot(x: Double) extends RootsOfQ
  final case class TwoRoots(x1:Double,x2:Double) extends RootsOfQ

  case class QEqu(b:Double,c:Double)

  def solve(quadraticEqu: QEqu):RootsOfQ= {
    quadraticEqu match {
      case QEqu(b, c) =>
        (b * b / 4 - c) match {
          case d if d > 0 => {
            val s = math.sqrt(d)
            TwoRoots(b / 2 - s, b / 2 + s)
          }
          case 0.0 => OneRoot(b / 2)
          case _ => NoRoots()
        }
    }
  }
  println(Seq(QEqu(1,1),QEqu(1,-1),QEqu(6,9)).map(solve(_)))
}

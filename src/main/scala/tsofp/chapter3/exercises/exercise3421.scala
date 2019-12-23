package tsofp.chapter3.exercises

import scala.collection.immutable.{AbstractSeq, LinearSeq}

object exercise3421 extends App{
  sealed trait CellState
  case class Close() extends CellState
  case class OpenShowBomb() extends CellState
  case class OpenShowClose(n: Int) extends CellState

  //3422
  def SumZeroBomsShown(state: Seq[Seq[CellState]]): Int={
    def doesItSum(cell: CellState): Int={
      cell match {
        case Close() => 1
        case OpenShowBomb() => 1
        case OpenShowClose(n) if n==0 => 1
        case _ => 0
      }
    }

    def sumLine(line: Seq[CellState],acu: Int=0):Int={
      line match{
        case Nil => acu
        case _ => sumLine(line.tail,acu+doesItSum(line.head))
      }
    }
    state.foldLeft(0){case (prev,linee) => prev+sumLine(linee)}
  }
  println(SumZeroBomsShown(Seq(Seq(Close(),OpenShowBomb(),Close()),Seq(Close(),OpenShowClose(3)))))


}

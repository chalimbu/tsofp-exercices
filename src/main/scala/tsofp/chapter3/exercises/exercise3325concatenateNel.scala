package tsofp.chapter3.exercises

import scala.annotation.tailrec

object exercise3325concatenateNel extends App{
  sealed trait NEL[A]
  final case class Last[A](head: A) extends NEL[A]
  final case class More[A](head: A,tail: NEL[A]) extends NEL[A]


  def concat[A](xs: NEL[A],ys: NEL[A]):NEL[A]= {

    def concatInter(xs: NEL[A],subxs: NEL[A]): NEL[A] ={
      subxs match {
        case Last(head) => More(head,ys)
        case More(head, tail) => More(head,concatInter(xs,tail))
      }
    }
    concatInter(xs,xs)
  }
  def tailNEL[A](nel: NEL[A]):NEL[A]={
    nel match {
      case Last(head) => Last(head)
      case More(head, tail) => tail
    }
  }

  println(concat(More(1,More(2,Last(3))),More(4,Last(5))))

}

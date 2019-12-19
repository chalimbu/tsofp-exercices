package tsofp.chapter3.exercises

import scala.annotation.tailrec

object exercise3323NelToList extends App{
  sealed trait NEL[A]
  final case class Last[A](head: A) extends NEL[A]
  final case class More[A](head: A,tail: NEL[A]) extends NEL[A]

  def toList[A](nel: NEL[A]): List[A] = {
    @tailrec
    def tOlistHelpher(nel: NEL[A],acumulator: List[A]):List[A]={
      nel match {
        case Last(head) => acumulator:+head
        case More(head, tail) => tOlistHelpher(tail,acumulator:+head)
      }
    }
    tOlistHelpher(nel,List[A]())
  }

  println(toList(More(1,More(2,Last(3)))))

}

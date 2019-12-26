package tsofp.chapter3.exercises

object exercise3428 extends App{
  sealed trait EventList[A]
  case class PairElement[A](a: A,b:A,rest: EventList[A]) extends EventList[A]
  case class EmptyElement[A]() extends EventList[A]

  def foldleft[I,A](eventList: EventList[A])(init: I)(f: (I,A)=> I):I= {
    eventList match {
      case PairElement(a, b, rest) => foldleft(rest)(f(f(init,a),b))(f)
      case EmptyElement() => init
    }
  }
  println(foldleft(PairElement("3","4",PairElement("5","6",EmptyElement())))("")(_+_))

  def map[A,B](eventList: EventList[A])(f: A=>B):EventList[B]={
    eventList match {
      case PairElement(a, b, rest) => PairElement[B](f(a),f(b),map(rest)(f))
      case EmptyElement() => EmptyElement()
    }
  }
  println(map(PairElement("3","4",PairElement("5","6",EmptyElement())))(_.toInt))

}

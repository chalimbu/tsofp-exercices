package tsofp.chapter2.exercises

object exercise25213 extends App{
  def unfold2[A,B](init: A)(next: A=> Option[(A,B)]): LazyList[B] = {
    next(init) match {
      case Some(value) => {
        val initialValue: Option[(A, B)] =Some(value)
        LazyList.iterate(initialValue){
          case Some(value) => {
            next(value._1)
          }
        }.takeWhile(x=> x match {
          case Some(value) => true
          case None =>false
        }).collect{case Some(value)=>value._2}
      }
      case None => LazyList.empty
    }
  }
  println(unfold2(0){x=> if(x>5) None else Some ((x+2,s"had $x"))}.toList.toString())
}

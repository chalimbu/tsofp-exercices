package tsofp.chapter2.exercises

object exercise25210 extends App{
  def skip[A](xs: Seq[A]): Seq[(A,A)]= {
    val newList: Seq[A] =xs.tail.tail
    xs.zip(newList)
  }
  println(skip(List(1,2,3,4,5)))
                  //5 1 2 3 4 5
                  //3 4 5
  //List((1,3),(2,4),(3,5))
}

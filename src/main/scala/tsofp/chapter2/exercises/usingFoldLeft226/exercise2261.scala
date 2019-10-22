package tsofp.chapter2.exercises.usingFoldLeft226

object exercise2261 extends App{
  def fromPairs[A](xs: Seq[(A,A)]): Seq[A] =
    xs.foldLeft(Seq[A]()){(a,b)=>(a:+b._1:+b._2)}

  println(fromPairs(Seq((1,2),(3,4))))
  //List(1,2,3,4)

}

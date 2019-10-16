package tsofp.chapter2.exercises

object exercise2175 extends App{
  val p: Seq[String] =Seq("a","se","quen","si")
  val q: Seq[Int]= Seq(1,2,3,4)
  val mapping=q.zip(p).toMap
  println(mapping)
}

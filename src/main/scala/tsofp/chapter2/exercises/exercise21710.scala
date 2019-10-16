package tsofp.chapter2.exercises

object exercise21710 extends App{
  val list=Seq(List(1,2,3,4,5),List(2,1,4,56,2),List(1,2))
  val result=list.map(_.sortBy(-_).take(3))
  println(result)

}

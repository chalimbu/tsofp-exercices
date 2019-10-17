package tsofp.chapter2.doneExamples

object foldLeftExample extends App{
  val digits=Seq(1,2,4,5)
  val res=digits.foldLeft(0){case (prev,x)=>prev*10+x}
  println(res)
}

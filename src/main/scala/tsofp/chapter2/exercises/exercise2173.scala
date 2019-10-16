package tsofp.chapter2.exercises

object exercise2173 extends App{
val seq1=Seq("Hi","None","Some")
  val seq2=Seq(false,true,true)
  val result=seq1.zip(seq2).filter{case(a,b)=>b}.map{case (a,b)=>a}
  println(result)
}

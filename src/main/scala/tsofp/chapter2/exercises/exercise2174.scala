package tsofp.chapter2.exercises

object exercise2174 extends App{
  val initialSeq=Seq(1,3,2,4)
  val modifiedInitial=initialSeq:+initialSeq.min
  val comparationSequence=modifiedInitial.zip(modifiedInitial.tail)
  val resulting=comparationSequence.map{case (actual,second)=>(actual,second>actual)}
  println(resulting)
}

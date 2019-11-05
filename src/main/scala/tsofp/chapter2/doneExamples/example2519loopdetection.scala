package tsofp.chapter2.doneExamples

object example2519loopdetection extends App{
  //stop a stream at a place k where the sequence repeats itself; that is an element  sk equals some earlier
  //element si with i<k

  val seq= Seq(1,3,5,7,9,3,5,7,9)
  val halfSpeedSeq= seq.flatMap(a=>Seq(a,a))
  val result=halfSpeedSeq.zip(seq)
      .drop(1)
      .takeWhile{case(h,s)=> h!=s}
      .map(_._2)

  println(seq.head+:result)

}

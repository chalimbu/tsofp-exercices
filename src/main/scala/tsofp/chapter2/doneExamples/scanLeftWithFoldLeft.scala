package tsofp.chapter2.doneExamples

object scanLeftWithFoldLeft extends App{

  def partialSums(xs: Seq[Int]): Seq[Int]=
    xs.scanLeft(0){_+_}
  println(partialSums(Seq(1,2,3,4)))
  //List(0,1,3,6,10)
  def scanLeftM[A,B](xs: Seq[A])(b0: B)(next: (B,A)=>B):Seq[B]={
    val init:(B,Seq[B])=(b0,Seq(b0))
    val (_,result)=xs.foldLeft(init){case ((b,seq),x)=>
      val newB=next(b,x)
      (newB,seq++Seq(newB))
    }
    result
  }
  println(scanLeftM(Seq(1,2,3,4))(0){_+_})
}

package tsofp.chapter2.doneExamples.section24sequencetosequence

object partialSum extends App{
    def partialSum(xs:Seq[Int])= xs.scanLeft(0){case (x,y)=>{x+y}}
  println(partialSum(Seq(123,234,4,4,5)))

  def scanLeftM[A,B](xs: Seq[A])(bo: B)(next: (B,A)=>B):Seq[B]={
    val init:(B,Seq[B])=(bo,Seq(bo))
    val (_,result)=xs.foldLeft(init){case ((b,seq),x)=>
      val newB=next(b,x)
      (newB,seq++Seq(newB))
    }
    result
  }
  println(scanLeftM[Int,Int](Seq(123,234,4,4,5))(0)((x,y)=>x+y))

}

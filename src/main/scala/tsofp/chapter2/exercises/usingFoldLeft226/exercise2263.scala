package tsofp.chapter2.exercises.usingFoldLeft226

object exercise2263 extends App{
  //use fold left to implement zipWithIndex method for sequences
  def zipWithIndex[A](xs: Seq[A]): Seq[(A,Int)] = {
    xs.foldLeft(Seq[(A,Int)]()){(prev,nex)=>
      if(prev==Seq()) Seq((nex,0))
      else { prev:+(nex,prev.last._2+1)}
    }
  }

  println(zipWithIndex(Seq("a","b","c","d")))

}

package tsofp.chapter2.exercises.usingFoldLeft226

object exercise2264FilterMap extends App{
  //use foldleft to implement a function filtermap that combines .map and filter for sequences.
  def filterMap[A,B](xs: Seq[A])(pred: A=>Boolean)(f: A=>B): Seq[B] = {
    xs.foldLeft(Seq[B]()){(prev,nex)=>
      if(!pred(nex)) prev
      else prev:+f(nex)
    }
  }

  println(filterMap(Seq(1,2,3,4)){x=>x>2}{x=>x*10})
  //List(30,40)

}

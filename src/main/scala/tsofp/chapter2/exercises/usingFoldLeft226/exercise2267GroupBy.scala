package tsofp.chapter2.exercises.usingFoldLeft226

object exercise2267GroupBy extends App{
  def groupBy[A,K](xs: Seq[A])(by: A=>K): Map[K,Seq[A]] ={
    xs.foldLeft(Map[K,Seq[A]]()){ (prev,next)=> {
      val index=by(next)
      val state: Seq[A] =prev.getOrElse(index,Seq(next))
      if(prev.contains(index)){
        prev.updated(index,state:+next)
      }else{
        prev.updated(index,state)
      }
    }

    }
  }

  println(groupBy(Seq(1,2,3,4,5)){x=>x%2})
  // Map(1->List(1,3,5),0->List(2,4))
}

package tsofp.chapter2.exercises

object exercise25215 extends App{
  def maxsub(xs: Seq[Double]): Seq[Double]= {
    val initFinal=Seq(Double.MinValue)
    val init: List[List[Double]]=List()
    xs.foldLeft(init){ case (prev,next)=>{
        //duplicate the squence of previus and add next to duplicate
        //val newDuplicate: List[List[Double]] =prev.map(x=>x:+next)
        val nextSequence: List[List[Double]] =(prev):+List(next)
        nextSequence
      }
    }.foldLeft(initFinal){ case (prev,next)=>{
      if(prev.sum>next.sum){
        prev
      }else{
        next
      }
    }
    }
  }
  println(maxsub(Seq(1.0,-1.5,2.0,3.0,-0.5,2.0,1.0,-10.0,20)))
  //List(2.0 ,3.0, -0.5, 2.0, 1.0)
}

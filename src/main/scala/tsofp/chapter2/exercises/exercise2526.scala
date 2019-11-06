package tsofp.chapter2.exercises

object exercise2526 extends App{
  def pairs(goal: Int,xs: Array[Int]): Set[(Int,Int)] = {
    val xsSeq: Seq[Int] =xs.toSeq
    val mixing: Seq[(Int,Int)] =xsSeq.flatMap(x=>xsSeq.map(y=>{
      (x,y)
    }))
    val condition=mixing.filter{case(a,b)=>(a+b)==10}.toSet
    condition.foldLeft(Set[(Int,Int)]()){case (prev,next)=>{
      if(prev.contains((next._2,next._1))){prev}
      else prev+next
    }}
  }

  println(pairs(10,Array(1,2,3,4,5,6,7,8)))
  //Set( (2,8), (3,7), (4,6), (5,5))
}

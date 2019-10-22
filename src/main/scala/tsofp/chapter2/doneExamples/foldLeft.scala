package tsofp.chapter2.doneExamples

object foldLeft extends App{
  def maxOwn(s: Seq[Int])={
    s.foldLeft(Int.MinValue)((pre,next)=>if(next>pre)next else pre)
  }
  print(maxOwn(Seq(3,1,3,10,7)))
  def minMaxMed(s: Seq[Int])={
    val init=(Int.MinValue,Int.MaxValue,0)
    val triple=s.foldLeft(init){(a,b)=>(Math.max(a._1,b),Math.min(a._2,b),a._3+b)}
    val result=(triple._1,triple._2,triple._3/s.length)
    result
  }
  println(minMaxMed(Seq(3,4,5,1,3,4,10)))
}

package tsofp.chapter2.exercises.usingFoldLeft226

object exercise2265byLength extends App{
  def byLength[A](xs: Seq[A],length: Int): Seq[Seq[A]] = {
    val res=xs.foldLeft(Seq(Seq[A]()),0.toInt) { (prev, next) =>
      if(prev._2%length==0){
        if(prev._2==0){
          (Seq(Seq(next)),1)
        }else{
          (prev._1:+Seq(next),prev._2+1)
        }
      }else{
        val last: Seq[A] =prev._1.last:+next
        val recreating: Seq[Seq[A]] =prev._1.dropRight(1)
        (recreating:+last,prev._2+1)
      }
    }
    res._1
  }

  println(byLength(Seq("a","b","c","d"),2))
  //List(List(a,b),List(c,d))
  print(byLength(Seq(1,2,3,4,5,6,7),3))
  //List(List(1,2,3),List(4,5,6),List(7))
}

package tsofp.chapter2.exercises.usingFoldLeft226

object exercise2266ByWeight extends App {
  def byWeight[A](xs: Seq[A],maxW: Double)(w:A=>Double):Seq[Seq[A]]= {
    case class byWeight(batches:Seq[Seq[A]],currentWeighInBatch:Double)
    val res=xs.foldLeft(byWeight(Seq(Seq()),0)){(prev,next)=>{
      val weighOfElement=w(next)
      if(prev.currentWeighInBatch+weighOfElement>maxW){
        if(weighOfElement>maxW) prev
        else if(prev==byWeight(Seq(Seq()),0)) byWeight(Seq(Seq(next)),0)
        else byWeight(prev.batches:+Seq(next),weighOfElement)
      }else{
        val last =prev.batches.last:+next
        val recreating=prev.batches.dropRight(1)
        byWeight(recreating:+last,prev.currentWeighInBatch+weighOfElement)
      }
    }}
    res.batches
  }

  println(byWeight((1 to 10).toList,5.75){math.sqrt(_)})
  //List(List(1,2,3),List(4,5),List(6,7),List(8),List(8),List(9),List(10))
}

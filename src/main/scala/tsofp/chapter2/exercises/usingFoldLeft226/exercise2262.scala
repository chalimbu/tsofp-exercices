package tsofp.chapter2.exercises.usingFoldLeft226

import scala.annotation.tailrec
import scala.collection.immutable.{AbstractSeq, LinearSeq}

object exercise2262 extends App{


  @tailrec
  def addRecursively[A](initialState:Seq[A],addSeq: Seq[A],finish: Boolean):Seq[A]={
    if(finish) initialState
    else if(addSeq.length==0) addRecursively(initialState,addSeq,true)
    else addRecursively(initialState:+addSeq.head,addSeq.tail,false)
  }


  def flatten[A](xxs: Seq[Seq[A]]): Seq[A]= {
    xxs.foldLeft(Seq[A]()) { (previus, next) => {
      addRecursively(previus, next, false)
    }
    }
  }
  println(flatten(Seq(Seq(1,2,3),Seq(),Seq(4))))

}

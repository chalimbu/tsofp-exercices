package tsofp.chapter2.exercises

import scala.collection.immutable.{AbstractSeq, LinearSeq}

object exercise25215subsequenceBigger extends App{
  def maxsub(xs: Seq[Double]): Seq[Double]= {
    val allPosible: Seq[List[Double]] =postSequences(xs.toList).foldLeft(postSequences(xs.toList)){
      case (prev,next)=>{
        preSequences(next) ++ prev
      }
    }
    allPosible.maxBy(x=>x.sum)
  }
  def preSequences(xs:List[Double]):List[List[Double]]={
    xs match {
      case Nil => List()
      case _ => val init: Seq[Double] =xs
        LazyList.iterate(xs){ case (x)=>
          x.tail
        }.takeWhile(!_.isEmpty).toList
    }
  }

  def postSequences(xs: List[Double]): List[List[Double]]={
    xs match {
      case Nil => List()
      case _ => val init: List[List[Double]]=List()
        xs.foldLeft(init){ case (prev,next)=>
          val asdf: List[List[Double]] =prev
          val asdfa: Double = next
          prev match {
            case Nil=> List(List(next))
            case _ => val newELement: List[Double] = prev.last:+next
              prev:+newELement
          }
        }
    }
  }


  println(preSequences(List(2,3,4)))
  //2,3,4 3,4 4
  println(postSequences(List(1,2,3,4)))
  //1 1,2 1,2,3 1,2,3,4
  println(maxsub(Seq(1.0,-1.5,2.0,3.0,-0.5,2.0,1.0,-10.0,2.0)))
  //List(2.0 ,3.0, -0.5, 2.0, 1.0)
}

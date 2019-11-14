package tsofp.chapter2.exercises

object exercise25214 extends App{
  //remove repeated elements(wheter adjacent or not) from a sequence of type Seq[A]
  def removeRepeated[A](sequence: Seq[A]): Seq[A]= {
    sequence.toSet.toList
  }
  println(removeRepeated(Seq("a","b","a","b","b","c","b","a")))

  def removeK[A](sequence: Seq[A],k: Int): Seq[A]= {
    if(sequence.isEmpty){
      List()
    }else{
      //the maps saves for each value how many times has repeated and the sequence holds hte actual values
      val init: (Map[A,Int],Seq[A])=(Map(),Seq())
      //sequence.toSet.toList
      sequence.foldLeft(init){case ((valuesCounter,returnSequence),next)=>{
        val newValuesCounter:Map[A,Int]= if(valuesCounter.contains(next)){valuesCounter.updated(next,valuesCounter(next)+1)}else{
          valuesCounter + (next -> 0)
        }
        if(newValuesCounter(next)<k){
          (newValuesCounter,returnSequence:+next)
        }else{
          (newValuesCounter,returnSequence)
        }
      }
      }._2
    }
  }
  println(removeK(Seq("a","b","a","b","b","c","b","a"),2))
  // List(a, b, a, b, c)

}

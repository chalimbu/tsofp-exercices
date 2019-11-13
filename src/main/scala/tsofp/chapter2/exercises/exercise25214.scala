package tsofp.chapter2.exercises

object exercise25214 extends App{
  //remove repeated elements(wheter adjacent or not) from a sequence of type Seq[A]
  def removeRepeated[A](sequence: Seq[A]): Seq[A]= {
    sequence.toSet.toList
  }
  println(removeRepeated(Seq("a","b","a","b","b","c","b","a")))
}

package tsofp.chapter2.exercises

object exercise2525SetsFromSets extends App{
  def prod3(a: Set[Set[Int]]):Set[Set[Int]]= {
    //val result: Set[Set[Int]] =a.flatMap(av=>{b.flatMap(bv=>c.map(Set(av,bv,_)))})
    //    result
    val init = (0, Set(Set[Int]()))
    a.foldLeft(init) { case ((current, sets), next) => {
      if (current == 0) {
        (1, next.map(Set(_)))
      } else {
        val newSets: Set[Set[Int]] = sets.flatMap(set => {
          next.map(element => {
            set + element
          })
        })
        (current+1,newSets)
      }
    }
    }._2
  }

  println(prod3(Set(Set(1,2),Set(3),Set(4,5),Set(6))))
  //Set(Set(1,3,4), Set(1,3,5), Set(2,3,4) Set(2,3,5))
}

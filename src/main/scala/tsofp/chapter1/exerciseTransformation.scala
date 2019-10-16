package tsofp.chapter1

object exerciseTransformation extends App{
  def adds20(list: List[List[Int]]) = {
    list.map(_.map(x=>x+20))
  }
  val result=adds20(List(List(1),List(2,3)))
  println(result)

  def threeFactorIntegers()={
    val limit=1000
    (1 to 1000)
      .filter(n=>{
        if(n<=2)false
        else if( (2 to n).filter(j=> n%j==0).size==3 ) true
        else false
      })
  }
  println(threeFactorIntegers)

}

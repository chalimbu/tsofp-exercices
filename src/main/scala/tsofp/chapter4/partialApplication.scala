package tsofp.chapter4

object partialApplication extends App{
  def f2(a: Int,b: Int): Int = a-b

  val r2 = f2(3,_)
  println(r2(3))

  val r3: Int => Int = {y=> f2(3,y)}

  //from uncurried to curried
  val f1c: Int => Int => Int = (f2 _).curried

  //from curried to uncurried
  val f2u: (Int, Int) => Int =Function.uncurried(f1c)
}

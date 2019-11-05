package tsofp.chapter2.exercises

object exercise2523 extends App{
  def cubes(n:Int):LazyList[Int]= {
    LazyList.iterate(n){sumCubeOfDigits}
  }
  def sumCubeOfDigits(n:Int): Int ={
    LazyList.iterate(n){_/10}.takeWhile(_>0).map(_%10).foldLeft(0)((prev,next)=>prev+(next*next*next))
  }

  println(cubes(123).take(10).toList)
  //List(123,36,243,99,1458,702,351,153,153,153)
  println(cubes(2).take(10).toList)
  //List(2,8,512,134,92,737,713,371,371,371)
  println(cubes(4).take(10).toList)
  //List(4,64,280,520,133,55,250,133,55,250)

  //actual is repeated sequence
  def cubesReach1(n:Int):Boolean={
    val originalSequence=cubes(n)
    val halfSpeedSequence=originalSequence.flatMap(x=>Seq(x,x))
    val tupleSequence=originalSequence.zip(halfSpeedSequence).drop(1)
      .takeWhile{case(h,s)=> h!=s && s!=1}
    tupleSequence.map(_._1).last==1
  }
  println(cubesReach1(4))
}

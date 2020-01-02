package tsofp.chapter4

object forwardComposition extends App{

  val f: Int => Double = ( x => 5.67 + x)
  val g: Double => String = (x => f"Result x = $x%3.2f")

  val h = f andThen g

  println(h(40))
}

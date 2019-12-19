package tsofp.chapter3.doneExample

object optionWithCollections extends App{
  val res1=(1 to 10).find(_>5)
  println(res1)

  println((1 to 100).lift(10))

  println((15 to 100).headOption)

  //lift over (), get over ()

  println((1 to 10).find{x=>true}.getOrElse("None"))
  val map= Map(10 -> "a",20 -> "b")
  println(s"printing a get that does not exist ${map.get(2)}")
  println(map.get(10))

}

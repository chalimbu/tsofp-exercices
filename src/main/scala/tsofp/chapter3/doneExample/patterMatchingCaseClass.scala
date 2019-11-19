package tsofp.chapter3.doneExample

object patterMatchingCaseClass extends App{
  case class MySock(size: Double, color: String)
  case class BagOfSocks(sock: MySock, count: Int)

  def printBag(bag: BagOfSocks):  String={
    val BagOfSocks(MySock(size,color),count)=bag
    s"bag has $count socks of size $size"
  }

  println(printBag(BagOfSocks(MySock(3,"blue"),10)))

  def fitsMe(bag: BagOfSocks): Boolean = bag match {
    case BagOfSocks(MySock(size,_),_) => (size >=10.5 && size <=11.0)
  }
  println(fitsMe(BagOfSocks(MySock(10.7,"blue"),3)))
  println(fitsMe(BagOfSocks(MySock(12.7,"blue"),3)))

}

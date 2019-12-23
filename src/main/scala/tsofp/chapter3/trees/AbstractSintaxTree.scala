package tsofp.chapter3.trees

object AbstractSintaxTree extends App{
  sealed trait Arith
  final case class Num(x: Int) extends Arith
  final case class Sqrt(x: Arith) extends Arith
  final case class Add(x: Arith,y: Arith) extends Arith
  final case class Mul(x: Arith,y: Arith) extends Arith
  final case class Div(x: Arith,y: Arith) extends Arith

  //for example srqt(16)* (1+2)
  Mul(Sqrt(Num(16)),Add(Num(1),Num(2)))
}

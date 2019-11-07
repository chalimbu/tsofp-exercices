package tsofp.chapter2.exercises

import scala.annotation.tailrec

object exercise2529 extends App{
  def revDigits(n: Long): Long = {
    LazyList.iterate(n){_/10}.takeWhile(_>0).map(_%10).toList.mkString("").toInt
  }
  def isPalindrome(n:Long): Boolean={
    (n==revDigits(n))
  }
  @tailrec
  def findPalindrome(n: Long):Long ={
    def f(number:Long):Long ={
      revDigits(number)+n
    }
    if(isPalindrome(n)) n
    else findPalindrome(f(n))
  }
  println(findPalindrome(10101))
  //10101
  println(findPalindrome(123))
  //444
  println(findPalindrome(83951))
}

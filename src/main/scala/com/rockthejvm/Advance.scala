package com.rockthejvm


import scala.concurrent.Future
import scala.util.{Failure, Success, Try}
import scala.concurrent.ExecutionContext.Implicits.global

object Advance extends App{

  //lazy evaluation --> an expression is not evaluated until is evaluated
  lazy val aLazyValu = 2
  lazy val lazyWithSideEffect = {
    println("I am so vary lazy")
    23
  }
  val eagerValue = lazyWithSideEffect + 1
  // useful in infinite collection

  //"pseudo collection": Option, Try
  def methodWichCanReturnNull(): String = "hello Scala"
 //not used in scala
  if (methodWichCanReturnNull() == null) {
    //defensive code
  }

  // option = "collection" wich contains at most one element
  val anOption = Option(methodWichCanReturnNull()) // Some ("Hello Scala")
  val stringProcessing = anOption match {
    case Some(string) => s"tuttappost"
    case _ => "somthing wrong I can feel it"
  }
  def methodWithCanThrowException(): String = throw new RuntimeException
  /**
    //not really used
    try{
      methodWithCanThrowException()
    } catch {
      case e: Exception => "defend"
    }
  **/
  val aTry = Try(methodWithCanThrowException())
  // a Try = "collection with either a valye if the cose went sell or an exception if the code threw one

  val process = aTry match {
    case Success(value) => "allGood"
    case Failure(ex) => "exception"
  }

  // Both Option and Try have map filter and flatmap

  /**
   * Evaluate something on another thread
   */

  val aFuture = Future({
    println("Loading")
    Thread.sleep(1000)
    println("computed")
    56
  })
  // the Future is a "collection" which contains a vlaue when it's evaluated
  // future is composable with map, flatmap and filter
  // monads

  // Implicits basics
  /**
   * Two use cases
   */

  // 1 Implicit arguments

  def aMethodWIthImplicid(implicit arg: Int) = arg + 1
  implicit val myImplicitInt = 46
  println(aMethodWIthImplicid) // aMethodeWithImplicid(myImplicitInt)

  //2 implicit conversions
  implicit class MyRichIntegers(n: Int){
    def isEven() = n % 2 == 0
  }

  println(23.isEven()) //new MyRichInteger(23).isEven()
}


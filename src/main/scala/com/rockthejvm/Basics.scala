package com.rockthejvm

object Basics extends App{
  // define valu
  val meaningOfLife: Int = 42
  // const meaningOfLife = 42
  // a val is a constant and cannot change
  val aBoolean = false
  // optional type

  //String and interpolation
  val aString = "I love Scala"
  val aComposedString = "I" + " " + "love" + " " + "Scala"
  val anInterpolatedString = s"The meaning of lige id $meaningOfLife"

  //expressions = structures that can be reduced to a value
  val anExpression = 2 + 3

  // if-expression
  val ifExpression = if (meaningOfLife > 43) 56 else 45
  val chainedIf = {
    if (meaningOfLife < 43 ) 56
    else if (meaningOfLife < 45) 59
    else if (meaningOfLife < 47) 534
    else 0
  }

  //code block
  val aCodeBlock = {
    //definition
    val aLocalValue = 80

    //value of the block == value of last expression == return value
    aLocalValue + 3
  }

  //define a function
  def myFunction( x: Int, y: String): String = y + " " + x
  def myFunction3( x: Int, y: String): String = {
    y + " " + x
  }

  def factorialFunc(n: Int) : Int = {
    if (n <= 1) 1
    else n * factorialFunc(n - 1)

    //In scala there are no loop or iteration but Recursions
  }

  // the Unit type has no meaningful value === "void" in other language
  // type of side effects (i/o)
  println("Hello World")

  def myUnitReturnAction(): Unit = {
    println("Lol")
  }

  val theUnit = ()
}


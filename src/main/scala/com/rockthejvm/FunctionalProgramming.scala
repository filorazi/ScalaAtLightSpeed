package com.rockthejvm


object FunctionalProgramming extends App{
  // Scala is object oriented
  class Person(name: String){
    def apply(age: Int): Unit = println(s"i've aged: $age")

  }
  val bob = new Person("Bob")
  bob.apply(11)
  bob(22)

  /*
    scala runs on JVM
    in functional programming function are equal to values
    - compose function
    - pass functions
    - return functions

    --> FunctionX = Function1, Function2, ..., Function22
   */

  val simpleIncremented = new ((Int) => Int) {
     override def apply(arg: Int) : Int = arg + 1
  }

  simpleIncremented.apply(23) // 24
  simpleIncremented(23)
  // defined a function as a variable
  // all scala function are instances of these FunctionX type

  val stringConcat = new Function2[String,String, String]{
    override def apply(v1: String, v2: String): String = v1 + v2
  }

  stringConcat("Hello", " World!") //return Hello World!


  //Syntactic sugar
  val doubler: Function1[Int, Int] = (x: Int ) => 2 * x
  doubler(4) // 8

  val doubler2:Int => Int = (x: Int ) => 2 * x
  doubler2(4) // 8

  val doubler3 = (x: Int ) => 2 * x
  doubler3(4) // 8


  // Higher order functions: take functions as args/return functions as results

  val aMappedList = List(1,2,3,4).map(x => x + 1) //returns [2,3,4,5]
  //map is an HOF as it takes a function as parameter
  val aFlatMapList = List(1,2,4).flatMap(x => List(x, 2*x)) // returns [1,2,2,4,4,8]
  val aFlatMapList2 = List(1,2,4).flatMap{  x =>
    List(x, 2*x)
  } // returns [1,2,2,4,4,8]
  val aFilterList = List(1,2,3,5,6).filter(x => x <= 3) //return a list where all the elements satisfy the condition
  val aFilterList2 = List(1,2,3,5,6).filter(_ <= 3) //return a list where all the elements satisfy the condition

  //al the pair between (1,2,3) and (a,b,c)
  val allPairs = List(1,2,3).flatMap(number => List("a","b","c").map(letter => s"$number-$letter"))
  println(allPairs)

  // for comprehension (NOT A NORMAL FOR)
  val alternativePairs = for {
    number <- List(1,2,3)
    letter <- List("a","b","c")
  } yield s"$number-$letter"
  ///equivalent to the map/flatmap

  /**
   * collections
   */
  // Lists
  val aList = List(1,2,4,5,6,8)
  val firstEld = aList.head
  val restElems = aList.tail
  val aPrependedList = 0 :: aList //List(0,1,2,3,4,5,6,8)
  val anExtendedList = 0 +: aList :+ 6
  // +: prepends ---- :+ appends

  //sequence
  val aSequence: Seq[Int] = Seq(1,2,3) //Seq.apply(1,2,3)
  val accessedEl = aSequence.apply(1)
  val accessedEl1 = aSequence(1)
  // Elem of the seq at index 1

  // Vector is a fast seq implementation
  val aVector = Vector(1,2,3,5)

  //sets = no duplicates
  val aSet = Set(1,2,34,5,6,6)
  val setHas4 = aSet.contains(5)
  val anAddedSet = aSet + 7 // (1,2,34,5,6,7)
  val aRemovedSet = aSet - 6 // (1,2,34,5)

  //ranges
  val aRange = 1 to 100
  val twoByTwo = aRange.map(x => 2*x) //Vector (2,4,...,200)
  println(twoByTwo)

  //tuples
  val aTuples = ("Bon Jovi", "Rock", 1234)

  //maps
  val aNotebook: Map[String, Int] = Map(
    ("Daniel", 382048),
    "Jane" -> 4903494 // equivalent to ("Jane", 4903494)
  )
}

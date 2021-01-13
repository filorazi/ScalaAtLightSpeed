package com.rockthejvm

object PatternMatching extends App{

  // switch expression
  val integer: Int = 56
  val ordering = integer match {
    case 1 => "first"
    case 2 => "second"
    case 3 => "third"
    case _ => integer + "th"
  }
  //PM is an expression

  case class Person(name: String, age: Int)
  val bob = Person("Bob", 43) // Person.apply("Bob",43)

  // pattern matching can deconstruct case classes
  val personGreeting = bob match {
    case Person(n,a) => s"Hi, my name is $n and I am $a years old"
    case _ => "Something else"
  }
  println(personGreeting)

  val aTuple = ("Bon Jovi", "Rock")
  val bandDescriptor = aTuple match{
    case (band, genre) => s"$band belongs to $genre"
    case _ => "I don't know what you are talking about"
  }

  val aList = List(1,2,3)
  val listDescription = aList match {
    case List(_, 2, _) => "List contains 2 on its second position"
    case _ => "unknown list"
  }

  //if PM doesn't match anything, it will throw a MatchError
  //PM will try all cases in sequence and execute only one

}

package com.rockthejvm

object ObjectOrientation extends App {

  //class and instance
  class Animal {
    val age: Int = 0

    def eat() = println("I'm eating")
  }

  val aAnimal = new Animal

  //inerithance
  class Dog(name: String) extends Animal //constructor
  val aDog: Dog = new Dog("Lassie")
  //contructior argument are not fieds

  //subtype polymorfism
  val declareAnimal: Animal = new Dog("Hachi")
  declareAnimal.eat() //the most derived method will be called at runtime

  //abstract class
  abstract class WalkingAnimal {
    val hasLeg = true //by default public
    def walk(): Unit
  }

  //can be restrict by protected or private

  //interface = ultimate abstract
  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  trait Philosopher {
    def ?!(thought: String): Unit //valid method name
  }

  //single inheritance multiple trait "mixing"
  class Crocodile extends Animal with Carnivore with Philosopher {
    override def eat(animal: Animal): Unit = println("I am eating you, animal")

    override def ?!(thought: String): Unit = println(s"I was thinking: $thought")
  }

  val aCroc = new Crocodile
  aCroc.eat(aDog)
  aCroc eat aDog //possible only for methods with one parameter
  aCroc ?! "What if I could fly??"

  //operators in Scala are methods
  val basicMath = 1 + 2
  val anotherOne = 1.+(2) //equivalent

  // anonymous classes
  val dinosaur = new Carnivore {
    override def eat(animal: Animal): Unit = println(s"I'm eating you $animal")
  }

  //this produces an anonymous class Carnivore_Anonymous_30498 that is assigned to dinosaur

  // singleton Object
  object MySingleton { //define both the type and the only instance
    val myVal = 482
    def specMethod(): Int = 23480
    def apply(x: Int): Int = x + 1
  }
  MySingleton.specMethod()
  MySingleton.apply(84)
  MySingleton(65)
  //the last two are the same as the apply method is stranfe

  object Animal { //this is different from the class Animal
    // this are called companion object
    // companions can access each orhte's private fields/methods
    // singleton Animal and instances of animal are different things
    val calnLiveIndef = false
  }

  val animalsMaxAge = Animal.calnLiveIndef //static field/methods of classes

  /*case classes = light data structur with some boilerplate
   - sensible equals and hash code
   - serialization
   - companion with apply
   */

  case class Person(name: String, age: Int)
  //may be constructed without new
  val bob = Person("Bob", 54) //Person.apply("Bob", 54)

  //exceptions
  try{
    // code to try
    val x: String = null
    x.length
  } catch {
    case e: Exception => "some faulty erro message"
  } finally {
    //executed some code no matter what
  }

  // generics
  abstract class myList[T]{
    def head: T
    def tail: myList[T]
  }

  //using a generic with a concrate type
  val aList: List[Int] = List(1,2,3) // List.apply(1,2,3)
  val first = aList.head
  val rest = aList.tail
  val stringList: List[String] = List("hello","Scala")
  val firtSting = stringList.head

  //point #1 in scala we usually operate with immutable values/object
  //any modification to an object should return another objects
  /*
    Benefits
    1- works miracles in multithread env
    2- helps making sense of the code ("reasoning about")
   */

  val reversedList = aList.reverse
  //scala is closest to a OO ideal

}
package com.mwee.scala.`class`

/**
  * Created by hwt on 2018/12/19.
  */
//抽象类只能被继承不能被实例化
abstract class Vehicle {
  def checkType(): String
}

class Car extends Vehicle {
  def checkType(): String = "Im a Car"
}

class Bicycle extends Vehicle {
  def checkType(): String = "Im a Bike"
}


object Demo2 extends App {
  val p1: Vehicle = new Car()
  println(p1.checkType())

  val p2: Vehicle = new Bicycle
  println(p2.checkType())
}

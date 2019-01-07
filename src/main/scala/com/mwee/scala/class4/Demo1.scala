package com.mwee.scala.class4

/**
  * 抽象字段就是没有初始值的字段
  * Created by hwt on 2018/12/19.
  */
abstract class Person{
  //有get方法的抽象字段
  val id:Int
  //有get/set方法的抽象字段
  var name:String
  def say():String="123"
}

//定义子类
class Employee1 extends Person{
  //提供抽象字段的初始值
  val id: Int = 0
  var name: String = "No name"
}

class Employee2(val id:Int) extends Person{
  //id的值由构造器传入
  var name:String="No Nname"
}


object Demo1 {
  def main(args: Array[String]): Unit = {
    val e=new Employee1
    println(e.say())
  }
}

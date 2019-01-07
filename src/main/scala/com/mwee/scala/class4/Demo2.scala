package com.mwee.scala.class4

/**
  * Scala中的trait
  * trait和抽象类的关系
  * 1、trait就是抽象类
  * 2、区别：trait支持多重继承，抽象类只能单一继承
  * Created by hwt on 2018/12/19.
  */

trait Human{
  val id:Int
  val name:String

  def sayHello():String="heloo"+name
}

trait Actions{
  def getActionNmae():String
}

class Student(val id:Int,val name:String) extends Human with Actions{

  override def getActionNmae(): String = "Action is running"
}

object Demo2 {
  def main(args: Array[String]): Unit = {
    var s = new Student(20,"tom")
    println(s.getActionNmae()+s.sayHello())
  }

}

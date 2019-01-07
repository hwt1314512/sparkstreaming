package com.mwee.scala.class123

/**
  * Created by hwt on 2018/12/18.
  */
class Student1 {
  private var student1:String ="Tom"
  private var age:Int=20

  def getStuName():String=student1
  def setStuName(newStuName:String)=this.student1=newStuName

  def getAge():Int=age
  def setAge(newAge:Int)=this.age=newAge
}

object Student1{
  def main(args: Array[String]): Unit = {
    val s1 = new Student1

    println(s1.getAge())
    println(s1.getStuName())
    s1.setAge(10)
    s1.setStuName("Ma")
    println(s1.getAge())
    println(s1.getStuName())
  }
}

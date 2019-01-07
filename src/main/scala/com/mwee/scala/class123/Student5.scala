package com.mwee.scala.class123

/**
  * 演示object的apply方法
  * 作用：省略new关键字
  * Created by hwt on 2018/12/18.
  */
class Student5(var name:String) {

}

object Student5{
  def apply(name:String)={
    println("**apply in object**")
    new Student5(name)
  }

  def main(args: Array[String]): Unit = {
    var s1 = new Student5("Tom")
    println(s1.name)
    println("--------")
    var s2 = Student5("Mary")
    println(s2.name)
  }
}

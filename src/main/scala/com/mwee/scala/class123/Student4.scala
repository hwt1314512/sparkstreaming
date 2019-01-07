package com.mwee.scala.class123

/**
  * 主构造器
  *
  * 辅构造器
  * Created by hwt on 2018/12/18.
  */
class Student4(var name:String,var age:Int) {
  def this(age:Int){
    this("No name",age)
  }
}

object Student4{
  def main(args: Array[String]): Unit = {
    var s4 = new Student4("Tom",20)
    println(s4.age+s4.name)

    var s5=new Student4(25)
    println(s5.name+s5.age)
  }
}

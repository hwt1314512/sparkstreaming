package com.mwee.scala.`class`

/**
  * Created by hwt on 2018/12/19.
  */

class Persion(val name:String,val age:Int){
  def sayHello():String="Hello"+name
}

class Emoloyee(override val name:String,override val age:Int,val money:Int)
  extends Persion(name,age){
  override def sayHello(): String = "hello111"
}

object Demo1 {
  def main(args: Array[String]): Unit = {
    val p1:Persion=new Emoloyee("Tom",20,1000)
    println(p1.sayHello())

    //匿名子类
    val p2:Persion = new Persion("Mary",20){
      override def sayHello(): String = "sss"
    }
    println(p2.sayHello())

  }
}

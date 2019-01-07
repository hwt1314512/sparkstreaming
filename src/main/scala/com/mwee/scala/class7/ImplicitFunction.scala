package com.mwee.scala.class7

/**
  * 隐式转换：指的是以implicit关键字申明的带有单个参数的函数
  * scala会自动调用隐式转换函数
  * Created by hwt on 2018/12/23.
  */

class Fruit(name:String){
  def getF():String ={name}
}

class M(f:Fruit){
  def say()={println("xxxxx "+f.getF())}
}

object Implicit {

  implicit def fToM(f:Fruit):M={
    new M(f)
  }

  def main(args: Array[String]): Unit = {
    val f:Fruit=new Fruit("xj")
    //将Fruit转换M对象
    f.say()
  }
}

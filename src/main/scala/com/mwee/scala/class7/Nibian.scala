package com.mwee.scala.class7

/**
  * 逆变：泛型变量的值可以是本身或者其父类，符号“-”
  * Created by hwt on 2018/12/23.
  */

//所有的动物
class Animal{}

class Bird extends Animal{}
class Sparrow extends Bird{}
class EatSomething[-T](t:T){}


object Nibian {
  def main(args: Array[String]): Unit = {
    val c1:EatSomething[Bird] = new EatSomething[Bird](new Bird )
    val c2:EatSomething[Sparrow]=c1
  }
}

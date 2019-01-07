package com.mwee.scala.class7

/**
  * Scala的隐式类：用于对类的加强
  * Created by hwt on 2018/12/25.
  */
object ImplictClass {
  implicit class Calc(x:Int){
    def add(a:Int):Int = a+x
  }

  def main(args: Array[String]): Unit = {
    /**
      *  隐式类的执行过程：
      *  1、当1.add(2),scala的编译器不会立即报错，而是在当前域中查找，有没有implicit修饰的，同时可以将Int作为参数
      *  的构造器，并且具有add方法的类。通过查找，找到了Calc
      *  2、利用隐式类Calc来执行add方法
      */
    println(1.add(2))
  }
}

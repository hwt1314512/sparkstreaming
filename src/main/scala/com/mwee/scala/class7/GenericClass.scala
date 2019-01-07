package com.mwee.scala.class7

/**
  * 泛型类
  * Created by hwt on 2018/12/23.
  */
class GenericClass[T] {
  private var c:T = _
}

object GenericClass{
  def main(args: Array[String]): Unit = {
    val intGeneric = new GenericClass[Int]
    intGeneric.c=100
    println(intGeneric.c)

    val strGeneric = new GenericClass[String]
    strGeneric.c="str"
    println(strGeneric.c)
  }
}

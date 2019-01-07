package com.mwee.scala.`class`

/**
  * 用Object对象实现单例
  * Created by hwt on 2018/12/18.
  */
object CreditCard {
  private var creditCardNumer:Long=0

  def generateNewCreditCardNumber()={
    creditCardNumer+=1
    creditCardNumer
  }

  def main(args: Array[String]): Unit = {
//    var c = new CreditCard.
    println(CreditCard.generateNewCreditCardNumber())
    println(CreditCard.generateNewCreditCardNumber())
    println(CreditCard.generateNewCreditCardNumber())
  }
}

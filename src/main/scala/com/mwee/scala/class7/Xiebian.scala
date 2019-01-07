package com.mwee.scala.class7

/**协变：泛型变量的值可以是本身或者其子类(子类转父类)
  * 在类型参数之前加上“+”符号，就可以使类或特征为协变
  * Created by hwt on 2018/12/23.
  */
//所有的动物
package t1{
  class Animal{}
  class Bird extends Animal{}
  class EatSomething[+T](t:T){}
  class Sparrow extends Bird{}


  object Xiebian {
    def main(args: Array[String]): Unit = {
      val c1:EatSomething[Bird]=new EatSomething[Bird](new Bird)

      //动物吃东西
      //尽管Bird是Animal的子类，
      var c2:EatSomething[Bird] = c1
      val c3:EatSomething[Sparrow]=new EatSomething[Sparrow](new Sparrow)
      val c4:EatSomething[Animal]=c1
    }
  }
}

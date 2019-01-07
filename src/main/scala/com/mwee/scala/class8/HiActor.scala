//package com.mwee.scala.class8
//
//import scala.actors.Actor
//
///**
//  * 如何创建Actor
//  * Created by hwt on 2018/12/25.
//  */
//class HiActor extends Actor{
//  override def act(): Unit = {
//    //处理消息
//    while(true){
//      //表示收到消息
//      receive{
//        case "Hi"=>println("hi actor")
//        case "hello"=>println("hello actor")
//      }
//    }
//  }
//}
//
//object HiActor{
//  def main(args: Array[String]): Unit = {
//    //创建一个Actor的对象
//    val actor1=new HiActor
//    //启动Actor
//    actor1.start()
//    //发送消息
//    //!表示异步发送消息，不等待返回结果
//    actor1 ! "Hi"
//    actor1 ! "hello"
//
//  }
//}

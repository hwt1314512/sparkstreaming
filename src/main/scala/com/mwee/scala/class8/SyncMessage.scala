//package com.mwee.scala.class8
//
//import scala.actors.Actor
//
///**
//  * 演示同步消息:处理同步消息的时候，处理方法会返回一个结果给发送方
//  * 否则发送回一直等待处理结果
//  * Created by hwt on 2018/12/25.
//  */
//class SyncMessage extends Actor{
//  override def act(): Unit = {
//    while(true){
//      receive{
//        case "Tom"=>{
//          println("In actor:hello tom")
//          //返回结果
//          reply("hello tom")
//        }
//      }
//    }
//  }
//}
//
//object SyncMessage{
//  def main(args: Array[String]): Unit = {
//    //创建actor对象
//    var actor = new SyncMessage
//    actor.start()
//    //用 !?发送一个同步消息 用!!发送一个异步消息
//    //replyMessage用来保存对方处理后返回的结果
//    val replyMessag=actor !? "Tom"
//     replyMessag match {
//      case "hello tom"=>println("in main method,we get the result")
//    }
//  }
//}

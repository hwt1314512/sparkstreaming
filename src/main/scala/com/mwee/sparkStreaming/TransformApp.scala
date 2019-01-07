package com.mwee.sparkStreaming

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
  * 黑名单过滤
  * Created by hwt on 2018/12/16.
  */
object TransformApp {
  def main(args: Array[String]): Unit = {
    val sc = new SparkConf().setMaster("local[2]").setAppName("TransformApp")
    val ssc = new StreamingContext(sc,Seconds(5))

    val blackMenu = List("zs","ls")
    val blackRdd = ssc.sparkContext.parallelize(blackMenu).map((_,true))

    val lines = ssc.socketTextStream("dn2.hadoop.pdbd.mwbyd.cn",6789)
    val result = lines.map(x=>(x.split(",")(1),x))

    val filterResult = result.transform(rdd=>{
      rdd.leftOuterJoin(blackRdd)
        .filter(x=>x._2._2.getOrElse(false)!=true)
        .map(x=>x._2._1)
    })

    filterResult.print()

    ssc.start()
    ssc.awaitTermination()

  }
}

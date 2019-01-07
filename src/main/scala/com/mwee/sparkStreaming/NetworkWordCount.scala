package com.mwee.sparkStreaming

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
  * Spark Streaming 处理Scoket数据
  * Created by hwt on 2018/12/15.
  */
object NetworkWordCount {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[2]").setAppName("NetworkWordCount");

    val ssc = new StreamingContext(sparkConf,Seconds(5))

    val lines = ssc.socketTextStream("dn2.hadoop.pdbd.mwbyd.cn",6789)

    val result = lines.flatMap(_.split(" ")).map((_,1)).reduceByKey(_+_)

    result.print()

    ssc.start()
    ssc.awaitTermination()
  }
}

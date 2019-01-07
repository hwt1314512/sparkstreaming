package com.mwee.sparkStreaming

import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession
import org.apache.spark.streaming.{Seconds, StreamingContext, Time}

/**
  * SparkStreaming整合SparkSql完成词频统计
  * Created by hwt on 2018/12/16.
  */
object SqlNetworkWordCount {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[2]").setAppName("SqlNetworkWordCount")
    val ssc = new StreamingContext(sparkConf, Seconds(5))

    val lines = ssc.socketTextStream("dn2.hadoop.pdbd.mwbyd.cn", 6789)
    val words = lines.flatMap(_.split(" "))

    words.foreachRDD((rdd: RDD[String], time: Time) => {
      val spark = SparkSessionSingleton.getInstance(rdd.sparkContext.getConf)
      import spark.implicits._

      val wordsDataFrame = rdd.map(w => Record(w)).toDF()

      wordsDataFrame.createOrReplaceTempView("words")

      val wordCountsDataFrame =
        spark.sql("select word,count(*) as total from words group by word")
      println(s"==============$time=================")
      wordCountsDataFrame.show()
    })

    ssc.start()
    ssc.awaitTermination()
  }
    case class Record(word:String)

    object SparkSessionSingleton {
      @transient private var instance :SparkSession = _

      def getInstance(sparkConf: SparkConf):SparkSession={
        if(instance==null){
          instance  = SparkSession.
            builder()
            .config(sparkConf)
            .getOrCreate()
        }
        instance
      }
    }
}

package com.mwee.sparkSql.log

import com.mwee.sparkSql.Contants
import org.apache.spark.sql.SparkSession

/**
  * 第一步清洗：抽取出我们所需要的指定列的数据
  * Created by hwt on 2019/1/6.
  */
object SparkStatFormatJob {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("SparkStatFormatJob").master("local[2]").getOrCreate()

    val access = spark.sparkContext.textFile(Contants.dataPath + "mooc_access.log")

    //    access.take(10).foreach(println)
    access.map(line => {
      val splits = line.split(" ")
      val ip = splits(0)
      //3、4两个字段和起来才是完整的访问时间，[10/Nov/2016:00:01:02 +0800]
      val time = DateUtils.parse(splits(3) + " " + splits(4))
      val url = splits(11).replaceAll("\"","")
      val traffic = splits(9)
//      (ip, time,url,traffic)

      time+"\t"+url+"\t"+traffic+"\t"+ip
    }).saveAsTextFile(Contants.dataPath+"output")

    spark.stop()

  }
}

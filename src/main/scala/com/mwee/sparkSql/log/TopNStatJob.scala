package com.mwee.sparkSql.log

import com.mwee.sparkSql.Contants
import org.apache.spark.sql.functions._
import org.apache.spark.sql.{DataFrame, SparkSession}

/**
  * 统计TopN
  * Created by hwt on 2019/1/6.
  */
object TopNStatJob {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("TopNStatJob").master("local[2]").getOrCreate()

    val accessCleanDF = spark.read.format("parquet").load(Contants.dataPath + "clean")

    vedioAccessTopNStat(spark, accessCleanDF)

    spark.stop()
  }

  /**
    * 统计最受欢迎的topN课程
    */
  def vedioAccessTopNStat(spark: SparkSession, accessCleanDF: DataFrame) = {
    //使用sql统计
//    accessCleanDF.createOrReplaceTempView("access_log")
//    val countDF2 = spark.sql("select day,cmsId,count(1) as times from access_log where day='20161110' and cmsType='video' " +
//      "group by day,cmsId order by times desc")

    //使用DF api统计
    import spark.implicits._
    val countDF = accessCleanDF.filter($"day" === "20161110" && $"cmsType" === "video").
      groupBy("day", "cmsId").agg(count("cmsId").as("times")).orderBy($"times".desc)

  }
}

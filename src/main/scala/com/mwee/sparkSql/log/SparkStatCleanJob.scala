package com.mwee.sparkSql.log

import com.mwee.sparkSql.Contants
import org.apache.spark.sql.{SaveMode, SparkSession}

/**
  * Created by hwt on 2019/1/6.
  */
object SparkStatCleanJob {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("SparkStatCleanJob").master("local[2]").getOrCreate()

    val accessRDD = spark.sparkContext.textFile(Contants.dataPath + "mooc_access_parsed.log")

    val accessDF = spark.createDataFrame(accessRDD.map(line => {
      AccessConvertUtils.parseAccessLog(line)
    }), AccessConvertUtils.accessSchema)

//    accessDF.printSchema()
//    accessDF.show(false)

    //coalesce设置分区数量，为优化点
    accessDF.coalesce(1).write.format("parquet").mode(SaveMode.Overwrite).save(Contants.dataPath+"clean")

    spark.stop()
  }

}

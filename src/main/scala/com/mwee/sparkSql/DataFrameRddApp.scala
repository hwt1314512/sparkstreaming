package com.mwee.sparkSql

import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}
import org.apache.spark.sql.{Row, SparkSession}

/**
  * DataFrame和RDD的互操作
  * Created by hwt on 2019/1/2.
  */
object DataFrameRddApp {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("DataFrameRddApp").master("local[2]").getOrCreate()

    //1、反射方式，事先需知道字段和字段类型，优先考虑这种方式
    inferReflection(spark)

    //2、编程方式，如果第一种情况不能满足要求（事先不知道列）
    program(spark)

    spark.stop()
  }

  def program(spark: SparkSession): Unit = {
    val rdd = spark.sparkContext.textFile("D:\\data\\infos.txt")

    val infoRDD = rdd.map(_.split(",")).map(line => Row(line(0).toInt, line(1), line(2).toInt))

    val structType = StructType(Array(StructField("id", IntegerType, true),
      StructField("name",StringType,true),
      StructField("age",IntegerType,true)))

    val df = spark.createDataFrame(infoRDD,structType)

    df.printSchema()
    df.show()
  }

  def inferReflection(spark: SparkSession): Unit = {
    //RDD=>DataFrame
    val rdd = spark.sparkContext.textFile("D:\\data\\infos.txt")

    //需要导入隐式转换
    import spark.implicits._
    val infoDF = rdd.map(_.split(",")).map(line => Info(line(0).toInt, line(1), line(2).toInt)).toDF()
    infoDF.show()

    //使用DataFrame  API编程
    infoDF.filter(infoDF.col("age") > 30).show()

    //使用sql编程
    infoDF.createOrReplaceTempView("infos")
    spark.sql("select * from infos where age>30").show()
  }

  //可以理解为java中的javabean
  case class Info(id: Int, name: String, age: Int)

}

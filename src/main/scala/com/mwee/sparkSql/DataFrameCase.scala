package com.mwee.sparkSql

import org.apache.spark.sql.SparkSession

/**
  * DataFrame中的其它操作
  * Created by hwt on 2019/1/2.
  */
object DataFrameCase {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("DataFrameCase").master("local[2]").getOrCreate()

    val rdd = spark.sparkContext.textFile("D:\\data\\student.data")
    import spark.implicits._
    val studentDf = rdd.map(_.split("\\|")).map(line=>Student(line(0).toInt,line(1),line(2),line(3))).toDF()

    //show 默认展示前20条，超过一定长度的用...表示
    studentDf.show()
    studentDf.show(30)
    studentDf.show(30,false)

    studentDf.take(10)
    studentDf.first()
    studentDf.head(3)

    studentDf.select("email").show(30,false)

    //过滤名字为空的
    studentDf.filter("name='' or name='NULL'").show()

    //找出name以M开头的
    studentDf.filter("substr(name,0,1)='M'").show()

    //排序
    studentDf.sort(studentDf("name")).show()
    studentDf.sort(studentDf("name").desc).show()
    studentDf.sort("name","id").show()
    studentDf.sort(studentDf("name").desc,studentDf("id").asc)

    //重命名
    studentDf.select(studentDf("name").as("student_name")).show()

    //join
    val studentDf2 = rdd.map(_.split("\\|")).map(line=>Student(line(0).toInt,line(1),line(2),line(3))).toDF()
    studentDf.join(studentDf2,studentDf("id")===studentDf2("id")).show()

  }

  case class Student(id:Int,name:String,phone:String,email:String)
}

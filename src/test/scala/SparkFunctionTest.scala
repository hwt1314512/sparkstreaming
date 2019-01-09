
import org.apache.spark.HashPartitioner
import org.apache.spark.sql.SparkSession
import org.scalatest.FunSuite

import scala.collection.mutable.ListBuffer

/**
  * Created by huangwt on 2019/1/7.
  */
class SparkFunctionTest extends FunSuite {

    val sc = SparkSession.builder().appName("FunctionTest").master("local[2]").getOrCreate().sparkContext


    /**
      * 将所有key相同的值相加
      * seqop在分区内聚合，combop将所有分区聚合
      */
    test("aggregateByKey"){
        val list = List("you,jump", "i,jump")
        sc.parallelize(list)
                .flatMap(_.split(","))
                .map((_, 1))
                .aggregateByKey(0)(_+_,_+_)
                .foreach(tuple =>println(tuple._1+"->"+tuple._2))
    }

    /**
      * seqop在分区内聚合，combop将所有分区聚合
      */
    test("aggregate"){
        val rdd  =List(1,2,3,4,5,6,7,8,9)
        val a =rdd.par.aggregate((0,0))(
            (acc,number) => (acc._1 + number, acc._2 + 1),
            (par1,par2) => (par1._1 + par2._1, par1._2 + par2._2)
        )
        println(a)
    }

    test("sortByKey"){
        val list = List((99, "张三丰"), (96, "东方不败"), (66, "林平之"), (98, "聂风"))
        sc.parallelize(list).sortByKey()
    }

    test("groupByKey") {
        val list = List(("武当", "张三丰"), ("峨眉", "灭绝师太"), ("武当", "宋青书"), ("峨眉", "周芷若"))
        val rdd = sc.parallelize(list).groupByKey()
        rdd.foreach(println)
    }

    //根据返回结果对元素进行分区
    test("groupBy"){
        val list = List(1,2,3,4,5,6)
        val rdd = sc.parallelize(list)
        rdd.groupBy(x=>{
            x%2
        }).foreach(println)
    }

    test("reduce"){
        val list = List(1,2,3,4,5,6)
        val rdd = sc.parallelize(list).reduce((x,y)=>x+y)
        println(rdd)

    }

    /**
      * 分区数由多变少
      * coalesce默认shuffle为false，此时只能将分区减少（分区增多要设置shuffle为true）
      */
    test("coalesce") {
        val list = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
        sc.parallelize(list, 3).coalesce(1).foreach(println(_))
    }

    /**
      * 分区数由少变多
      * 是coalesce函数shuffle为true时的简易实现
      */
    test("repartition") {
        val list = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
        sc.parallelize(list, 2).repartition(4).foreach(println(_))
    }

    /**
      * 重新分区，并且在分区内排序
      */
    test("repartitionAndSortWithinPartitions") {
        val list = List(1, 4, 55, 66, 33, 48, 23)
        val listRdd = sc.parallelize(list, 1)
        listRdd.map(num => (num, num))
                .repartitionAndSortWithinPartitions(new HashPartitioner(2))
                .mapPartitionsWithIndex((index, iterator) => {
                    val listBuffer: ListBuffer[String] = new ListBuffer
                    while (iterator.hasNext) {
                        listBuffer.append(index + "_" + iterator.next())
                    }
                    listBuffer.iterator
                }, false).foreach(print(_))

    }

    /**
      * 对两个RDD中的KV元素，每个RDD中相同key中的元素分别聚合成一个集合。与reduceByKey不同的是针对两个RDD中相同的key的元素进行合并。
      */
    test("cogroup") {
        val list1 = List((1, "www"), (2, "bbs"))
        val list2 = List((1, "cnblog"), (2, "cnblog"), (3, "very"))
        val list3 = List((1, "com"), (2, "com"), (3, "good"))

        val list1RDD = sc.parallelize(list1)
        val list2RDD = sc.parallelize(list2)
        val list3RDD = sc.parallelize(list3)

        list1RDD.cogroup(list2RDD, list3RDD).foreach(tuple => println(tuple._1 + " " + tuple._2._1 + " " + tuple._2._2 + " " + tuple._2._3))
    }
}

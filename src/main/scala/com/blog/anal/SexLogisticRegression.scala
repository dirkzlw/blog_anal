package com.blog.anal

import org.apache.spark.ml.feature.LabeledPoint
import org.apache.spark.mllib.classification.{LogisticRegressionModel, LogisticRegressionWithSGD}
import org.apache.spark.mllib.regression
import org.apache.spark.mllib.util.MLUtils
import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  *
  * @author Ranger
  * @create 2020-01-07 19:45
  */
object SexLogisticRegression {
  def main(args: Array[String]): Unit = {
    // 构建Spark对象，本地执行
    val conf = new SparkConf().setAppName("SexLogisticRegression").setMaster("local")
    val sc = new SparkContext(conf)

    val data: RDD[regression.LabeledPoint] = MLUtils.loadLibSVMFile(sc, "./data/sex.data")

    val splits: Array[RDD[regression.LabeledPoint]] = data.randomSplit(Array(0.8, 0.2), 11L)

    val parsedData: RDD[regression.LabeledPoint] = splits(0)
    val parsedTest: RDD[regression.LabeledPoint] = splits(1)

    val numiteartor = 50;
    //训练模型
    val model: LogisticRegressionModel = LogisticRegressionWithSGD.train(parsedData, numiteartor)

    println(model.weights)

  }
}

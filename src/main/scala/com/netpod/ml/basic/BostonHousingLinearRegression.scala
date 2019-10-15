package com.netpod.ml.basic
import org.apache.spark.SparkContext
import org.apache.spark.SparkConf
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.regression.LinearRegression
import org.apache.spark.sql.SparkSession

object BostonHousingLinearRegression {

  def sampleData(sparkSession : SparkSession, fileName: String) = {

    // load csv dataset
    val data = sparkSession.read.option("header", "true")
      .option("inferSchema", "true")
      .csv(fileName)

    data.show()
    val columns = data.columns

    // create feature array of first 13 features
    val mergeFeaturesTransformer = new VectorAssembler()

    mergeFeaturesTransformer.setInputCols(columns)
    mergeFeaturesTransformer.setOutputCol("features")

    val featuresColumn = mergeFeaturesTransformer.transform(data)

    featuresColumn.show()
    featuresColumn.collect().toList.foreach(println)

  }

  def fitData(sparkSession : SparkSession, fileName: String) : Unit = {
    // load csv dataset
    val data = sparkSession.read.option("header", "true")
      .option("inferSchema", "true")
      .csv(fileName)

    val columns = data.columns

    // create feature array of first 13 features
    val mergeFeaturesTransformer = new VectorAssembler()

    mergeFeaturesTransformer.setInputCols(columns)
    mergeFeaturesTransformer.setOutputCol("features")

    val featuresColumn = mergeFeaturesTransformer.transform(data)

    val trainTestDataSplit = Array(0.7, 0.3)
//    val trainTestDataSplit = Array(0.7, 0.2, 0.1)
    val splitData = featuresColumn.randomSplit(trainTestDataSplit)
    val trainingData = splitData(0)
    val testData = splitData(1)
//    val correlationData = splitData(2)

    val linearRegression = new LinearRegression()
    linearRegression.setFeaturesCol("features")
    linearRegression.setLabelCol("medv")

    // train
    val model = linearRegression.fit(trainingData)
    // test model
    val summary = model.evaluate(testData)

    println("meanAbsoluteError = ", summary.meanAbsoluteError)
    println("rootMeanSquaredError = ", summary.rootMeanSquaredError)
    println("r2 = ", summary.r2)
    println("meanSquaredError = ", summary.meanSquaredError)

    val predictions = model.transform(testData)
//    val predictions = model.transform(correlationData)
    val result = predictions.select("medv", "features", "prediction")
    result.show()

  }
}

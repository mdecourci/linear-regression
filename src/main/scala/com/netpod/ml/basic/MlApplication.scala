package com.netpod.ml.basic

import java.net.URL

import com.typesafe.config.ConfigFactory
import org.apache.spark.sql.SparkSession

object MlApplication {
  def main(args: Array[String]): Unit = {

    val config = ConfigFactory.load().getConfig("dataset.bostonHousing")
    val fileName = config.getString("fileName")

    println(fileName)

    val sparkSession = SparkSession.builder.appName("boston-regression").master("local[4]").getOrCreate

    val regression = BostonHousingLinearRegression
  //  regression.sampleData(sparkSession, fileName)

    regression.fitData(sparkSession, fileName)

    sparkSession.close()
  }
}

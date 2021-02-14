package com.droolsplay.util

import org.apache.log4j.Logger
import org.apache.spark.sql.SparkSession

object  SparkSessionSingleton {
  val logger = Logger.getLogger(this.getClass.getName)
  @transient private var instance: SparkSession = _

  def getInstance(): SparkSession = {
    if (instance == null) {
      instance = SparkSession
        .builder
        .config("spark.master", "local[*]")
        .appName("LoanApplicants")
        .getOrCreate()
    }
    instance
  }
}
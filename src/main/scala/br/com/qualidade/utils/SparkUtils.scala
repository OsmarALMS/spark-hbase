package br.com.qualidade.utils

import org.apache.spark.sql.SparkSession

object SparkUtils {

  def getSparkSession: SparkSession = {

    val queue = "Desenvolvimento"

    SparkSession
      .builder()
      .appName("spark-count")
      .config("spark.yarn.queue", queue)
      .config("spark.sql.broadcastTimeout", "36000")
      .config("spark.sql.codegen.aggregate.map.twolevel.enable", "false")
      .config("spark.sql.caseSensitive", "false")
      .config("spark.shuffle.service.enabled", "true")
      .config("spark.dynamicAllocation.enabled", "true")
      .config("spark.dynamicAllocation.initialExecutors", "3")
      .config("spark.dynamicAllocation.minExecutors", "3")
      .config("spark.dynamicAllocation.maxExecutors", "10")
      .config("spark.executor.instances", "3")
      .config("spark.executor.cores", "4")
      .config("spark.executor.memory", "2G")
      .config("spark.yarn.executor.memoryOverhead", "20000")
      .config("spark.driver.memory", "5G")
      .config("spark.yarn.driver.memoryOverhead", "20000")
      .config("spark.scheduler.mode", "FIFO")
      .config("spark.ui.port", "4142")
      .config("spark.shuffle.compress", "true")
      .config("spark.hadoop.yarn.resourcemanager.webapp.address", "brtlvlts0077co.redecorp.br:8088")
      .config("spark.master", "yarn")
      .config("spark.master", "local[*]")
      .config("hive.execution.engine", "spark")
      .config("hive.merge.mapredfiles", "true")
      .config("hive.merge.size.per.task", "128000000")
      .config("hive.merge.smallfiles.avgsize", "128000000")
      .config("hive.auto.convert.join", "true")
      .config("hive.auto.convert.sortmerge.join", "true")
      .config("hive.exec.dynamic.partition", "true")
      .config("hive.exec.dynamic.partition.mode", "nonstrict")
      .config("hive.exec.max.dynamic.partitions", "500000")
      .config("hive.vectorized.execution.enabled", "true")
      .config("hive.vectorized.execution.reduce.enabled", "true")
      .config("hive.cbo.enable", "true")
      .config("hive.compute.query.using.stats", "true")
      .config("hive.stats.fetch.column.stats", "true")
      .config("hive.stats.fetch.partition.stats", "true")
      .config("tez.queue.name", queue)
      .config("mapreduce.job.queuename", queue)
      .enableHiveSupport()
      .getOrCreate()

  }

}

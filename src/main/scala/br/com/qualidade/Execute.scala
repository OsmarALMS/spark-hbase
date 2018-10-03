package br.com.qualidade

import br.com.qualidade.utils.SparkUtils
import org.apache.log4j._
import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.sql.execution.datasources.hbase.HBaseTableCatalog

object Execute {

  val log: Logger = Logger.getLogger(Execute.getClass)

  val cat: String = s"""{
     |"table":{"namespace":"default", "name":"shcExampleDCTable", "tableCoder":"Phoenix", "version":"2.0"},
     |"rowkey":"key1:key2",
     |"columns":{
     |"col00":{"cf":"rowkey", "col":"key1", "type":"string"},
     |"col01":{"cf":"rowkey", "col":"key2", "type":"int"},
     |"col1":{"cf":"CF1", "col":"COL1", "type":"boolean"},
     |"col2":{"cf":"CF1", "col":"COL2", "type":"double"},
     |"col3":{"cf":"CF2", "col":"COL3", "type":"float"},
     |"col4":{"cf":"CF2", "col":"COL4", "type":"int"},
     |"col5":{"cf":"CF3", "col":"COL5", "type":"bigint"},
     |"col6":{"cf":"CF3", "col":"COL6", "type":"smallint"},
     |"col7":{"cf":"CF4", "col":"COL7", "type":"string"},
     |"col8":{"cf":"CF4", "col":"COL8", "type":"tinyint"}
     |}
     |}""".stripMargin

  def main(args: Array[String]): Unit = {
    val spark = SparkUtils.getSparkSession

    val df = withCatalog(cat, spark)
    df.show

    def withCatalog(cat: String, spark: SparkSession): DataFrame = {
      spark.sqlContext
        .read
        .options(Map(HBaseTableCatalog.tableCatalog->cat))
        .format("org.apache.spark.sql.execution.datasources.hbase")
        .load()
    }
  }

}
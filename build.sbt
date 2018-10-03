name := "spark-hbase"

version := "1.0"

scalaVersion := "2.11.8"

resolvers += "Hortonworks Repository" at "http://repo.hortonworks.com/content/repositories/releases/"

// === Spark === //
libraryDependencies += "org.apache.spark" %% "spark-core" % "2.1.1" % "provided"
libraryDependencies += "org.apache.spark" %% "spark-sql"  % "2.1.1" % "provided"
libraryDependencies += "org.apache.spark" %% "spark-hive" % "2.1.1" % "provided"


libraryDependencies += "com.hortonworks" % "shc-core" % "1.1.1-2.1-s_2.11" % "provided"
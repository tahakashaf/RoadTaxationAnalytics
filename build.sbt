name := "RoadTaxationAnalytics"

version := "0.1"

scalaVersion := "2.11.12"

val SPARK_VERSION = "2.2.0"

libraryDependencies += "org.apache.spark" %% "spark-core" % SPARK_VERSION
libraryDependencies += "org.apache.spark" %% "spark-mllib" % SPARK_VERSION
libraryDependencies += "org.apache.spark" %% "spark-sql" % SPARK_VERSION
libraryDependencies += "org.apache.spark" %% "spark-streaming" % SPARK_VERSION


libraryDependencies += "org.joda" % "joda-convert" % "1.2"

libraryDependencies += "joda-time" % "joda-time" % "2.7"
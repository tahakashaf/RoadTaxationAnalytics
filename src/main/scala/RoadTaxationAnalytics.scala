import models.{DriveData, TripData, VehicleData, WeatherData}
import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.{DataFrame, SparkSession}
//import org.apache.spark.sql.functions.col
//import utils.Schema2CaseClass
import org.apache.spark.sql.functions._
import org.apache.spark.sql.functions.lit

object RoadTaxationAnalytics {

  def main(args: Array[String]): Unit = {


    val logger: Logger = Logger.getLogger(RoadTaxationAnalytics.getClass)
    Logger.getLogger("org").setLevel(Level.OFF)
    val spark = SparkSession.builder()
      .appName("ana")
      .master("local[*]")
      .config("spark.hadoop.validateOutputSpecs", false)
      .config("spark.driver.allowMultipleContexts", "true")
      .config("spark.sql.session.timeZone", "PST")
      .getOrCreate()

    import spark.implicits._


    //val s2cc = new Schema2CaseClass
    //import s2cc.implicits._

    val tripData = spark.read.parquet("input_data/trip").
      toDF("vehicle_id", "trip_id", "datetime", "latitude", "longitude", "velocity", "index_level_0").as[TripData];
    val driveData = spark.read.parquet("input_data/drive").as[DriveData];
    val weatherData = spark.read.parquet("input_data/weather").as[WeatherData];
    val vehicleData = spark.read.format("org.apache.spark.csv").
      option("header", true).
      option("inferSchema", true).
      csv("input_data/vehicle.csv").as[VehicleData]

    //calculated as Engine load/ 255
    //drive : eng_load,vehicle_id,rpm,datetime,


    //driveData.selectExpr("90 / eng_load").show()

    val driveTemp = driveData.
      withColumn("Torque Utilization", driveData.col("eng_load").divide(255).multiply(lit(100)))
    driveTemp.select("eng_load", "Torque Utilization", "vehicle_id", "datetime")


    val tumblingWindow = driveTemp
      .groupBy(driveTemp.col("vehicle_id"),window(driveTemp.col("datetime"), "1 week","1 week", "5 days"))
      .agg(avg("Torque Utilization"))

    printWindow(tumblingWindow, "avg(Torque Utilization)")

  }

  def printWindow(windowDF: DataFrame, aggCol: String) = {
    windowDF.sort("window.start").
      select("window.start", s"$aggCol","vehicle_id").
      show(truncate = false)
  }
}
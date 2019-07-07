package models

case class WeatherData (
                         x:Option[Long],
                         y:Option[Long],
                         date:Option[java.sql.Date],
                         time:Option[String],
                         lat:Option[Double],
                         lon:Option[Double],
                         temperature_data:Option[java.math.BigDecimal],
                         temperature_unit:Option[String],
                         precipitation_data:Option[java.math.BigDecimal],
                         precipitation_unit:Option[String],
                         wind_ew_data:Option[java.math.BigDecimal],
                         wind_ew_unit:Option[String],
                         wind_ns_data:Option[java.math.BigDecimal],
                         wind_ns_unit:Option[String]
                       )

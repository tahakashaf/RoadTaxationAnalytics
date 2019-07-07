package models

case class DriveData (
                   vehicle_id:Option[Long],
                   trip_id:Option[String],
                   datetime:Option[java.sql.Timestamp],
                   velocity:Option[Double],
                   accel_x:Option[Double],
                   accel_y:Option[Double],
                   accel_z:Option[Double],
                   engine_coolant_temp:Option[Double],
                   eng_load:Option[Double],
                   fuel_level:Option[Double],
                   iat:Option[Double],
                   rpm:Option[Double],
                   __index_level_0__ :Option[Long]

)
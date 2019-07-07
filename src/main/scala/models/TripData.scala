package models

case class TripData (
                        vehicle_id:Option[Long],
                        trip_id:Option[String],
                        datetime:Option[java.sql.Timestamp],
                        latitude:Option[Double],
                        longitude : Option[String],
                        velocity:Option[Double],
                        index_level_0 :Option[Long]
  )


package models

case class VehicleData (
                         vehicle_id:Option[Int],
                         year:Option[Int],
                         make:Option[String],
                         Model:Option[String],
                         drivetrain:Option[Int],
                         max_torque:Option[Int],
                         max_horsepower:Option[Int],
                         max_horsepower_rpm:Option[Int],
                         max_torque_rpm:Option[Int],
                         engine_displacement:Option[Double],
                         fuel_type:Option[Int],
                         fuel_tank_capacity:Option[Int],
                         fuel_economy_city:Option[Double],
                         fuel_economy_highway:Option[Double],
                         cylinders:Option[Int],
                         forced_induction:Option[String],
                         device_generation:Option[Int]
                       )

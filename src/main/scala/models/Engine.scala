package models

case class Engine(

  vehicle_id:Int,
  week_start_date :String,
  ft_torque_util_60pct_s :Long,
  ft_torque_util_70pct_s :Long,
  ft_torque_util_80pct_s :Long,
  ft_torque_util_90pct_s :Long,
  ft_horsepower_util_50pct_s :Long,
  ft_horsepower_util_60pct_s :Long,
  ft_horsepower_util_70pct_s :Long,
  ft_horsepower_util_80pct_s :Long,
  ft_rpm_util_50pct_s	:Long,
   ft_rpm_util_60pct_s : Long
)


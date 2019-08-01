package utils

  object implicits {
    implicit val defaultTypeConverter:TypeConverter = (t:DataType) => { t match {
      case _:ByteType => "Byte"
      case _:ShortType => "Short"
      case _:IntegerType => "Int"
      case _:LongType => "Long"
      case _:FloatType => "Float"
      case _:DoubleType => "Double"
      case _:DecimalType => "java.math.BigDecimal"
      case _:StringType => "String"
      case _:BinaryType => "Array[Byte]"
      case _:BooleanType => "Boolean"
      case _:TimestampType => "java.sql.Timestamp"
      case _:DateType => "java.sql.Date"
      case _:ArrayType => "scala.collection.Seq"
      case _:MapType => "scala.collection.Map"
      case _:StructType => "org.apache.spark.sql.Row"
      case _ => "String"
    }}
  }
}

package models

import org.joda.time.DateTime
import play.api.libs.json.Json

/**
  * models.Balance json model
  */
case class Balance(name: String, amount: Long, updatedAt: DateTime)

object Balance {
  implicit val formatter = Json.format[Balance]
}

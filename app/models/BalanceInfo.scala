package models

import org.joda.time.DateTime
import play.api.libs.json.{Reads, Writes, Json}

/**
  * models.BalanceRecord model
  */
case class BalanceRecord(bank: String, amount: Double /*, updated: DateTime why? */)

object BalanceRecord {

  implicit val dateWrites = Writes.jodaDateWrites("yyyy-MM-dd'T'HH:mm:ss.SSSZ")

  implicit val dateReads = Reads.jodaDateReads("yyyy-MM-dd'T'HH:mm:ss.SSSZ")

  implicit val formatter = Json.format[BalanceRecord]
}

/**
  * models.BalanceInfo model
  */
case class BalanceInfo(name: String, contact: Option[String], balances: List[BalanceRecord])


object BalanceInfo {

  implicit val formatter = Json.format[BalanceInfo]

}

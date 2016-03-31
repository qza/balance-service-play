package controllers

import javax.inject.{Inject, Singleton}

import models.BalanceInfo
import play.api.libs.json.Json
import play.api.mvc.{Action, Controller}
import play.modules.reactivemongo.json._
import play.modules.reactivemongo.json.collection.JSONCollection
import play.modules.reactivemongo.{MongoController, ReactiveMongoApi, ReactiveMongoComponents}
import reactivemongo.api.{Cursor, ReadPreference}

import scala.concurrent.{ExecutionContext, Future}

/**
  * Serving balance info from Mongo collection
  */
@Singleton
class BalanceInfoController @Inject()(val reactiveMongoApi: ReactiveMongoApi)(implicit exec: ExecutionContext)
  extends Controller with MongoController with ReactiveMongoComponents {

  val balances: JSONCollection = db.collection[JSONCollection]("balance_info")

  def get(name: String) = Action.async {
    val balanceCursor: Cursor[BalanceInfo] =
      balances.find(Json.obj("name" -> name)).cursor[BalanceInfo](ReadPreference.primary)
    val balanceFuture: Future[List[BalanceInfo]] = balanceCursor.collect[List]()
    balanceFuture.map { data => Ok(Json.toJson(data)) }
  }

}

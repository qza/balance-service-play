package controllers

import javax.inject.{Inject, Singleton}
import play.api.mvc.{Controller, Action}
import services.BalanceStore

/**
  * Simple balance controller for retrieving balances
  */
@Singleton
class BalanceController @Inject()(store: BalanceStore) extends Controller {

  def get(name: String) = Action {
    store.get(name) match {
      case Some(result) => Ok(s"balance for $name is $result")
      case None => NotFound(s"unknown user $name")
    }
  }

}

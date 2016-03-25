package services

import javax.inject.{Inject, Singleton}

import play.api.Logger

/**
  * Simple in-memory store that keeps info about user balances
  */
@Singleton
class BalanceStore @Inject()() {

  var map = Map("tom" -> 10.1, "mark" -> 20.1)

  def get(name: String): Option[Double] = {
    map.get(name)
  }

}





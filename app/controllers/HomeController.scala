package controllers

import javax.inject._
import play.api.mvc._
import play.api.routing.Router

@Singleton
class HomeController @Inject()(router: Router) extends Controller {

  def index = Action {

    Ok(router.documentation.foldLeft("")((a, b) => a + "%-15s %-50s %s \n".format(b._1, b._2, b._3)))

  }

}

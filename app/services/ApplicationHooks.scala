package services

import java.time.Clock
import javax.inject._
import play.api.Logger
import play.api.inject.ApplicationLifecycle
import scala.concurrent.Future

@Singleton
class ApplicationHooks @Inject()(clock: Clock, appLifecycle: ApplicationLifecycle) {

  Logger.info(s" ==> Starting application")

  appLifecycle.addStopHook { () =>
    Logger.info(s" ==> Stopping application")
    Future.successful(())
  }
}

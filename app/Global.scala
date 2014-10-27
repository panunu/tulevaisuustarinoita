import play.api.Play.current
import play.api.{GlobalSettings, Play}
import com.google.inject.Guice
import com.tzavellas.sse.guice.ScalaModule

object Global extends GlobalSettings {
  private lazy val injector = {
    Guice.createInjector(
      new ScalaModule {
        override def configure(): Unit = {}
      }
    )
  }

  override def getControllerInstance[A](controllerClass: Class[A]): A = {
    injector.getInstance(controllerClass)
  }
}

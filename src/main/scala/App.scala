import GetUserService.GetUserService
import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import caliban.interop.circe.AkkaHttpCirceAdapter
import zio.Runtime
import zio.clock.Clock
import zio.console.Console
import zio.internal.Platform

import scala.concurrent.ExecutionContextExecutor

object ExampleApp extends App with AkkaHttpCirceAdapter {

  implicit val system: ActorSystem[String] = ActorSystem(Behaviors.empty[String], "example-app")

  implicit val executionContext: ExecutionContextExecutor = system.executionContext

  implicit val runtime: Runtime[GetUserService with Console with Clock] =
    Runtime.unsafeFromLayer(GetUserService.make() ++ Console.live ++ Clock.live, Platform.default)

  val interpreter = runtime.unsafeRun(PortFolioApi.api.interpreter)

  val route = path("graphql") {
    adapter.makeHttpService(interpreter)
  }

  val bindingFuture = Http().newServerAt("localhost", 8088).bind(route)

  sys.addShutdownHook {
    bindingFuture
      .flatMap(_.unbind())
      .onComplete(_ => system.terminate())
  }
}

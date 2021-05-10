import GetUserService.GetUserService
import caliban.GraphQL.graphQL
import caliban.schema.GenericSchema
import caliban.{GraphQL, RootResolver}
import zio.URIO
import zio.clock.Clock
import zio.console.Console

import scala.language.postfixOps
object PortFolioApi extends GenericSchema[GetUserService] {
  case class Queries(
      skills: URIO[GetUserService, Seq[Skill]],
      skill: SkillTypeArgs => URIO[GetUserService, Seq[Skill]],
      me: URIO[GetUserService, Seq[Me]],
      contact: URIO[GetUserService, Seq[Contact]]
  )
  val api: GraphQL[Console with Clock with GetUserService] =
    graphQL(
      RootResolver(
        Queries(
          GetUserService.findSkills,
          args => GetUserService.findBySkill(args.Type),
          GetUserService.findMe,
          GetUserService.findContact
        )
      )
    )

}

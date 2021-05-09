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
      users: URIO[GetUserService, Seq[UserSchema]],
      user: UserIdArgs => URIO[GetUserService, Option[UserSchema]],
      skills: URIO[GetUserService, Seq[Skill]],
      skill: SkillTypeArgs => URIO[GetUserService, Seq[Skill]]
  )
  val api: GraphQL[Console with Clock with GetUserService] =
    graphQL(
      RootResolver(
        Queries(
          GetUserService.findUsers,
          args => GetUserService.findUser(args.id),
          GetUserService.findSkills,
          args => GetUserService.findBySkill(args.Type)
        )
      )
    )

}

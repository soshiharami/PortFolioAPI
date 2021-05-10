import Users.skill
import zio.{Has, Ref, UIO, URIO, ZLayer}

object GetUserService {
  type GetUserService = Has[Service]

  trait Service {
    def findSkills: UIO[Seq[Skill]]

    def findBySkillType(Type: String): UIO[Seq[Skill]]
  }

  def findSkills: URIO[GetUserService, Seq[Skill]] =
    URIO.accessM(_.get.findSkills)

  def findBySkill(Type: String): URIO[GetUserService, Seq[Skill]] =
    URIO.accessM(_.get.findBySkillType(Type))

  def make(
      skills: Seq[Skill] = skill
  ): ZLayer[Any, Nothing, GetUserService] =
    ZLayer.fromEffect {
      for {
        skills <- Ref.make(skills)
      } yield new Service {

        def findSkills: UIO[Seq[Skill]] = skills.get

        def findBySkillType(Type: String): UIO[Seq[Skill]] =
          skills.get.map(_.filter(c => c.types.name == Type))
      }
    }
}

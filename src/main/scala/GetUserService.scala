import Users.{sample, skill}
import zio.{Has, Ref, UIO, URIO, ZLayer}

object GetUserService {
  type GetUserService = Has[Service]

  trait Service {
    def findUsers: UIO[Seq[UserSchema]]

    def findByUserId(id: Int): UIO[Option[UserSchema]]

    def findSkills: UIO[Seq[Skill]]

    def findBySkillType(Type: String): UIO[Seq[Skill]]
  }

  def findUsers: URIO[GetUserService, Seq[UserSchema]] =
    URIO.accessM(_.get.findUsers)

  def findUser(id: Int): URIO[GetUserService, Option[UserSchema]] =
    URIO.accessM(_.get.findByUserId(id))

  def findSkills: URIO[GetUserService, Seq[Skill]] =
    URIO.accessM(_.get.findSkills)

  def findBySkill(Type: String): URIO[GetUserService, Seq[Skill]] =
    URIO.accessM(_.get.findBySkillType(Type))

  def make(
      initial: Seq[UserSchema] = sample,
      skills: Seq[Skill] = skill
  ): ZLayer[Any, Nothing, GetUserService] =
    ZLayer.fromEffect {
      for {
        users <- Ref.make(initial)
        skills <- Ref.make(skills)
      } yield new Service {

        def findUsers: UIO[Seq[UserSchema]] = users.get

        def findByUserId(id: Int): UIO[Option[UserSchema]] =
          users.get.map(_.find(c => c.id == id))

        def findSkills: UIO[Seq[Skill]] = skills.get

        def findBySkillType(Type: String): UIO[Seq[Skill]] =
          skills.get.map(_.filter(c => c.types.name == Type))
      }
    }
}

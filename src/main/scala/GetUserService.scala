import Users.{sample, skill}
import zio.{Has, Ref, UIO, URIO, ZLayer}

object GetUserService {
  type GetUserService = Has[Service]

  trait Service {
    def findUsers: UIO[Seq[UserSchema]]

    def findByUserId(id: Int): UIO[Option[UserSchema]]

    def findSkill: UIO[Seq[Skill]]
  }

  def findUsers: URIO[GetUserService, Seq[UserSchema]] =
    URIO.accessM(_.get.findUsers)

  def findUser(id: Int): URIO[GetUserService, Option[UserSchema]] =
    URIO.accessM(_.get.findByUserId(id))

  def findSkill: URIO[GetUserService, Seq[Skill]] =
    URIO.accessM(_.get.findSkill)

  def make(
      initial: Seq[UserSchema] = sample,
      skillquery: Seq[Skill] = skill
  ): ZLayer[Any, Nothing, GetUserService] =
    ZLayer.fromEffect {
      for {
        users <- Ref.make(initial)
        skillquery <- Ref.make(skillquery)
      } yield new Service {

        def findUsers: UIO[Seq[UserSchema]] = users.get

        def findByUserId(id: Int): UIO[Option[UserSchema]] =
          users.get.map(_.find(c => c.id == id))

        override def findSkill: UIO[Seq[Skill]] = skillquery.get
      }
    }
}

import Users.{contacts, me, skills, histories}
import zio.{Has, Ref, UIO, URIO, ZLayer}

object GetUserService {
  type GetUserService = Has[Service]

  trait Service {
    def findSkills: UIO[Seq[Skill]]

    def findBySkillType(Type: String): UIO[Seq[Skill]]

    def findMe: UIO[Seq[Me]]

    def findContacts: UIO[Seq[Contact]]

    def findHistories: UIO[Seq[History]]
  }

  def findSkills: URIO[GetUserService, Seq[Skill]] =
    URIO.accessM(_.get.findSkills)

  def findBySkill(Type: String): URIO[GetUserService, Seq[Skill]] =
    URIO.accessM(_.get.findBySkillType(Type))

  def findMe: URIO[GetUserService, Seq[Me]] =
    URIO.accessM(_.get.findMe)

  def findContacts: URIO[GetUserService, Seq[Contact]] =
    URIO.accessM(_.get.findContacts)

  def findHistories: URIO[GetUserService, Seq[History]] =
    URIO.accessM(_.get.findHistories)

  def make(
      skills: Seq[Skill] = skills,
      me: Seq[Me] = me,
      contacts: Seq[Contact] = contacts,
      histories: Seq[History] = histories
  ): ZLayer[Any, Nothing, GetUserService] =
    ZLayer.fromEffect {
      for {
        skills <- Ref.make(skills)
        me <- Ref.make(me)
        contact <- Ref.make(contacts)
        histories <- Ref.make(histories)
      } yield new Service {

        def findSkills: UIO[Seq[Skill]] = skills.get

        def findBySkillType(Type: String): UIO[Seq[Skill]] =
          skills.get.map(_.filter(c => c.types.name == Type))

        def findMe: UIO[Seq[Me]] =
          me.get

        override def findContacts: UIO[Seq[Contact]] = contact.get

        override def findHistories: UIO[Seq[History]] = histories.get

      }
    }
}

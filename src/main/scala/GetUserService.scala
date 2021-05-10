import Users.{contact, me, skills}
import zio.{Has, Ref, UIO, URIO, ZLayer}

object GetUserService {
  type GetUserService = Has[Service]

  trait Service {
    def findSkills: UIO[Seq[Skill]]

    def findBySkillType(Type: String): UIO[Seq[Skill]]

    def findMe: UIO[Seq[Me]]

    def findContact: UIO[Seq[Contact]]
  }

  def findSkills: URIO[GetUserService, Seq[Skill]] =
    URIO.accessM(_.get.findSkills)

  def findBySkill(Type: String): URIO[GetUserService, Seq[Skill]] =
    URIO.accessM(_.get.findBySkillType(Type))

  def findMe: URIO[GetUserService, Seq[Me]] =
    URIO.accessM(_.get.findMe)

  def findContact: URIO[GetUserService, Seq[Contact]] =
    URIO.accessM(_.get.findContact)

  def make(
      skills: Seq[Skill] = skills,
      me: Seq[Me] = me,
      contact: Seq[Contact] = contact
  ): ZLayer[Any, Nothing, GetUserService] =
    ZLayer.fromEffect {
      for {
        skills <- Ref.make(skills)
        me <- Ref.make(me)
        contact <- Ref.make(contact)
      } yield new Service {

        def findSkills: UIO[Seq[Skill]] = skills.get

        def findBySkillType(Type: String): UIO[Seq[Skill]] =
          skills.get.map(_.filter(c => c.types.name == Type))

        def findMe: UIO[Seq[Me]] =
          me.get

        override def findContact: UIO[Seq[Contact]] = contact.get
      }
    }
}

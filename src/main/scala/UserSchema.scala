case class Me(
    name: String,
    about: String,
    age: String,
    skills: Array[Skill],
    histories: Array[History],
    contact: Array[Contact]
)
case class History(id: Int, time: String, title: String, about: String)
case class Skill(id: Int, name: String, types: SkillType)
case class SkillType(id: Int, name: String)
case class Contact(id: Int, url: String, name: String)
case class SkillTypeArgs(Type: String) extends AnyVal

object Users {

  val me = Seq(
    /* Me(
      name = "soshi",
      about = "2003年8月7日生まれの千葉県の学生\n趣味はゲームとプログラミング",
      age = "18",
      skills = ,
      histories = ???,
      contact = ???
    ) */
  )

  val skillType = Seq(
    SkillType(id = 1, name = "FrontEnd"),
    SkillType(id = 2, name = "BackEnd"),
    SkillType(id = 3, name = "OtherPrograming"),
    SkillType(id = 4, name = "OS"),
    SkillType(id = 5, name = "Other")
  )

  val skill = Seq(
    Skill(
      id = 1,
      name = "TypeScript",
      types = skillType.find(_.name == "FrontEnd").get
    ),
    Skill(
      id = 2,
      name = "JavaScript",
      types = skillType.find(_.name == "FrontEnd").get
    ),
    Skill(
      id = 3,
      name = "React",
      types = skillType.find(_.name == "FrontEnd").get
    ),
    Skill(
      id = 4,
      name = "Next",
      types = skillType.find(_.name == "FrontEnd").get
    ),
    Skill(
      id = 5,
      name = "Svelte",
      types = skillType.find(_.name == "FrontEnd").get
    ),
    Skill(
      id = 6,
      name = "ScalaJS",
      types = skillType.find(_.name == "FrontEnd").get
    ),
    Skill(
      id = 7,
      name = "ScalaJS-React",
      types = skillType.find(_.name == "FrontEnd").get
    ),
    Skill(
      id = 8,
      name = "HTML5",
      types = skillType.find(_.name == "FrontEnd").get
    ),
    Skill(
      id = 9,
      name = "CSS3",
      types = skillType.find(_.name == "FrontEnd").get
    ),
    Skill(
      id = 10,
      name = "PlayFramework",
      types = skillType.find(_.name == "BackEnd").get
    ),
    Skill(
      id = 11,
      name = "SpringBoot",
      types = skillType.find(_.name == "BackEnd").get
    ),
    Skill(
      id = 12,
      name = "SQLite",
      types = skillType.find(_.name == "BackEnd").get
    ),
    Skill(
      id = 13,
      name = "MongoDB",
      types = skillType.find(_.name == "BackEnd").get
    ),
    Skill(
      id = 14,
      name = "MySQL",
      types = skillType.find(_.name == "BackEnd").get
    ),
    Skill(
      id = 15,
      name = "Node.js",
      types = skillType.find(_.name == "BackEnd").get
    ),
    Skill(
      id = 16,
      name = "Scala",
      types = skillType.find(_.name == "OtherPrograming").get
    ),
    Skill(
      id = 17,
      name = "Python",
      types = skillType.find(_.name == "OtherPrograming").get
    ),
    Skill(
      id = 18,
      name = "Java",
      types = skillType.find(_.name == "OtherPrograming").get
    ),
    Skill(
      id = 19,
      name = "MinecraftPlugin & Mod",
      types = skillType.find(_.name == "OtherPrograming").get
    ),
    Skill(
      id = 20,
      name = "Windows",
      types = skillType.find(_.name == "OS").get
    ),
    Skill(
      id = 21,
      name = "Arch Linux",
      types = skillType.find(_.name == "OS").get
    ),
    Skill(
      id = 22,
      name = "Alter Linux",
      types = skillType.find(_.name == "OS").get
    ),
    Skill(
      id = 23,
      name = "Ubuntu",
      types = skillType.find(_.name == "OS").get
    ),
    Skill(
      id = 24,
      name = "IOS",
      types = skillType.find(_.name == "OS").get
    ),
  )

}

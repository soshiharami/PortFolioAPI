import java.text.SimpleDateFormat
import java.util.Date

case class Me(
    name: String,
    about: String,
    age: String,
    skills: Seq[Skill],
    histories: Seq[History],
    contact: Seq[Contact]
)
case class History(id: Int, time: String, title: String, about: String)
case class Skill(id: Int, name: String, types: SkillType)
case class SkillType(id: Int, name: String)
case class Contact(id: Int, url: String, name: String)
case class SkillTypeArgs(Type: String) extends AnyVal

object Users {

  val contacts = Seq(
    Contact(id = 1, url = "https://twitter.com/soshi_harami", name = "Twitter"),
    Contact(id = 2, url = "https://github.com/soshiharami", name = "GitHub"),
    Contact(id = 3, url = "https://lapras.com/public/ELLYVRF", name = "Lapras"),
    Contact(id = 4, url = "https://qiita.com/soshi_harami", name = "Qiita"),
    Contact(id = 5, url = "https://approvers.dev/", name = "限界開発鯖")
  )

  val skillType = Seq(
    SkillType(id = 1, name = "FrontEnd"),
    SkillType(id = 2, name = "BackEnd"),
    SkillType(id = 3, name = "OtherPrograming"),
    SkillType(id = 4, name = "OS"),
    SkillType(id = 5, name = "Other")
  )

  val skills = Seq(
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
      name = "iOS",
      types = skillType.find(_.name == "OS").get
    ),
    Skill(
      id = 25,
      name = "functional programming",
      types = skillType.find(_.name == "Other").get
    ),
    Skill(
      id = 26,
      name = "PC",
      types = skillType.find(_.name == "Other").get
    ),
    Skill(
      id = 27,
      name = "Proxmox",
      types = skillType.find(_.name == "OS").get
    ),
    Skill(
      id = 28,
      name = "MineOS",
      types = skillType.find(_.name == "OS").get
    ),
    Skill(
      id = 29,
      name = "Go",
      types = skillType.find(_.name == "OtherPrograming").get
    )
  )

  val histories = Seq(
    History(id = 1, time = "2003/08/07", title = "誕生", about = "千葉県にて誕生"),
    History(
      id = 2,
      time = "2017/08/18",
      title = "留学",
      about = "オーストラリア メルボルンにて短期留学"
    ),
    History(
      id = 3,
      time = "2019/04/05",
      title = "高専入学",
      about = "国立木更津工業高等専門学校の情報工学科に入学"
    ),
    History(
      id = 4,
      time = "2020/03/01",
      title = "限界開発鯖に参加",
      about = "このタイミングでプログラミングを本格的にスタート"
    ),
    History(
      id = 5,
      time = "2020/06/01",
      title = "Scalaを始める",
      about = "関数型言語を知り、Scalaを始める"
    ),
    History(
      id = 6,
      time = "2020/10/01",
      title = "仕事を始める",
      about = "株式会社 C-Style で業務委託という形で業務を開始"
    ),
    History(id = 7, time = "2021/04/05", title = "高専プロコン", about = "高専プロコンに出場")
  )

  val me = Seq(
    Me(
      name = "soshi",
      about = "2003年8月7日生まれの千葉県の学生\n趣味はゲームとプログラミング",
      age =
        (new SimpleDateFormat("YYYY").format(new Date()).toInt - 2003).toString,
      skills = skills,
      histories = histories,
      contact = contacts
    )
  )
}

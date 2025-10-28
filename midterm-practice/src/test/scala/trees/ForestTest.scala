package trees

case class ForestCase(title: String, input: Forest, expected: String)

class ForestSuite extends munit.FunSuite:
  val cases: List[ForestCase] = List(
    ForestCase(
      title = "empty forest",
      input = Nil,
      expected = "."
    ),
    ForestCase(
      title = "example from instructions",
      input = Seq(Tree("hello", Seq(Leaf("world"))), Tree("we", Seq(Tree("are", Seq(Leaf("cs214")))))),
      expected = """
.
├── hello
│   └── world
└── we
    └── are
        └── cs214
""".trim()
    ),
    ForestCase(
      title = "large forest",
      input = Seq(
        Tree(
          "A",
          Seq(
            Leaf("A.1"),
            Tree("A.2", Seq(Leaf("A.2.x"), Leaf("A.2.y"), Leaf("A.2.z"))),
            Tree("A.3", Seq(Leaf("A.3.u"), Leaf("A.3.v")))
          )
        ),
        Leaf("B"),
        Tree(
          "C",
          Seq(
            Leaf("C.1"),
            Tree("C.2", Seq(Leaf("C.2.a"), Leaf("C.2.b"), Leaf("C.2.c")))
          )
        )
      ),
      expected = """
.
├── A
│   ├── A.1
│   ├── A.2
│   │   ├── A.2.x
│   │   ├── A.2.y
│   │   └── A.2.z
│   └── A.3
│       ├── A.3.u
│       └── A.3.v
├── B
└── C
    ├── C.1
    └── C.2
        ├── C.2.a
        ├── C.2.b
        └── C.2.c
""".trim()
    ),
    ForestCase(
      title = "scala project bis",
      input = Seq(
        Leaf("build.sbt"),
        Tree("project", Seq(Leaf("build.properties"))),
        Tree(
          "src",
          Seq(
            Tree(
              "main",
              Seq(
                Tree("scala", Seq(Leaf("playground.worksheet.sc"), Leaf("App.scala")))
              )
            ),
            Tree(
              "test",
              Seq(
                Tree("scala", Seq(Leaf("AppTest.scala")))
              )
            )
          )
        )
      ),
      expected = """
.
├── build.sbt
├── project
│   └── build.properties
└── src
    ├── main
    │   └── scala
    │       ├── playground.worksheet.sc
    │       └── App.scala
    └── test
        └── scala
            └── AppTest.scala
""".trim()
    )
  )

  for c <- cases do
    test(s"unixForest: ${c.title}"):
      val actual = unixForest(c.input)
      assertEquals(actual, c.expected)

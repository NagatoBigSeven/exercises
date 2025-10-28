package trees

type TreeCase = (String, Tree, String)
case class PartialTreeCase(title: String, input: Tree)

abstract class TreeSuite(
    funcName: String,
    renderFn: Tree => String,
    cases: List[(String, Tree, String)]
) extends munit.FunSuite:
  for (title, inputTree, expectedOutput) <- cases do
    test(s"$funcName: $title"):
      val actual = renderFn(inputTree)
      assertEquals(actual, expectedOutput)

object TreeSuite:
  val leaf: TreeCase = ("single leaf", Leaf("leaf"), "leaf")

  val singleChild = PartialTreeCase(
    title = "single child",
    input = Tree("parent", Seq(Leaf("child")))
  )

  val balancedTree = PartialTreeCase(
    title = "balanced tree",
    input = Tree(
      "root",
      Seq(
        Tree("first", Seq(Leaf("first.first"), Leaf("first.second"))),
        Tree("second", Seq(Leaf("second.first"), Leaf("second.second")))
      )
    )
  )

  val instructionsExample = PartialTreeCase(
    title = "example from instructions",
    input = Tree(
      "hello",
      Seq(
        Leaf("world"),
        Tree("and", Seq(Tree("welcome", Seq(Tree("to", Seq(Leaf("cs214")))))))
      )
    )
  )

  val scalaProject = PartialTreeCase(
    title = "scala project",
    input = Tree(
      "my-project",
      Seq(
        Tree(
          "project",
          Seq(Leaf("build.properties"))
        ),
        Tree(
          "src",
          Seq(
            Tree(
              "main",
              Seq(
                Tree("scala", Seq(Leaf("App.scala")))
              )
            ),
            Tree(
              "test",
              Seq(
                Tree("scala", Seq(Leaf("AppTest.scala")))
              )
            )
          )
        ),
        Leaf("LICENSE"),
        Leaf(".gitignore"),
        Leaf("build.sbt"),
        Leaf("README.md")
      )
    )
  )

  val largeTreeCase = PartialTreeCase(
    title = "large tree",
    input = Tree(
      "large",
      Seq(
        Tree("tree", Seq(Tree("with", Seq(Tree("many", Seq(Leaf("levels"))))))),
        Tree("and", Seq(Tree("multiple", Seq(Leaf("children"), Leaf("leaves"), Leaf("?")))))
      )
    )
  )

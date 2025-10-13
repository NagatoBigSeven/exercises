name := "parallelism"
scalaVersion := "3.7.2"
libraryDependencies += "org.scalameta" %% "munit" % "1.1.1" % Test
libraryDependencies += "org.scala-lang.modules" %% "scala-parallel-collections" % "1.2.0"

enablePlugins(JmhPlugin)

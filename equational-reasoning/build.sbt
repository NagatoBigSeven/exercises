name := "equational-reasoning"

scalaVersion := "3.7.2"
scalacOptions ++= Seq("-deprecation", "-feature", "-Xfatal-warnings")

libraryDependencies += "ch.epfl.lara" %% "lisa" % "0.7" from "https://github.com/sankalpgambhir/lisa/raw/refs/heads/lisa07-scala372/lisa_3-0.7.jar"
libraryDependencies += "org.scalameta" %% "munit" % "1.1.1" % Test
libraryDependencies += "com.lihaoyi" %% "sourcecode" % "0.4.4"

run / fork := true

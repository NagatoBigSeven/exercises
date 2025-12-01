name := "pbt"
scalaVersion := "3.7.2"
libraryDependencies += "org.scalameta" %% "munit" % "1.1.1" % Test
libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.19.0"
scalacOptions ++= Seq("-deprecation", "-feature", "-Xfatal-warnings")

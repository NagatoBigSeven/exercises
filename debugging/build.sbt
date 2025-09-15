name := "debugging"
scalaVersion := "3.7.2"
libraryDependencies += "org.scalameta" %% "munit" % "1.1.1" % Test
scalacOptions ++= Seq("-deprecation", "-feature", "-Xfatal-warnings")

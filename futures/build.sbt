name := "futures"
scalaVersion := "3.7.2"
libraryDependencies += "com.softwaremill.sttp.client4" %% "core" % "4.0.0-M19"
libraryDependencies += "com.softwaremill.sttp.client4" %% "upickle" % "4.0.0-M19"
libraryDependencies += "org.scalameta" %% "munit" % "1.1.1" % Test

scalacOptions ++= Seq("-deprecation", "-feature", "-Xfatal-warnings")
//run / fork := true
//run / connectInput := true

// Makes sure that all spwaned threads are killed at the end of the test suite.
Test / fork := true
Test / parallelExecution := false
Test / testForkedParallel := false

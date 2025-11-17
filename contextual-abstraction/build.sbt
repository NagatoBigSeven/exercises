name := "contextual-abstraction"
scalaVersion := "3.7.2"
libraryDependencies ++= Seq(
  "com.lihaoyi" %% "upickle" % "4.3.0",
  "org.scalacheck" %% "scalacheck" % "1.19.0" % Test
)
scalacOptions ++= Seq("-deprecation", "-feature", "-Xfatal-warnings")

Test / testOptions += Tests.Argument(
  TestFrameworks.ScalaCheck,
  // "-maxSize",
  // "5",
  // "-minSuccessfulTests",
  // "33",
  "-workers",
  "1",
  // "-verbosity",
  // "1"
  )

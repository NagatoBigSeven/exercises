name := "formal-verification"
scalaVersion := "3.7.2"
scalacOptions ++= Seq("-deprecation", "-feature", "-Xfatal-warnings")

// Prevent SBT from including Stainless files in CI/CD compilation,
// as those files need to be compiled using the Stainless frontend.
Compile / unmanagedSourceDirectories := Seq.empty
Test / unmanagedSourceDirectories := Seq.empty

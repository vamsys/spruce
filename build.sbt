import Dependencies._
import sbt.Keys.version

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
        version := "0.1",
        scalaVersion := "2.12.4"
    )),
    name:= "SpruceTest",
    resolvers += "Typesafe Releases" at "https://repo.typesafe.com/typesafe/releases/",
    libraryDependencies ++= Seq(
      scalaTest % Test,
      selenium % Test,
      scalaJHttp % Test,
      playJson % Test,
      playAhc % Test,
      playWs % Test,
      jerseyClient % Test,
      jerseyCore % Test,
      pegdown % Test),
      testOptions in Test ++= Seq(Tests.Argument(TestFrameworks.ScalaTest, "-o"), Tests.Argument(TestFrameworks.ScalaTest, "-h", "target/test-reports"))
  )

        
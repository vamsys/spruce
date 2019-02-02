import sbt._

object Dependencies {

  lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.0.1"
  lazy val selenium = "org.seleniumhq.selenium" % "selenium-java" % "3.7.1"
  lazy val scalaJHttp = "org.scalaj" % "scalaj-http_2.12" % "2.3.0"
  lazy val playJson = "com.typesafe.play" % "play-json_2.12" % "2.6.6"
  lazy val playWs = "com.typesafe.play" %% "play-ws" % "2.6.12"
  lazy val playAhc = "com.typesafe.play" % "play-ahc-ws_2.12" % "2.6.12"
  lazy val akkaActor = "com.typesafe.akka" %% "akka-actor" % "2.4.16"
  lazy val akkaStream = "com.typesafe.akka" %% "akka-stream" % "2.5.11"
  lazy val jerseyClient = "com.sun.jersey" % "jersey-client" % "1.19.1"
  lazy val jerseyCore = "com.sun.jersey" % "jersey-core" % "1.19.1"
  lazy val pegdown = "org.pegdown"    %  "pegdown"     % "1.6.0"
}

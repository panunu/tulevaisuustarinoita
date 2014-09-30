name := """future-stories"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  ws
)

//libraryDependencies += "org.planet42" %% "laika-core_2.10" % "0.5.0"



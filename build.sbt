import sbt.Keys._

lazy val commonSettings = Seq(
  organization := "user-manager",
  version := "0.1.0-SNAPSHOT",
  organization := "com.example",
  scalaVersion := "2.12.4",
  scalacOptions := Seq(
    "-deprecation",
    "-feature"
  )
)

lazy val interface = Interface.project

lazy val application = Application.project

lazy val infrastructure = Infrastructure.project

lazy val domain = Domain.project

lazy val root = Project(
  "user-manager",
  file(".")
).enablePlugins(
  PlayScala
).dependsOn(
  interface,
  application,
  infrastructure,
  domain
).aggregate(
  interface,
  application,
  infrastructure,
  domain
)


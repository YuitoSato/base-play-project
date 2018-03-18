import sbt._
import sbt.Keys._

// Play
import play.sbt.PlayScala
import play.sbt.PlayImport._
import play.sbt.PlayImport.PlayKeys._

object API {

  val apiDependencies = Seq(
    cacheApi,
    filters,
    guice,

    "org.scalaz" %% "scalaz-core" % "7.2.12",

    // For Test
    "org.scalatest" %% "scalatest"                 % "3.0.1"  % "test",
    "org.mockito"   % "mockito-core"               % "2.8.9"  % "test",
    "org.scalaz"    %% "scalaz-scalacheck-binding" % "7.2.12" % "test",
  )

  lazy val project = Project(
    "api",
    file("api")
  ).enablePlugins(
    PlayScala
  ).settings(
    playDefaultPort := 9011
  ).settings(
    libraryDependencies ++= apiDependencies,
    unmanagedResourceDirectories in Compile += baseDirectory.value / "resources"
  ).dependsOn(
    Application.project
  )
}

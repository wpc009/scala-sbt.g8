import sbt._
import sbt.Keys._

object $name;format="Camel"$Build extends Build {


  val commonSettings = Seq[Def.Setting[_]](
    sourceManaged <<= (baseDirectory){ (base) => base / "src_managed" },
    organization := Conf.org,
    scalaVersion := "$scala_version$",
    scalacOptions ++= Seq(
        "-deprecation",
        "-feature",
        "-language:postfixOps"
    )
  )

  lazy val testSettings = Seq[Def.Setting[_]](

  )

  lazy val publish_settings = Seq(
       publishTo := {
      if(isSnapshot.value)
        Some("snapshots" at "http://artifactory.segmetics.com/artifactory/libs-snapshot-local")
      else
        Some("artifactory.segmetics.com-releases" at "http://artifactory.segmetics.com/artifactory/libs-release-local")
    },
    credentials += Credentials("Artifactory Realm","artifactory.segmetics.com","<username>","<password>")
  )


  lazy val $name;format="camel"$ = Project(
    id = "$name;format="norm"$",
    base = file("."),
    settings = Project.defaultSettings ++ commonSettings ++ Seq(
      name := "$name$",
      version := Ver("$version$").snapshot,
      libraryDependencies ++= Dependencies.$name;format="camel"$
      // add other settings here
    )
  )


}

object DepVersions {
  lazy val akka = "$akka_version$"

}

object Conf {


  lazy val org = "$organization$"

}

object Dependencies {

  private[this] lazy val logging = Seq(
  )

  private[this] lazy val unitest = Seq(
    "com.typesafe.akka" %% "akka-testkit" % DepVersions.akka % "test",
    "org.scalatest" %% "scalatest" % "2.2.4" % "test"
  )

  private[this] lazy val akka =  Seq(
    "com.typesafe.akka" %% "akka-actor" % DepVersions.akka
  )

  lazy val $name;format="camel"$ = Seq(
  ) ++ akka ++ unitest ++ logging
}

case class Ver(version:String){

  override def toString(): String =  version 
  

  def snapshot():String = version + "-SNAPSHOT"

def beta(v:Int):String = "%s-BetaV%d".format(version,v)

  def release():String = version


}




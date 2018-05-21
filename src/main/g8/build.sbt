lazy val logging = Seq(
      "ch.qos.logback" % "logback-classic" % "1.1.3"
)

lazy val unitest = Seq(
    "org.scalatest" %% "scalatest" % "2.2.4" % "test"
 )

enablePlugins(GitVersioning, GitBranchPrompt, BuildInfoPlugin,JavaAppPackaging)



name := "$name;format="Camel"$"

seq(MaxtropyngBuild.common:_*)
 
libraryDependencies ++= unitest ++ logging ++ Seq(
)

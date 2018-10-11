package nelson.build

import sbt._, Keys._
import xerial.sbt.Sonatype.autoImport.sonatypeProfileName
import verizon.build._

object CentralRequirementsPlugin extends AutoPlugin {

  override def trigger = allRequirements

  override def requires = RigPlugin

  override lazy val projectSettings = Seq(
    publishTo := Some("releases"  at "https://oss.sonatype.org/service/local/staging/deploy/maven2"),
    sonatypeProfileName := "io.getnelson",
    pomExtra in Global := {
      <developers>
        <developer>
          <id>timperrett</id>
          <name>Timothy Perrett</name>
          <url>http://github.com/timperrett</url>
        </developer>
      </developers>
    },
    licenses := Seq("Apache-2.0" -> url("https://www.apache.org/licenses/LICENSE-2.0.html")),
    homepage := Some(url("http://getnelson.io/")),
    scmInfo := Some(ScmInfo(url("https://github.com/getnelson/api"),
                                "git@github.com:getnelson/api.git"))
  )
}

scalaVersion := "2.12.8"

resolvers +=
  "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"

resolvers += "Typesafe" at "http://repo.typesafe.com/typesafe/releases/"

resolvers += "Java.net Maven2 Repository" at "http://download.java.net/maven/2/"

resolvers += Resolver.mavenLocal

name := "linear-regression"
organization := "com.netpod.ml"
version := "1.0"

libraryDependencies += "org.scala-lang.modules" %% "scala-parser-combinators" % "1.1.2"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.8" % Test
libraryDependencies += "com.typesafe" % "config" % "1.3.4"
libraryDependencies += "org.apache.spark" %% "spark-core" % "2.4.4"
libraryDependencies += "org.apache.spark" %% "spark-mllib" % "2.4.4"
//libraryDependencies += "org.apache.spark" %% "spark-mllib" % "2.4.4" % "runtime"
libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.4.4"

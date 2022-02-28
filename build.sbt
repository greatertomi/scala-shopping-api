name := "shopping-api"

version := "0.1"

scalaVersion := "2.13.8"

idePackagePrefix := Some("org.john.shopping")

val akkaVersion = "2.6.16"
val circeVersion = "0.14.1"
val sangriaAkkaHttpVersion = "0.0.2"

libraryDependencies ++= Seq(
  "org.sangria-graphql" %% "sangria" % "2.1.5",
  "org.sangria-graphql" %% "sangria-slowlog" % "2.0.4",
  "org.sangria-graphql" %% "sangria-circe" % "1.3.2",

  "org.sangria-graphql" %% "sangria-akka-http-core" % sangriaAkkaHttpVersion,
  "org.sangria-graphql" %% "sangria-akka-http-circe" % sangriaAkkaHttpVersion,

  "com.typesafe.akka" %% "akka-http" % "10.2.8",
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "com.typesafe.akka" %% "akka-stream" % akkaVersion,
  "de.heikoseeberger" %% "akka-http-circe" % "1.39.2",
  "com.lightbend.akka" %% "akka-stream-alpakka-slick" % "3.0.4",

  "io.circe" %% "circe-core" % circeVersion,
  "io.circe" %% "circe-parser" % circeVersion,
  "io.circe" %% "circe-optics" % circeVersion,

  "com.typesafe.slick" %% "slick" % "3.3.3",
  "com.h2database" % "h2" % "1.4.200",
  "org.postgresql" % "postgresql" % "42.2.24",
  "org.slf4j" % "slf4j-nop" % "1.7.32",
  "com.typesafe.slick" %% "slick-hikaricp" % "3.3.3",
  "com.google.inject" % "guice" % "5.0.1",

  "com.github.tminglei" %% "slick-pg" % "0.19.7",
  "com.github.tminglei" %% "slick-pg_circe-json" % "0.19.7",
  "com.github.tminglei" %% "slick-pg_joda-time" % "0.19.7",

  "org.scalatest" %% "scalatest" % "3.2.9" % Test
)


name := "untitled"

version := "0.1"

scalaVersion := "2.13.5"

scalacOptions ++= Seq(
  "-deprecation", // Emit warning and location for usages of deprecated APIs.
  "-explaintypes", // Explain type errors in more detail.
  "-feature", // Emit warning and location for usages of features that should be imported explicitly.
  "-language:existentials", // Existential types (besides wildcard types) can be written and inferred
  "-language:experimental.macros", // Allow macro definition (besides implementation and application)
  "-language:higherKinds", // Allow higher-kinded types
  "-language:implicitConversions", // Allow definition of implicit functions called views
  "-unchecked", // Enable additional warnings where generated code depends on assumptions.
  "-Xcheckinit", // Wrap field accessors to throw an exception on uninitialized access.
  "-Xfatal-warnings", // Fail the compilation if there are any warnings.
  "-Xlint:adapted-args", // Warn if an argument list is modified to match the receiver.
  "-Xlint:constant", // Evaluation of a constant arithmetic expression results in an error.
  "-Xlint:delayedinit-select", // Selecting member of DelayedInit.
  "-Xlint:doc-detached", // A Scaladoc comment appears to be detached from its element.
  "-Xlint:inaccessible", // Warn about inaccessible types in method signatures.
  "-Xlint:infer-any", // Warn when a type argument is inferred to be `Any`.
  "-Xlint:missing-interpolator", // A string literal appears to be missing an interpolator id.
  "-Xlint:nullary-unit", // Warn when nullary methods return Unit.
  "-Xlint:option-implicit", // Option.apply used implicit view.
  "-Xlint:package-object-classes", // Class or object defined in package object.
  "-Xlint:poly-implicit-overload", // Parameterized overloaded implicit methods are not visible as view bounds.
  "-Xlint:private-shadow", // A private field (or class parameter) shadows a superclass field.
  "-Xlint:stars-align", // Pattern sequence wildcard must align with sequence component.
  "-Xlint:type-parameter-shadow", // A local type parameter shadows a type already in scope.
  "-Ywarn-dead-code", // Warn when dead code is identified.
  "-Ywarn-extra-implicit", // Warn when more than one implicit parameter section is defined.
  "-Ywarn-numeric-widen", // Warn when numerics are widened.
  "-Ywarn-unused:implicits", // Warn if an implicit parameter is unused.
  //"-Ywarn-unused:imports", // Warn if an import selector is not referenced.
  "-Ywarn-unused:locals", // Warn if a local definition is unused.
  "-Ywarn-unused:params", // Warn if a value parameter is unused.
  "-Ywarn-unused:patvars", // Warn if a variable bound in a pattern is unused.
  "-Ywarn-unused:privates", // Warn if a private member is unused.
  //"-Ywarn-value-discard", // Warn when non-Unit expression results are unused.
  "-Ybackend-parallelism",
  "8", // Enable paralellisation — change to desired number!
  "-Ycache-plugin-class-loader:last-modified", // Enables caching of classloaders for compiler plugins
  "-Ycache-macro-class-loader:last-modified" // and macro defini
)

resolvers ++= Seq(
  "jitpack" at "https://jitpack.io",
  Resolver.jcenterRepo
)

libraryDependencies ++= Seq(
  "org.slf4j" % "slf4j-api" % "1.7.25",
  "ch.qos.logback" % "logback-classic" % "1.2.3",
  "com.google.code.findbugs" % "jsr305" % "3.0.2" % Optional,
  "org.scalatest" %% "scalatest" % "3.0.8",
  "org.scalatest" %% "scalatest" % "3.0.8" % Test,
  "com.typesafe" % "config" % "1.4.1",
  "org.scalaj" %% "scalaj-http" % "2.4.2",
  "com.typesafe.akka" %% "akka-actor" % "2.5.23",
  "com.typesafe.akka" %% "akka-http" % "10.2.4",
  "com.typesafe.akka" %% "akka-stream" % "2.5.23",
  "com.github.ghostdogpr" %% "caliban" % "0.9.5",
  "com.github.ghostdogpr" %% "caliban-http4s" % "0.9.5",
  "com.github.ghostdogpr" %% "caliban-play" % "0.9.5",
  "com.github.ghostdogpr" %% "caliban-akka-http" % "0.9.5",
  "com.github.ghostdogpr" %% "caliban-cats" % "0.9.5",
  "com.github.ghostdogpr" %% "caliban-monix" % "0.9.5",
  "com.github.ghostdogpr" %% "caliban-finch" % "0.9.5",
  "com.github.ghostdogpr" %% "caliban-federation" % "0.9.5",
  "com.github.ghostdogpr" %% "caliban-tapir" % "0.9.5",
  "com.github.ghostdogpr" %% "caliban-client" % "0.9.5",
  "de.heikoseeberger" %% "akka-http-circe" % "1.36.0",
  "com.softwaremill.sttp.client3" %% "async-http-client-backend-zio" % "3.2.3",
  "com.softwaremill.sttp.tapir" %% "tapir-json-circe" % "0.17.18",
  "io.circe" %% "circe-generic" % "0.13.0",
  "com.typesafe.play" %% "play-akka-http-server" % "2.8.8",
  "com.typesafe.akka" %% "akka-actor-typed" % "2.6.14",
  "ch.megard" %% "akka-http-cors" % "1.1.1"
)

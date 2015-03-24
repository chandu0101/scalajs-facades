resolvers += Resolver.url(
  "scala-js-experiments",
  url("https://dl.bintray.com/content/sjrd/scala-js-experiments"))(
  Resolver.ivyStylePatterns)

dependencyOverrides ++= Set(
  Defaults.sbtPluginExtra("org.scala-js" % "sbt-scalajs" % "0.6.2+bench.2",
    (sbtBinaryVersion in update).value, (scalaBinaryVersion in update).value),
  "org.scala-js" %% "scalajs-tools" % "0.6.2+bench.2",
  "org.scala-js" %% "scalajs-js-envs" % "0.6.2+bench.2",
  "org.scala-js" %% "scalajs-test-adapter" % "0.6.2+bench.2"
)

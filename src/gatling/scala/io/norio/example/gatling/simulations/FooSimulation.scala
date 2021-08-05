package io.norio.example.gatling.simulations

import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.concurrent.duration._

class FooSimulation extends Simulation {

  val httpProtocol = http
    .baseUrl("http://localhost")

  val fooScenario = scenario("Foo scenario")
    .exec(
      http("request_1")
        .get("/foo")
    )

  setUp(
    fooScenario
      .inject(constantUsersPerSec(20) during 15.seconds)
      .protocols(httpProtocol)
  )
}

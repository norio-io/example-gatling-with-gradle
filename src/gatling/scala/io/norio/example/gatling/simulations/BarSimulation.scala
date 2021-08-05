package io.norio.example.gatling.simulations

import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.concurrent.duration._

class BarSimulation extends Simulation {

  val httpProtocol = http
    .baseUrl("http://localhost")

  val barScenario = scenario("Bar scenario")
    .exec(
      http("request_1")
        .get("/bar")
    )

  setUp(
    barScenario
      .inject(constantUsersPerSec(20) during 15.seconds)
      .protocols(httpProtocol)
  )
}

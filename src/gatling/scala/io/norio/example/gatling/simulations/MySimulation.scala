package io.norio.example.gatling.simulations

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class MySimulation extends Simulation {

  val httpProtocol = http
    .baseUrl("http://localhost")

  val myScenario = scenario("My scenario")
    .exec(
      http("request_1")
        .get("/")
    )

  setUp(
    myScenario
      .inject(constantUsersPerSec(20) during 15.seconds)
      .protocols(httpProtocol)
  )
}

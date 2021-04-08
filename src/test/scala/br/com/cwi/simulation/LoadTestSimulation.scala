package br.com.cwi.simulation

import br.com.cwi.http.Http
import io.gatling.core.Predef._
import scala.concurrent.duration._

/**
 * Simulação a ser executada.
 */
class LoadTestSimulation extends BaseSimulation {

  val scenarios = Map (
    "ramp" -> List(
      Simulacao.EditarUmProduto.inject(rampUsers(userCount) during (rampDuration seconds))
    ),
    "constants" -> List(
      Simulacao.EditarUmProduto.inject(constantUsersPerSec(userCount) during (constantDuration seconds))
    )
  )
  setUp(scenarios(scn):_*).protocols(Http.httpProtocol).maxDuration(maxDuration hours)
}

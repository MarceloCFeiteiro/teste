package br.com.cwi.simulation

import br.com.cwi.cenario.Acesso
import br.com.cwi.utils.{Config, Utils}
import io.gatling.core.Predef.{exec, _}

/**
 * Representação das simulações, composição de cenários, a serem expostos para
 * execução do teste de carga.
 */
object Simulacao {

  /**
   * Agrupamento de cenários visando a execução
   * de diferentes simulações de execução dos cenários planejados.
   */
  val completa = scenario("Simulação completa")
    .feed(csv(Config.data.usuariosCsv).random.circular)
    .group("Cenário de acesso ao sistema") {
      exec(Acesso.cenarioLoginAcessoApiServRest)
    }
    .exec {
      Utils.printSessionAttributes()
    }
}

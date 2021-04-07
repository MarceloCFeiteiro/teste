package br.com.cwi.cenario

import br.com.cwi.api._
import io.gatling.core.Predef.{exec, _}

/**
 * Representação de fluxos e cenários de negócio relacionados à acesso ao sistema.
 */
/**
 * /Representa o pedido de um token e o cadastro de um produto.
 */
object Acesso {

  private[cenario] def AcessoAoSistema() = {
    exec(ApiServRest.login())
  }

  val cenarioLoginAcessoApiServRest = scenario("Cenário de acesso de login na api server rest")
    .group("Fluxo de acesso ao sistema") {
      exec(AcessoAoSistema())
    }

}

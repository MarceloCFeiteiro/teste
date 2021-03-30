package br.com.cwi.cenario

import br.com.cwi.api.{ApiProdutos, _}
import br.com.cwi.utils.Config
import io.gatling.core.Predef.{exec, _}

/**
 * Representação de fluxos e cenários de negócio relacionados à acesso ao sistema.
 */
object Acesso {

  /**
   * Fluxo de acesso, usuário acessa executando login, faz uma pausa conforme tempo configurado para simular uma
   * leitura e após executa o logout.
   *
   * @return
   */
  private[cenario] def fluxoAcesso() = {
    exec(
      AuthApi.login(),
      AuthApi.logout()
    )
  }


  private[cenario] def loginApiSeverRest() = {
    exec(ApiServRest.login(),
      ApiProdutos.CadastrarProduto())
  }


  /**
   * Agrupamento de fluxos visando gerar um cenário de acesso ao sistema.
   */
  val cenarioAcesso = scenario("Cenário de acesso")
    .group("Fluxo de acesso ao sistema") {
      exec(fluxoAcesso())
    }

  val cenarioLoginAcessoApiServRest = scenario("Cenário de acesso de login na api server rest")
    .group("Fluxo de acesso ao sistema") {
      exec(loginApiSeverRest())
    }
}

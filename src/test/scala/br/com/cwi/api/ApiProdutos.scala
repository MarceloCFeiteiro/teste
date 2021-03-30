package br.com.cwi.api

import br.com.cwi.http.HeaderServeRest
import br.com.cwi.utils.{Config, SessionKeys}
import io.gatling.core.Predef.{exec, _}
import io.gatling.http.Predef.http

object ApiProdutos {

  def CadastrarProduto() = {
    exec(
      http("Api Cadastro produto")
        .post(Config.uris.apiserveRest.concat("/produtos"))
        .headers(HeaderServeRest.authorization)
        .headers(HeaderServeRest.content_type_json)
        .headers(HeaderServeRest.accept)
        .headers(HeaderServeRest.host)
        .headers(HeaderServeRest.connection)
        .body(ElFileBody("bodies/login/produto.json"))
    )
      .pause(Config.pausa.processamento_resposta)
  }

}

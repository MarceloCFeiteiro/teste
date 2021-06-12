package br.com.cwi.api

import br.com.cwi.http.HeaderServeRest
import br.com.cwi.utils.{Config, SessionKeys}
import io.gatling.core.Predef.{exec, _}
import io.gatling.core.structure.ChainBuilder
import io.gatling.http.Predef._

// Classe responsávelp or armazenar os métodos da api de produtos.

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
        .check(jsonPath("$._id").saveAs("idProduto"))
        .check(status is 201)
    )
      .pause(Config.pausa.processamento_resposta)
  }

  def EditarPodutoPorId(): ChainBuilder = {
    exec(
      http("Api Editar Produto por Id.")
        .put(Config.uris.apiserveRest.concat("/produtos").concat("/${idProduto}"))
        .headers(HeaderServeRest.authorization)
        .headers(HeaderServeRest.accept)
        .headers(HeaderServeRest.host)
        .headers(HeaderServeRest.connection)
        .body(ElFileBody("bodies/login/produtoAlterado.json"))
        .check(status is 200)
    )
      .pause(Config.pausa.processamento_resposta)
  }

  def ListarProdutosCadastrados(): ChainBuilder = {
    exec(
      http("Api Listar Produtos Cadastrados")
        .get(Config.uris.apiserveRest.concat("/produtos"))
        .headers(HeaderServeRest.accept)
        .headers(HeaderServeRest.host)
        .headers(HeaderServeRest.connection)
        .check(status is 200)
    )
      .pause(Config.pausa.processamento_resposta)
  }

  def BuscarPodutoPorId(): ChainBuilder = {
    exec(
      http("Api Buscar Produto por Id.")
        .get(Config.uris.apiserveRest.concat("/produtos").concat("/${idProduto}"))
        .headers(HeaderServeRest.accept)
        .headers(HeaderServeRest.host)
        .headers(HeaderServeRest.connection)
        .check(status is 200)
    )
      .pause(Config.pausa.processamento_resposta)
  }



}

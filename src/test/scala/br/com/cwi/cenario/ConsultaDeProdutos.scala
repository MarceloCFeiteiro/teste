package br.com.cwi.cenario

import br.com.cwi.api._
import io.gatling.core.Predef.{exec, _}
import io.gatling.core.structure._

object ConsultaDeProdutos {

  private[cenario] def listarProdutosCadastrados(): ChainBuilder = {
    exec(ApiProdutos.ListarProdutosCadastrados())
  }

  private[cenario] def listarUmProduto(): ChainBuilder = {
    exec(ApiProdutos.ListarProdutosCadastrados())
  }

  val cenarioListarUmProdutoCadastrado = scenario("Cenário de listagem de um produto cadastrado")
    .group("Visualização de dados") {
      exec(listarProdutosCadastrados())
    }

  val cenarioListarProdutosCadastrados = scenario("Cenário de listagem dos produtos cadastrados")
    .group("Visualização de dados") {
      exec(listarProdutosCadastrados())
    }
}

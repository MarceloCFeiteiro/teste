package br.com.cwi.cenario

import br.com.cwi.api._
import io.gatling.core.Predef.{exec, _}
import io.gatling.core.structure._

object CadastroDeProduto {

  private[cenario] def cadastrarProduto(): ChainBuilder = {
    exec(ApiProdutos.CadastrarProduto())
  }

  val cenarioCadastrarProduto = scenario("Cadastro de um produto no sistema")
    .group("Cadastro de produto") {
      exec(cadastrarProduto())
    }
}

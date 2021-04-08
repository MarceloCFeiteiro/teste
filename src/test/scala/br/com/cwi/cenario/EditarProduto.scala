package br.com.cwi.cenario

import br.com.cwi.api._
import io.gatling.core.Predef.{exec, _}
import io.gatling.core.structure._

object EditarProduto {

  private[cenario] def EditarProduto(): ChainBuilder = {
    exec(ApiProdutos.EditarPodutoPorId())
  }

  val cenarioEditarProduto = scenario("Edição de um produto no sistema")
    .group("Editar produto") {
      exec(EditarProduto())
    }

}

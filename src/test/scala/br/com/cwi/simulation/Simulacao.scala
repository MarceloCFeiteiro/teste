package br.com.cwi.simulation

import br.com.cwi.cenario._
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
  val CadastroProduto = scenario("Cadastro de Produto")
    .feed(csv(Config.data.usuariosCsv).random.circular)
    .group("Cenário de cdastro de um produto") {
      exec(Acesso.cenarioLoginAcessoApiServRest)
        .exec(CadastroDeProduto.cenarioCadastrarProduto)

    }

  val completa = scenario("Simulação completa")
    .feed(csv(Config.data.usuariosCsv).random.circular)
    .group("Cenário de acesso ao sistema") {
      exec(Acesso.cenarioLoginAcessoApiServRest)
        .exec(ConsultaDeProdutos.cenarioListarProdutosCadastrados)
    }
    .exec {
      Utils.printSessionAttributes()
    }

  val ListarProdutos = scenario("Listar produtos cadastrados")
    .group("Cenário para a listagem de produtos cadastrados") {
      exec(ConsultaDeProdutos.cenarioListarProdutosCadastrados)
    }
    .exec {
      Utils.printSessionAttributes()
    }

  val ListarUmProduto = scenario("Listar um produto cadastrado")
    .feed(csv(Config.data.usuariosCsv).random.circular)
    .group("Cenário para a listagem um produto cadastrado") {
      exec(Acesso.cenarioLoginAcessoApiServRest)
        .exec(CadastroDeProduto.cenarioCadastrarProduto)
        .exec(ConsultaDeProdutos.cenarioListarUmProdutoCadastrado)
    }
    .exec {
      Utils.printSessionAttributes()
    }

  val EditarUmProduto = scenario("Editar um produto cadastrado")
    .feed(csv(Config.data.usuariosCsv).random.circular)
    .group("Cenário para a Edição um produto cadastrado") {
      exec(Acesso.cenarioLoginAcessoApiServRest)
        .exec(CadastroDeProduto.cenarioCadastrarProduto)
        .exec(EditarProduto.cenarioEditarProduto)
    }
    .exec {
      Utils.printSessionAttributes()
    }
}

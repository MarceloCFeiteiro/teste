package br.com.cwi.simulation

import br.com.cwi.model.Produto
import br.com.cwi.utils.{Config, ConversorJson, SessionKeys, Utils, ManipularArquivo}
import io.gatling.core.Predef._

/**
 * Classe base para simulação.
 * Executa principalmente a carga de configurações através de variáveis de ambiente ou o valor default.
 */
class BaseSimulation extends Simulation {

  def scn: String = Utils.getProperty("LT_SCENARIO", "ramp")

  def userCount: Int = Utils.getProperty("LT_USERS", "1").toInt

  def rampDuration: Int = Utils.getProperty("LT_RAMP_DURATION", "60").toInt

  def constantDuration: Int = Utils.getProperty("LT_CONSTANT_DURATION", "10").toInt

  def maxDuration: Int = Utils.getProperty("LT_MAX_DURATION", "2").toInt

  Config.data.usuariosCsv = Utils.getProperty("LT_USUARIOS_CSV", "data/usuarios.csv")
  Config.data.cartoesCsv = Utils.getProperty("LT_CARTOES_CREDITO_CSV", "data/cartoes-credito.csv")

  Config.uris.apiserveRest = Utils.getProperty("LT_URLAPISERVEREST", "https://serverest.dev")


  before {
    ManipularArquivo.salvaArquivo(ConversorJson.EntidadeParaJson(Produto.criaProduto()))
    println("================================================================================")
    println("Iniciando os testes de carga, utilizando as seguintes configurações:")
    println(s"Execução")
    println(s" - Cenário escolhido: ${scn}")
    println(s" - Executando testes com ${userCount} usuários")
    println(s" - Rampa de usuários em ${rampDuration} segundos")
    println(s" - Usuários constantes por ${rampDuration} segundos")
    println(s" - Duração máxima: ${maxDuration} hora(s)")
    println(s"URIs")
    println(s" - Client Id : ${Config.uris.apiserveRest}")
    println(s"Dados")
    println(s" - Usuários : ${Config.data.usuariosCsv}")
    println("================================================================================")
  }

  after {
    println("Simulação finalizada")
  }
}

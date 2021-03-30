package br.com.cwi.simulation

import br.com.cwi.utils.{Config, SessionKeys, Utils}
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

  Config.uris.clientId = Utils.getProperty("LT_CLIENT_ID", "")
  Config.uris.webAppBaseUri = Utils.getProperty("LT_WEB_APP_BASE_URI", "https://web-app.azurewebsites.net/")
  Config.uris.b2cLoginUri = Utils.getProperty("LT_B2C_LOGIN_URI", "https://b2c.b2clogin.com/tfp/b2c.onmicrosoft.com/B2C_1_ROPC/")
  Config.uris.apiBaseUri = Utils.getProperty("LT_API_BASE_URI", "http://54.87.160.50:8000/api")
  Config.uris.ocpApimSubscriptionKey = Utils.getProperty("LT_OCP_APIM_SUBSCRIPTION_KEY", "80b7c3")
  Config.data.usuariosCsv = Utils.getProperty("LT_USUARIOS_CSV", "data/usuarios.csv")
  Config.data.cartoesCsv = Utils.getProperty("LT_CARTOES_CREDITO_CSV", "data/cartoes-credito.csv")

  Config.uris.authurl = Utils.getProperty("LT_AUTHURL", "https://www.googleapis.com/identitytoolkit/v3/relyingparty/verifyPassword?key=AIzaSyD0bL8l4l6O7Gfb5bmdA5z7z0whywRsZD4")
  Config.uris.apiserveRest = Utils.getProperty("LT_URLAPISERVEREST", "https://serverest.dev")


  before {
    println("================================================================================")
    println("Iniciando os testes de carga, utilizando as seguintes configurações:")
    println(s"Execução")
    println(s" - Cenário escolhido: ${scn}")
    println(s" - Executando testes com ${userCount} usuários")
    println(s" - Rampa de usuários em ${rampDuration} segundos")
    println(s" - Usuários constantes por ${rampDuration} segundos")
    println(s" - Duração máxima: ${maxDuration} hora(s)")
    println(s"URIs")
    println(s" - Client Id : ${Config.uris.clientId}")
    println(s" - Web APP : ${Config.uris.webAppBaseUri}")
    println(s" - B2C Login : ${Config.uris.b2cLoginUri}")
    println(s" - API base URI : ${Config.uris.apiBaseUri}")
    println(s" - OCP API Subscription Key : ${Config.uris.ocpApimSubscriptionKey}")
    println(s"Dados")
    println(s" - Usuários : ${Config.data.usuariosCsv}")
    println(s" - Cartões Crédito : ${Config.data.cartoesCsv}")
    println(s"${SessionKeys.bearer_token}")
    println("================================================================================")
  }

  after {
    println(s"${SessionKeys.bearer_token}")
    println("Simulação finalizada")
  }
}

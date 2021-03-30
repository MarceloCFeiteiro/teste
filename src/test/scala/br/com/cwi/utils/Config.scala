package br.com.cwi.utils

import scala.concurrent.duration.DurationInt

object Config {

  object uris {
    val microsoftOnlineLogin = "https://login.microsoftonline.com/"

    var clientId = ""
    var webAppBaseUri = ""
    var b2cLoginUri = ""
    var apiBaseUri = ""
    var ocpApimSubscriptionKey = ""

    var authurl = ""
    var urlwtp = ""

    var apiserveRest = ""

  }

  object data {
    var usuariosCsv = ""
    var cartoesCsv = ""
  }

  /**
   * Define as configurações padrão dos tempos de pausa estimadas para aplicação,
   * considerando a simulação de navegação do usuário.
   */
  object pausa {
    /**
     * Define uma duração de pausa, simulação de tempo de processamento
     * de resposta da api, transição de página e apresentação para usuário.
     */
    var processamento_resposta = 350.milliseconds

    /**
     * Define uma duração de pausa, simulação de tempo do usuário fazer uma rolagem,
     * ou navegação através de um link, botão, menu ou outro já visivel na tela.
     */
    var usuario_acao_navegacao_visivel = 1.seconds

    /**
     * Define uma duração de pausa, simulação de tempo de leitura / permanencia
     * do usuário em determinada página.
     */
    var usuario_leitura = 5.seconds

    /**
     * Define uma duração de pausa, simulação de tempo de preenchimento de um formulário
     * curto pelo usuário.
     */
    var usuario_preenchimento_formulario_curto = 5.seconds

    /**
     * Define uma duração de pausa, simulação de tempo de preenchimento de um formulário
     * longo pelo usuário.
     */
    var usuario_preenchimento_formulario_longo = 10.seconds
  }
}

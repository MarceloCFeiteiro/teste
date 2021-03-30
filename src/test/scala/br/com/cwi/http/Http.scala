package br.com.cwi.http

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import br.com.cwi.utils._

/**
 * Configuração base para requisições http.
 */
object Http {

  val httpProtocol = http
    .baseUrls(Config.uris.webAppBaseUri)
    .inferHtmlResources()
    .acceptHeader("image/webp,*/*")
    .contentTypeHeader("application/json")
    .acceptEncodingHeader("gzip, deflate, br")
    .acceptLanguageHeader("pt-BR,en-US;q=0.8,pt;q=0.5,en;q=0.3")
    .doNotTrackHeader("1")
    .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:76.0) Gecko/20100101 Firefox/76.0")
    .check(status.in(200, 201, 202, 204))
    // habilita proxy, fiddler ou outro que estiver rodando.
    // Útil para debug.
//    .proxy(Proxy("localhost", 8888).httpsPort(8888))
}

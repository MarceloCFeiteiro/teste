package br.com.cwi.http

import br.com.cwi.utils.{Config, SessionKeys}

/**
 * Cabeçalhos http comuns à aplicação.
 */
object Header {

  val accept_application_json = Map(
    "Accept" -> "application/json, text/plain, */*"
  )

  val no_cache = Map(
    "Cache-Control" -> "no-cache",
    "Pragma" -> "no-cache"
  )

  val accept_encoding_gzip_deflate_br = Map(
    "Accept-Encoding" -> "gzip, deflate, br"
  )

  val content_type_application_json = Map(
    "Content-Type" -> "application/json"
  )

  val keep_alive = Map(
    "Connection" -> "keep-alive"
  )

  val ocp_apim = Map(
    "Ocp-Apim-Trace" -> "false",
    "Ocp-Apim-Subscription-Key" -> Config.uris.ocpApimSubscriptionKey
  )

  /**
   *
   */
  val authorization = Map(
    "Authorization" -> "Bearer ".concat("${" + SessionKeys.bearer_token + "}")
  )

  val origin = Map(
    "Origin" -> Config.uris.webAppBaseUri
  )

  val api_key = Map(
    "apikey" -> "AIzaSyD6-TnDPf6pca9XIbQ8vN2I0xnEH28SDns"
  )

  val accepted_language_en = Map(
    "accept-language" -> "en-Us"
  )

  val accepted_language_pt_br = Map(
    "accept-language" -> "pt-BR"
  )

  val x_android_package_cert = Map(
    "X-Android-Package" -> "br.com.bonemedicina.sanus.test",
    "X-Android-Cert" -> "D1B600729FB7A86BD6283994168819BF461887FF"
  )

  val x_client_version = Map(
    "X-Client-Version" -> "Android/Fallback/X20000001/FirebaseCore-Android"
  )

  def contentLength(length: Int): Map[String, String] = {
    Map("Content-Length" -> length.toString())
  }

  val user_agent = Map(
    "User-Agent" -> "Dalvik/2.1.0 (Linux; U; Android 10; Android SDK built for x86 Build/QSR1.190920.001)"
  )

  val host = Map(
    "Host" -> "www.googleapis.com"
  )
  val connetting = Map(
    "Connection" -> "Keep-Alive"
  )

  val accept_encoding = Map(
    "Accept-Encoding" -> "gzip")
}


package br.com.cwi.api

import br.com.cwi.http.Header
import br.com.cwi.utils.{Config, SessionKeys, Utils}
import io.gatling.core.Predef.{exec, _}
import io.gatling.http.Predef.{http, _}

/**
 * Representação de ações na api de autenticação / autorização.
 */
object AuthApi {

  /**
   * Executa o login de usuário.
   *
   * @note
   * O berare token é extraído da resposta e armazenado na sessão.
   *
   * @return
   */
  def login() = {
    exec()
      .pause(Config.pausa.usuario_preenchimento_formulario_curto)
      .exec(
        actionBuilder = http("auth api: login")
          .post(Config.uris.authurl)// //.post(Config.uris.authurl.concat("/auth/login/"))
          .body(ElFileBody("bodies/login/login.json"))
          .headers(Header.content_type_application_json)
          .headers(Header.x_android_package_cert)
          .headers(Header.accepted_language_en)
          .headers(Header.x_client_version)
          .headers(Header.user_agent)
          .headers(Header.contentLength(90))
          .headers(Header.user_agent)
          .headers(Header.host)
          .headers(Header.accept_encoding)
          .check(
            checkIf(
              (response: Response, session: Session) => response.status.code() == 200)
            (jsonPath("$.accessToken").find.saveAs(SessionKeys.bearer_token))
          )
      )
      .pause(Config.pausa.processamento_resposta)
  }

  /**
   * Executa o logout do usuário.
   *
   * @note
   * Utiliza o bearer token armazenado em sessão para a chamada e então remove a chave da sessão.
   */
  def logout() = {
    exec(
      http("auth api: logout")
        .post(Config.uris.apiBaseUri.concat("/auth/logout/"))
        .headers(Header.api_key)
        .headers(Header.authorization)
        .headers(Header.accepted_language_en)
        .headers(Header.accept_application_json)
        .headers(Header.content_type_application_json)
    )
    .exec(session => {
      session.set(SessionKeys.bearer_token, null)
    })
    .pause(Config.pausa.processamento_resposta)
  }
}

package br.com.cwi.api

import br.com.cwi.http.HeaderServeRest
import br.com.cwi.utils.{Config, SessionKeys, Utils}
import io.gatling.core.Predef.{exec, _}
import io.gatling.http.Predef.{http, _}

//Classe responsável por armazenar os métodos da api de autenticação

object ApiServRest {

  def login() = {
    exec()
      .pause(Config.pausa.usuario_preenchimento_formulario_curto)
      .exec(
        actionBuilder = http("Api serveRest")
          .post(Config.uris.apiserveRest.concat("/login")) // //.post(Config.uris.authurl.concat("/auth/login/"))
          .body(ElFileBody("bodies/login/loginApiServeRest.json"))
          .headers(HeaderServeRest.content_type_json)
          .headers(HeaderServeRest.accept)
          .headers(HeaderServeRest.host)
          .headers(HeaderServeRest.connection)
          .headers(HeaderServeRest.content_length)
          .check(
            checkIf(
              (response: Response, session: Session) => response.status.code() == 200)
            (jsonPath("$.authorization").find.saveAs(SessionKeys.bearer_token))
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
  //  def logout() = {
  //    exec(
  //      http("auth api: logout")
  //        .post(Config.uris.apiBaseUri.concat("/auth/logout/"))
  //        .headers(Header.api_key)
  //        .headers(Header.authorization)
  //        .headers(Header.accepted_language_en)
  //        .headers(Header.accept_application_json)
  //        .headers(Header.content_type_application_json)
  //    )
  //      .exec(session => {
  //        session.set(SessionKeys.bearer_token, null)
  //      })
  //      .pause(Config.pausa.processamento_resposta)
  //  }
}

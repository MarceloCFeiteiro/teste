package br.com.cwi.api

import br.com.cwi.http.{Header, HeaderServeRest}
import br.com.cwi.utils.{Config, SessionKeys, Utils}
import io.gatling.core.Predef.{exec, _}
import io.gatling.http.Predef.{http, _}

object ApiServRest{

  def login() = {
    exec()
      .pause(Config.pausa.usuario_preenchimento_formulario_curto)
      .exec(
        actionBuilder = http("Api serveRest")
          .post(Config.uris.apiserveRest.concat("/login"))// //.post(Config.uris.authurl.concat("/auth/login/"))
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
}

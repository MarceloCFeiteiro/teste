package br.com.cwi.utils

object SessionKeys {

  val csrf_token = "csrf_token"
  var bearer_token = "bearer_token"
  var usuario_id = "usuario_id"

  val cartao_credito_numero = "cartao_credito_numero"
  val cartao_credito_nome_titular = "cartao_credito_nome_titular"
  val cartao_credito_mes_data_validade = "cartao_credito_mes_data_validade"
  val cartao_credito_ano_data_validade = "cartao_credito_ano_data_validade"
  val cartao_credito_codigo_seguranca = "cartao_credito_codigo_seguranca"
}

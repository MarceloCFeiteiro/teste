package br.com.cwi.utils

import br.com.cwi.ADClient
import com.typesafe.scalalogging.StrictLogging
import io.gatling.core.Predef._
import io.gatling.core.structure.ChainBuilder

object Utils extends StrictLogging {
  private val IsDebugEnabled = logger.underlying.isDebugEnabled

  def printSessionAttributes(): ChainBuilder = {
    exec(session => {
      println(session.attributes)
      session
    })
  }

  def printKey(key: String): ChainBuilder = {
    exec(session => {
      if (IsDebugEnabled) {
        println("Imprimindo variáveis da sessão: " + session.attributes)//println("Imprimindo key [" + key + "]: " + getKey(session, key))
      }
      session
    })
  }

  def printSomething(value: String): ChainBuilder =  {
    exec(session => {
      if (IsDebugEnabled) {
        println(value)
      }
      session
    })
  }

  def getKey(session: Session, keyName: String): String = {
    keyExtractor(session.attributes.get(keyName))
  }

  def keyExtractor(keyOption: Option[Any]): String = {
    keyExtractor(keyOption, true)
  }

  def keyExtractor(keyOption: Option[Any], end: Boolean): String = {
    val key = keyOption.toString()
    if (key.contains("Some(")) {
      if (end)
        key.substring(5).replace(")", "")
      else key.substring(5).replace(")", ",")
    } else "NULL"
  }

  def getMap(value: String): Map[String, String] =  {
      Map(
        "Authorization" -> value
    )
  }

  def getProperty(propertyName: String, defaultValue: String) = {
    Option(System.getenv(propertyName))
      .orElse(Option(System.getProperty(propertyName)))
      .getOrElse(defaultValue)
  }

}

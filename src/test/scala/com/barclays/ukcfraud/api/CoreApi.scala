package com.barclays.ukcfraud.api

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import org.scalatest.Matchers
import org.scalatest.concurrent.{IntegrationPatience, ScalaFutures}
import play.api.libs.json.JsObject
import play.api.libs.ws._
import play.api.libs.ws.ahc.AhcWSClient


trait CoreApi
  extends ScalaFutures
    with Matchers
    with WithWsClient
    with IntegrationPatience
    with DefaultBodyWritables {

  val apiUrl = "https://jsonplaceholder.typicode.com/"

  def GET(path: String): WSResponse = {
    wsClient.url(path).get().futureValue
  }


  def POST(path: String, body: JsObject): WSResponse = {
    wsClient
      .url(path)
      .addHttpHeaders(("Content-Type","application/json"))
      .post(body).futureValue
  }
}

trait WithWsClient {
  val wsClient: AhcWSClient = {
    implicit val system = ActorSystem()
    implicit val materializer = ActorMaterializer()
    AhcWSClient()
  }
}
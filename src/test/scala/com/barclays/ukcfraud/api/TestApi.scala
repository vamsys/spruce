package com.barclays.ukcfraud.api

import play.api.libs.json.{JsValue, Json}
import play.api.libs.ws.WSResponse

import scala.util.Random

object TestApi extends CoreApi {

  val usersApi = "users/"
  val postsApi = "posts"
  val randomUser = Random.nextInt(10)
  val queryString = "?userId="+randomUser
  val userData: JsValue = null
  var email: Any = null

  case class PostBody(title: String = "testTitle", body: String = "vankai")


  def getUserData: JsValue = {
    val userData: JsValue = Json.parse(GET(s"${apiUrl + usersApi + randomUser}").body)
    email = userData("email")
    userData
  }

  def getpostsByAUser: JsValue = {
    val userPosts: JsValue = Json.parse(GET(s"${apiUrl + postsApi + queryString}").body)
    userPosts
  }

  def createPostForAUser: WSResponse = {
    val postBody = Json.obj("title" -> "testTitle", "body" -> "vankai")
    val response = POST(s"${apiUrl + postsApi + queryString}", postBody)
    response
  }
}

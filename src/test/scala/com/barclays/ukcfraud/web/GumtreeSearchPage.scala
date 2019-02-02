package com.barclays.ukcfraud.web

import org.openqa.selenium.WebDriver
import org.scalatest.selenium.Page

import scala.collection.mutable.ListBuffer

object GumtreeSearchPage extends WebPage with Page {

  override val url = "http://google.co.uk"

  //Page Elements

  def gumtreeAds(implicit webDriver: WebDriver): Iterator[Element] = {
    findAll(cssSelector(".listing-link[href*=\"p\"]"))
  }

  def findGumtreeLinks(implicit webDriver: WebDriver): Iterator[Element] = {
    findAll(cssSelector("a[href*=\"gumtree\"]"))
  }

  //Access Functions

  def searchFor(queryString: String) (implicit webDriver: WebDriver): Unit = {
    textField("q").value = queryString
    submit()
  }

  def searchResults(implicit webDriver: WebDriver): List[String] = {
    var returnUrls = new ListBuffer[String]
    findGumtreeLinks.foreach {
      element: Element =>
        returnUrls += element.attribute("href").get
    }
    println("Returned Gumtree links:"+returnUrls.length)
    returnUrls.toList
  }

}

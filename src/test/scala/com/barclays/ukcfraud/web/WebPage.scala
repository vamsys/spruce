package com.barclays.ukcfraud.web

import java.util.concurrent.TimeUnit

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.{ChromeDriver, ChromeOptions}
import org.openqa.selenium.remote.CapabilityType
import org.scalatest._
import org.scalatest.concurrent.{Eventually, PatienceConfiguration}
import org.scalatest.selenium.WebBrowser

import scala.util.Try

trait WebPage extends FeatureSpec
  with Browser
  with GivenWhenThen
  with Matchers
  with BeforeAndAfterAll
  with BeforeAndAfterEach
  with Assertions
  with Eventually
  with PatienceConfiguration {

  implicit lazy val webDriver: WebDriver = chromeDriver

  override def afterAll(): Unit = {
    Try(webDriver.quit())
  }

}

trait Browser extends WebBrowser {
  lazy val chromeDriver: ChromeDriver = {

    System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver")

    val options = new ChromeOptions()
    options.addArguments("start-maximized")
    options.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true)

    val driver = new ChromeDriver(options)
    driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS)
    driver
  }
}

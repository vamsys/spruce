package com.barclays.ukcfraud.web

import com.barclays.ukcfraud.common.RunWeb

class GumtreeSpec extends WebPage {

  val lookingForCars = "Cars in London"
  val gumtreeDomain = "https://www.gumtree.com"

  feature(s"Find cars for sale on Gumtree by Google search") {
    info(s"Google search for $lookingForCars")
    info("returns links to car sales on gumtree")
    info("each link has gumtree title and show adverts")

    scenario("Gumtree links returned in google search have title and adverts", RunWeb) {

      Given(s"Search for $lookingForCars on google returns gumtree links")
//      go to GumtreeSearchPage

//      searchFor(lookingForCars)

//      searchResults.foreach {
//        link =>
//
//          When("User navigates to the links")
//          if(link.startsWith(gumtreeDomain)){
//          goTo(link)
//
//          eventually {
//            Then("gumtree title is displayed")
//            pageTitle should include("Gumtree")
//
//            And("Each link has at least one car sale advert")
//            gumtreeAds.length should be > 0
//
//          }
//
//          }
//
//      }

    }

  }

}

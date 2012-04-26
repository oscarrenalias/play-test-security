package test

import org.specs2.mutable._

import play.api.test._
import play.api.test.Helpers._

class ApplicationTest extends Specification {
  
  "Application" should {
        // this compiles fine
        "show the login page" in {
            val result = controllers.Application.login()(FakeRequest())
            status(result) must equalTo(OK)
            contentType(result) must beSome("text/html")
            charset(result) must beSome("utf-8")
            contentAsString(result) must contain("form")        
        }
        // this doesn't
        "show the login page if user is not authenticated" {
            val result = controllers.Application.index()(FakeRequest())
            status(result) must equalTo(OK)
            contentType(result) must beSome("text/html")
            charset(result) must beSome("utf-8")
            contentAsString(result) must contain("form")        
        }

        "respond to the index Action using routeAndCall" in {
            val Some(result) = routeAndCall(FakeRequest(GET, "/"))
            status(result) must equalTo(OK)
            contentType(result) must beSome("text/html")
            charset(result) must beSome("utf-8")
            contentAsString(result) must contain("form")
        }
    }
}
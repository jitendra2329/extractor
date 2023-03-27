package com.knoldus

import org.scalatest.flatspec.AnyFlatSpec

class URLParserTest extends AnyFlatSpec {
  val urlParser = new URLParser

  it should "return an interpolated string with Protocol, Domain and Path of an URL" in {
    val url = "https://sqlrelease.com/scala-try-success-failure-functional-error-handling"
    val actualResult = urlParser.inputURL(url)
    val protocol = "https"
    val domain = "sqlrelease.com"
    val path = "scala-try-success-failure-functional-error-handling"
    val expectedResult = s"Protocol: $protocol\nDomain: $domain\nPath: $path"
    assert(actualResult == expectedResult)
  }

  it should "also return an interpolated string with Protocol, Domain and Path of an URL" in {
    val url = "https://knoldus.keka.com/#/me/attendance/logs"
    val actualResult = urlParser.inputURL(url)
    val protocol = "https"
    val domain = "knoldus.keka.com"
    val path = "#/me/attendance/logs"
    val expectedResult = s"Protocol: $protocol\nDomain: $domain\nPath: $path"
    assert(actualResult == expectedResult)
  }

  it should "return a error message -> (Enter a valid String), in case url is not valid" in {
    val url = ""
    val actualResult = urlParser.inputURL(url)
    val expectedResult = "Enter a valid URL!!"
    assert(actualResult == expectedResult)
  }

  it should "also return a error message -> (Enter a valid String), in case url is not valid" in {
    val url = "abc/xyz/egf"
    val actualResult = urlParser.inputURL(url)
    val expectedResult = "Enter a valid URL!!"
    assert(actualResult == expectedResult)
  }
}

package com.knoldus

object Driver extends App {
  private val url = "https://livebook.manning.com/concept/scala/unapply"
  private val urlParser = new URLParser
  println(urlParser.inputURL(url))
}

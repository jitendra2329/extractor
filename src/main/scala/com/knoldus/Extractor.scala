package com.knoldus

import scala.util.{Try, Success, Failure}

class Extractor(val url: String)

object Extractor {

  // Defining the unapply method for extracting the Protocol, Domain and Path from a given URL
  def unapply(extractor: Extractor): Option[(String, String, String)] = {
    val listOfStringsForHelp = extractor.url.split("/").filter(_ != "").toList
    val tupleOfStrings = extractor.url.splitAt(listOfStringsForHelp(0).length + listOfStringsForHelp(1).length + 3)
    val finalListOfStrings = tupleOfStrings._1.split("/").toList.filter(_ != "")
    Some(finalListOfStrings.head.take(finalListOfStrings.head.length - 1), finalListOfStrings(1), tupleOfStrings._2)
  }
}

class URLParser {

  //Validating if given URL is valid or not
  def validateURL(url: String): Boolean = {
    if (url.isEmpty) throw new IllegalArgumentException
    else if (!url.contains("https") || !url.contains("http")) throw new IllegalArgumentException
    else true
  }

  //taking URL as input from outside of the class
  def inputURL(url: String): String = {
    Try(validateURL(url)) match {
      case Success(value) =>
        val extractor = new Extractor(url)
        val result = extractor match {
          case Extractor(protocol, domain, path) => s"Protocol: $protocol\nDomain: $domain\nPath: $path"
          case _ => "not a valid url!"
        }
        result
      case Failure(_) => "Enter a valid URL!!"
    }
  }
}

//Driver class of the Extractor (For printing the result on the console)
object Driver extends App {
  private val url = "https://knoldus.keka.com/#/me/attendance/logs"
  private val urlParser = new URLParser
  println(urlParser.inputURL(url))
}



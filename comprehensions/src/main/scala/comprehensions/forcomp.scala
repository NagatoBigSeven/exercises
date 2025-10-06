package comprehensions

import collection.immutable.List
import scala.util.Random.shuffle
import scala.util.Random.nextInt
import java.util.Locale
import scala.util.Try

def onlyThreeLetterWords(words: List[String]): List[String] =
  ???

def louder(words: List[String]): List[String] =
  ???

def echo(words: List[String], n: Int): List[String] =
  ???

def allTogether(words: List[String], n: Int): List[String] =
  ???

def crossProduct[A, B](l1: List[A], l2: List[B]): List[(A, B)] =
  ???

def distinctPairs[A](items: Seq[A]): Seq[(A, A)] =
  ???

def parseInt(s: String): Option[Int] =
  Try(s.toInt).toOption

def validInts(strings: List[String]): List[Int] =
  ???

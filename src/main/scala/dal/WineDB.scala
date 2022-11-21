package dal

import classes.*
import java.nio.charset.UnmappableCharacterException;

import java.nio.charset.CodingErrorAction
import scala.io.Codec


class WineDB {

  //columns number in csv
  val NAME = 0;
  val COUNTRY = 1;
  val REGION = 2;
  val WINERY = 3;
  val RATING = 4;
  val NB_RATINGS = 5;
  val PRICE = 6;
  val YEAR = 7;

  //change the default behavior to replace the letter in case of encoding exception
  implicit val codec: Codec = Codec("UTF-8")
  codec.onMalformedInput(CodingErrorAction.REPLACE)
  codec.onUnmappableCharacter(CodingErrorAction.REPLACE)

  val getAvgRatingCountry = (country: String) => println("salut")
  val getWineByYear = (year: Int) => println("salut")
  val getTotalPriceWineryWines = (winery: String) => println("salut")

  val getWineByName = (wineName: String) => {
    val src = io.Source.fromFile("11-WhiteWine.csv")
    val iter = src.getLines().map(_.split(","))
    val wineIt = iter.filter(_(NAME).equals(wineName))
    val foundWine = wineIt.next()
    if (wineIt.next() != null) 
          new Wine(foundWine(NAME), foundWine(YEAR).toInt, foundWine(PRICE).toDouble, 
          new Country(foundWine(COUNTRY)), new Region(foundWine(REGION)), new Winery(foundWine(WINERY)),
          new Rating(foundWine(RATING).toDouble, foundWine(NB_RATINGS).toInt));
    else 
        null
  }

  val getNbWineByRegion = (region: String) => {
    val src = io.Source.fromFile("11-WhiteWine.csv")
    val iter = src.getLines().map(_.split(","))
    val wineIt = iter.filter(_(REGION).equals(region))
    wineIt.length
  }


  val readCSV = () => {
    val bufferedSource = io.Source.fromFile("11-WhiteWine.csv")

    for (line <- bufferedSource.getLines) {
      val cols = line.split(",").map(_.trim)
      // do whatever you want with the columns here
      println(s"${cols(0)}|${cols(1)}|${cols(2)}|${cols(3)}")
    }
    bufferedSource.close
  }
}



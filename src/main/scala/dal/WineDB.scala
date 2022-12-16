package dal

import classes.*
import java.nio.charset.UnmappableCharacterException;

import java.nio.charset.CodingErrorAction
import scala.io.Codec


class WineDB {

  //CSV file constant
  val FILE_PATH = "11-WhiteWine.csv"
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

  val getAvgRatingCountry = (country: String) => {
    val iter = getCSVIterator(FILE_PATH);
    val filteredIt = iter.filter(_ (COUNTRY).equals(country));
    if (filteredIt.hasNext)
      val iter2 = getCSVIterator(FILE_PATH);
      val filteredIt2 = iter2.filter(_ (COUNTRY).equals(country))
      filteredIt.foldLeft(0.0)(_ + _ (RATING).toDouble) / filteredIt2.length
    else
      null
  }

  val getWineByYear = (year: Int) => {
    val iter = getCSVIterator(FILE_PATH);
    val filteredIt = iter.filter(_ (YEAR).equals(year.toString));
    if (filteredIt.hasNext)
        filteredIt.map(w => new Wine(w(NAME), w(YEAR).toInt, w(PRICE).toDouble,
          new Country(w(COUNTRY)), new Region(w(REGION)), new Winery(w(WINERY)),
          new Rating(w(RATING).toDouble, w(NB_RATINGS).toInt)))
    else
      null
  }


  val getTotalPriceWineryWines = (winery: String) => {
    val iter = getCSVIterator(FILE_PATH);
    val filteredIt = iter.filter(_ (WINERY).equals(winery))
    filteredIt.foldLeft(0.0)(_ + _ (PRICE).toDouble)
  }

  val getWineByName = (wineName: String) => {
    val iter = getCSVIterator(FILE_PATH);
    val filteredIt = iter.filter(_ (NAME).equals(wineName))
    if (filteredIt.hasNext)
      val foundWine = filteredIt.next()
      new Wine(foundWine(NAME), foundWine(YEAR).toInt, foundWine(PRICE).toDouble,
        new Country(foundWine(COUNTRY)), new Region(foundWine(REGION)), new Winery(foundWine(WINERY)),
        new Rating(foundWine(RATING).toDouble, foundWine(NB_RATINGS).toInt));
    else
      null
  }

  val getNbWineByRegion = (region: String) => {
    val iter = getCSVIterator(FILE_PATH);
    val filteredIt = iter.filter(_ (REGION).equals(region))
    filteredIt.size
  }

  val getCSVIterator = (fileName: String) => {
    val src = io.Source.fromFile(fileName)
    src.getLines().map(_.split(","))
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



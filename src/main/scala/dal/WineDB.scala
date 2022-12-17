package dal

import classes.*
import manipulation.SafeConversion

import java.nio.charset.UnmappableCharacterException
import java.nio.charset.CodingErrorAction
import scala.io.Codec

/**
 * The wine data access class calibrated for CSV files.
 * Its functions are organized as follows:
 * 1. Generic functions
 * 2. List member functions
 * 3. Single member functions
 * 4. Aggregation functions
 * 5. Pure display functions
 */
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

  /*
  Generic functions
  */

  /**
   * Create a new wine using the csv line fields.
   * Number format exceptions are checked before creation.
   */
  val createWineFromCsvLine = (csvLine: Array[String]) => {
    // numerical data is converted with regards
    // to number format exceptions
    val converter = new SafeConversion();
    val year = converter.stringToInt(csvLine(YEAR))
    val nb_ratings = converter.stringToInt(csvLine(NB_RATINGS))
    val price = converter.stringToDouble(csvLine(PRICE))
    val avg_rating = converter.stringToDouble(csvLine(RATING))

    //create a new wine using the csv line fields
    Wine(csvLine(NAME), year, price, new Country(csvLine(COUNTRY)),
      new Region(csvLine(REGION)), new Winery(csvLine(WINERY)),
      new Rating(avg_rating, nb_ratings))
  }

  /**
   * returns an iterator of array of strings,
   * each line cell being a csv line
   */
  val getCSVIterator = (fileName: String) => {
    val src = io.Source.fromFile(fileName)
    src.getLines().map(_.split(","))
  }

  /**
   * convert a csv iterator (Array[String] to a wine objects list
   */
  val iteratorToWinesList = (csvIterator: Iterator[Array[String]]) => {
    if (csvIterator.hasNext)
      csvIterator.map(w => createWineFromCsvLine(w))
    else
      null
  }

 

  /*
  List members functions
  */

  /**
   * get all wines for a given year
   */
  val getWineByYear = (year: Int) => {
    val iter = getCSVIterator(FILE_PATH);
    val filteredIt = iter.filter(_ (YEAR).equals(year.toString))
    iteratorToWinesList(filteredIt)
  }

  /**
   * get all wines in the dataset
   */
  val getAllWines = () => {
    val iter = getCSVIterator(FILE_PATH)
    iteratorToWinesList(iter)
  }

  /*
  Single member functions
  */

  /**
   * search for a wine with the given name in the dataset
   */
  val getWineByName = (wineName: String) => {
    val iter = getCSVIterator(FILE_PATH);
    val filteredIt = iter.filter(_ (NAME).equals(wineName))
    if (filteredIt.hasNext)
      val foundWine = filteredIt.next()
      createWineFromCsvLine(foundWine)
    else
      null
  }

  /*
  Aggregation functions
  */

  /**
   * Get the total price of all wines price
   * for a winery.
   */
  val getTotalPriceWineryWines = (winery: String) => {
    val iter = getCSVIterator(FILE_PATH);
    val filteredIt = iter.filter(_ (WINERY).equals(winery))
    filteredIt.foldLeft(0.0)(_ + _ (PRICE).toDouble)
  }

  /**
   * Get the average of wines rating for a country.
   */
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

  /**
   * Gets the number of wines in a region.
   */
  val getNbWineByRegion = (region: String) => {
    val iter = getCSVIterator(FILE_PATH);
    val filteredIt = iter.filter(_ (REGION).equals(region))
    filteredIt.size
  }

  /*
  Pure display functions
  */

  /**
   * Display the dataset in the console without mapping
   * it to objects
   */
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



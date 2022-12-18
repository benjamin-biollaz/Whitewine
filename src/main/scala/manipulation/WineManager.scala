package manipulation

import classes.{Country, Rating, Region, Wine, Winery}
import display.DataManipulation

import scala.util.Random

/**
 * WineManager contains The business logic for wines
 */
class WineManager {

  /**
   * Rates a wine and return and object with the new ratings
   */
  val rateWine = (wine: Wine, newRate: Double) => {
    if (newRate < 1 || newRate > 5) {
      println("Rating must be set from 1 to 5")
      wine
    } else {
      val newRateAverage = calculateNewRatings(newRate, wine)
      wine.copy(rating = Rating(newRateAverage, wine.rating.nb_rating + 1))
    }
  }

  /**
   * Calculates the new rating average using
   * the number of ratings already attributed
   */
  val calculateNewRatings = (newRate: Double, wine: Wine) => {
    // total number of rating weight is respected
    (wine.rating.rating * wine.rating.nb_rating + newRate) / (wine.rating.nb_rating + 1)
  }

  /**
   * Returns a random discounted price
   * between 1% and 25%
   */
  val getARandomDiscountedPrice = (wine: Wine) => {
    val discount = new Random().between(1, 25)
    val discountedPrice = wine.price - (wine.price * discount / 100)
    wine.copy(price = discountedPrice)
  }


  /**
   * Creates a wine according to arguments.
   *
   * @return The freshly created wine
   */
  def addWine = (name: String, year: Int, price: Double, country: Country, region: Region, winery: Winery, rating: Rating) => {
    val dataManipulation = new DataManipulation();
    Wine(name, year, price, country, region, winery, rating)
  }

  /**
   * Modify a wine price using the case class .copy method
   */
  val modifyWinePrice = (wine: Wine, newPrice: Double) => {
    //use of case class copy property to avoid concurrency problem
    //in our case it is useless as no concurrent access is possible
    wine.copy(price = newPrice)
  }

  /**
   * Modify a wine name using the case class .copy method
   */
  val modifyWineName = (wine: Wine, newName: String) => {
    //use of case class copy property to avoid concurrency problem
    //in our case it is useless as no concurrent access is possible
    wine.copy(name = newName)
  }


}

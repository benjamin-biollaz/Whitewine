package manipulation

import classes.{Country, Rating, Region, Wine, Winery}
import display.DataManipulation

/**
 * WineManager contains The business logic for wines
 */
class WineManager {

  /**
   * Rate a wine using the method defined in the wine class
   */
  val rateWine = (wine:Wine, newRate: Double) => {
    val newRateAverage = wine.rateWine(newRate)
    wine.copy(rating = Rating(newRateAverage, wine.rating.nb_rating+1))
  }

  /**
   * Creates a wine according to arguments.
   * @return The freshly created wine
   */
  def addWine = (name:String, year:Int, price:Double, country: Country, region: Region, winery: Winery, rating:Rating) => {
    val dataManipulation = new DataManipulation();
    Wine(name, year, price, country, region, winery, rating)
  }

  //remove wine
  val removeWine = () => {

  }

  /**
   * Modify a wine price using the case class .copy method
   */
  val modifyWinePrice = (wine:Wine, newPrice: Double) => {
    //use of case class copy property to avoid concurrency problem
    //in our case it is useless as no concurrent access is possible
    wine.copy(price = newPrice)
  }

  /**
   * Modify a wine name using the case class .copy method
   */
  val modifyWineName = (wine:Wine, newName: String) => {
    //use of case class copy property to avoid concurrency problem
    //in our case it is useless as no concurrent access is possible
    wine.copy(name = newName)
  }


}

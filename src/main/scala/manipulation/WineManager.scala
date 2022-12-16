package manipulation

import classes.{Country, Rating, Region, Wine, Winery}
import display.DataManipulation

class WineManager {
  
  //add wine
  def addWine = (name:String, year:Int, price:Double, country: Country, region: Region, winery: Winery, rating:Rating) => {
    val dataManipulation = new DataManipulation();
    new Wine(name, year, price, country, region, winery, rating)
  }

  //remove wine
  val removeWine = () => {

  }
  
  //modify price of the wine
  
  //remove wine
  val modifyWinePrice = (wine:Wine) => {

  }
  
  //modify wine name
  val modifyWineName = (wine:Wine) => {

  }
  
  //rate a wine
  val rateWine = (wine:Wine) => {

  }
}

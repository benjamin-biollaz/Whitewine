package manipulation

import classes.{Country, Rating, Region, Winery, Wine}

class WineManager {
  //add wine
  val addWine = (name:String, year:Int, price:Double, country: Country, region: Region, winery: Winery, rating:Rating) => {
   
  }

/*  val getWineByName = (wineName: String) => {
    val iter = getCSVIterator(FILE_PATH);
    val filteredIt = iter.filter(_ (NAME).equals(wineName))
    if (filteredIt.hasNext)
      val foundWine = filteredIt.next()
      new Wine(foundWine(NAME), foundWine(YEAR).toInt, foundWine(PRICE).toDouble,
        new Country(foundWine(COUNTRY)), new Region(foundWine(REGION)), new Winery(foundWine(WINERY)),
        new Rating(foundWine(RATING).toDouble, foundWine(NB_RATINGS).toInt));
    else
      null
  }*/

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

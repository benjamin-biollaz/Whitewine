package display

import classes.{Country, Rating, Region, Winery}
import dal.WineDB
import manipulation.WineManager

import java.util.Scanner


class DataManipulation {
  val wineDB = new WineDB();
  val wineManager = new WineManager();

    def getManipulateChoice = () => {
      val inputChoice = getInput("What do you want to do ? \n" +
        "1. Add a wine? \n" +
        "2. Remove a wine? \n" +
        "3. Change a wine's name? \n" +
        "4. Modify a wine's price? \n" +
        "5. Rate a wine?")
      inputChoice match {
        case "1" => getInputAddWine();
        case "2" => getInputRemoveWine();
        case "3" => getInputChangeWineName();
        case "4" => getInputChangeWinePrice();
        case "5" => getInputRateWine();
      }
    }

  def getInput = (message: String) => {
    println(message)
    val scan = new Scanner(System.in);
    scan.nextLine();
  }

  def getInputRemoveWine = () => {
    val inputRemoveWine = getInput("Which wine do you want to remove?")
    val wine = wineDB.getWineByName(inputRemoveWine)
    // do something....
  }


  def getInputChangeWineName = () => {
    val inputChangeWineName = getInput("For which wine do you want to change its name?")
    val wine = wineDB.getWineByName(inputChangeWineName)
    println(wine)
    val newName = getInput("How should we call it?")
    val newWine = wineManager.modifyWineName(wine, newName)
      println(newWine)
  }

  def getInputChangeWinePrice = () => {
    val inputChangeWinePrice = getInput("For which wine do you want to change the price?")
    val wine = wineDB.getWineByName(inputChangeWinePrice)
    println(wine)
    val newPrice = getInput("How much would you put for this wine ?")
    val newWine = wineManager.modifyWinePrice(wine, newPrice.toDouble)
    println(newWine)
  }

  def getInputRateWine = () => {
    val inputRateWine = getInput("Which wine do you want to rate ")
    val wine = wineDB.getWineByName(inputRateWine)
    println(wine)
    val newRate = getInput("On a scale of 1 to 5, how would you rate this wine ?")
    val newWine = wineManager.rateWine(wine, newRate.toDouble)
    println(newWine)
  }

  def getInputAddWine = () => {
    val name = getInput("Which wine do you want to add?");
    val year = getInput("What is the year of the wine?");
    val price = getInput("What is the price of the wine?");
    val country = getInput("What is the country of the wine?");
    val region = getInput("What is the region of the wine");
    val winery = getInput("What is the wine's winery?");
    val rating = getInput("What is the wine's rate?");
    val newWine = wineManager.addWine(name, year.toInt, price.toDouble, new Country(country),
      new Region(region),  new Winery(winery), new Rating(rating.toDouble, 1))
    println("successfully added : " + newWine);
  }
  
}

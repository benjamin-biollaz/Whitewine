package display

import classes.{Country, Rating, Region, Winery}
import dal.WineDB
import manipulation.{InputManager, SafeConversion, WineManager}

import java.util.Scanner


class DataManipulation {
  val wineDB = new WineDB();
  val wineManager = new WineManager();
  val inputManager = new InputManager()

    def getManipulateChoice = () => {
      val inputChoice = inputManager.getInput("What do you want to do ? \n" +
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

  def getInputRemoveWine = () => {
    val inputRemoveWine = inputManager.getInput("Which wine do you want to remove?")
    val wine = wineDB.getWineByName(inputRemoveWine)
    // do something....
  }


  def getInputChangeWineName = () => {
    val inputChangeWineName = inputManager.getInput("For which wine do you want to change its name?")
    val wine = wineDB.getWineByName(inputChangeWineName)
    println(wine)
    val newName = inputManager.getInput("How should we call it?")
    val newWine = wineManager.modifyWineName(wine, newName)
      println(newWine)
  }

  def getInputChangeWinePrice = () => {
    val inputChangeWinePrice = inputManager.getInput("For which wine do you want to change the price?")
    val wine = wineDB.getWineByName(inputChangeWinePrice)
    println(wine)
    val newPrice = inputManager.getInput("How much would you put for this wine ?")
    val newWine = wineManager.modifyWinePrice(wine, newPrice.toDouble)
    println(newWine)
  }

  def getInputRateWine = () => {
    val inputRateWine = inputManager.getInput("Which wine do you want to rate ")
    val wine = wineDB.getWineByName(inputRateWine)
    println(wine)
    val newRate = inputManager.getInput("On a scale of 1 to 5, how would you rate this wine ?")
    val newWine = wineManager.rateWine(wine, newRate.toDouble)
    println(newWine)
  }

  def getInputAddWine = () => {
    val converter = new SafeConversion()
    val name = inputManager.getInput("Which wine do you want to add?");
    val year = converter.stringToInt(inputManager.getInput("What is the year of the wine?"))
    val price = converter.stringToDouble(inputManager.getInput("What is the price of the wine?"))
    val country = inputManager.getInput("What is the country of the wine?");
    val region = inputManager.getInput("What is the region of the wine");
    val winery = inputManager.getInput("What is the wine's winery?");
    val rating = converter.stringToDouble(inputManager.getInput("What is the wine's rate?"))
    val newWine = wineManager.addWine(name, year, price, new Country(country),
      new Region(region),  new Winery(winery), new Rating(rating, 1))
    println("successfully added : " + newWine);
  }

}

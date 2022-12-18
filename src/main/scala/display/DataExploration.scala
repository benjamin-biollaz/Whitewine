package display

import dal.WineDB
import manipulation.{InputManager, SafeConversion}

import java.util.Scanner

/**
 * A class with methods that prompts the user for inputs
 * and display the corresponding results.
 */

class DataExploration {
  val wineDB = new WineDB();
  val inputManager = new InputManager();
  val converter = new SafeConversion()

  /**
   * Prompt the the user for which data exploration he wants to perform.
   */
  def getInformationFromCSV = () => {
    val inputChoice = inputManager.getInput("What do you want to do ? \n" +
      "1. Get a wine details by name? \n" +
      "2. Get number of wine for a region? \n" +
      "3. Get total prices of all wine of a winery? \n" +
      "4. Get average wine rating of a country? \n" +
      "5. Get all wines for a year ?\n" +
      "6. Get all wines in the dataset ?");

    /**
     * Match case to display the user's choice
     */
    inputChoice match {
      case "1" => getInputWineByName();
      case "2" => getInputRegion();
      case "3" => getInputWinery();
      case "4" => getInputCountry();
      case "5" => getAllWinesByYear();
      case "6" => getAllWines();
    }
  }

  /**
   * Get the user's year input and call the method getWineByYear from the WineDB class
   * Displays all the wines created in a year.
   */
  def getAllWinesByYear = () => {
    val input = converter.stringToInt(inputManager.getInput("For which year do you want to display wines ?"))
    val wines = wineDB.getWineByYear(input.toInt);
    if (wines == null) println("No wines for " + input) else for (wine <- wines) println(wine)
  }

  /**
   * Display all wines in the db
   */
  def getAllWines = () => {
    val wines = wineDB.getAllWines()
    if (wines == null) println("No wines in the dataset") else for (wine <- wines) println(wine)
  }

  /**
   * Get a wine name input and display the wine
   */
  def getInputWineByName = () => {
    val inputName = inputManager.getInput("Enter the name of the wine ?");
    val wine = wineDB.getWineByName(inputName);
    if (wine == null) println("Wine not found") else println(wine);
  }

  /**
   * Get the user's region input and display the number of wines for it
   */
  def getInputRegion = () => {
    val inputRegion = inputManager.getInput("For which region do you want the total price of wines?");
    println("There's " + wineDB.getNbWineByRegion(inputRegion) + " wines in " + inputRegion);
  }

  /**
   * Get the user's winery input and display the total price of all wines in it
   */
  def getInputWinery = () => {
    val inputWinery = inputManager.getInput("For which winery do you want the total price of wines?");
    println("The total price of all the wines from" + inputWinery + " is :" + wineDB.getTotalPriceWineryWines(inputWinery) + "CHF")
  }

  /**
   * Get the user's country input and display the average rating for the wines from it.
   */
  def getInputCountry = () => {
    val inputCountry = inputManager.getInput("For which country you want the average rating?")
    val averageRating = wineDB.getAvgRatingCountry(inputCountry)
    if (averageRating == null) println("No wines in this country.") else println("The average wine rating for" + inputCountry + " is " + averageRating)
  }

}

package display

import dal.WineDB

import java.util.Scanner

class DataExploration {
  val wineDB = new WineDB();

  def getInformationFromCSV = () => {
    val inputChoice = getInput("What do you want to do ? \n" +
      "1. Get a wine details by name? \n" +
      "2. Get number of wine for a region? \n" +
      "3. Get total prices of all wine of a winery? \n" +
      "4. Get average wine rating of a country? \n" +
      "5. Get all wines for a year ?\n" +
      "6. Get all wines in the dataset ?");

    inputChoice match {
      case "1" => getInputWineByName();
      case "2" => getInputRegion();
      case "3" => getInputWinery();
      case "4" => getInputCountry();
      case "5" => getAllWinesByYear();
      case "6" => getAllWines();
    }
  }

  def getInput = (message: String) => {
    println(message)
    val scan = new Scanner(System.in);
    scan.nextLine();
  }

  def getAllWinesByYear = () => {
    val input = getInput("For which year do you want to display wines ?");
    val wines = wineDB.getWineByYear(input.toInt);
    if (wines == null) println("No wines for " + input) else for (wine <- wines) println(wine)
  }

  def getAllWines = () => {
    val wines = wineDB.getAllWines()
    if (wines == null) println("No wines in the dataset") else for (wine <- wines) println(wine)
  }

  def getInputWineByName = () => {
    val inputName = getInput("Enter the name of the wine ?");
    val wine = wineDB.getWineByName(inputName);
    if (wine == null) println("Wine not found") else println(wine);
  }

  def getInputRegion = () => {
    val inputRegion = getInput("For which region do you want the total price of wines?");
    println("There's " + wineDB.getNbWineByRegion(inputRegion) + " wines in " + inputRegion);
  }

  def getInputWinery = () => {
    val inputWinery = getInput("For which winery do you want the total price of wines?");
    println("The total price of all the wines from" + inputWinery + " is :" + wineDB.getTotalPriceWineryWines(inputWinery) + "CHF")
  }

  def getInputCountry = () => {
    val inputCountry = getInput("For which country you want the average rating?")
    println("The average wine rating for  " + inputCountry + " is " + wineDB.getAvgRatingCountry(inputCountry))
  }

}

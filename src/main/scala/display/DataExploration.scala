package display

import dal.WineDB

import java.util.Scanner

class DataExploration {
  val wineDB = new WineDB();

  def getInformationFromCSV = () => {
    println("What do you want to do ? \n" +
      "1. Get a wine details by name? \n" +
      "2. Get number of wine for a region? \n" +
      "3. Get total prices of all wine of a winery? \n" +
      "4. Get average wine rating of a country?")

    val scanChoice = new Scanner(System.in);
    val inputChoice = scanChoice.nextLine();
    inputChoice match {
      case "1" => getInputWineByName();
      case "2" => getInputRegion();
      case "3" => getInputWinery();
      case "4" => getInputCountry();
    }
  }

  def getInputWineByName = () => {
    println("Which wine do you want to search?");
    val scan = new Scanner(System.in);
    val inputName = scan.nextLine();
    val wine = wineDB.getWineByName(inputName);
    if (wine == null) println("Wine not found") else println(wine);
  }

  def getInputRegion = () => {
    println("Which region do you want to search")
    val scan = new Scanner(System.in);
    val inputRegion = scan.nextLine();
    println("There's " + wineDB.getNbWineByRegion(inputRegion) + " wines in " + inputRegion);
  }

  def getInputWinery = () => {
    println("For which winery do you want the total price of wines?")
    val scan = new Scanner(System.in);
    val inputWinery = scan.nextLine();
    println("The total price of all the wines from" + inputWinery + " is :" + wineDB.getTotalPriceWineryWines(inputWinery) + "CHF")
  }

  def getInputCountry = () => {
    println("For which country you want the average rating?")
    val scan = new Scanner(System.in);
    val inputCountry = scan.nextLine();
    println("The average wine rating for  " + inputCountry + " is " + wineDB.getAvgRatingCountry(inputCountry))
  }
  
}

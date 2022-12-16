package display

import dal.WineDB

import java.util.Scanner

class DataManipulation {
  val wineDB = new WineDB();

    def getManipulateChoice = () => {
      println("What do you want to do ? \n" +
        "1. Add a wine? \n" +
        "2. Remove a wine? \n" +
        "3. Change a wine's name? \n" +
        "4. Modify a wine's price? \n" +
        "5. Rate a wine?")


      val scanChoice = new Scanner(System.in);
      val inputChoice = scanChoice.nextLine();
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

  def getInputAddWine = () => {
    val inputAddWine = getInput("Which wine do you want to add?");
    // do something....
  }

  def getInputRemoveWine = () => {
    val inputRemoveWine = getInput("Which wine do you want to remove?");
    val wine = wineDB.getWineByName(inputRemoveWine);
    // do something....
  }


  def getInputChangeWineName = () => {
    val inputChangeWineName = getInput("For which wine do you want to change its name?");
    val wine = wineDB.getWineByName(inputChangeWineName);
    // do something....
  }

  def getInputChangeWinePrice = () => {
    val inputChangeWinePrice = getInput("For which wine do you want to change the price?");
    val wine = wineDB.getWineByName(inputChangeWinePrice);
    // do something....
  }

  def getInputRateWine = () => {
    val inputRateWine = getInput("Which wine do you want to rate ");
    val wine = wineDB.getWineByName(inputRateWine);
    // do something....
  }


}

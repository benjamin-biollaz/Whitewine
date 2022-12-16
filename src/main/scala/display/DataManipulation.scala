package display

import dal.WineDB
import classes.Rating

import java.util.Scanner

class DataManipulation {
  val wineDB = new WineDB()

    def getManipulateChoice = () => {
      println("What do you want to do ? \n" +
        "1. Add a wine? \n" +
        "2. Remove a wine? \n" +
        "3. Change a wine's name? \n" +
        "4. Modify a wine's price? \n" +
        "5. Rate a wine?")


      val scanChoice = new Scanner(System.in)
      val inputChoice = scanChoice.nextLine()
      inputChoice match {
        case "1" => getInputAddWine()
        case "2" => getInputRemoveWine()
        case "3" => getInputChangeWineName()
        case "4" => getInputChangeWinePrice()
        case "5" => getInputRateWine()
      }
    }

  def getInput = (message: String) => {
    println(message)
    val scan = new Scanner(System.in)
    scan.nextLine()
  }

  def getInputAddWine = () => {
    val inputAddWine = getInput("Which wine do you want to add?")
    // do something....
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
    //use of case class copy property to avoid concurrency problem
    //in our case it is useless as no concurrent access is possible
    val newWine = wine.copy(name = newName)
    println(newWine)
  }

  def getInputChangeWinePrice = () => {
    val inputChangeWinePrice = getInput("For which wine do you want to change the price?")
    val wine = wineDB.getWineByName(inputChangeWinePrice)
    val newPrice = getInput("How should we call it?")
    //use of case class copy property to avoid concurrency problem
    //in our case it is useless as no concurrent access is possible
    val newWine = wine.copy(name = newPrice)
    println(newWine)
  }

  def getInputRateWine = () => {
    val inputRateWine = getInput("Which wine do you want to rate ")
    val wine = wineDB.getWineByName(inputRateWine)
    println(wine)
    val newRate = getInput("On a scale of 1 to 5, how would you rate this wine ?")
    val newRateAverage = wine.rateWine(newRate.toDouble)
    val newWine = wine.copy(rating = Rating(newRateAverage, wine.rating.nb_rating+1))
    println(newWine)
  }


}

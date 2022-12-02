package demo

import dal.WineDB
import classes.Wine

import java.util.Scanner;

@main def hello() = {

    val wineDB=new WineDB();

    println("What do you want to do ? \n" +
      "1. Get a wine details by name? \n" +
      "2. Get number of wine for a region? \n" +
      "3. Get total prices of all wine of a winery? \n" +
      "4. Get average wine rating of a country?")

    val scanChoice = new Scanner(System.in);
    val inputChoice = scanChoice.next();

  inputChoice match {
      case "1" => getInputWineByName();
      case "2" => getInputRegion();
      case "3" => getInputWinery();
      case "4" => getInputCountry();

  }

   def getInputWineByName = () =>{
       println("Which wine do you want to search?");
   val scan = new Scanner(System.in);
       val inputName = scan.next();
      println(wineDB.getWineByName(inputName));
   }

    def getInputRegion = () =>{
        println("Which region do you want to search")
        val scan = new Scanner(System.in);
        val inputRegion = scan.next();
        println("There's " + wineDB.getNbWineByRegion(inputRegion) + " wines in " + inputRegion);
    }

    def getInputWinery = () =>{
        println("For which winery do you want the total price of wines?")
        val scan = new Scanner(System.in);
        val inputWinery = scan.next();
        println("The total price of all the wines from" + inputWinery + " is :" + wineDB.getTotalPriceWineryWines(inputWinery) + "CHF")
    }

    def getInputCountry = () =>{
        println("For which country you want the average rating?")
        val scan = new Scanner(System.in);
        val inputCountry = scan.next();
        println("The average wine rating for  " + inputCountry + " is " + wineDB.getAvgRatingCountry(inputCountry))
    }


   /* println(wineDB.getWineByName("Vermentino 2017"));
    println("Nb wines: " + wineDB.getNbWineByRegion("Toscana"));
    println("Price for winery wines: " + wineDB.getTotalPriceWineryWines("19 Crimes"));
    println("Average rating: " + wineDB.getAvgRatingCountry("China"));*/


   // wineDB.readCSV();
}

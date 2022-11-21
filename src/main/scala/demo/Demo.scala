package demo

import dal.WineDB;
import classes.Wine;

@main def hello() = {
    val wineDB=new WineDB(); 
    println(wineDB.getWineByName("Vermentino 2017"));
    println("Nb wines: " + wineDB.getNbWineByRegion("Toscana"));
    println("Price for winery wines: " + wineDB.getTotalPriceWineryWines("19 Crimes"));
    println("Average rating: " + wineDB.getAvgRatingCountry("China"));
   // wineDB.readCSV();
}

package demo

import dal.WineDB;
import classes.Wine;

@main def hello() = {
    val whineDB=new WineDB(); 
    val wine = whineDB.getWineByName("Memòries de Biniagual Blanc 2018");
    println(wine);

    println(whineDB.getNbWineByRegion("Toscana"));
   // whineDB.readCSV();
}

package demo

import dal.WineDB;
import classes.Wine;

@main def hello() = {
    val whineDB=new WineDB(); 
    val wine = whineDB.getWineByName("Vermentino 2017");
    println(wine);
}

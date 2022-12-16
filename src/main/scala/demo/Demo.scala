package demo

import dal.WineDB
import classes.Wine
import display.DataExploration
import display.DataManipulation

import java.util.Scanner

@main def hello() = {

  println("What do you want to do ? \n" +
    "1. Explore data from CSV ? \n" +
    "2. Manipulate data from CSV ? \n");

  val dataExploration = DataExploration();
  val dataManipulation = DataManipulation();
  val scanChoice = new Scanner(System.in);
  val inputChoice = scanChoice.nextLine();
  inputChoice match {
    case "1" => dataExploration.getInformationFromCSV();
    case "2" => dataManipulation.getManipulateChoice();
  }
}

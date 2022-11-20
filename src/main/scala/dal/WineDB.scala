package dal

class WineDB {

  val getAvgRatingCountry = (country: String) => println("salut")
  val getWineByYear = (year: Int) => println("salut")
  val getTotalPriceWineryWines = (winery: String) => println("salut")
  val getWineByName = (wine: String) => println("salut")
  val getNbWineByRegion = (wine: String) => println("salut")


  val readCSV = () => {
    val bufferedSource = io.Source.fromFile("11-WhiteWine.csv")

/*    for (line <- bufferedSource.getLines) {
      val cols = line.split(",").map(_.trim)
      // do whatever you want with the columns here
      println(s"${cols(0)}|${cols(1)}|${cols(2)}|${cols(3)}")
    }*/
  /*  bufferedSource.close*/
  }
}



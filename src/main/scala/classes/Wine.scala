package classes

/**
 * Wine class contains all properties of a wine.
 * It is composed of both native types (int, ...) and custom objects (Country, ...)
 *
 * @param name The name of the wine
 * @param year The year of the wine.
 * @param price The price of the wine.
 * @param country Country class has a name and extends from area.
 * @param region Region class has a name and extends from area.
 * @param winery Winery class has a name and extends from area.
 * @param rating Rating class contains both the number of ratings and the average of ratings.
 */
case class Wine(name: String, year: Int, price: Double, country: Country, region: Region, winery: Winery, rating: Rating) {
  override def toString: String = "Name:" + name + " Year:" + year + " Price:" + price + " " + country + " " + region + " " + winery + " " + rating
}

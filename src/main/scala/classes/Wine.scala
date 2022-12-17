package classes

case class Wine(name: String, year: Int, price: Double, country: Country, region: Region, winery: Winery, rating: Rating) {
  override def toString: String = "Name:" + name + " Year:" + year + " Price:" + price + " " + country + " " + region + " " + winery + " " + rating

  // rateWine calculates the new rating average using 
  // the number of ratings already attributed
  val rateWine = (newRate: Double) => {
    (this.rating.rating * this.rating.nb_rating + newRate) / (this.rating.nb_rating + 1)
  }

}

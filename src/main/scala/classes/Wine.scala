package classes

case class Wine(name: String = "Porto", year: Int = 2000, price: Double = 29.90, country: Country, region: Region, winery: Winery, rating: Rating) {
  override def toString: String = "Name:" + name + " Year:" + year + " Price:" + price + " " + country + " " + region + " " + winery + " " + rating

  //rate a wine calculates the rating average according to
  //the numbers of ratings
  val rateWine = (newRate: Double) => {
    (this.rating.rating * this.rating.nb_rating + newRate) / (this.rating.nb_rating + 1)
  }

}

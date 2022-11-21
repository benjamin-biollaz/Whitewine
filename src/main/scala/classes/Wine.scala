package classes

class Wine (val name:String = "Porto", val year:Int = 2000, val price:Double = 29.90, val country: Country, val region: Region, val winery: Winery, val rating:Rating){
    override def toString="Name:" + name + " Year:" + year + " Price:" + price + " " + country + " " + region + " " + winery+ " " + rating
}

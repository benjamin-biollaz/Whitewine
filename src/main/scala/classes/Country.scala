package classes

/**
 * A simple class with only one property for now: 
 * could be easily extended later to hold other information.
 * @param name The name of the country: super class property (Area)
 */
class Country (val name:String)
  extends Area:
    override def toString="Region:" + name 



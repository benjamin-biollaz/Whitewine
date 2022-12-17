package classes

/**
 * A simple class with only one property for now: 
 * could be easily extended later to hold other information.
 * @param nameThe name of the region: super class property (Area)
 */
class Region (val name:String) 
extends Area:
    override def toString="Region:" + name 




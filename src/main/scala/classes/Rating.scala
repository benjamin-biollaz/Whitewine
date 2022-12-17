package classes

/**
 * This class holds both the number of ratings and the average of rating.
 * @param rating The average rating
 * @param nb_rating The number of ratings
 */
class Rating (val rating:Double, val nb_rating:Int):
    override def toString="Rating:" + rating + " NB_Ratings:" + nb_rating 



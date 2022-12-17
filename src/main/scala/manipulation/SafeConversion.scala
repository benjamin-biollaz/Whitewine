package manipulation

class SafeConversion {
  /**
   * convert string to int with regards to number format exception
   */
  val stringToInt = (s: String) => {
    try {
      s.toInt
    } catch {
      case nb: NumberFormatException =>
        println(s + " cannot be converted to a number, 0 was attributed to it instead.")
        0
    }
  }

  /**
   * convert string to double with regards to number format exception
   */
  val stringToDouble = (s: String) => {
    try {
      s.toDouble
    } catch {
      case nb: NumberFormatException =>
        println(s + " cannot be converted to a number, 0 was attributed to it instead.")
        0
    }
  }
}

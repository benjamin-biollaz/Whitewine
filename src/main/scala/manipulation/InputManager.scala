package manipulation

import java.util.Scanner

class InputManager {
  def getInput = (message: String) => {
    println(message)
    val scan = new Scanner(System.in);
    scan.nextLine();
  }
}

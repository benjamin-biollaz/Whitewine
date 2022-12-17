package manipulation

import java.util.Scanner

/**
 * Generic and reusable console input manager.
 */
class InputManager {
  /**
   * Prompt the user for a message and waits until completion.
   * @return The entered input
   */
  def getInput = (message: String) => {
    println(message)
    val scan = new Scanner(System.in);
    scan.nextLine();
  }
}

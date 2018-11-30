import java.util.Scanner;

public class TextGames {
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Hello, Welcome to Text Games!");
    int gameID = 0;
    while (true) {  //This loop allows the player to select a game from the main menu
      System.out.println("");
      System.out.println("Please select a game by its number to play from the menu below:");
      System.out.println("1. Rocks, Paper, Scissors");
      System.out.println("2. Two-Player Tic-Tac-Toe");
      System.out.println("3. Math Quiz");
      System.out.println("4. Love Calculator");
      System.out.println("5. Word Quiz");
      System.out.println("6. Adventure Game");
      System.out.println("7. Hangman");
      System.out.println("8. Typing Test");
      System.out.println("9. Exit Text Games");
      System.out.print("> ");
      gameID = scanner.nextInt(); //this gets the users game choice
      switch (gameID) { //this uses methods to launch the game that the player chooses
        case 1:
          MainGame.playRPS();  //this is rock, paper, Scissors
          break;
        case 2:
          MainGame.playTTT();
          break;
        case 3:
          MainGame.mathQuiz();
          break;
        case 4:
          MainGame.loveCalc();
          break;
        case 5:
          MainGame.wordQuiz();
          break;
        case 6:
          MainGame.adventureGame();
          break;
        case 7:
          MainGame.hangmanMain(scanner);
          break;
        case 8:
          MainGame.startTypingTest(2, scanner);
          break;
        case 9:
          System.out.println("Thanks for playing!");
          scanner.close();
          return;
      } //end of switch (gameID)
    } //end of mainMenu
  } //end of main
} //end of TextGames

import java.util.Scanner;

public class TextGames {
  public static void main(String[] args){
    System.out.println("Hello, Welcome to Text Games!");
    mainMenu: while (true) {  //This loop allows the player to select a game from the main menu
      System.out.println("Please select a game by its number to play from the menu below:");
      System.out.println("1. Rocks, Paper, Scissors");
      System.out.println("2. Two-Player Tic-Tac-Toe");
      System.out.println("3. Math Quiz");
      System.out.println("4. Love Calculator");
      System.out.println("5. Word Quiz");
      System.out.println("6. Adventure Game");
      System.out.println("7. Hangman");
      System.out.println("8. Exit Text Games");
      System.out.println("> ");
      int gameID = TextIO.getlnInt(); //this gets the users game choice
      switch (gameID) { //this uses methods to launch the game that the player chooses
        case 1:
          MainGame.playRPS();  //this is rock, paper, Scissors
          break;
        case 2:
          MainGame.playTTT();  //this is tic tac toe
          break;
        case 3:
          MainGame.mathQuiz();  //this is tic tac toe
          break;
        case 4:
          MainGame.loveCalc();  //this is tic tac toe
          break;
        case 5:
          MainGame.wordQuiz();  //this is tic tac toe
          break;
        case 6:
          MainGame.adventureGame();  //this is tic tac toe
          break;
        case 7:
          MainGame.hangmanMain();  //this is tic tac toe
          break;
        case 8:
          break mainMenu;
      } //end of switch (gameID)
    } //end of mainMenu
  } //end of main
} //end of TextGames

public class TrackGames {
  public static void main(String[] args){

    System.out.println("Hello, Welcome to Track Games!");

    mainLoop: while (true) {  //This loop allows the player to select a game from the main menu
      System.out.println("Please select a game by its number to play from the menu below:");
      System.out.println("1. Rocks, Paper, Scissors");
      System.out.println("2. Hangman");
      System.out.println("3. War (Card Game)");
      System.out.println("4. Quiz Game");
      System.out.println("5. Tic-Tac-Toe");
      System.out.println("6. Exit Track Games");
      int gameID = TextIO.getlnInt(); //this gets the users game choice

      switch (gameID) { //this uses methods to launch the game that the player chooses
        case 1:
          playRPS();  //this is rock, paper, scissors
          break;
        case 2:
          playHangman();  //this will be a method
          break;
        case 3:
          playWar();  //this will be a method
          break;
        case 4:
          playQuiz();  //this will be a method
          break;
        case 5:
          playTTT();  //this will be a method
          break;
        case 6:
          break mainLoop;
      }

    }

  }

  public static void playRPS() {
//introduction, menu, and choosing your hand
    System.out.println("Welcome to Rock, Paper, Scissors!");
    System.out.println("Choose your hand (type 1, 2, or 3):");
    System.out.println("1. Rock");
    System.out.println("2. Paper");
    System.out.println("3. Scissors");
    int yourHand = TextIO.getlnInt(); //this is the player's choice of hand
    String playerHand = "";

//processing and confirming which hand you chose
    while (true) {
      if (yourHand == 1) {
        playerHand = "Rock";
        break;
      } else if (yourHand == 2) {
        playerHand = "Paper";
        break;
      } else if (yourHand == 3) {
        playerHand = "Scissors";
        break;
      } else {
        System.out.println("You didn't choose one of the options!");
        System.out.println("Choose another option:");
        yourHand = TextIO.getlnInt();
      }
    }
    System.out.println("You choose "+playerHand);

//choosing computers hand
    int computerHand = 0;
    String compHand = "";
    double cHand = Math.random()*3;
    if (cHand <= 1) {
      computerHand = 1;
      compHand = "Rock";
    } else if (cHand <= 2 && cHand > 1) {
      computerHand = 2;
      compHand = "Paper";
    } else if (cHand <= 3 && cHand > 2) {
      computerHand = 3;
      compHand = "Scissors";
    }
    System.out.println("The computer chooses "+compHand);

//deciding and announcing who won
    if (yourHand == 1) {  //you are rock
      if (computerHand == 1) {  //comp is rock
        System.out.println("It is a tie!");
      } else if (computerHand == 2) { //comp is paper
        System.out.println("You Lose!");
      } else if (computerHand == 3) { //comp is scissors
        System.out.println("You Win!");
      }
    } else if (yourHand == 2) { //you are paper
      if (computerHand == 1) {  //comp is rock
        System.out.println("You Win!");
      } else if (computerHand == 2) { //comp is paper
        System.out.println("It is a tie!");
      } else if (computerHand == 3) { //comp is scissors
        System.out.println("You Lose!");
      }
    } else if (yourHand == 3) { //you are scissors
      if (computerHand == 1) {  //comp is rock
        System.out.println("You Lose!");
      } else if (computerHand == 2) { //comp is paper
        System.out.println("You Win!");
      } else if (computerHand == 3) { //comp is scissors
        System.out.println("It is a tie!");
      }
    }

//ask if you will play again
    System.out.println("Would you like to play again? (Type yes or no)");
    boolean playAgain = TextIO.getlnBoolean();
    if (playAgain) {
      playRPS();
    } else {
      return;
    }

  } //end of playRPS

  public static void playHangman() {
    System.out.println("This game is not yet available.");
  }

  public static void playWar() {
    System.out.println("This game is not yet available.");
  }

  public static void playQuiz() {
    System.out.println("This game is not yet available.");
  }

  public static void playTTT() {
    System.out.println("This game is not yet available.");
  }
}

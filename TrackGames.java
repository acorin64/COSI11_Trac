public class TrackGames {

  public static char[][] board = new char[3][3]; //holds current gameboard status for Tic Tac Toe
  public static int[] usedMoves = new int[9]; //holds list of all used moves for Tic Tac Toe
  public static char playerSymbol = 'X';  //denotes current player and their used symbol for Tic Tac Toe

  public static void main(String[] args){

    System.out.println("Hello, Welcome to Track Games!");

    mainLoop: while (true) {  //This loop allows the player to select a game from the main menu
      System.out.println("Please select a game by its number to play from the menu below:");
      System.out.println("1. Rocks, Paper, Scissors");
      System.out.println("2. Two-Player Tic-Tac-Toe");
      System.out.println("3. War (Card Game)");
      System.out.println("4. Quiz Game");
      System.out.println("5. Hangman");
      System.out.println("6. Exit Track Games");
      int gameID = TextIO.getlnInt(); //this gets the users game choice

      switch (gameID) { //this uses methods to launch the game that the player chooses
        case 1:
          playRPS();  //this is rock, paper, scissors
          break;
        case 2:
          playTTT();  //this is tic tac toe
          break;
        case 3:
          playWar();  //this will be a method
          break;
        case 4:
          playQuiz();  //this will be a method
          break;
        case 5:
          playHangman();  //this will be a method
          break;
        case 6:
          break mainLoop;
      }

    }

  }

  public static void playRPS() {
//introduction, menu, and choosing your hand
    System.out.println();
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
//prepares the board by filling in the empty elements with spaces
    for (int i=0; i<3; i++) {
      for (int j=0; j<3; j++) {
        board[i][j] = ' ';
      } //end of inner FOR loop
    } //end of outer FOR loop

//Welcomes the player to the game
    System.out.println();
    System.out.println();
    System.out.println("Welcome to Text-based Two-player Tic-Tac-Toe!");
    System.out.println("Would you like to see the instructions?");
    boolean instructions = TextIO.getlnBoolean();
//explains the instructions to the player if needed
    if (instructions) {
      System.out.println("Player X (1) will go first, followed by Player O (2).");
      System.out.println("To select a move, type a number between 1 and 9,");
      System.out.println("corresponding to the spots in the board below.");
      System.out.println("[1][2][3]");
      System.out.println("[4][5][6]");
      System.out.println("[7][8][9]");
      System.out.println("The new status of the board will then be printed out,");
      System.out.println("and the next player may then enter their move.");
    } //end of instructions if statement
    System.out.println("Let's get Started!");
    printBoard();


//main loop in which game is played
    playingTTT: while (true) {
//gets each player's move
      System.out.println("Player "+playerSymbol+", please enter your move:");
      int move = TextIO.getlnInt();
//evaluates whether this is a valid move
      if (move < 1 || move > 9) {
        System.out.println("That is not a valid move.");
        continue playingTTT;
      }
//checks to see whether the move has already been used, and records its use
//if it has not been used
      moveCheck: while (true) {
        if (usedMoves[move-1] == 1) {
          System.out.println("That move has been used, please enter your move:");
          move = TextIO.getlnInt();
          //evaluates whether this is a valid move
          if (move < 1 || move > 9) {
            System.out.println("That is not a valid move.");
            continue playingTTT;
          }
        } else {
          usedMoves[move-1] = 1;
          break moveCheck;
        }
      }
      updateBoard(move);  //updates the game board status
      printBoard();       //prints the new game board status
      switchPlayer();     //switches the current player/symbol
      boolean gameWon = checkForWin();      //checks to see if a player has won
      if (gameWon) {
        break playingTTT;
      }
    } //end of playingTTT

    if (playerSymbol == 'X') {
      System.out.println("The winner is Player 2 (O)!");
    } else {
      System.out.println("The winner is Player 1 (X)!");
    }

//ask if you will play again
    System.out.println("Would you like to play again? (Type yes or no)");
    boolean playAgain = TextIO.getlnBoolean();
    if (playAgain) {
      resetTTT(); //resets the game so it can be played again
      playTTT();  //calls the initial method, restarting the game
    } else {
      return;
    }
  } //end of playTTT

  public static void printBoard() { //prints the board in its current state for TTT
    for (int i=0; i<3; i++) {
      for (int j=0; j<3; j++) {
        System.out.printf("[%1s]", board[i][j]);
      }
      System.out.println();
    }
    System.out.println();
  } //end of printBoard

  public static void updateBoard(int a) { //updates the board for TTT
    switch (a) {
      case 1: board[0][0] = playerSymbol; break;
      case 2: board[0][1] = playerSymbol; break;
      case 3: board[0][2] = playerSymbol; break;
      case 4: board[1][0] = playerSymbol; break;
      case 5: board[1][1] = playerSymbol; break;
      case 6: board[1][2] = playerSymbol; break;
      case 7: board[2][0] = playerSymbol; break;
      case 8: board[2][1] = playerSymbol; break;
      case 9: board[2][2] = playerSymbol; break;
    }
  } //end of updateBoard

  public static void switchPlayer() { //switches current player/symbol used for TTT
    if (playerSymbol == 'X') {
      playerSymbol = 'O';
    } else if (playerSymbol == 'O') {
      playerSymbol = 'X';
    }
  } //end of switchPlayer

  public static boolean checkForWin() { //checks to see if a player has won for TTT
    if (board[0][0] == board[0][1] && board[0][1] == board[0][2] && board[0][0] != ' ') { //horizontal top
      return true;
    } else if (board[1][0] == board[1][1] && board[1][1] == board[1][2] && board[1][0] != ' ') { //horizontal mid
      return true;
    } else if (board[2][0] == board[2][1] && board[2][1] == board[2][2] && board[2][0] != ' ') { //horizontal bot
      return true;
    } else if (board[0][0] == board[1][0] && board[1][0] == board[2][0] && board[0][0] != ' ') { //vertical left
      return true;
    } else if (board[0][1] == board[1][1] && board[1][1] == board[2][1] && board[0][1] != ' ') { //vertical mid
      return true;
    } else if (board[0][2] == board[1][2] && board[1][2] == board[2][2] && board[0][2] != ' ') { //vertical right
      return true;
    } else if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ') { //top left corner
      return true;
    } else if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != ' ') { //top right corner
      return true;
    } else {
      return false;
    }
  } //end of checkForWin

  public static void resetTTT() { //resets the game so it can be played again for TTT
//reset starting player to player 1 (X)
    playerSymbol = 'X';
//empty out the list of moves already used
    for (int i=0; i<usedMoves.length; i++) {
      usedMoves[i] = 0;
    }
//prepares the board by filling in the empty elements with spaces
    for (int i=0; i<3; i++) {
      for (int j=0; j<3; j++) {
        board[i][j] = ' ';
      } //end of inner FOR loop
    } //end of outer FOR loop
  } //end of resetTTT
}

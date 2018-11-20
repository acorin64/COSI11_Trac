public class TTT {

  public static char[][] board = new char[3][3]; //holds current gameboard status
  public static int[] usedMoves = new int[9];
  public static char playerSymbol = 'X';
  public static int count = 0;

  public static void main(String[] args){
    playTTT();
  } //end of main

  public static void playTTT() {
//Welcomes the player to the game
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
//checks to see whether the move has already been used, and records its use
//if it has not been used
      moveCheck: while (true) {
        if (usedMoves[move-1] == 1) {
          System.out.println("That move has been used, please enter your move:");
          move = TextIO.getlnInt();
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


//!!named while loop (playing), broken when someone wins
//!!current player enters 1-9
//!!accounts for move being used already
//!!use method "updateBoard" (will take 1-9 as int parameter)
    //switch statement that will insert player symbol into correct gameboard spots
//use method "checkForWin"
    //This will check to see if someone has run and break the while loop if they have
//!!use method/if statement - switch player symbol

  } //end of playTTT

  public static void printBoard() { //prints the board in its current state
    for (int i=0; i<3; i++) {
      for (int j=0; j<3; j++) {
        System.out.print("["+board[i][j]+"]");
      }
      System.out.println();
    }
  } //end of printBoard

  public static void updateBoard(int a) { //updates the board
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

  public static void switchPlayer() { //switches current player/symbol used
    if (playerSymbol == 'X') {
      playerSymbol = 'O';
    } else if (playerSymbol == 'O') {
      playerSymbol = 'X';
    }
  } //end of switchPlayer

  public static boolean checkForWin() { //checks to see if a player has won
    if (board[0][0] == board[0][1] && board[0][1] == board[0][2] && board[0][0] != '\u0000') { //horizontal top
      return true;
    } else if (board[1][0] == board[1][1] && board[1][1] == board[1][2] && board[1][0] != '\u0000') { //horizontal mid
      return true;
    } else if (board[2][0] == board[2][1] && board[2][1] == board[2][2] && board[2][0] != '\u0000') { //horizontal bot
      return true;
    } else if (board[0][0] == board[1][0] && board[1][0] == board[2][0] && board[0][0] != '\u0000') { //vertical left
      return true;
    } else if (board[0][1] == board[1][1] && board[1][1] == board[2][1] && board[0][1] != '\u0000') { //vertical mid
      return true;
    } else if (board[0][2] == board[1][2] && board[1][2] == board[2][2] && board[0][2] != '\u0000') { //vertical right
      return true;
    } else if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '\u0000') { //top left corner
      return true;
    } else if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != '\u0000') { //top right corner
      return true;
    } else {
      return false;
    }
  } //end of checkForWin

} //end of Program (TTT class)

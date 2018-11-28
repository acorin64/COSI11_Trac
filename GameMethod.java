import java.util.Scanner;

public class GameMethod { //This holds all of the methods used in each game

  public static void checkForTie() { //checks for a tie
    int count = 0;
    for (int i=0; i<3; i++) {
      for (int j=0; j<3; j++) {
        if (Static.board[i][j] != ' ') {
          count++;
        }
      } //end of inner FOR loop
    } //end of outer FOR loop
    if (count == 9 && Static.gameWon == false) {
      Static.tie = true;
    }
  } //end of checkForTie

  public static boolean moveCheck(int move) { //checks to see whether the move is valid
    if (move >= 1 && move <= 9 && Static.usedMoves[move-1] == 0) {
      return true;
    } else {
      return false;
    }
  } //end of moveCheck

  public static void replayTTT() { //determines if player will play again and relaunches/ends game accordingly
    System.out.println("Would you like to play again? (Type yes or no)");
    boolean playAgain = TextIO.getlnBoolean();
    if (playAgain) {
      GameMethod.resetTTT(); //resets the game so it can be played again
      MainGame.playTTT();  //calls the initial method, restarting the game
    } else {
      return;
    }
  } //end of replay

  public static void welcomePlayer() { //welcomes player and explains rules
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
  } //end of welcomePlayer

  public static void announceWinner() { //announces the winner
    if (Static.tie) {
      System.out.println("The game is a Tie!");
    } else {
      if (Static.playerSymbol == 'X') {
        System.out.println("The winner is Player 2 (O)!");
      } else {
        System.out.println("The winner is Player 1 (X)!");
      }
    }
  } //end of announceWinner

  public static void printBoard() { //prints the board in its current state
    for (int i=0; i<3; i++) {
      for (int j=0; j<3; j++) {
        System.out.printf("[%1s]", Static.board[i][j]);
      }
      System.out.println();
    }
    System.out.println();
  } //end of printBoard

  public static void emptyBoard() { //empties the board, fills elements with a space
    for (int i=0; i<3; i++) {
      for (int j=0; j<3; j++) {
        Static.board[i][j] = ' ';
      } //end of inner FOR loop
    } //end of outer FOR loop
  } //end of emptyBoard

  public static void updateBoard(int a) { //updates the board
    switch (a) {
      case 1: Static.board[0][0] = Static.playerSymbol; break;
      case 2: Static.board[0][1] = Static.playerSymbol; break;
      case 3: Static.board[0][2] = Static.playerSymbol; break;
      case 4: Static.board[1][0] = Static.playerSymbol; break;
      case 5: Static.board[1][1] = Static.playerSymbol; break;
      case 6: Static.board[1][2] = Static.playerSymbol; break;
      case 7: Static.board[2][0] = Static.playerSymbol; break;
      case 8: Static.board[2][1] = Static.playerSymbol; break;
      case 9: Static.board[2][2] = Static.playerSymbol; break;
    }
  } //end of updateBoard

  public static void switchPlayer() { //switches current player/symbol used
    if (Static.playerSymbol == 'X') {
      Static.playerSymbol = 'O';
    } else if (Static.playerSymbol == 'O') {
      Static.playerSymbol = 'X';
    }
  } //end of switchPlayer

  public static boolean checkForWin() { //checks to see if a player has won
    if (Static.board[0][0] == Static.board[0][1] && Static.board[0][1] == Static.board[0][2] && Static.board[0][0] != ' ') { //horizontal top
      return true;
    } else if (Static.board[1][0] == Static.board[1][1] && Static.board[1][1] == Static.board[1][2] && Static.board[1][0] != ' ') { //horizontal mid
      return true;
    } else if (Static.board[2][0] == Static.board[2][1] && Static.board[2][1] == Static.board[2][2] && Static.board[2][0] != ' ') { //horizontal bot
      return true;
    } else if (Static.board[0][0] == Static.board[1][0] && Static.board[1][0] == Static.board[2][0] && Static.board[0][0] != ' ') { //vertical left
      return true;
    } else if (Static.board[0][1] == Static.board[1][1] && Static.board[1][1] == Static.board[2][1] && Static.board[0][1] != ' ') { //vertical mid
      return true;
    } else if (Static.board[0][2] == Static.board[1][2] && Static.board[1][2] == Static.board[2][2] && Static.board[0][2] != ' ') { //vertical right
      return true;
    } else if (Static.board[0][0] == Static.board[1][1] && Static.board[1][1] == Static.board[2][2] && Static.board[0][0] != ' ') { //top left corner
      return true;
    } else if (Static.board[0][2] == Static.board[1][1] && Static.board[1][1] == Static.board[2][0] && Static.board[0][2] != ' ') { //top right corner
      return true;
    } else {
      return false;
    }
  } //end of checkForWin

  public static void resetTTT() { //resets the game so it can be played again
    //reset starting player to player 1 (X), and turn off tie
    Static.playerSymbol = 'X';
    Static.tie = false;
    Static.gameWon = false;
    //empty out the list of moves already used
    for (int i=0; i<Static.usedMoves.length; i++) {
      Static.usedMoves[i] = 0;
    }
    GameMethod.emptyBoard();

  } //end of resetTTT

  public static int randomNum(){
    return (int)(20 * Math.random()) + 1;
  } //mathQuiz

  public static void addProb(){
    int randomNumber1 = randomNum();
    int randomNumber2 = randomNum();
    System.out.println("What is "+randomNumber1+" + "+randomNumber2+"?");
    int guess = TextIO.getlnInt();
    int answer = randomNumber1 + randomNumber2;
    if (guess == answer) {
      System.out.println("Correct!");
      Static.mathCorrect++;
    } else {
      System.out.println("Incorrect!");
      System.out.println("The correct answer is " + answer);
    }
  }//mathQuiz

  public static void subProb(){
    int randomNumber1 = randomNum();
    int randomNumber2 = randomNum();
    System.out.println("What is "+randomNumber1+" - "+randomNumber2+"?");
    int guess = TextIO.getlnInt();
    int answer = randomNumber1 - randomNumber2;
    if (guess == answer) {
      System.out.println("Correct!");
      Static.mathCorrect++;
    } else {
      System.out.println("Incorrect!");
      System.out.println("The correct answer is " + answer);
    }
  }//mathQuiz

  public static void multProb(){
    int randomNumber1 = randomNum();
    int randomNumber2 = randomNum();
    System.out.println("What is "+randomNumber1+" * "+randomNumber2+"?");
    int guess = TextIO.getlnInt();
    int answer = randomNumber1 * randomNumber2;
    if (guess == answer) {
      System.out.println("Correct!");
      Static.mathCorrect++;
    } else {
      System.out.println("Incorrect!");
      System.out.println("The correct answer is " + answer);
    }
  }//mathQuiz

  public static void divProb(){
    int randomNumber1 = randomNum();
    int randomNumber2 = randomNum();
    System.out.println("What is "+randomNumber1+" / "+randomNumber2+"?");
    int guess = TextIO.getlnInt();
    int answer = randomNumber1 / randomNumber2;
    if (guess == answer) {
      System.out.println("Correct!");
      Static.mathCorrect++;
    } else {
      System.out.println("Incorrect!");
      System.out.println("The correct answer is " + answer);
    }
  }//mathQuiz

  public static void modProb(){
    int randomNumber1 = randomNum();
    int randomNumber2 = randomNum();
    System.out.println("What is "+randomNumber1+" % "+randomNumber2+"?");
    int guess = TextIO.getlnInt();
    int answer = randomNumber1 % randomNumber2;
    if (guess == answer) {
      System.out.println("Correct!");
      Static.mathCorrect++;
    } else {
      System.out.println("Incorrect!");
      System.out.println("The correct answer is " + answer);
    }
  }//mathQuiz

  public static void scoreCalc(){
    double percentageCorrect = Static.mathCorrect * 20;
    System.out.println("You got " + Static.mathCorrect + " correct answers.");
    System.out.println("That's a score of " + percentageCorrect + "%");
  }//mathQuiz

  public static void loveTest(int sum) {
    if (sum == 0){
      Static.love = "0%";
    } else if (sum == 1){
      Static.love = "20%";
    } else if (sum == 2){
       Static.love = "40%";
    } else if (sum == 3){
       Static.love = "60%";
    } else if (sum == 4){
       Static.love = "80%";
    } else if (sum >= 5){
       Static.love = "100%";
    } else {
      System.out.println("You might wanna find a new boo!");
    }
  }

  public static void selectQ(int q) {
    switch (q) {
      case 1: question1(); break;
      case 2: question2(); break;
      case 3: question3(); break;
      case 4: question4(); break;
      case 5: question5(); break;
      case 6: question6(); break;
      case 7: question7(); break;
      case 8: question8(); break;
      case 9: question9(); break;
      case 10: question10(); break;
    }
  }

  public static int randomNum10(){
    return (int)(10 * Math.random()) + 1;
  }

  public static void question1(){
    System.out.println("What is the capital of Austrailia?");
    String answer = TextIO.getlnString();
    if (answer.equals("Canberra")) {
      System.out.println("Correct");
      Static.wordCorrect++;
    }
    else{
      System.out.println("Incorrect, the capital is Canberra.");
    }
  }

  public static void question2(){
    System.out.println("Which country is the world's biggest producer of coffee?");
    String answer = TextIO.getlnString();
    if (answer.equals("Brazil")) {
      System.out.println("Correct");
      Static.wordCorrect++;
    }
    else{
      System.out.println("Incorrect, the answer is Brazil.");
    }
  }

  public static void question3(){
    System.out.println("In what city is the Dome of the Rock found?");
    String answer = TextIO.getlnString();
    if (answer.equals("Jerusalem")) {
      System.out.println("Correct");
      Static.wordCorrect++;
    }
    else{
      System.out.println("Incorrect, the answer is Jerusalem.");
    }
  }

  public static void question4(){
    System.out.println("Who is younger, Serena or Venus Williams?");
    String answer = TextIO.getlnString();
    if (answer.equals("Serena")) {
      System.out.println("Correct");
      Static.wordCorrect++;
    }
    else{
    System.out.println("Incorrect, the answer is Serena.");
    }
  }

  public static void question5(){
    System.out.println("Which movement was founded by L. Ron Hubbard?");
    String answer = TextIO.getlnString();
    if (answer.equals("Scientology")) {
      System.out.println("Correct");
      Static.wordCorrect++;
    }
    else{
      System.out.println("Incorrect, the answer is Scientology.");
    }
  }

  public static void question6(){
    System.out.println("Do the Yankees play in the American or National League?");
    String answer = TextIO.getlnString();
    if (answer.equals("American")) {
      System.out.println("Correct");
      Static.wordCorrect++;
    }
    else{
      System.out.println("Incorrect, the answer is American.");
    }
  }

  public static void question7(){
    System.out.println("What is the world's largest ocean?");
    String answer = TextIO.getlnString();
    if (answer.equals("Pacific")) {
      System.out.println("Correct");
      Static.wordCorrect++;
    }
    else{
      System.out.println("Incorrect, the answer is Pacific.");
    }
  }

  public static void question8(){
    System.out.println("What year did the Cold War end?");
    String answer = TextIO.getlnString();
    if (answer.equals("1989")) {
      System.out.println("Correct");
      Static.wordCorrect++;
    }
    else{
      System.out.println("Incorrect, the answer is 1989.");
    }
  }

  public static void question9(){
    System.out.println("What is the largest freshwater lake in the world?");
    String answer = TextIO.getlnString();
    if (answer.equals("Superior")) {
      System.out.println("Correct");
      Static.wordCorrect++;
    }
    else{
      System.out.println("Incorrect, the answer is Superior.");
    }
  }

  public static void question10(){
    System.out.println("What is the world's longest river?");
    String answer = TextIO.getlnString();
    if (answer.equals("Amazon")) {
      System.out.println("Correct");
      Static.wordCorrect++;
    }
    else{
      System.out.println("Incorrect, the answer is Amazon.");
    }
  }

  public static void quizScoreCalc(){
    double percentageCorrect = (double) Static.wordCorrect/3*100;
    System.out.println("You got " + Static.wordCorrect + " correct answers.");
    System.out.println("That's a score of " + percentageCorrect + "%");
  }

  public static void chooseCH() {
    double cHand = Math.random()*3;
    if (cHand <= 1) {
      Static.computerHand = 1;
      Static.compHand = "Rock";
    } else if (cHand <= 2 && cHand > 1) {
      Static.computerHand = 2;
      Static.compHand = "Paper";
    } else if (cHand <= 3 && cHand > 2) {
      Static.computerHand = 3;
      Static.compHand = "Scissors";
    }
    System.out.println("The computer chooses "+Static.compHand);
  }

  public static void findWinnerRPS() {
    if (Static.yourHand == 1) {  //you are rock
      if (Static.computerHand == 1) {  //comp is rock
        System.out.println("It is a tie!");
      } else if (Static.computerHand == 2) { //comp is paper
        System.out.println("You Lose!");
      } else if (Static.computerHand == 3) { //comp is scissors
        System.out.println("You Win!");
      }
    } else if (Static.yourHand == 2) { //you are paper
      if (Static.computerHand == 1) {  //comp is rock
        System.out.println("You Win!");
      } else if (Static.computerHand == 2) { //comp is paper
        System.out.println("It is a tie!");
      } else if (Static.computerHand == 3) { //comp is scissors
        System.out.println("You Lose!");
      }
    } else if (Static.yourHand == 3) { //you are scissors
      if (Static.computerHand == 1) {  //comp is rock
        System.out.println("You Lose!");
      } else if (Static.computerHand == 2) { //comp is paper
        System.out.println("You Win!");
      } else if (Static.computerHand == 3) { //comp is scissors
        System.out.println("It is a tie!");
      }
    }
  }

  public static void playRPSAgain() {
    System.out.println("Would you like to play again? (Type yes or no)");
    boolean playAgain = TextIO.getlnBoolean();
    if (playAgain) {
      MainGame.playRPS();
    } else {
      return;
    }
  }

  public static void hang(String guess) {
    //set up to manipulate
		String newUnderscore = "";
    /*loop with ifs so that if a character is right then it
    changes it into the word that is right */
		for (int i = 0; i < Static.word.length(); i++) {
			if (Static.word.charAt(i) == guess.charAt(0)) {
				newUnderscore += guess.charAt(0);
			} else if (Static.Underscore.charAt(i) != '_') {
				newUnderscore += Static.word.charAt(i);
			} else {
				newUnderscore += "_";
			}
		}
		// if statement that changes the image if wrong
		if (Static.Underscore.equals(newUnderscore)) {
			Static.count++;
      hangmanImageSwitch();
      //if right, change asteriks
		} else {
			Static.Underscore = newUnderscore;
		}
    //if win, then stop
		if (Static.Underscore.equals(Static.word)) {
			System.out.println("Correct! You won! The word was " + Static.word);
		}
	}//new method - for guessing

	public static void hangmanImageSwitch() {
    //change so that it starts with a full thing, make sure to camelcase too
    switch(Static.count) { // switch
      case 1: hang1(); break;
      case 2: hang2(); break;
      case 3: hang3(); break;
      case 4: hang4(); break;
      case 5: hang5(); break;
      case 6: hang6(); break;
      case 7: hang7(); break;
    }
  }//method for changing picture

	public static void hang1() {
      System.out.println("Wrong guess, try again");
      System.out.println("   ____________");
      System.out.println("   |          |");
      System.out.println("   |");
      System.out.println("   |");
      System.out.println("   |");
      System.out.println("   |");
      System.out.println("   |");
      System.out.println("   | ");
      System.out.println("___|___");
		}

	public static void hang2() {
      System.out.println("Wrong guess, try again");
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |         \\ __/");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("___|___");
		}

	public static void hang3() {
      System.out.println("Wrong guess, try again");
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |         \\ __/");
			System.out.println("   |           |");
			System.out.println("   |           |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("___|___");
		}

	public static void hang4() {
  			System.out.println("Wrong guess, try again");
  			System.out.println("   ____________");
  			System.out.println("   |          _|_");
  			System.out.println("   |         /   \\");
  			System.out.println("   |         \\__ /");
  			System.out.println("   |           |");
  			System.out.println("   |           |");
  			System.out.println("   |            \\");
  			System.out.println("   |             \\ ");
  			System.out.println("___|___");
		}

	public static void hang5() {
      System.out.println("Wrong guess, try again!");
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |         \\__ /");
      System.out.println("   |           |");
			System.out.println("   |           | ");
			System.out.println("   |          / \\ ");
			System.out.println("   |         /   \\");
			System.out.println("___|___");
		}

	public static void hang6() {
			System.out.println("Wrong guess, try again");
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |         \\__ /");
			System.out.println("   |          _|");
			System.out.println("   |         / |");
			System.out.println("   |          / \\");
			System.out.println("   |         /   \\ ");
			System.out.println("___|___");
		}

	public static void hang7() {
			System.out.println("GAME OVER!");
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |         \\__ /");
      System.out.println("   |          _|_");
			System.out.println("   |         / | \\");
			System.out.println("   |          / \\ ");
			System.out.println("   |         /   \\");
			System.out.println("___|___");
			System.out.println("Game over! The word was " + Static.word);
		}

} //end of gameMethod

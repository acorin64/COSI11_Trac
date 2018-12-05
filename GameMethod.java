import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.Scanner;
import org.json.JSONObject;

public class GameMethod { //This holds all of the methods used in each game

  /**
  * This is a method which will connect to a website and return the content as a string.
  * You can get information about time in different timezones by connecting
  * to the URL http://worldtimeapi.org/api/, e.g.
  * myURL="http://worldtimeapi.org/api/timezones/America/New_York.txt"
  * gives info about the current time in New York
  */
  public static String getStringFromURL(String myURL) {
		StringBuilder sb = new StringBuilder();
		URLConnection urlConn = null;
		InputStreamReader in = null;
		try {
			URL url = new URL(myURL);
			urlConn = url.openConnection();
			if (urlConn != null)
				urlConn.setReadTimeout(60 * 1000);
			if (urlConn != null && urlConn.getInputStream() != null) {
				in = new InputStreamReader(urlConn.getInputStream(),
						Charset.defaultCharset());
				BufferedReader bufferedReader = new BufferedReader(in);
				if (bufferedReader != null) {
					int cp;
					while ((cp = bufferedReader.read()) != -1) {
						sb.append((char) cp);
					}
					bufferedReader.close();
				}
			}
		in.close();
		} catch (Exception e) {
			throw new RuntimeException("Exception while calling URL:"+ myURL, e);
	  }

		return sb.toString();
  }

  public static int k2f(int k){
    return (((k - 273) * 9/5) + 32);
  }

  /**
  This gets the weather for a given zipcode...
  */
  public static void getWeather(String zipcode){
	   System.out.print("Enter a ZIP code: ");
	   Scanner scanner = new Scanner(System.in);
	   String zip = scanner.next();
	   String apiKey = "06d70799a9fcdfb5cffd48536349e502";
     String url = "https://api.openweathermap.org/data/2.5/weather?zip="+zip+",us"+"&appid="+apiKey;
     String json = getStringFromURL(url);
     JSONObject obj = new JSONObject(json);
	   System.out.print("Guess the current temperature (°F): ");

     int tempK = obj.getJSONObject("main").getInt("temp");
     int tempF = k2f(tempK);
     int guess = scanner.nextInt();
	   int difference = Math.abs(guess - tempF);
	   if (difference == 0) {
		     System.out.println("Correct!");
	   } else {
		     System.out.println("So close! you were " + Math.round(difference) + " degrees F away!");
		       System.out.println("Current temp in " + zip + ": " + tempF + " degrees F");
     }
  }

  public static void checkForTie() { //checks for a tie
    int count = 0; //starts the count at zero
    /*cycles through all elements of array and checks to see
    if these elements are empty or not
    */
    for (int i=0; i<3; i++) {
      for (int j=0; j<3; j++) {
        if (Static.board[i][j] != ' ') {
          count++;
        }
      } //end of inner FOR loop
    } //end of outer FOR loop
    //if all 9 slots are filled and noone has won the game, then there is a tie
    if (count == 9 && Static.gameWon == false) {
      Static.tie = true;
    }
  } //end of checkForTie
  /**
    *moveCheck checks to see whether the move is valid
    *@param move is the move a player makes
    *@return whether or not move is valid
    */
  public static boolean moveCheck(int move) { //checks to see whether the move is valid
    //if the move lands in one of the 9 slots, then the move is valid
    if (move >= 1 && move <= 9 && Static.usedMoves[move-1] == 0) {
      return true;
    } else {
      return false;
    }
  } //end of moveCheck
  /**
    *replayTTT determines if player will play again and relaunches/ends game accordingly
    */
  public static void replayTTT() { //determines if player will play again and relaunches/ends game accordingly
    //asks the user if they would like to play again
    System.out.println("Would you like to play again? (Type yes or no)");
    //creates variable for playAgain as a boolean and gets TextIO
    boolean playAgain = TextIO.getlnBoolean();
    if (playAgain) {
      GameMethod.resetTTT(); //resets the game so it can be played again
      MainGame.playTTT();  //calls the initial method, restarting the game
    } else {
      return;
    }
  } //end of replay
  /**
    *welcomePlayer welcomes the player and explains the rules
    */
  public static void welcomePlayer() {
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
  /**
    *announceWinner announces the winner of the game
    */
  public static void announceWinner() {
    if (Static.tie) {
      System.out.println("The game is a Tie!"); //prints the game is a tie
    } else {
      if (Static.playerSymbol == 'X') {
        System.out.println("The winner is Player 2 (O)!"); //prints the winner is player 2
      } else {
        System.out.println("The winner is Player 1 (X)!"); //prints the winner is player 1
      }
    }
  } //end of announceWinner
  /**
    *printBoard prints the board in its current state
    */
  public static void printBoard() {
    for (int i=0; i<3; i++) {
      for (int j=0; j<3; j++) {
        System.out.printf("[%1s]", Static.board[i][j]);
      }
      System.out.println();
    }
    System.out.println();
  } //end of printBoard
  /**
    *emptyBoard empties the board and fills the elements with a space
    */
  public static void emptyBoard() {
    for (int i=0; i<3; i++) {
      for (int j=0; j<3; j++) {
        Static.board[i][j] = ' ';
      } //end of inner FOR loop
    } //end of outer FOR loop
  } //end of emptyBoard
  /**
    *updateBoard updates the board
    */
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
  /**
    *switchPlayer switches the current player/symbol used
    */
  public static void switchPlayer() {
    if (Static.playerSymbol == 'X') {
      Static.playerSymbol = 'O';
    } else if (Static.playerSymbol == 'O') {
      Static.playerSymbol = 'X';
    }
  } //end of switchPlayer
  /**
    *checkForWin checks to see if a player has won
    */
  public static boolean checkForWin() {
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
  /**
    *resetTTT resets the game so it can be played again
    */
  public static void resetTTT() {
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
  /**
    *randomNum generates a random number from 1 to 20
    */
  public static int randomNum(){
    return (int)(20 * Math.random()) + 1;
  } //mathQuiz
  /**
    *addProb creates a random addition problem
    */
  public static void addProb(){
    //creates random number variables
    int randomNumber1 = randomNum();
    int randomNumber2 = randomNum();
    //asks the user an addition  problem with 2 random numbers
    System.out.println("What is "+randomNumber1+" + "+randomNumber2+"?");
    //uses TextIO and creates the vaariable for a guess
    int guess = TextIO.getlnInt();
    //creates the variable for the solution
    int answer = randomNumber1 + randomNumber2;
    //if the answer is correct, prints "correct!" and goes to the next question
    if (guess == answer) {
      //answer is correct
      System.out.println("Correct!");
      //this adds to your correct numbers
      Static.mathCorrect++;
      //otherwise it is wrong so it prints incorrect and tells the answer
    } else {
      System.out.println("Incorrect!");
      System.out.println("The correct answer is " + answer);
    }
  }//mathQuiz
  /**
    *subProb creates a random subtraction problem
    */
  public static void subProb(){
    //creates random number variables
    int randomNumber1 = randomNum();
    int randomNumber2 = randomNum();
    //asks the user a subtraction problem using 2 random numbers
    System.out.println("What is "+randomNumber1+" - "+randomNumber2+"?");
    //creates the variable for guess and uses TextIO
    int guess = TextIO.getlnInt();
    //creates the variable for the solution
    int answer = randomNumber1 - randomNumber2;
    //if the answer is correct, prints "correct!" and goes to the next question
    if (guess == answer) {
      System.out.println("Correct!");
      Static.mathCorrect++;
      //otherwise it is wrong so it prints incorrect and tells the answer
    } else {
      System.out.println("Incorrect!");
      System.out.println("The correct answer is " + answer);
    }
  }//mathQuiz
  /**
    *multProb creates a random multiplication problem
    */
  public static void multProb(){
    //creates random number variables
    int randomNumber1 = randomNum();
    int randomNumber2 = randomNum();
    //asks the user a multiplication problem using 2 random numbers
    System.out.println("What is "+randomNumber1+" * "+randomNumber2+"?");
    //creates the variable for guess and uses TextIO
    int guess = TextIO.getlnInt();
    //creates the variable for the solution
    int answer = randomNumber1 * randomNumber2;
    //if the answer is correct, prints "correct!" and goes to the next question
    if (guess == answer) {
      System.out.println("Correct!");
      Static.mathCorrect++;
      //otherwise it is wrong so it prints incorrect and tells the answer
    } else {
      System.out.println("Incorrect!");
      System.out.println("The correct answer is " + answer);
    }
  }//mathQuiz
  /**
    *divProb creates a random division problem
    */
  public static void divProb(){
    //creates random number variables
    int randomNumber1 = randomNum();
    int randomNumber2 = randomNum();
    //asks the user a division problem using 2 random numbers
    System.out.println("What is "+randomNumber1+" / "+randomNumber2+"?");
    //creates the variable for guess and uses TextIO
    int guess = TextIO.getlnInt();
    //creates the variable for the solution
    int answer = randomNumber1 / randomNumber2;
    //if the answer is correct, prints "correct!" and goes to the next question
    if (guess == answer) {
      System.out.println("Correct!");
      Static.mathCorrect++;
      //otherwise it is wrong so it prints incorrect and tells the answer
    } else {
      System.out.println("Incorrect!");
      System.out.println("The correct answer is " + answer);
    }
  }//mathQuiz
  /**
    *modProb creates a random modulus problem
    */
  public static void modProb(){
    //creates random number variables
    int randomNumber1 = randomNum();
    int randomNumber2 = randomNum();
    //asks the user a modulus problem using 2 random numbers
    System.out.println("What is "+randomNumber1+" % "+randomNumber2+"?");
    //creates the variable for guess and uses TextIO
    int guess = TextIO.getlnInt();
    //creates the variable for the solution
    int answer = randomNumber1 % randomNumber2;
    //if the answer is correct, prints "correct!" and goes to the next question
    if (guess == answer) {
      System.out.println("Correct!");
      Static.mathCorrect++;
      //otherwise it is wrong so it prints incorrect and tells the answer
    } else {
      System.out.println("Incorrect!");
      System.out.println("The correct answer is " + answer);
    }
  }//mathQuiz
  /**
    *scoreCalc calculates your score on the quiz
    */
  public static void scoreCalc(){
    //creates the formula to calculate the percent correct
    double percentageCorrect = Static.mathCorrect * 20;
    //prints out the number of correct answers
    System.out.println("You got " + Static.mathCorrect + " correct answers.");
    //prints the percent correct out of 100
    System.out.println("That's a score of " + percentageCorrect + "%");
  }//mathQuiz
  /**
    *loveTest takes the number of corresponding letters in two names and prints percentage of compatibitly
    */
  public static void loveTest(int sum) {
    //takes the number of corresponding letters in two names and prints percentage of compatibitly
    //five corresponding letters is 100 percent match even if names do not completely match
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
     //prints this if something goes wrong
    } else {
      System.out.println("You might wanna find a new boo!");
    }
  }
  /**
    *selectQ assigns numbers to the different questions in the quiz
    to be chosen randomly later on
    *@param numbers for each question in the quiz
    */
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
  /**
    *randomNumber10 chooses a random number from 1 to 10
    *@return random integer from 1-10
    */
  public static int randomNum10(){
    return (int)(10 * Math.random()) + 1;
  }
  /**
    *question1 creates a question and tells the user whether or not
    they answered correctly.  If they answered incorrectly, the correct
    answer is printed.
    */
  public static void question1(){
    //prints the question
    System.out.println("What is the capital of Austrailia?");
    //creates the variable for answer and uses TextIO
    String answer = TextIO.getlnString();
    //if the answer is correct, prints "correct!" and goes to the next question
    if (answer.equals("Canberra")) {
      System.out.println("Correct");
      Static.wordCorrect++;
    }
    //otherwise it is wrong so it prints incorrect and tells the answer
    else{
      System.out.println("Incorrect, the capital is Canberra.");
    }
  }
  /**
    *question2 creates a question and tells the user whether or not
    they answered correctly.  If they answered incorrectly, the correct
    answer is printed.
    */
  public static void question2(){
    //prints the question
    System.out.println("Which country is the world's biggest producer of coffee?");
    //creates the variable for answer and uses TextIO
    String answer = TextIO.getlnString();
    //if the answer is correct, prints "correct!" and goes to the next question
    if (answer.equals("Brazil")) {
      System.out.println("Correct");
      Static.wordCorrect++;
    }
    //otherwise it is wrong so it prints incorrect and tells the answer
    else{
      System.out.println("Incorrect, the answer is Brazil.");
    }
  }
  /**
    *question3 creates a question and tells the user whether or not
    they answered correctly.  If they answered incorrectly, the correct
    answer is printed.
    */
  public static void question3(){
    //prints the question
    System.out.println("In what city is the Dome of the Rock found?");
    //creates the variable for answer and uses TextIO
    String answer = TextIO.getlnString();
    //if the answer is correct, prints "correct!" and goes to the next question
    if (answer.equals("Jerusalem")) {
      System.out.println("Correct");
      Static.wordCorrect++;
    }
    //otherwise it is wrong so it prints incorrect and tells the answer
    else{
      System.out.println("Incorrect, the answer is Jerusalem.");
    }
  }
  /**
    *question4 creates a question and tells the user whether or not
    they answered correctly.  If they answered incorrectly, the correct
    answer is printed.
    */
  public static void question4(){
    //prints the question
    System.out.println("Who is younger, Serena or Venus Williams?");
    //creates the variable for answer and uses TextIO
    String answer = TextIO.getlnString();
    //if the answer is correct, prints "correct!" and goes to the next question
    if (answer.equals("Serena")) {
      System.out.println("Correct");
      Static.wordCorrect++;
    }
    //otherwise it is wrong so it prints incorrect and tells the answer
    else{
    System.out.println("Incorrect, the answer is Serena.");
    }
  }
  /**
    *question5 creates a question and tells the user whether or not
    they answered correctly.  If they answered incorrectly, the correct
    answer is printed.
    */
  public static void question5(){
    //prints the question
    System.out.println("Which movement was founded by L. Ron Hubbard?");
    //creates the variable for answer and uses TextIO
    String answer = TextIO.getlnString();
    //if the answer is correct, prints "correct!" and goes to the next question
    if (answer.equals("Scientology")) {
      System.out.println("Correct");
      Static.wordCorrect++;
    }
    //otherwise it is wrong so it prints incorrect and tells the answer
    else{
      System.out.println("Incorrect, the answer is Scientology.");
    }
  }
  /**
    *question6 creates a question and tells the user whether or not
    they answered correctly.  If they answered incorrectly, the correct
    answer is printed.
    */
  public static void question6(){
    //prints the question
    System.out.println("Do the Yankees play in the American or National League?");
    //creates the variable for answer and uses TextIO
    String answer = TextIO.getlnString();
    //if the answer is correct, prints "correct!" and goes to the next question
    if (answer.equals("American")) {
      System.out.println("Correct");
      Static.wordCorrect++;
    }
    //otherwise it is wrong so it prints incorrect and tells the answer
    else{
      System.out.println("Incorrect, the answer is American.");
    }
  }
  /**
    *question7 creates a question and tells the user whether or not
    they answered correctly.  If they answered incorrectly, the correct
    answer is printed.
    */
  public static void question7(){
    //prints the question
    System.out.println("What is the world's largest ocean?");
    //creates the variable for answer and uses TextIO
    String answer = TextIO.getlnString();
    //if the answer is correct, prints "correct!" and goes to the next question
    if (answer.equals("Pacific")) {
      System.out.println("Correct");
      Static.wordCorrect++;
    }
    //otherwise it is wrong so it prints incorrect and tells the answer
    else{
      System.out.println("Incorrect, the answer is Pacific.");
    }
  }
  /**
    *question8 creates a question and tells the user whether or not
    they answered correctly.  If they answered incorrectly, the correct
    answer is printed.
    */
  public static void question8(){
    //prints the question
    System.out.println("What year did the Cold War end?");
    //creates the variable for answer and uses TextIO
    String answer = TextIO.getlnString();
    //if the answer is correct, prints "correct!" and goes to the next question
    if (answer.equals("1989")) {
      System.out.println("Correct");
      Static.wordCorrect++;
    }
    //otherwise it is wrong so it prints incorrect and tells the answer
    else{
      System.out.println("Incorrect, the answer is 1989.");
    }
  }
  /**
    *question9 creates a question and tells the user whether or not
    they answered correctly.  If they answered incorrectly, the correct
    answer is printed.
    */
  public static void question9(){
    //prints the question
    System.out.println("What is the largest freshwater lake in the world?");
    //creates the variable for answer and uses TextIO
    String answer = TextIO.getlnString();
    //if the answer is correct, prints "correct!" and goes to the next question
    if (answer.equals("Superior")) {
      System.out.println("Correct");
      Static.wordCorrect++;
    }
    //otherwise it is wrong so it prints incorrect and tells the answer
    else{
      System.out.println("Incorrect, the answer is Superior.");
    }
  }
  /**
    *question10 creates a question and tells the user whether or not
    they answered correctly.  If they answered incorrectly, the correct
    answer is printed.
    */
  public static void question10(){
    //prints the question
    System.out.println("What is the world's longest river?");
    //creates the variable for answer and uses TextIO
    String answer = TextIO.getlnString();
    //if the answer is correct, prints "correct!" and goes to the next question
    if (answer.equals("Amazon")) {
      System.out.println("Correct");
      Static.wordCorrect++;
    }
    //otherwise it is wrong so it prints incorrect and tells the answer
    else{
      System.out.println("Incorrect, the answer is Amazon.");
    }
  }
  /**
    *quizScoreCalc calculates your score on the quiz.
    */
  public static void quizScoreCalc(){
    //creates the variable for the percent correct
    double percentageCorrect = (double) Static.wordCorrect/3*100;
    //prints the number of correct answers
    System.out.println("You got " + Static.wordCorrect + " correct answers.");
    //prints the score as a percentage out of 100
    System.out.println("That's a score of " + percentageCorrect + "%");
  }
  /**
    *chooseCH chooses a random number out of 3, each corresponding to
     either rock, paper or scissors
    */
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
  /**
    *findWinnerRPS determines the winner of Rock, Paper, Scissors
    */
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
  /**
    *playRPSAgain asks the user if they want to play
    *Rock, Paper, Scissors again
    */
  public static void playRPSAgain() {
    System.out.println("Would you like to play again? (Type yes or no)");
    boolean playAgain = TextIO.getlnBoolean();
    //if the user says yes, plays game again
    if (playAgain) {
      MainGame.playRPS();
    }
    //if user types no, returns to menu
    else {
      return;
    }
  }
  /**
    *hang changes the word into an underscore
    *@param guess is the guess a user makes
    */
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
  /**
    *hangmanImageSwitch changes the hangman picture
    */
	public static void hangmanImageSwitch() {
    switch(Static.count) { // switch that decides which hangman to print
      case 1: hang1(); break;
      case 2: hang2(); break;
      case 3: hang3(); break;
      case 4: hang4(); break;
      case 5: hang5(); break;
      case 6: hang6(); break;
      case 7: hang7(); break;
    }
  }
  /**
    *hang1 is the penalty for incorrect guess 1
    *each hang method is a different penalty until 7 wrong guesses
    */
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
  /**
    *hang2 is the penalty for incorrect guess 2
    *each hang method is a different penalty until 7 wrong guesses
    */
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
  /**
    *hang3 is the penalty for incorrect guess 3
    *each hang method is a different penalty until 7 wrong guesses
    */
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
  /**
    *hang4 is the penalty for incorrect guess 4
    *each hang method is a different penalty until 7 wrong guesses
    */
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
  /**
    *hang5 is the penalty for incorrect guess 5
    *each hang method is a different penalty until 7 wrong guesses
    */
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
  /**
    *hang6 is the penalty for incorrect guess 6
    *each hang method is a different penalty until 7 wrong guesses
    */
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
    /**
      *hang7 is the penalty for incorrect guess 7
      *each hang method is a different penalty until 7 wrong guesses
      *end code, loss at 7 guesses
      */

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

  /**
    *generateTestWords generates the words for the typing test game
    *@param size the size of the words
    *@return random words from an array
    */
  public static String generateTestWords(int size) {
   String testString = "";
   //array for string of words to be used in typing test
   String[] words = new String[] {"cat", "dog", "animal", "basketball", "pizza", "house", "desk", "elephant", "student", "mushroom", "banana", "spongebob", "zealous", "sheep", "aloof", "pneumonia"};
   //generates random words from array
   for (int i = 0; i < size; i++) {
    int randomIndex = (int) (Math.random() * words.length);
    testString += words[randomIndex] + " ";
   }
   return testString;
  }

  /**
    *round rounds the time it took to type to 1 decimal place
    *Method from https://stackoverflow.com/a/22186845
    *@param value the value you are rounding
    *@param precision the precision to which you round
    *@return the time it took to type the words
    */
  public static double round (double value, int precision) {
    int scale = (int) Math.pow(10, precision);  //calculates scale (used for determining rounded value)
    return (double) Math.round(value * scale) / scale;
  }
  /**
    *printStats prints typing speed statistics
    *@param totalSeconds how many seconds it took to type the words
    *@param testStringSize used to calculate words per minute
    *@return the typing speed statistics
    */
  public static void printStats(double totalSeconds, int testStringSize) {
    //formula to calculate words per minute
    double wordsPerMinute = testStringSize / (totalSeconds / 60);
    //rounds time, seconds
    double roundedTime = round(totalSeconds, 1);
    //creates variable for rounded words per minute
    double roundedWpm = round(wordsPerMinute, 1);
    //prints a line above stats
    System.out.println("\nCORRECT! Here are your stats:\n---------");
    //prints total rounded time in seconds
    System.out.println("Total time: " + roundedTime + " seconds");
    //prints rounded words per minute
    System.out.println("Words Per Minute: " + roundedWpm);
  }
} //end of gameMethod

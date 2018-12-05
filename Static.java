import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.Scanner;
import org.json.JSONObject;

public class Static {
  //static variables for all games are listed here
  public static char[][] board = new char[3][3]; //holds current gameboard status for Tic-Tac-Toe
  public static int[] usedMoves = new int[9]; //holds list of all used moves for Tic-Tac-Toe
  public static char playerSymbol = 'X';  //denotes current player and their used symbol for Tic-Tac-Toe
  public static boolean tie = false;  //test for if the game was a tie for Tic-Tac-Toe
  public static boolean gameWon = false;//test for if the game was won for Tic-Tac-Toe
  public static int mathCorrect = 0;  //counts the number of correct answers given for Math Quiz
  public static String love = ""; //tells what percent compatible the two people are for Love Test
  public static int wordCorrect = 0;  //counts the number of correct answers given for Word Quiz
  public static int computerHand = 0; //determines a number indicator of whether the computer will throw rock, paper, or scissors for Rock Paper Scissors
  public static String compHand = ""; //interprets computerHand as an int, and prints out the corresponding play of rock, paper, or scissors for Rock Paper Scissors
  public static int yourHand = 0; //number indicator of the player's choice of rock, paper or scissors for Rock Paper Scissors
  public static String playerHand = ""; //interprets yourHand as an int, and prints the corresponding play for Rock Paper Scissors
  public static String[] words = {"terminator", "code", "computer", "miami", "github", "hangman", "software", "charger", "void", "tim" }; //hangman
	public static String word = words[(int) (Math.random() * words.length)]; //hangman
	public static String Underscore = new String(new char[word.length()]).replace("\0", "_"); //hangman
	public static int count = 0; //hangman
} //end of Statics

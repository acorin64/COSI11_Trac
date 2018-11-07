public class TrackGames {
  public static void main(String[] args){


    System.out.println("Hello, Welcome to Track Games!");
    System.out.println("Please select a game by its number to play from the menu below:");
    System.out.println("1. Rocks, Paper, Scissors");
    System.out.println("2. Hangman");
    System.out.println("3. War (Card Game)");
    System.out.println("4. Quiz Game");
    int gameID = TextIO.getlnInt();

    switch (gameID) {
      case 1:
        playRPS();  //this will be a method
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
    }


  }

  public static void playRPS() {
    System.out.println("This game is not yet available.");
  }

  public static void playHangman() {
    System.out.println("This game is not yet available.");
  }

  public static void playWar() {
    System.out.println("This game is not yet available.");
  }

  public static void playQuiz() {
    System.out.println("This game is not yet available.");
  }
}

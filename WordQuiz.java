public class WordQuiz{
  public static int wordCorrect = 0;
  public static void main(String[] args){
    System.out.println("Hey There! Please answer the following questions with one word: ");
    int q1 = randomNum10();
    int q2 = randomNum10();
    boolean same = false;
    if (q1 == q2) {
      same = true;
    }
    while (same) {
      q2 = randomNum10();
      if (q1 != q2) {
        same = false;
      }
    }
    int q3 = randomNum10();
    if (q3 == q1 || q3 == q2) {
      same = true;
    }
    while (same){
      q3 = randomNum10();
      if (q3 != q1 && q3 != q2) {
        same = false;
      }
    }

    selectQ(q1);
    selectQ(q2);
    selectQ(q3);
    quizScoreCalc();
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
      wordCorrect++;
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
      wordCorrect++;
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
      wordCorrect++;
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
      wordCorrect++;
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
      wordCorrect++;
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
      wordCorrect++;
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
      wordCorrect++;
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
      wordCorrect++;
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
      wordCorrect++;
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
      wordCorrect++;
    }
    else{
      System.out.println("Incorrect, the answer is Amazon.");
    }
  }

  public static void quizScoreCalc(){
    double percentageCorrect = (double) wordCorrect/3*100;
    System.out.println("You got " + wordCorrect + " correct answers.");
    System.out.println("That's a score of " + percentageCorrect + "%");
  }
}

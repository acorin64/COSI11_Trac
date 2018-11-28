public class MathQuiz{
  public static int correct = 0;
  public static void main(String[] args){
  System.out.println("Hey there! Please answer the following questions: ");
  randomNum();
  addProb();
  subProb();
  multProb();
  divProb();
  modProb();
  scoreCalc();
  }

  public static int randomNum(){
    return (int)(20 * Math.random()) + 1;
  }

  public static void addProb(){
    int randomNumber1 = randomNum();
    int randomNumber2 = randomNum();
    System.out.println("What is "+randomNumber1+" + "+randomNumber2+"?");
    int guess = TextIO.getlnInt();
    int answer = randomNumber1 + randomNumber2;
    if (guess == answer) {
    System.out.println("Correct!");
    correct++;
  }else {
    System.out.println("Incorrect!");
    System.out.println("The correct answer is " + answer);
  }
}
public static void subProb(){
  int randomNumber1 = randomNum();
  int randomNumber2 = randomNum();
  System.out.println("What is "+randomNumber1+" - "+randomNumber2+"?");
  int guess = TextIO.getlnInt();
  int answer = randomNumber1 - randomNumber2;
  if (guess == answer) {
  System.out.println("Correct!");
  correct++;
}else {
  System.out.println("Incorrect!");
  System.out.println("The correct answer is " + answer);
}
}
public static void multProb(){
  int randomNumber1 = randomNum();
  int randomNumber2 = randomNum();
  System.out.println("What is "+randomNumber1+" * "+randomNumber2+"?");
  int guess = TextIO.getlnInt();
  int answer = randomNumber1 * randomNumber2;
  if (guess == answer) {
  System.out.println("Correct!");
  correct++;
}else {
  System.out.println("Incorrect!");
  System.out.println("The correct answer is " + answer);
}
}
public static void divProb(){
  int randomNumber1 = randomNum();
  int randomNumber2 = randomNum();
  System.out.println("What is "+randomNumber1+" / "+randomNumber2+"?");
  int guess = TextIO.getlnInt();
  int answer = randomNumber1 / randomNumber2;
  if (guess == answer) {
  System.out.println("Correct!");
  correct++;
}else {
  System.out.println("Incorrect!");
  System.out.println("The correct answer is " + answer);
}
}
public static void modProb(){
  int randomNumber1 = randomNum();
  int randomNumber2 = randomNum();
  System.out.println("What is "+randomNumber1+" % "+randomNumber2+"?");
  int guess = TextIO.getlnInt();
  int answer = randomNumber1 % randomNumber2;
  if (guess == answer) {
  System.out.println("Correct!");
  correct++;
}else {
  System.out.println("Incorrect!");
  System.out.println("The correct answer is " + answer);
}
}
public static void scoreCalc(){
  double percentageCorrect = correct * 20;
  System.out.println("You got " + correct + " correct answers.");
  System.out.println("That's a score of " + percentageCorrect + "%");
}
}

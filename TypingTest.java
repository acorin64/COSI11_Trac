import java.util.Scanner;

public class TypingTest {

  public static void main(String[] args) {
    startTypingTest(2);
  }

 public static String generateTestWords(int size) {
  String testString = "";
  String[] words = new String[] {"cat", "dog", "animal", "basketball", "pizza", "house", "desk", "elephant", "student", "mushroom", "banana", "spongebob", "zealous", "sheep", "aloof", "pneumonia"};
  for (int i = 0; i < size; i++) {
   int randomIndex = (int) (Math.random() * words.length);
   testString += words[randomIndex] + " ";
  }
  return testString;
 }

 // Method from https://stackoverflow.com/a/22186845
 public static double round (double value, int precision) {
     int scale = (int) Math.pow(10, precision);
     return (double) Math.round(value * scale) / scale;
 }

 public static void printStats(double totalSeconds, int testStringSize) {
   double wordsPerMinute = testStringSize / (totalSeconds / 60);
   double roundedTime = round(totalSeconds, 1);
   double roundedWpm = round(wordsPerMinute, 1);
   System.out.println("\nCORRECT! Here are your stats:\n---------");
   System.out.println("Total time: " + roundedTime + " seconds");
   System.out.println("WPM: " + roundedWpm);
 }

 public static void startTypingTest(int testStringSize) {
  String testString = generateTestWords(testStringSize);
  Scanner scanner = new Scanner(System.in);
  System.out.println("Press enter when you are ready. Once you press enter, a sequence of words will appears. Type them and press enter to calculate your typing speed.");
  scanner.nextLine();
  System.out.println("Begin\n---------");
  long startTime = System.currentTimeMillis();
  System.out.println(testString);
  testString = testString.trim();
  String input = scanner.nextLine();
  while (!input.equals(testString)) {
   System.out.println("Incorrect. Try again");
   System.out.println(testString);
   startTime = System.currentTimeMillis();
   input = scanner.nextLine();
  }

  long endTime = System.currentTimeMillis();
  double totalSeconds = (endTime - startTime) / 1000;

  printStats(totalSeconds, testStringSize);
  scanner.close();
 }
}

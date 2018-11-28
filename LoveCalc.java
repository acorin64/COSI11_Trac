public class LoveCalc {
  public static void main(String args[]){
    int sum = 0;
    System.out.println("What's your name?");
    String name1 = TextIO.getlnString();
    char[] name1AR = new char[10];
    for (int i = 0; i<name1.length(); i++) {
      name1AR[i] = name1.charAt(i);
    }
    System.out.println("What's your boos name?");
    String name2 = TextIO.getlnString();
    char[] name2AR = new char[10];
    for (int i = 0; i<name2.length(); i++) {
      name2AR[i] = name2.charAt(i);
    }
    for (int i = 0; i<10; i++) {
      if (name1AR[i] == name2AR[i] && name1AR[i] != '\u0000'){
        sum++;
      }
    }

    String love = "";

    if (sum == 0){
      love = "0%";
    } else if (sum == 1){
      love = "20%";
    } else if (sum == 2){
       love = "40%";
    } else if (sum == 3){
       love = "60%";
    } else if (sum == 4){
       love = "80%";
    } else if (sum >= 5){
       love = "100%";
    } else {
      System.out.println("You might wanna find a new boo!");
    }

    System.out.println("You are " + love + " compatible with your boo!" );
  }
}

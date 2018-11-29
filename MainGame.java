import java.util.Scanner;

public class MainGame {
  public static void playTTT() {  //This method is the Tic Tac Toe game
    GameMethod.emptyBoard();
    GameMethod.welcomePlayer();
    GameMethod.printBoard();
    playingTTT: while (true) {//main loop in which game is played (playingTTT)
      System.out.printf("Player %s, please enter your move: %n", Static.playerSymbol);
      int move = TextIO.getlnInt(); //gets each player's move
      boolean validMove = GameMethod.moveCheck(move);
      if (validMove) { Static.usedMoves[move-1] = 1;
      } else {
        System.out.println("That is not a valid move.");
        continue playingTTT;
      }
      GameMethod.updateBoard(move);  //updates the game board status
      GameMethod.printBoard();       //prints the new game board status
      GameMethod.switchPlayer();     //switches the current player/symbol
      Static.gameWon = GameMethod.checkForWin();   //checks to see if a player has won
      GameMethod.checkForTie();
      if (Static.gameWon || Static.tie) break playingTTT;
    } //end of playingTTT
    GameMethod.announceWinner();
    GameMethod.replayTTT();
  } //end of playTTT

  public static void mathQuiz() {
    System.out.println("Hey there! Please answer the following questions: ");
    GameMethod.addProb();
    GameMethod.subProb();
    GameMethod.multProb();
    GameMethod.divProb();
    GameMethod.modProb();
    GameMethod.scoreCalc();
    resetStatics();
  }

  public static void loveCalc() {
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

    GameMethod.loveTest(sum);

    System.out.println("You are " + Static.
    love + " compatible with your boo!" );

    resetStatics();
  } //end of loveCalc

  public static void wordQuiz() {
    System.out.println("Hey There! Please answer the following questions with one word: ");
    int q1 = GameMethod.randomNum10();
    int q2 = GameMethod.randomNum10();
    boolean same = false;
    if (q1 == q2) { same = true; }
    while (same) {
      q2 = GameMethod.randomNum10();
      if (q1 != q2) { same = false; }
    }
    int q3 = GameMethod.randomNum10();
    if (q3 == q1 || q3 == q2) { same = true; }
    while (same){
      q3 = GameMethod.randomNum10();
      if (q3 != q1 && q3 != q2) { same = false; }
    }
    GameMethod.selectQ(q1);
    GameMethod.selectQ(q2);
    GameMethod.selectQ(q3);
    GameMethod.quizScoreCalc();

    resetStatics();
  }

  public static void adventureGame() {
    String choice = "";
    //intro
    System.out.println("Welcome to your adventure. Make your choice by typing in any word indicated 'like this'.");
    System.out.println(" ");
    //choice 1
    System.out.println("You are laying on your bed listening to music. The all powerful ZEO appears, and offers you the choice to 'join' him on an adventure, or 'stay' home.");
    System.out.print("> ");
    choice = TextIO.getlnWord();
    if (choice.equals("stay")) {
      return;
    } else if (choice.equals("join")) {
      //choice 2
      System.out.println("ZEO conjurs a door and you both step through it. Once through the door, you find yourself facing an old ladder. Do you 'climb' it or 'continue' forward?");
      System.out.print("> ");
      choice = TextIO.getlnWord();
      if (choice.equals("climb")) {
        System.out.println("You get 20 feet up when one of the old ladder rungs breaks. You fall backwards and land back on your bed in your room.");
        return;
      } else if (choice.equals("continue")) {
        //choice 3
        System.out.println("ZEO leads you past the ladder. Once you've finished discussing what might have been at the top, you realize that you've wandered onto a forest path. In the middle of the path there is a tree with a door in its trunk. Do you 'knock' on the door or 'walk' past the tree?");
        System.out.print("> ");
        choice = TextIO.getlnWord();
        if (choice.equals("walk")) {
          System.out.println("You find a dead end on the path, the brush too thick to walk through. ZEO snaps his fingers and you find yourself back home, Drake still blaring loudly from your speakers.");
          return;
        } else if (choice.equals("knock")) {
          //choice 4
          System.out.println("A squirrel answers the door, looking none too happy to have been disturbed. She bares her teeth at you and grows to ten times her original size. Do you 'run' or attempt to 'fight'?");
          System.out.print("> ");
          choice = TextIO.getlnWord();
          if (choice.equals("fight")) {
            System.out.println("The squirrel bats you with its massive tail, sending you flying through the air. You land back in your room, and hear your mom knocking on the door. You answer and she tells you to come downstairs, dinner's ready.");
            return;
          } else if (choice.equals("run")) {
            //choice 5
            System.out.println("You escape the squirrel after a lengthy chase, finding yourself on the shore of a large lake.  There is a rowboat with two oars sitting right next to the water line. Do you 'launch' the rowboat into the lake or 'lay' down on the beach and try to catch a tan?");
            System.out.print("> ");
            choice = TextIO.getlnWord();
            if (choice.equals("lay")) {
              System.out.println("You fall asleep while tanning and wake up back in your bed. Your mom is frantically knocking on your door. You overslept, youre late for school.");
              return;
            } else if (choice.equals("launch")) {
              //choice 6
              System.out.println("You row the boat until you find an island in the center of the lake. You land the boat on the island, but find a warning sign telling you to turn around. Do you heed its advice and 'launch' the boat back into the lake or do you 'explore' the island?");
              System.out.print("> ");
              choice = TextIO.getlnWord();
              if (choice.equals("launch")) {
                System.out.println("Your boat pops a hole and sinks, you swim to shore and ZEO teleports you back home.");
                return;
              } else if (choice.equals("explore")) {
                //choice 7
                System.out.println("You wander up into the trees on the island, eventually finding a large castle placed in a clearing. Do you want to 'enter' the castle or 'swim' in the moat?");
                System.out.print("> ");
                choice = TextIO.getlnWord();
                if (choice.equals("enter")) {
                  System.out.println("You fail to account for the castle's defenses, and you fall through a trap door, landing back in your room, you need to do your laundry.");
                  return;
                } else if (choice.equals("swim")) {
                  //choice 8
                  System.out.println("You swim in the moat, making it around to the back of the castle. You climb out of the moat and notice a peculiar mushroom growing on the ground. ZEO suggests that you eat it. Do you follow his advice and 'eat' the mushroom or do you 'leave' it be and get back in the moat?");
                  System.out.print("> ");
                  choice = TextIO.getlnWord();
                  if (choice.equals("leave")) {
                    System.out.println("You swim back around the moat, and climb out of the water. ZEO is furious you have ignored his advice and teleports you back to your room.");
                    return;
                  } else if (choice.equals("eat")) {
                    //choice 9
                    System.out.println("The Mushroom turns out to be from the popular video game Mario, and you become significantly larger. With your newfound height, you could climb the castle walls. Do you 'climb' or do you continue to 'swim' in the moat?");
                    System.out.print("> ");
                    choice = TextIO.getlnWord();
                    if (choice.equals("swim")) {
                      System.out.println("Your new size decreases your coordination, negating your ability to swim. You sink to the bottom of the moat and regret not taking extra swim lessons. You then find yourself back in your room, you need to shower.");
                      return;
                    } else if (choice.equals("climb")) {
                      //choice 10
                      System.out.println("You reach the top of the wall with relative ease, using the worn down masonry as hand and footholds. After climbing over the battlements, you discover that the castle is full of rare stones. As you eye a particularly large diamond, ZEO warns you not to touch anything. Do you 'listen' to him or do you 'take' the diamond anyways?");
                      System.out.print("> ");
                      choice = TextIO.getlnWord();
                      if (choice.equals("listen")) {
                        System.out.println("You walk past the stones and further into the castle. As you open one of the doors, you walk right back into your room from home. Your phone reconnects to your bluetooth speaker and you sing along to your playlist while dreaming about the diamond you left in the castle.");
                        return;
                      } else if (choice.equals("take")) {
                        //choice 11
                        System.out.println("You pocket a diamond, and ZEO nods, showing respect for your boldness. As you continue through the castle, you find a door with a keyhole the same shape as the diamond you just found. Do you 'insert' the diamond into the keyhole, or do you try to 'pick' the lock?");
                        System.out.print("> ");
                        choice = TextIO.getlnWord();
                        if (choice.equals("pick")) {
                          System.out.println("The lockpicking skills your friend James taught you in seventh grade prove insufficient. The door does not open, and ZEO cannot help you, he instead returns you home to your mother, who is wondring where you have been.");
                          return;
                        } else if (choice.equals("insert")) {
                          //choice 12
                          System.out.println("The lock clicks, and you open the door. ZEO walks past you and leans on the table in the center of the room. He notes that there are two things on the table, a small 'portrait' and a 'sack' of money. Which do you take?");
                          System.out.print("> ");
                          choice = TextIO.getlnWord();
                          if (choice.equals("sack")) {
                            System.out.println("When you take the sack of money to the bank, you discover that it is entirely counterfeit. You have lost.");
                            return;
                          } else if (choice.equals("portrait")) {
                            System.out.println("It turns out that unassuming portrait was the Mona Lisa. You return it to the Louvre and are rewarded handsomely for your troubles. You have won.");
                            return;
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }

  public static void playRPS() {
    //introduction, menu, and choosing your han
    System.out.println("Welcome to Rock, Paper, Scissors!");
    System.out.println("Choose your hand (type 1, 2, or 3):");
    System.out.println("1. Rock");
    System.out.println("2. Paper");
    System.out.println("3. Scissors");
    Static.yourHand = TextIO.getlnInt(); //this is the player's choice of hand
    while (true) { //processing and confirming which hand you chose
      if (Static.yourHand == 1) {
        Static.playerHand = "Rock";
        break;
      } else if (Static.yourHand == 2) {
        Static.playerHand = "Paper";
        break;
      } else if (Static.yourHand == 3) {
        Static.playerHand = "Scissors";
        break;
      } else {
        System.out.println("You didn't choose one of the options!");
        System.out.println("Choose another option:");
        Static.yourHand = TextIO.getlnInt();
      }
    }
    System.out.println("You choose "+Static.playerHand);
    GameMethod.chooseCH(); //choosing computers hand
    GameMethod.findWinnerRPS(); //deciding and announcing who won
    GameMethod.playRPSAgain(); //ask if you will play again
  } //end of playRPS

  public static void hangmanMain() {
    Scanner sc = new Scanner(System.in);
    while (Static.count < 7 && Static.Underscore.contains("_")) { //loop to continue until loss or win
      System.out.println("Guess any letter in the word");  //ask user for a letter
      System.out.println(Static.Underscore); //prints out how many letters there are in asteriks
      int numLetters = Static.word.length();
      System.out.println("there are "+ numLetters + " letters in the word. Good Luck!");
      //ask for the guess - input is here
      String guess = sc.next();
      GameMethod.hang(guess);//uses hang method with guess
		}	//closes loop
		sc.close(); // here

    resetStatics();
	}

  public static void resetStatics() {
    Static.mathCorrect = 0;  //MathQuiz
    Static.love = ""; //loveCalc
    Static.wordCorrect = 0;  //wordQuiz
    Static.computerHand = 0; //RPS
    Static.compHand = ""; //RPS
    Static.yourHand = 0; //RPS
    Static.playerHand = ""; //RPS
  	Static.word = Static.words[(int) (Math.random() * Static.words.length)]; //hangman
  	Static.Underscore = new String(new char[Static.word.length()]).replace("\0", "_"); //hangman
  	Static.count = 0; //hangman
  }

  public static void startTypingTest(int testStringSize, Scanner scanner) {
   String testString = GameMethod.generateTestWords(testStringSize);
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

   GameMethod.printStats(totalSeconds, testStringSize);
  }


} //end of MainGame

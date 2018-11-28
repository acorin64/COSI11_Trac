//This game is a choose your own adventure text based game. With each choice, the player can either correctly choose their path, or make an incoorect choice, ending the game. 
public class Adventure {
  public static void main( String[] args ){
    adventureGame();
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
                          } else if (choice.equals("portrait")) {
                            System.out.println("It turns out that unassuming portrait was the Mona Lisa. You return it to the Louvre and are rewarded handsomely for your troubles. You have won.");
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
}

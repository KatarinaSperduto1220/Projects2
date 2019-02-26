//Katarina Sperduto
// Some extra info about the theme is located in the comments on the bottom (in case you are interested)

import java.util.*;

public class GameProject{
  static Character c;
  static Scanner s;

  public static void goToTheed(){
    int num = 0;
// loop for the town menu
    while(num != 4 && c.isDead(c.getHp())== false){

      System.out.println("\n" + "Welcome to Theed " + c.getName()+ " What would you like to do today?" + "\n");
      System.out.println("Type 1 to Go to the planet Muunilinst" + '\n' + "Type 2 to Go to the Market" + '\n'+ "Type 3 to Go to the Temple" + '\n' + "Type 4 to Quit" + '\n');
      int num4 = s.nextInt();
      num = num4;
      s.nextLine();
      // if the user chooses to go to the forest
      if (num == 1){
        System.out.println('\n' + c.getName() + " you have chosen to Go to the planet Muunilinst" + '\n');
        goToMuunilinst();
      }
      // if the user chooses to go to the shop
      else if (num == 2){
        System.out.println('\n' + c.getName() + " you have chosen to Go to the Market" + '\n');
        goToTheMarket();
      }
      // if the user chooses to go to the tavern
      else if (num == 3){
        System.out.println('\n' + c.getName() + " you have chosen to Go to the Temple" + '\n');
        goToTheTemple();
      }
      // of the user chooses to quit
      else if (num == 4){
        System.out.println('\n' + c.getName() + " you have chosen to Quit. Have a good day!" + '\n');
      }
      // if the user types a number other then 1,2,3,or 4
      else{
        System.out.println('\n' + c.getName() + " please pick where you would like to go. Only pick numbers 1 through 4" + '\n');
      }
    }

    // if the user is dead
    if (c.getHp()<= 0){
      System.out.println('\n' + "Sorry " + c.getName() + " it seems you have Died." + '\n');
    }
  }

  // method for choosing to fight in the forest
  public static void goToMuunilinst(){
    String[] monsters= {"11-4D", "Darth Maul", "Sheev Palpatine"};
    Random mNum = new Random();
    String monster =  monsters[mNum.nextInt(3)];
    int monsterHp = 4;

    System.out.println(" You will be facing "+ monster + '\n');

      while (monsterHp > 0 && c.getHp() > 0) {


        System.out.println("What you would like to do! Fight, Heal, or Run");
        String choice = s.nextLine();

      if(choice.equals("Fight")||choice.equals("fight")){
        if(Math.random()<= .8){
          monsterHp -= 1;
          System.out.println("You have caused damage to " + monster);
          System.out.println("Your Hp: " + c.getHp());
          System.out.println( monster + " Hp: " + monsterHp );
        }
        else{
          c.setHp(c.getHp()-1);
          System.out.println("OH NO! " + c.getName() + " you got hit by "+ monster);
          System.out.println("Your Hp: " + c.getHp());
          System.out.println( monster + " Hp: " + monsterHp );
        }
        }
      else if(choice.equals("Heal")|| choice.equals("heal")){
        if (c.getPotions() > 0 && c.getHp() < c.getMaxHp()){
          if (c.getHp()+ 8 > c.getMaxHp()){
            int healingAmount = c.getMaxHp() - c.getHp();
            c.setHp(c.getHp() + healingAmount);
            System.out.println(c.getName() + " you are back up to Max Hp");
          }
          else{
            c.setHp(c.getHp() + 8) ;
            System.out.println(c.getName() + " your HP is now " + c.getHp());
          }
        }
        else{
          if (c.getPotions() == 0 && c.getHp() > 0){
            System.out.println(c.getName() + " you don't have any force energy to heal yourself" +'\n');
            }
          else{
            System.out.println('\n' + "Sorry " + c.getName() + ", it seems you have Died." + '\n');
          }
        }
      }
      else{
        System.out.println(c.getName() +" you have choosen to fly back to Theed");
        break;
      }
    }

    if (monsterHp == 0) {
      c.setXp(c.getXp() + 10);
      System.out.println("CONGRADULATIONS " + c.getName() + " You have successfully defeated " + monster + " You now have " + c.getXp() + " XP. Time to head back to Theed" );
      c.setXp(c.getXp() + 10);
    }
    if (c.getHp() <= 0){
      System.out.println('\n' + "Sorry " + c.getName() + ", it seems you have Died." + '\n');
        }
      }


  // method for choosing to go to town
  public static void goToTheMarket(){
    System.out.println("The Market is closed " +c.getName() +". Please try again later.");
  }

  //method for going to the tavern
  public static void goToTheTemple(){
    System.out.println( c.getName() + " An interesting thing has happened at the Temple! I'll tell you about it later");
  }

  // main method
  public static void main (String [] args){
      s = new Scanner(System.in);
      System.out.println("A long time ago, in a Galaxy far far away, a darkness began to consume all in its path. An Muun by the name of Hego Damask, CEO of Damask Holdings, has targeted Theed, the Capital city of Naboo, for the precious Plasma located beneath its surface. While it seemed wealth was the primary focus of this operation, A Young Jedi, who was sent to Naboo on a mission, received some important information. In the western sea of the planet Muunilinst, is an island known as Aborah. It is believed that Aborah is the location of Demask's home and main research facility. However, the journey there is long and filled with many obstacles and dangers.  " + "\n");

      System.out.println("Young Jedi, what is thy name?" );
      String n = s.nextLine();
      c = new Character(n);
      goToTheed();
       }
    }

    // Extra information:
    //   - Game Name: Stopping the Grand Plan
    //                 (aka execution of the Jedi Order)
    //   - Name of the Planet: Naboo
    //   - Villan: Hego Demask (otherwise know as Darth Plagueis)
    //             Species- Muun
    //             CEO of Damask Holdings and Great influence with the Banking Clan and Trade Federation (the Muuns have all the Credits)
    //   - Lair: Location - Aborah (an island located in the western sea of Muunilinst (Plagueis's home world))
    //           Holds all of his research for execution of the grand plan as well as his experiments (used while he learned about and manipulated Midi-Chlorians)
    //   - Town: Theed (capital city of Naboo)
    //           Targeted for its Plasma located beneith the surface
    //           Palpatine's Home world (where Plagueis found and turned him)
    //   - Dangers(monsters): 11-4D : Plagueis's droid
    //                       Sheev Palpatine: Plagueis's Apprentace in disguise (politition)
    //                       Darth Maul: Palpatines apprentace which Plagueis used as a tool
    //

//Katarina Sperduto
// Some extra info about the theme is located in the comments on the bottom (in case you are interested)

import java.util.*;

public class GameProject{
  static Character c;
  static Scanner s;

  public static void goToTheed(){
    int num = 0;
// loop for the town menu
    while(num != 6 && c.isDead(c.getHp())== false){

      System.out.println("\n" + "Welcome to Theed " + c.getName() + '\n');
      System.out.println("Your Current Stats are as follows: " +'\n'+ "Level: "+c.getLevel()+'\n'+ "HP: " +c.getHp() +" (MaxHp: " +c.getMaxHp()+")"+'\n' +"XP: "+ c.getXp() +'\n'+"Credits: "+ c.getCredits() +'\n'+ "Jogan Fruit: " + c.getJoganFruit() +'\n');
      System.out.println(" What would you like to do today?" + "\n");
      System.out.println("Type 1 to Go to the planet Muunilinst" + '\n' +"Type 2 to Face the Sith Lord" + '\n'+ "Type 3 to Go to the Market" + '\n'+ "Type 4 to Go to the Cantina" + '\n' + "Type 5 to Go to the Temple " + '\n' + "Type 6 to Quit" + '\n');
      int num4 = s.nextInt();
      num = num4;
      s.nextLine();
      // if the user chooses to go to the forest
      if (num == 1){
        System.out.println('\n' + c.getName() + " you have chosen to Go to the planet Muunilinst" + '\n');
        goToMuunilinst();
      }
      // if the user chooses to fight darth Plagueis
      else if (num ==2){
        System.out.println('\n' + c.getName()+ "  you have chosen to face the Sith Lord Darth Palgueis" + '\n');
        fightDarthPlagueis();
      }
      // if the user chooses to go to the shop
      else if (num == 3){
        System.out.println('\n' + c.getName() + " you have chosen to Go to the Market" + '\n');
        goToTheMarket();
      }
      // if the user chooses to go to the tavern
      else if (num == 4){
        System.out.println('\n' + c.getName() + " you have chosen to Go to the Cantina" + '\n');
        goToTheCantina();
      }
      // if user wants to go to the Healing Shrine
      else if (num == 5){
        System.out.println('\n' + c.getName() + " you have chosen to Go to the Temple" + '\n');
        goToTheTemple();
      }
      // of the user chooses to quit
      else if (num == 6){
        System.out.println('\n' + c.getName() + " you have chosen to Quit. Have a good day!" + '\n');
      }
      // if the user types a number other then 1,2,3,or 4
      else{
        System.out.println('\n' + c.getName() + " please pick where you would like to go. Only pick numbers 1 through 6" + '\n');
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
        if (c.getJoganFruit() > 0 && c.getHp() < c.getMaxHp()){
          if (c.getHp()+ 8 > c.getMaxHp()){
            int healingAmount = c.getMaxHp() - c.getHp();
            c.setHp(c.getHp() + healingAmount);
            c.setJoganFruit(c.getJoganFruit() - 1);
            System.out.println(c.getName() + " you are back up to Max Hp"+ " You have " + c.getJoganFruit()+ " Jogan Fruit left.");
            System.out.println("Your Hp: " + c.getHp());
            System.out.println( monster + " Hp: " + monsterHp );
          }
          else{
            c.setHp(c.getHp() + 8) ;
            c.setJoganFruit(c.getJoganFruit() - 1);
            System.out.println(c.getName() + " your HP is now " + c.getHp()+ " You have " + c.getJoganFruit()+ " Jogan Fruit left.");
            System.out.println("Your Hp: " + c.getHp());
            System.out.println( monster + " Hp: " + monsterHp );
          }
        }
        else{
          if (c.getJoganFruit() == 0 && c.getHp() > 0){
            System.out.println(c.getName() + " you don't have any Jogan Fruit to heal yourself" +'\n');
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
      System.out.println('\n' + "CONGRADULATIONS " + c.getName() + " You have successfully defeated " + monster + " You now have " + c.getXp() + " XP. Time to head back to Theed" );
      levelUp();
    }
    if (c.getHp() <= 0){
      System.out.println('\n' + "Sorry " + c.getName() + ", it seems you have Died." + '\n');
        }
      }


  //  method for fighting the boss
  public static void fightDarthPlagueis(){
    int darthPlagueisHp = 80;
    System.out.println("After months of searching you have finally found the information you have been searching for! Hego Demask is not just the CEO of Damask holdings, but is actually the Sith Lord, Darth Plagueis, in disguise! You have heards rumors about the Sith however you have never seen nor fought one. This is a battle to the death. Are you sure you would like to continue?");
    String decision = s.nextLine();

    if(decision.equals("yes") || decision.equals("Yes")){
      System.out.println("It is time for the ultimate test! Defeat Plagueis to save Theed. Remember Do or Do Not, There is no Try! Good Luck " + c.getName()+ " and May the Force be with You!");

      while (darthPlagueisHp > 0 && c.getHp() > 0) {
        System.out.println("What you would like to do! Fight or Heal");
        String choice = s.nextLine();

      if(choice.equals("Fight")||choice.equals("fight")){
        if(Math.random()<= .6){
          darthPlagueisHp -= 1;
          System.out.println("You have caused damage to Darth Plagueis");
          System.out.println("Your Hp: " + c.getHp());
          System.out.println( "Plagueis Hp: " + darthPlagueisHp );
        }
        else{
          c.setHp(c.getHp()-1);
          System.out.println("OH NO! " + c.getName() + " you got hit by Darth Palgueis");
          System.out.println("Your Hp: " + c.getHp());
          System.out.println("Plagueis Hp: " + darthPlagueisHp );
        }
        }
      else if(choice.equals("Heal")|| choice.equals("heal")){
        if (c.getJoganFruit() > 0 && c.getHp() < c.getMaxHp()){
          if (c.getHp()+ 8 > c.getMaxHp()){
            int healingAmount = c.getMaxHp() - c.getHp();
            c.setHp(c.getHp() + healingAmount);
            c.setJoganFruit(c.getJoganFruit() - 1);
            System.out.println(c.getName() + " you are back up to Max Hp" + " You have " + c.getJoganFruit()+ " Jogan Fruit left.");
            System.out.println("Your Hp: " + c.getHp());
            System.out.println("Plagueis Hp: " + darthPlagueisHp );
          }
          else{
            c.setHp(c.getHp() + 8) ;
            c.setJoganFruit(c.getJoganFruit() - 1);
            System.out.println(c.getName() + " your HP is now " + c.getHp()+ " You have " + c.getJoganFruit()+ " Jogan Fruit left.");
            System.out.println("Your Hp: " + c.getHp());
            System.out.println("Plagueis Hp: " + darthPlagueisHp );
          }
        }
      else{
        if (c.getJoganFruit() == 0 && c.getHp() > 0){
          System.out.println(c.getName() + " you don't have any Jogan Fruit to heal yourself" +'\n');
          }
        else{
          System.out.println('\n' + "Sorry " + c.getName() + ", it seems you have Died." + '\n');
        }
      }
    }
  }
  if (darthPlagueisHp == 0) {
    c.setXp(c.getXp() + 10);
    System.out.println('\n' + "CONGRADULATIONS " + c.getName() + " You have successfully defeated Darth Plagueis and Saved Theed! The citizens are eternally greatful for your help!");
  }
  if (c.getHp() <= 0){
    System.out.println('\n' + "Sorry " + c.getName() + ", it seems you may have taken on the Sith Lord too soon. However, You will be remebered for your courageous effort." + '\n');
      }
    }
  else{
      System.out.println("Don't worry "+c.getName()+ " you'll get to face him soon enough!");
    }
}

  // method for choosing to go to town
  public static void goToTheMarket(){
    System.out.println("Welcome to the Market! There is a sale on Jogan Fruit for 20 credits each" + '\n'+ "Would you like to purchase any? ");
    String purchase = s.nextLine();
    if (purchase.equals("yes")||purchase.equals("Yes")){
      if (c.getCredits() > 0){
        System.out.println('\n'+ "How many would you like to purchase? ");
        int number = s.nextInt();
        s.nextLine();
        if (number*20 <= c.getCredits()){
          c.setJoganFruit(c.getJoganFruit()+ number);
          int amount = number *20;
          c.setCredits(c.getCredits()- amount);
          System.out.println(" You now have "+ c.getJoganFruit()+ " Jogan fruit, and "+ c.getCredits()+ " credits remaining");

        }
        else{
          System.out.println("Sorry you don't have enough credits to purchase that many"+ '\n'+ "Would you like to purchase a different amount?");
          String yOrN = s.nextLine();
          if (yOrN.equals("yes")||yOrN.equals("Yes")){
            goToTheMarket();
          }
          else if (yOrN.equals("no")||yOrN.equals("No")){

          }
          // else {
          //   System.out.println("Please Type either yes or no" + '\n');
          //   String y = s.nextLine();
          //   yOrN = y;
          // }
        }
      }
        else{
          System.out.println("Sorry " + c.getName() + " you don't seem to have any credits. Try again later");

        }
      }
    else if (purchase.equals("no")||purchase.equals("No")){

    }
    // else{
    //   System.out.println("Please type either yes or no");
    // }
  }

  //method for going to the tavern
  public static void goToTheCantina(){
    System.out.println( c.getName() + " An interesting thing has happened at the Cantina! I'll tell you about it later");
  }

  //method fro healing Shrine
  public static void goToTheTemple(){
    System.out.println("Meditaiton is one of the best recovery methods. However there is a fee dependent on how long your meditiation is."+ '\n'+"Would you like to continue?");
    String med = s.nextLine();
    if(med.equals("yes")||med.equals("Yes")){
      if (c.getCredits() > 0){
      System.out.println('\n'+"Each minute of meditiation cost 10 credits and heals 1 hp. " + '\n' + "You have a maximum of 10 minutes. How long would you like to meditate for?");
      int length = s.nextInt();
      s.nextLine();
          if (length <= 10 && length*10 <= c.getCredits()){
            if (c.getHp()+length <= c.getMaxHp()){
              c.setHp(c.getHp()+ length);
              c.setCredits(c.getCredits()-length*10);
              System.out.println(" You now have "+ c.getHp()+ " Hp, and "+ c.getCredits()+ " credits remaining");
            }
            else if (c.getHp()+length > c.getMaxHp()){
              int len = c.getMaxHp() - c.getHp();
              c.setHp(c.getMaxHp());
              c.setCredits(c.getCredits()-len*10);
              if (len > 0){
              System.out.println("It seems you have arrived late and the temple is only open for " + len + "more minutes. Meditation for that time will be plenty.");
              System.out.println("You now have "+ c.getHp()+ " which is MaxHp, and "+ c.getCredits()+ " credits remaining");

              }
              else if (len == 0){
                System.out.println("You are at Max Hp and have no need for meditiation.");
              }
            else if (length > 10){
              System.out.println("You can have a maxmimum of 10 minuets. How long would you like to meditiate for?");
              int l = s.nextInt();
              s.nextLine();
              length = l;

            }
            else{
              System.out.println("Sorry you don't have enough credits to meditate that long"+ '\n'+ "Would you like to mediatate for a shorter amount of time?");
              String yN = s.nextLine();
              if (yN.equals("yes")||yN.equals("Yes")){
                goToTheTemple();
              }
              else if (yN.equals("no")||yN.equals("No")){
              }
            //   else {
            //     System.out.println("Please Type either yes or no");
            //     String yn = s.nextLine();
            //     med = yn;
            // }
          }
        }
      }
    }
          else{
            System.out.println("Sorry " + c.getName() + " you don't seem to have any credits. Try again later");
            goToTheed();
          }
        }
    if (med.equals("no")||med.equals("No")){
        goToTheed();
      }
      // else{
      //   System.out.println("Please type either yes or no");
      //   String yesno = s.nextLine();
      //   med = yesno;
      // }
    }


  //method for Level up
  public static void levelUp(){
    int level = c.getLevel();
    int exponent = level - 1;
    int power = (int) Math.pow(2, exponent);
    int qualificationNum = 10 * power;
    if (c.getXp() == qualificationNum ){
      c.setLevel(c.getLevel() + 1);
      System.out.println('\n'+ "CONGRADULATIONS! You have earned right to move up to level " + c.getLevel());
      c.setMaxHp(c.getMaxHp() + 10);
    }
  }

  // main method
  public static void main (String [] args){
      s = new Scanner(System.in);
      System.out.println("A long time ago, in a Galaxy far far away, a darkness began to consume all in its path. An Muun by the name of Hego Damask, CEO of Damask Holdings, has targeted Theed, the Capital city of Naboo, for the precious Plasma located beneath its surface. While it seemed wealth was the primary focus of this operation, A Young Jedi, who was sent to Naboo on a mission, received some important information. In the western sea of the planet Muunilinst, is an island known as Aborah. It is believed that Aborah is the location of Demask's home and main research facility. However, the journey there is long and filled with many obstacles and dangers." + "\n");

      System.out.println("Young Jedi, what is thy name?" );
      String n = s.nextLine();
      c = new Character(n);

      System.out.println( '\n' +c.getName() +" Theed has some local areas which may be useful to you during your misson. There is an old Jedi Temple locted near by where you can meditate and recover, The market has one of your favorite fruits in the Galaxy, Jogan Fruit! When eaten during a battle it can help recover Hp, and the Cantina is just a fun place to hang." + '\n');
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

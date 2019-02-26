//Katarina Sperduto
// Some extra info about the theme is located in the comments on the bottom (in case you are interested)

import java.util.*;

public class GameProject{
  static Character c;
  static Monster m;
  static Weapon w;
  static Armor a;
  static Scanner s;

  public static void goToTheed(){
    int num = 0;
// loop for the town menu
    while(num != 6 && c.isDead(c.getHp())== false){

      System.out.println("\n" + "Welcome to Theed " + c.getName() + '\n');
      System.out.println("Your Current Stats are as follows: " +'\n'+ "Level: "+c.getLevel()+'\n'+"Damage per Hit: "+c.getDamage() +'\n'+ "HP: " +c.getHp() +" (MaxHp: " +c.getMaxHp()+")"+'\n' +"XP: "+ c.getXp() +'\n'+"Credits: "+ c.getCredits());
      System.out.println("Jogan Fruit: " + c.getJoganFruit() +'\n'+ "Weapon: " + c.w.weapon + '\n' + "Armor: " + c.a.armor+'\n');
      System.out.println("What would you like to do today?" + "\n");
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
    String turn = c.getName();
    String[] monsters= {"11-4D", "Darth Maul", "Sheev Palpatine"};
    Random mNum = new Random();
    Monster m = new Monster(monsters[mNum.nextInt(3)]);


    System.out.println("You will be facing "+ m.getName() + " Whose Current Stats are as follows:");
    System.out.println("HP: "+ m.getMaxHp()+'\n'+ "Chance of hitting you: " +m.getChance()*100+"% " +'\n' + "Damage per hit: " + m.getDamage()+ '\n'+ "XP Value: "+m.getXp()+'\n'+ "Credits Dropped: " + m.getCredits()+ '\n' );

      while (m.getHp() > 0 && c.getHp() > 0) {


        System.out.println("What you would like to do! Fight, Heal, Use Weapon, or Run");
        String choice = s.nextLine();


        //conditions for fight
      if(choice.equals("Fight")||choice.equals("fight")){

        // conditions for fighting on your turn
        while(turn.equals(c.getName())){
          if(Math.random()<= .8){
            m.setHp(m.getHp()-c.getDamage());
            System.out.println("You have caused damage to " + m.getName());
            System.out.println("  Your Hp: " + c.getHp());
            System.out.println( "  "+m.getName() + " Hp: " + m.getHp() );
            turn = m.getName();
          }

          else{
            System.out.println("OH NO! " + c.getName() + " You Missed! ");
            System.out.println("  Your Hp: " + c.getHp());
            System.out.println( "  "+m.getName() + " Hp: " + m.getHp());
            turn = m.getName();

          }
        }

      // conditions for fighting monsters turn
      while(turn.equals(m.getName())){
        if(Math.random()<= m.getChance()){
          c.setHp(c.getHp()-m.getDamage());
          c.setHp(c.getHp()+ c.a.absorbtion);
          System.out.println("OH NO! " + c.getName() + " you got hit by "+ m.getName());
          System.out.println("  Your Hp: " + c.getHp());
          System.out.println( "  "+m.getName() + " Hp: " + m.getHp());
          turn = c.getName();
        }
        else{
          System.out.println("Phew! " + m.getName()+ " missed");
          System.out.println("  Your Hp: " + c.getHp());
          System.out.println("  "+ m.getName() + " Hp: " + m.getHp() );
          turn = c.getName();
          }
        }

      }
      // conditions for heal
      else if(choice.equals("Heal")|| choice.equals("heal")){
        if (c.getJoganFruit() > 0 && c.getHp() < c.getMaxHp()){

          // conditions for healing on your turn
          while(turn.equals(c.getName())){
            if (c.getHp()+ 8 > c.getMaxHp()){
              int healingAmount = c.getMaxHp() - c.getHp();
              c.setHp(c.getHp() + healingAmount);
              c.setJoganFruit(c.getJoganFruit() - 1);
              System.out.println(c.getName() + " you are back up to Max Hp"+ " You have " + c.getJoganFruit()+ " Jogan Fruit left.");
              System.out.println("  Your Hp: " + c.getHp());
              System.out.println( "  "+ m.getName() + " Hp: " + m.getHp() );
              turn = m.getName();
            }
            else{
              c.setHp(c.getHp() + 8) ;
              c.setJoganFruit(c.getJoganFruit() - 1);
              System.out.println(c.getName() + " your HP is now " + c.getHp()+ " You have " + c.getJoganFruit()+ " Jogan Fruit left.");
              System.out.println("  Your Hp: " + c.getHp());
              System.out.println( "  "+ m.getName() + " Hp: " + m.getHp() );
              turn = m.getName();
            }
          }

        //conditions for monsters turn
        while(turn.equals(m.getName())){
          if(Math.random()<= m.getChance()){
            c.setHp(c.getHp()-m.getDamage());
            c.setHp(c.getHp()+ c.a.absorbtion);
            System.out.println("OH NO! " + c.getName() + " you got hit by "+ m.getName());
            System.out.println("  Your Hp: " + c.getHp());
            System.out.println( "  "+m.getName() + " Hp: " + m.getHp());
            turn = c.getName();
          }
          else{
            System.out.println("Phew! " + m.getName()+ " missed");
            System.out.println("  Your Hp: " + c.getHp());
            System.out.println( "  " + m.getName() + " Hp: " + m.getHp() );
            turn = c.getName();
            }
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

      //condition for choosing to use a weapon
      else if(choice.equals("Use Weapon")||choice.equals("use weapon")){
        while(turn.equals(c.getName())){
          if(Math.random()<= .8){
            m.setHp(m.getHp()-c.w.getDamage());
            System.out.println(c.w.attackText);
            System.out.println("  Your Hp: " + c.getHp());
            System.out.println( "  "+m.getName() + " Hp: " + m.getHp() );
            turn = m.getName();
          }

          else{
            System.out.println("OH NO! " + c.getName() + " You Missed! ");
            System.out.println("  Your Hp: " + c.getHp());
            System.out.println( "  "+m.getName() + " Hp: " + m.getHp());
            turn = m.getName();

          }
        }

      // conditions for using your weapon monsters turn
      while(turn.equals(m.getName())){
        if(Math.random()<= m.getChance()){
          c.setHp(c.getHp()-m.getDamage());
          c.setHp(c.getHp()+ c.a.absorbtion);
          System.out.println("OH NO! " + c.getName() + " you got hit by "+ m.getName());
          System.out.println("  Your Hp: " + c.getHp());
          System.out.println( "  "+m.getName() + " Hp: " + m.getHp());
          turn = c.getName();
        }
        else{
          System.out.println("Phew! " + m.getName()+ " missed");
          System.out.println("  Your Hp: " + c.getHp());
          System.out.println("  "+ m.getName() + " Hp: " + m.getHp() );
          turn = c.getName();
          }
        }
      }

      //condition for choosing to run
      else if (choice.equals("Run")||choice.equals("run")){
        System.out.println(c.getName() +" you have choosen to fly back to Theed");
        break;
      }
      else{
        System.out.println("Please choose either to Fight, Heal, Use Weapon, or Run");
      }
    }

    if (m.getHp() <= 0) {
      c.setXp(c.getXp() + m.getXp());
      c.setCredits(c.getCredits() + m.getCredits());
      System.out.println('\n' + "CONGRADULATIONS " + c.getName() + " You have successfully defeated " + m.getName() + " You now have " + c.getXp() + " XP and " + c.getCredits() +" credits. Time to head back to Theed" );
      levelUp();
    }
    if (c.getHp() <= 0){
      System.out.println('\n' + "Sorry " + c.getName() + ", it seems you have Died." + '\n');
        }
      }


  //  method for fighting the boss
  public static void fightDarthPlagueis(){
    String turn = c.getName();
    int darthPlagueisHp = 80;
    int darthPlagueisDamage = 8;
    System.out.println("After months of searching you have finally found the information you have been searching for! Hego Demask is not just the CEO of Damask holdings, but is actually the Sith Lord, Darth Plagueis, in disguise! You have heards rumors about the Sith however you have never seen nor fought one. This is a battle to the death. Are you sure you would like to continue?");
    String decision = s.nextLine();

    if(decision.equals("yes") || decision.equals("Yes")){
      System.out.println("It is time for the ultimate test! Defeat Plagueis to save Theed. Remember Do or Do Not, There is no Try! Good Luck " + c.getName()+ " and May the Force be with You!");

      while (darthPlagueisHp > 0 && c.getHp() > 0) {
        System.out.println("What you would like to do! Fight, Use Weapon, or Heal");
        String choice = s.nextLine();
        if(choice.equals("Fight")||choice.equals("fight")){

          // conditions for fighting on your turn
          while(turn.equals(c.getName())){
            if(Math.random()<= .7){
              darthPlagueisHp -= c.getDamage();
              System.out.println("You have caused damage to Darth Plagueis");
              System.out.println("  Your Hp: " + c.getHp());
              System.out.println( "   Darth Palgueis Hp: " + darthPlagueisHp );
              turn = "plagueis";
            }

            else{
              System.out.println("OH NO! " + c.getName() + " You Missed! ");
              System.out.println("  Your Hp: " + c.getHp());
              System.out.println( "   Darth Palgueis Hp: " + darthPlagueisHp );
              turn = "plagueis";

            }
          }

        // conditions for fighting monsters turn
        while(turn.equals("plagueis")){
          if(Math.random()<= .8){
            c.setHp(c.getHp()-darthPlagueisDamage);
            c.setHp(c.getHp()+ c.a.absorbtion);
            System.out.println("OH NO! " + c.getName() + " you got hit by Darth Plagueis");
            System.out.println("  Your Hp: " + c.getHp());
            System.out.println( "   Darth Palgueis Hp: " + darthPlagueisHp );
            turn = c.getName();
          }
          else{
            System.out.println("Phew! Darth Plagueis missed");
            System.out.println("  Your Hp: " + c.getHp());
            System.out.println( "   Darth Palgueis Hp: " + darthPlagueisHp );
            turn = c.getName();
            }
          }

        }

        else if(choice.equals("Use Weapon")||choice.equals("use weapon")){
          while(turn.equals(c.getName())){
            if(Math.random()<= .7){
              darthPlagueisHp -= c.w.getDamage();
              System.out.println(c.w.attackText);
              System.out.println("You have caused damage to Darth Plagueis");
              System.out.println("  Your Hp: " + c.getHp());
              System.out.println( "   Darth Palgueis Hp: " + darthPlagueisHp );
              turn = "plagueis";
            }

            else{
              System.out.println("OH NO! " + c.getName() + " You Missed! ");
              System.out.println("  Your Hp: " + c.getHp());
              System.out.println( "   Darth Palgueis Hp: " + darthPlagueisHp );
              turn = "plagueis";

            }
          }

        // conditions for fighting monsters turn
        while(turn.equals("plagueis")){
          if(Math.random()<= .8){
            c.setHp(c.getHp()-darthPlagueisDamage);
            c.setHp(c.getHp()+ c.a.absorbtion);
            System.out.println("OH NO! " + c.getName() + " you got hit by Darth Plagueis");
            System.out.println("  Your Hp: " + c.getHp());
            System.out.println( "   Darth Palgueis Hp: " + darthPlagueisHp );
            turn = c.getName();
          }
          else{
            System.out.println("Phew! Darth Plagueis missed");
            System.out.println("  Your Hp: " + c.getHp());
            System.out.println( "   Darth Palgueis Hp: " + darthPlagueisHp );
            turn = c.getName();
            }
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
    else{
      System.out.println("Please choose either to Fight, Heal, Use Weapon, or Run");
    }
  }
  if (darthPlagueisHp <= 0) {
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

  // method for choosing to go to the market
  public static void goToTheMarket(){
    System.out.println("Welcome to the Market! There are Weapons and Armor avaliable for purchase as well as some delicious Fruit" + '\n'+ "Would you like to purchase any? ");
    String purchase = s.nextLine();
    boolean purchases = false;
    if (purchase.equals("yes")||purchase.equals("Yes")){
      purchases = true;
      while (purchases == true){
        if (c.getCredits() > 0){
          System.out.println("What menu would you like to view, Weapons, Armor or Fruits?");
          String menu = s.nextLine();
          if(menu.equals("Fruits")||menu.equals("fruits")){
            System.out.println('\n'+ "Each Jogan Fruit is 20 credits. How many would you like to purchase?(Type 0 to return to Theed) ");
            int number = s.nextInt();
            s.nextLine();
            if(number == 0){
              purchases = false;
              //goToTheed();
            }
            else if (number*20 <= c.getCredits()){
              c.setJoganFruit(c.getJoganFruit()+ number);
              int amount = number *20;
              c.setCredits(c.getCredits()- amount);
              System.out.println("You now have "+ c.getJoganFruit()+ " Jogan fruit, and "+ c.getCredits()+ " credits remaining");
              purchases = false;
              }
            else{
              System.out.println("Sorry you don't have enough credits to purchase that many"+ '\n'+ "Would you like to purchase a different amount?");
              String yOrN = s.nextLine();
              if (yOrN.equals("yes")||yOrN.equals("Yes")){
                purchases = true;
              }
              else{
                purchases = false;
              }
            }
          }
            else if (menu.equals("Weapons")||menu.equals("weapons")){
              String[] weapons= {"Staff", "Blaster", "Bowcaster", "Lightsaber"};
              System.out.println("These are the weapons that are in stock"+ '\n');
              for (int i=0; i<weapons.length; i++){
                if (!c.w.weapon.equals(weapons[i])){
                  Weapon w = new Weapon(weapons[i]);
                  System.out.println("Weapon: " + weapons[i]);
                  System.out.println("  "+ "Max Damage: "+ w.damage+'\n'+"  "+"Cost: "+ w.cost+ '\n');
                }
              }
              System.out.println("Which would you like to purchase?(Type exit to return to Theed)");
              String weaponChoice = s.nextLine();
              c.w = new Weapon(weaponChoice);
              if(weaponChoice.equals("exit")){
                purchases = false;
                //goToTheed();
              }
              else if(!weaponChoice.equals("exit")){
                c.w = new Weapon(weaponChoice);
                  if (c.w.cost <= c.getCredits()){
                    c.setCredits(c.getCredits()-c.w.cost);
                    System.out.println("You have bought "+ weaponChoice + " for "+ c.w.cost+ " credits!");
                    purchases = false;
                  }
                  else{
                    System.out.println("Sorry You don't have enough to purchase this weapon. Would you like to purchase something else?");
                    String newWeapon = s.nextLine();
                    if (newWeapon.equals("yes")||newWeapon.equals("Yes")){
                      purchases = true;
                    }
                    else{
                      purchases = false;
                    }
                  }
                }
              }
            else if (menu.equals("Armor")||menu.equals("armor")){
              String[] armor= {"Jedi Robe","Jedi Hood", "Stormtrooper Helmet", "Darth Vader Cape"};
              System.out.println("This is the armor that is in stock"+ '\n');
              for (int i=0; i<armor.length; i++){
                if (!c.a.armor.equals(armor[i])){
                  Armor a = new Armor(armor[i]);
                  System.out.println("Armor: " + armor[i]);
                  System.out.println("  "+ "Absorbtion: "+ a.absorbtion+'\n'+"  "+"Cost: "+ a.cost+ '\n');
                }
              }
              System.out.println("Which would you like to purchase? (Type exit to return to Theed)");
              String armorChoice = s.nextLine();
              if (armorChoice.equals("exit")){
                purchases = false;
                //goToTheed();
              }
              else if(!armorChoice.equals("exit")){
                c.a = new Armor(armorChoice);
                if (c.a.cost <= c.getCredits()){
                  c.setCredits(c.getCredits()-c.a.cost);
                  System.out.println("You have bought "+ armorChoice + " for "+ c.a.cost+ " credits!");
                  purchases = false;
                }
                else{
                  System.out.println("Sorry You don't have enough to purchase this armor. Would you like to purchase something else?");
                  String newArmor = s.nextLine();
                  if (newArmor.equals("yes")||newArmor.equals("Yes")){
                    purchases = true;
                  }
                  else{
                    purchases = false;
                  }
                }
              }
            }
          else {
            System.out.println("Please choose one of the following categories : Fruits, Weapons, or Armor");
            }
          }
        else if (c.getCredits() == 0){
          System.out.println("Sorry " + c.getName() + " you don't seem to have any credits. Try again later");
          purchases = false;
        }
      }
    }
    else if (purchase.equals("no")||purchase.equals("No")){
      purchases = false;
      }
    }


  //method for going to the tavern
  public static void goToTheCantina(){
    System.out.println( c.getName() + " An interesting thing has happened at the Cantina! I'll tell you about it later");
  }

  //method for healing Shrine
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
        else if (length > 10){
            System.out.println("You can have a maxmimum of 10 minuets.");
            goToTheTemple();
            // int l = s.nextInt();
            // s.nextLine();
            // length = l;
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
      c.setDamage(c.getDamage()+c.getLevel());
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
    //  - Weapons: Staff: Default weapon
    //             Blaster
    //             Bowcaster
    //             Lightsaber
    //  - Armor: Jedi Robe: Default Armor
    //           Unknown1
    //           Unknown2
    //           Unknown3

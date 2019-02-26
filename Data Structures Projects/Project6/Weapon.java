// Katarina Sperduto

import java.util.*;

public class Weapon {
  public String weapon;
  public String attackText;
  public int damage = 1;
  public int cost = 0;

  public Weapon(String weapon){
    this.weapon = new String(weapon);


    if(this.weapon.equals("Staff")){
      this.attackText = ('\n'+"Looks like years of self-defense practice in the Jakku Desert has served you well"+'\n'+ "2 units of damage caused"+'\n');
      this.damage = 2;
      this.cost = 20;
    }
    else if (this.weapon.equals("Blaster")){
      this.attackText = ('\n'+"Hokey religions and ancient weapons are no match for a good blaster at your side.-Han Solo" +'\n'+"4 units of damage caused" +'\n');
      this.damage = 4;
      this.cost = 40;
    }
    else if (this.weapon.equals("Bowcaster")){
      this.attackText =('\n'+"Can I try that? ... I Like This Thing.-Han Solo" +'\n'+"6 units of damage caused"+'\n');
      this.damage = 6;
      this.cost = 60;
    }
    else{

      this.attackText = ('\n'+"This is the weapon of a Jedi Knight; not as clumsy or as random as a blaster. An elegant weapon for a more civilized age.-Obi Wan" +'\n'+"12 units of damage caused"+ '\n');
      this.damage = 12;
      this.cost = 120;
    }
  }
  public int getDamage(){
    if(weapon.equals("Staff")){
      Random dam = new Random();
      this.damage = dam.nextInt(2);
    }
    else if (weapon.equals("Blaster")){
      Random dam2 = new Random();
      this.damage = dam2.nextInt(4);
    }
    else if (weapon.equals("Bowcaster")){
      Random dam3 = new Random();
      this.damage = dam3.nextInt(6);
    }
    else{
      Random dam4 = new Random();
      this.damage = dam4.nextInt(8);
    }
    return damage;
  }
}

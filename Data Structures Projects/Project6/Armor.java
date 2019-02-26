// Katarina Sperduto

import java.util.*;

public class Armor {
  public String armor;
  public int absorbtion = 0;
  public int cost = 0;

  public Armor(String armor){
    this.armor = new String(armor);
    if(this.armor.equals("Jedi Robe")){
      this.absorbtion = 0;
      this.cost = 0;
    }
    else if (this.armor.equals("Jedi Hood")){
      this.absorbtion = 2;
      this.cost = 20;
    }
    else if (this.armor.equals("Stormtrooper Helmet")){
      this.absorbtion = 5;
      this.cost = 50;
    }
    else{
      this.absorbtion = 10;
      this.cost = 100;
    }
  }
}

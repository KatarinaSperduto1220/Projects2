// Katarina Sperduto

import java.util.*;

public class Character {

  //Instance Variables
  private String name;
  private int level = 1;
  private int xp = 0;
  private int maxHp = 20;
  private int hp = maxHp;
  private int credits = 100;
  private int joganFruit = 0;


  //Constructors

  public Character(String name){
    this.name = new String(name);
  }

  public boolean isDead(int hp){
    if (hp <= 0){
      return true;
    }
    else {
      return false;
    }
  }

  // set methods
  public void setName(String name){
    this.name = name;
  }
  public void setLevel(int level){
    if(level > 1){
      this.level = level;
    }
  }
  public void setXp(int xp){
    if(xp > 0){
      this.xp = xp;
    }
  }
  public void setMaxHp(int maxHp){
    if(maxHp > 20){
      this.maxHp = maxHp;
    }
  }
  public void setHp(int hp){
    if(hp < maxHp){
      this.hp = hp;
    }
    else{
      this.hp = maxHp;
    }
  }
  public void setCredits(int credits){
    if(credits > 100){
      this.credits = credits;
    }
    if(credits < 100){
      this.credits = credits;
    }
  }
  public void setJoganFruit(int joganFruit){
    if(joganFruit > 0){
      this.joganFruit = joganFruit;
    }
   }

// get methods
  public String getName(){
    return name;
  }
  public int getLevel(){
    return level;
  }
  public int getXp(){
    return xp;
  }
  public int getMaxHp(){
    return maxHp;
  }
  public int getHp(){
    return hp;
  }
  public int getCredits(){
    return credits;
  }
  public int getJoganFruit(){
    return joganFruit;
  }
}

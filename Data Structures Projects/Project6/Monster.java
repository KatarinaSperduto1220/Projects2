// Katarina Sperduto

import java.util.*;

public class Monster {
  private String name;
  private int damage = 0;
  private int maxHp = 40;
  private int hp = maxHp;
  private int xp = 0;
  private int credits = 0;
  private double chance = 0;

  public Monster(String name){
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
  public void setName(String name){
    this.name = name;
  }
  public void setXp(int xp){
    this.xp = xp;
  }
  public void setCredits(int credits){
    this.credits = credits;
  }
  public void setHp(int hp){
    this.hp = hp;
  }
  public void setDamage(int damage){
    this.damage = damage;
  }
  public void setChance(double chance){
    this.chance = chance;
  }
  public void setMaxHp(int maxHp){
    this.maxHp = maxHp;
  }

  public int getMaxHp(){
      if(name.equals("11-4D")){
        this.maxHp = 10;
      }
      else if(name.equals("Darth Maul")){
        this.maxHp = 15;
      }
      else if (name.equals("Sheev Palpatine")){
        this.maxHp = 30;
      }
      return maxHp;
  }

  public int getHp(){
    if(name.equals("11-4D")){
      if(hp < maxHp){
        this.hp=hp;
      }
      else{
        this.hp = maxHp;
      }
    }
    else if(name.equals("Darth Maul")){
      if(hp < maxHp){
        this.hp= hp;
      }
      else{
        this.hp = maxHp;
      }
    }
    else if (name.equals("Sheev Palpatine")){
      if(hp < maxHp){
        this.hp= hp;
      }
      else{
        this.hp = maxHp;
      }
    }
    return hp;
  }

  public int getCredits(){
    if(name.equals("11-4D")){
      this.credits = 20;
    }
    else if(name.equals("Darth Maul")){
      this.credits = 40;
    }
    else {
      this.credits = 60;
    }
    return credits;
  }

  public int getXp(){
    if(name.equals("11-4D")){
      this.xp = 10;
    }
    else if(name.equals("Darth Maul")){
      this.xp = 20;
    }
    else {
      this.xp = 30;
    }
    return xp;
  }

  public int getDamage(){
    if(name.equals("11-4D")){
      this.damage = 2;
    }
    else if(name.equals("Darth Maul")){
      this.damage = 4;
    }
    else {
      this.damage = 6;
    }
    return damage;
  }

  public double getChance(){
    if(name.equals("11-4D")){
      this.chance = .5;
    }
    else if(name.equals("Darth Maul")){
      this.chance = .6;
    }
    else {
      this.chance = .7;
    }
    return chance;
  }

  public String getName(){
    return name;
  }
}

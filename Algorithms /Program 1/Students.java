// Katarina Sperduto
//3380 001
//katarinasperduto@bellsouth.net

import java.util.*;
import java.io.*;

class Students{
  private String fName;
  private String lName;
  private int id;
  private int grade1;
  private int grade2;
  private int grade3;
  // private int examGrades;
  private double finalGrade;
  private char letterGrade;
  private int numStudents =0;
  private static int count=0;

  public Students(int id, String fName, String lName, int grade1, int grade2, int grade3){
    this.fName = fName;
    this.lName = lName;
    this.id = id;
    this.grade1 = grade1;
    this.grade2 = grade2;
    this.grade3 = grade3;
    count ++;
  }
  public String toString(){
    String s = "Name: " + fName + "\n";
    return s;
  }
  public void setFName(String fname){
    this.fName = fName;
  }
  public void setLName(String lname){
    this.lName = lName;
  }
  public void setID(int id){
    this.id = id;
  }
  public void setGrade1(int grade1){
    this.grade1 = grade1;
  }
  public void setGrade2(int grade2){
    this.grade2=grade2;
  }
  public void setGrade3(int grade3){
    this.grade3 = grade3;
  }

  public String getFName(){
    return fName;
  }
  public String getLName(){
    return lName;
  }
  public int getID(){
    return id;
  }
  public int getGrade1(){
    return grade1;
  }
  public int getGrade2(){
    return grade2;
  }
  public int getGrade3(){
    return grade3;
  }
  public static int getCount(){
    return count;
  }
  public double getAverage(){
    grade1 = getGrade1();
    grade2 = getGrade2();
    grade3 = getGrade3();
    double average = ((grade1*.3)+(grade2*.3)+(grade3*.4));
    return average;
  }
  public char getLetterGrade(){
    finalGrade = getAverage();
    if(finalGrade >= 90.00){
      letterGrade = 'A';
    }
    else if (finalGrade <= 90.00 && finalGrade >= 80.00){
      letterGrade ='B';
    }
    else if (finalGrade <= 80.00 && finalGrade >= 70.00){
      letterGrade ='C';
    }
    else if (finalGrade <= 70.00 && finalGrade >= 60.00){
      letterGrade ='D';
    }
    else{
      letterGrade = 'F';
    }
    return letterGrade;
  }



}

//Katarina Sperduto

import java.util.Scanner;

public class Project1{
  public static void main(String [] args) {
//Geting information from user
    Scanner s = new Scanner(System.in);
    System.out.println("Enter the student's name: ");
      String name = s.nextLine();
    System.out.println("Enter the Test 1 score: ");
      int test1 = s.nextInt();
    System.out.println("Enter the Test 2 score: ");
      int test2 = s.nextInt();
    System.out.println("Enter the Test 3 score: ");
      int test3 = s.nextInt();
    System.out.println("Enter the Test 4 score: ");
      int test4 = s.nextInt();
    System.out.println("Enter the Test 5 score: "+"");
      int test5 = s.nextInt();
    System.out.println("\n" + name + " Grade Report: "+"\n");

// Putting grades into an array
    double[] testGrades = {test1,test2,test3,test4,test5};

//Finding Max grade
    double max = testGrades[0];
     for (int i = 1; i < testGrades.length; i++) {
        if (testGrades[i] > max) max = testGrades[i];
      }
    System.out.println("Maximum Score: " + max);

//Finding Min Grade
    double min = testGrades[0];
      for (int i = 1; i < testGrades.length; i++) {
        if (testGrades[i] < min) min = testGrades[i];
      }
    System.out.println("Minimum Score: " + min);

// Finding Average
    double sum = 0;
      for (int i = 0; i < testGrades.length; i++) {
         sum += testGrades[i];
      }
      double average = sum/5;
      System.out.println("Average Score: " + average);

// Finding Final Grade
    String finalGrade = "NA";
    if (average >= 90){
      finalGrade = "A";
    }
    else if (average >= 80){
      finalGrade = "B";
    }
    else if (average >= 70){
        finalGrade = "C";
      }
    else if (average >= 60){
        finalGrade = "D";
      }
    else{
      finalGrade = "F";
      }
    System.out.println("Final Grade: "+ finalGrade);
     }
   }

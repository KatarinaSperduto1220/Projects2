// Katarina Sperduto
//3380 001
//katarinasperduto@bellsouth.net

import java.util.*;
import java.io.*;
import java.text.NumberFormat;
import java.text.DecimalFormat;

public class FSCgradebook{
  //Add Record
  public static int addRecord(int id, String fname, String lname, int grade1, int grade2, int grade3, Students students[], PrintWriter output ){
    int insertIdx = 0;
    DecimalFormat value = new DecimalFormat("###.##");
    output.println("Command: ADDRECORD");
    Students student = new Students(id, fname, lname, grade1, grade2, grade3);
    int index = Students.getCount()-1;
    if(index == 0){
      students[index]= student;
      insertIdx = index;
    }
    //Array Shifting
    else{
      for(int i =0; i< Students.getCount()-1; i++){
        int prior = students[i].getID();
        int current = student.getID();
        // System.out.println(prior + "vs" + current);
        if(prior > current){
          for(int j = index; j >=i; j--){
            students[j] = students[j-1];
          }
          students[i] = student;
          insertIdx = i;
        }
        else if (current > prior && i == index-1){
          students[index]= student;
          insertIdx = index;
        }
        else{
          continue;
        }
      }
    }

  output.println(student.getFName() + " " + student.getLName() + " (ID# " + student.getID() + ") has been added to the FSC Grade Book.");
  output.printf("   His final grade is %.2f", student.getAverage());
  output.println( " (" + student.getLetterGrade() +").\n");
  return insertIdx;
}

//Search By Id
  public static void searchStudentByID(int id, Students students[], PrintWriter output){
    output.println("Command: SEARCHBYID");
    // DecimalFormat value = new DecimalFormat("###.##");
    if (students[0] == null){
      output.println("\tERROR: cannot perform search. The gradebook is empty (no students added yet).\n");
    }
    else{
      //Do Binary Search
      int indexFound = binSearch(id, students, output);
      if ( indexFound != -1){
        output.println("\nStudent Record for " + students[indexFound].getFName() + " " + students[indexFound].getLName() + " (ID # " + id + "):" );
        output.println("     Exam 1:       " + students[indexFound].getGrade1());
        output.println("     Exam 2:       " + students[indexFound].getGrade2());
        output.println("     Final Exam:   " + students[indexFound].getGrade3());
        output.printf("     Final Grade:  %.2f\n",students[indexFound].getAverage());
        output.println("     Letter Grade: " + students[indexFound].getLetterGrade()+ "\n");
      }
      else{
        output.println("\n\tERROR: there is no record for student ID # " +id+".\n");
      }
  }
}

//Binary Search
  public static int binSearch(int id, Students students[], PrintWriter output){
    int low = 0;
    int high = Students.getCount()-1;
    ArrayList <Integer> searched = new ArrayList<Integer> ();
    int found;
    output.print("\tIndices searched: ");
    while(low <= high){
      int mid = (low + high)/2;
      if(id < students[mid].getID()){
        // System.out.print(mid);
        searched.add(mid);
        high = mid -1;
      }
      else if (id > students[mid].getID()){
        // System.out.print(mid);
        searched.add(mid);
        low = mid +1;
      }
      else{
        found = mid;
        searched.add(found);
        output.print("\tIndices searched: ");
        for (int i=0; i<searched.size(); i++){
          output.print(searched.get(i) + ", ");
      }
        return found;
      }
    }
    output.print("\tIndices searched: " );
    for (int i=0; i<searched.size(); i++){
      output.print(searched.get(i) + ", ");
  }
    return -1;
  }

//Search By Name
  public static void searchStudentByName(String fName, String lName,Students students[], PrintWriter output){
    output.println("Command: SEARCHBYNAME");
    boolean found = false;
    if (students[0] == null){
      output.println("\tERROR: cannot perform search. The gradebook is empty (no students added yet).\n");
    }
    else{
      //Linear Search
      for(int i =0; i < Students.getCount(); i++){
        if(fName.equals(students[i].getFName()) && lName.equals(students[i].getLName())){
          output.println("Student Record for " + students[i].getFName() + " " + students[i].getLName() + " (ID # " + students[i].getID() + "):" );
          output.println("     Exam 1:       " + students[i].getGrade1());
          output.println("     Exam 2:       " + students[i].getGrade2());
          output.println("     Final Exam:   " + students[i].getGrade3());
          output.printf("     Final Grade:  %.2f\n",students[i].getAverage());
          output.println("     Letter Grade: " + students[i].getLetterGrade()+ "\n");
          found = true;
          }
        }
        if(found == false){
          output.println("\tERROR: there is no record for student \"" + fName + " " + lName + "\".\n");
        }
      }
    }

//Display Class Stats
  public static void displayClassStatistics(String course, String professorF, String professorL, Students students[], PrintWriter output){
    output.println("Command: DISPLAYSTATS");
    // NumberFormat defaultFormat = NumberFormat.getPercentInstance();
    // defaultFormat.setMinimumFractionDigits(2);
    // DecimalFormat value = new DecimalFormat("###.##");

    double  averageScore = 0;
    double highestScore = 0;
    double lowestScore = 100.00;
    int totalA = 0;
    int totalB = 0;
    int totalC = 0;
    int totalD = 0;
    int totalF = 0;
    double percentA = 0;
    double percentB = 0;
    double percentC = 0;
    double percentD = 0;
    double percentF = 0;

    if(Students.getCount() == 0){
      averageScore = 0;
      highestScore = 0;
      lowestScore = 0;
      output.println("Statistical Results of " + course + " (Instructor: Dr " +professorF+" "+professorL+ "):");
      output.println("     Total number of student records: " + Students.getCount());
      output.printf("     Average Score: %.2f\n",averageScore);
      output.printf("     Highest Score: %.2f\n",highestScore);
      output.printf("     Lowest Score:  %.2f\n",lowestScore);
      output.println("     Total 'A' Grades: " + totalA + " (0% of class)");
      output.println("     Total 'B' Grades: " + totalB + " (0% of class)");
      output.println("     Total 'C' Grades: " + totalC + " (0% of class)");
      output.println("     Total 'D' Grades: " + totalD + " (0% of class)");
      output.println("     Total 'F' Grades: " + totalF + " (0% of class)\n");
    }
    else{
      for(int i =0; i <Students.getCount(); i++){
        averageScore += students[i].getAverage();
        if(students[i].getAverage() > highestScore){
          highestScore = students[i].getAverage();
        }
        if(students[i].getAverage() < lowestScore){
          lowestScore = students[i].getAverage();
        }
        if(students[i].getLetterGrade() == 'A'){
          totalA ++;
        }
        if(students[i].getLetterGrade() == 'B'){
          totalB ++;
        }
        if(students[i].getLetterGrade() == 'C'){
          totalC ++;
        }
        if(students[i].getLetterGrade() == 'D'){
          totalD ++;
        }
        if(students[i].getLetterGrade() == 'F'){
          totalF ++;
        }
      }
      averageScore = averageScore/Students.getCount();
      percentA = ((totalA*1.0)/Students.getCount())*100;
      percentB = ((totalB*1.0)/Students.getCount())*100;
      percentC = ((totalC*1.0)/Students.getCount())*100;
      percentD = ((totalD*1.0)/Students.getCount())*100;
      percentF = ((totalF*1.0)/Students.getCount())*100;
      output.println("Statistical Results of " + course + " (Instructor: Dr " +professorF+" "+professorL+ "):");
      output.println("     Total number of student records: " + Students.getCount());
      output.printf("     Average Score: %.2f\n",averageScore);
      output.printf("     Highest Score: %.2f\n",highestScore);
      output.printf("     Lowest Score:  %.2f\n",lowestScore);
      output.printf("     Total 'A' Grades: %d (%.2f", totalA, percentA);
      output.println("% of class)");
      output.printf("     Total 'B' Grades: %d (%.2f", totalB, percentB);
      output.println("% of class)");
      output.printf("     Total 'C' Grades: %d (%.2f", totalC, percentC);
      output.println("% of class)");
      output.printf("     Total 'D' Grades: %d (%.2f", totalD, percentD);
      output.println("% of class)");
      output.printf("     Total 'F' Grades: %d (%.2f", totalF, percentF);
      output.println("% of class)\n");
    }
  }

//Display Students
  public static void displayAllStudents(Students students[], PrintWriter output){
    output.println("Command: DISPLAYSTUDENTS");
    DecimalFormat value = new DecimalFormat("###.##");
    if (students[0] == null){
      output.println("   ERROR: there are no students currently in the system.\n");
    }
    else{
      // NumberFormat defaultFormat = NumberFormat.getPercentInstance();
      // defaultFormat.setMinimumFractionDigits(2);

      output.println("***Class Roster and Grade Sheet***\n");
      for(int i =0; i< Students.getCount(); i++ ){
        System.out.println(students[i]);
        output.println(" - Student Record for " + students[i].getFName() + " " + students[i].getLName() + " (ID # " + students[i].getID() + "):");
        output.println("     Exam 1:       " + students[i].getGrade1());
        output.println("     Exam 2:       " + students[i].getGrade2());
        output.println("     Final Exam:   " + students[i].getGrade3());
        output.printf("     Final Grade:  %.2f\n",students[i].getAverage());
        output.println("     Letter Grade: " + students[i].getLetterGrade() + "");
      }
      output.println("");
    }
  }

//Main
  public static void main(String [] args) throws Exception{
    String task;
    String courseName;
    int courseNumber;
    String course;
    String professorF;
    String professorL;
    int maxNumStudents;
    int id;
    String fName;
    String lName;
    int grade1;
    int grade2;
    int grade3;
    Students [] students;
    PrintWriter output = null;
    File inputFile = new File("FSCgradebook.in");
    int i = 0;
    try {
      Scanner in = new Scanner(inputFile);
      if (!inputFile.exists()) {
        System.out.println("Input file, " + inputFile + ", does not exist.");
        System.exit(0);
      }

    // Output File
      File outputFile = new File("FSCgradebook2.out");
      output = new PrintWriter(outputFile);
      output.println("Welcome to the FSC Grade Book.\n");
      courseName = in.next();
      courseNumber = Integer.parseInt(in.next());
      course = (courseName + "-"+ courseNumber);
      professorF = in.next();
      professorL = in.next();
      maxNumStudents = Integer.parseInt(in.next());
      students = new Students [maxNumStudents];

      do {
        task = in.next();
      //addRecord
        if (task.equals("ADDRECORD") == true) {
          id = Integer.parseInt(in.next());
          fName = in.next();
          lName = in.next();
          grade1 = Integer.parseInt(in.next());
          grade2 = Integer.parseInt(in.next());
          grade3 = Integer.parseInt(in.next());
          addRecord(id,fName,lName,grade1,grade2,grade3,students,output);
          task = in.nextLine();
      }

      //searchById
        else if (task.equals("SEARCHBYID") == true) {
          id = Integer.parseInt(in.next());
          searchStudentByID(id, students, output);
          task = in.nextLine();
      }

      //SearchByName
        else if (task.equals("SEARCHBYNAME") == true) {
          fName = in.next();
          lName = in.next();
          searchStudentByName(fName, lName, students, output);
          task = in.nextLine();
      }

      //displayStats
        else if (task.equals("DISPLAYSTATS") == true) {
          displayClassStatistics(course, professorF, professorL, students, output);
          task = in.nextLine();
      }

      //displayStudents
        else if (task.equals("DISPLAYSTUDENTS") == true) {
          displayAllStudents(students, output);
          task = in.nextLine();
      }

      // Quit
        else if (task.equals("QUIT") == true) {
          output.println("Thank you for using the FSC Grade Book.");
          output.println("Goodbye.");
      }

      // Command Not Listed
        else {
          System.out.println("Invalid Command: input invalid." + task);
        }
      } while (task.equals("QUIT") != true);
    }
    catch(Exception e){}

    output.close();

  }
}

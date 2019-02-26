// Katarina Sperduto
//3380 001
//katarinasperduto@bellsouth.net
// package fsctelecom;

import java.util.*;
import java.io.*;

class Student {

    private String firstName;
    private String lastName;
    private int ID;
    private String phoneNumber;
    private double balance;
    private String[] calledNumbers;
    private int[] duration;
    private String[] textedNumbers;
    private static int numStudents = 0;
    private static int numCalls = 0;
    private static int numTexts = 0;
    private Student next = null;

    public Student(int ID, String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
        this.phoneNumber = phoneNumber;
        this.balance = 20;
        this.calledNumbers = new String[10];
        this.duration = new int[10];
        this.textedNumbers = new String[10];
        this.numCalls = 0;
        this.numTexts = 0;
        numStudents++;
    }

    public String toString() {
        String s = "Name: " + firstName + "\n";
        return s;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setNext(Student next) {
        this.next = next;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getID() {
        return ID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public double getBalance() {
        return balance;
    }

    public Student getNext() {
        return next;
    }

    public int getNumStudents() {
        return numStudents;
    }

    public int getNumTexts(){
      return numTexts;
    }

    public int getNumCalls(){
      return numCalls;
    }

    public String[] getTextedNumbers() {
       return textedNumbers;
    }

    public String[] getCalledNumbers() {
      return calledNumbers;
    }

    public int[] getDuration() {
     return duration;
    }

    public void addTextedNumber(String phoneNumber){
      for(int i = 8; i >= 0; i--){
        textedNumbers[i+1] = textedNumbers[i];
      }
      textedNumbers[0] = phoneNumber;
      numTexts += 1;
    }

    public void addCall(String phoneNumber, int length){
      for (int i =8; i>= 0; i-- ){
        duration[i+1] = duration[i];
        calledNumbers[i+1] = calledNumbers[i];
      }
      duration[0]= length;
      calledNumbers[0] = phoneNumber;
      numCalls += 1;
    }
    public String printCall(int i){
      if(calledNumbers[i] == null){
        return "0";
      }
      else{
        return("\t\t"+calledNumbers[i] + " (" + duration[i] + ")");
    }
  }

    public String printText(int i){
      if(textedNumbers[i] == null){
        return "0";
      }
      else{
        return ("\t\t" + textedNumbers[i]);
      }
    }

    public boolean textEmpty(){
      if(textedNumbers[0] == null){
        return true;
    }
    return false;

}
    public boolean callEmpty(){
      if(calledNumbers[0] == null){
      return true;
    }
    return false;

}
}

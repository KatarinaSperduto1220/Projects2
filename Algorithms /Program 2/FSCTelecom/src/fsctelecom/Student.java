// Katarina Sperduto
//3380 001
//katarinasperduto@bellsouth.net
package fsctelecom;

import java.util.*;
import java.io.*;

class Student {

    private String firstName;
    private String lastName;
    private int ID;
    private String phoneNumber;
    private double balance;
    private String[] callNumbers;
    private int[] duration;
    private String[] textedNumbers;
    private static int numStudents = 0;
    private Student next = null;

    public Student(int ID, String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
        this.phoneNumber = phoneNumber;
        this.balance = 20;
        this.callNumbers = new String[10];
        this.duration = new int[10];
        this.textedNumbers = new String[10];
        numStudents++;
    }

    public String[] getCallNumbers() {
        return callNumbers;
    }

    public void setCallNumbers(String[] callNumbers) {
        this.callNumbers = callNumbers;
    }

    public int[] getDuration() {
        return duration;
    }

    public void setDuration(int[] duration) {
        this.duration = duration;
    }

    public String[] getTextedNumbers() {
        return textedNumbers;
    }

    public void setTextedNumbers(String[] textedNumbers) {
        this.textedNumbers = textedNumbers;
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

}

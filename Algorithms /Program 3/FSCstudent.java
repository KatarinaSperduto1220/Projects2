// Katarina Sperduto
//3380 001
//katarinasperduto@bellsouth.net

// package fscbook;
import java.util.*;
import java.io.*;

class FSCstudent{
  private int ID;
  private String firstName;
  private String lastName;
  private String department;
  private int numFriends;
  private FSCfriends myFriends;
  private FSCstudent right;
  private FSCstudent left;

// Constructor for creating a new FSCStudent
    public FSCstudent(int ID, String firstName, String lastName, String department) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.myFriends = new FSCfriends();
    }

// Creatimg type FSCStudent to a string
// Used for legibility when debugging
    public String toString() {
      String s = "Name: " + firstName + "\n";
      return s;
    }

// Getters
    public int getID() {
        return ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDepartment() {
        return department;
    }

    public int getNumFriends() {
        return myFriends.getCount();
    }

    public FSCfriends getMyFriends() {
        return myFriends;
    }

    public FSCstudent getRight() {
        return right;
    }

    public FSCstudent getLeft() {
        return left;
    }

// Setters
    public void setID(int ID) {
        this.ID = ID;
    }
    public void setMyFriends(FSCfriends myFriends){
      this.myFriends = myFriends;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setNumFriends(int numFriends) {
        this.numFriends = numFriends;
    }


    public void setRight(FSCstudent right) {
        this.right = right;
    }

    public void setLeft(FSCstudent left) {
        this.left = left;
    }

    // Add a freind to this students linked list
    public void addFriend(int ID){
      // FSCfriend friend = new FSCfriend(ID);
      myFriends.insert(ID);
      // this.numFriends ++;

    }
    // Delete a friend from this students linked list
    public void deleteFriend(int ID){
      // FSCfriend friend = new FSCfriend(ID);
      myFriends.delete(ID);
      // this.numFriends --;
    }

// Check to see if this student and another student are already friends
    public boolean findFriend(int ID){
      return myFriends.search(ID);
    }

}

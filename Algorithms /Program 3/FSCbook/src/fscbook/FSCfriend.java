// Katarina Sperduto
//3380 001
//katarinasperduto@bellsouth.net

package fscbook;

import java.util.*;
import java.io.*;

class FSCfriend{
    private int ID;
    private FSCfriend next;
    private static int  count =0;

    // CONSTRUCTORS
    public FSCfriend() {
        ID = 0;
        next = null;
        count ++;
    }

    public FSCfriend(int ID) {
        this.ID = ID;
        next = null;
    }

    public FSCfriend(int data, FSCfriend next) {
        this.ID = data;
        this.next = next;
    }

    // ACCESSORS
    public int getID() {
        return ID;
    }

    public FSCfriend getNext() {
        return next;
    }
    public static int getCount(){
        return count;
    }


    // MUTATORS
    public void setID(int ID) {
        this.ID = ID;
    }

    public void setNext(FSCfriend next) {
        this.next = next;
    }
}
  
  


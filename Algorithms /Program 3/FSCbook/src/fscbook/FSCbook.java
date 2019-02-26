// Katarina Sperduto
//3380 001
//katarinasperduto@bellsouth.net
 package fscbook;
import java.util.*;
import java.io.*;

class FSCbook{
    public  static void add(int ID, String firstName, String lastName, String department, PrintWriter output, FSCfriends friendList,FSCbookBST accounts) {
          output.println("ADD Command");

      }

      public static void findName(String firstName, String lastName, PrintWriter output, FSCfriends friendList, FSCbookBST accounts) {
          output.println("FINDNAME Command");
        }


      public static void findID(int ID, PrintWriter output, FSCfriends friendList, FSCbookBST accounts) {
          output.println("FINDID Command");
    }

      public static void friend(String firstName, String lastName, String firstName1, String lastName1, PrintWriter output, FSCfriends friendList, FSCbookBST accounts) {
          output.println("FRIEND Command");
      }

      public static void unfriend(String firstName, String lastName, String firstName1, String lastName1, PrintWriter output, FSCfriends friendList, FSCbookBST accounts) {
          output.println("UNFRIEND Command");

      }

      public static void delete(String firstName, String lastName, PrintWriter output, FSCfriends friendList, FSCbookBST accounts) {
          output.println("DELETE Command");
      }

      public static void printFriends(String firstName, String lastName, PrintWriter output, FSCfriends friendList, FSCbookBST accounts) {
          output.println("PRINTFRIENDS Command");
      }

      public static void printMembers(PrintWriter output, FSCfriends friendList, FSCbookBST accounts) {
          output.println("PRINTMEMBERS Command");
    }


      public static void main(String[] args) throws Exception {
          // Variables needed for program
          String command;
          int ID;
          String department;
          String firstName;
          String lastName;
          String firstName1;
          String lastName1;
          boolean quit = false;
          int commandCount = 0;


          File inputFile = new File("FSCbook.in");
          if (!inputFile.exists()) {
              System.out.println("Input file, " + inputFile + ", does not exist.");
              System.exit(0);
          }
          // Output File:
          File outputFile = new File("FSCbook2.out");

          Scanner in = new Scanner(inputFile);
          PrintWriter output = new PrintWriter(outputFile);

          int num = Integer.parseInt(in.next());
          FSCfriends friendList = new FSCfriends();
          FSCbookBST accounts = new FSCbookBST();

          do {
              command = in.next();
              // System.out.println(command);

              if (command.equals("ADD") == true) {
                commandCount ++;
                  ID = Integer.parseInt(in.next());
                  // sort = Integer.parseInt(in.next());
                  firstName = in.next();
                  lastName = in.next();
                  department = in.next();
                  add(ID, firstName, lastName, department, output, friendList, accounts);
                  if(commandCount < num){
                    command = in.nextLine();
                  }
                  else{
                    quit = true;
                  }
              } else if (command.equals("FINDNAME") == true) {
                  commandCount ++;
                  firstName = in.next();
                  lastName = in.next();
                  findName(firstName, lastName, output, friendList, accounts);
                  if(commandCount < num){
                    command = in.nextLine();
                  }
                  else{
                    quit = true;
                  }
              } else if (command.equals("FINDID") == true) {
                  commandCount ++;
                  ID = Integer.parseInt(in.next());
                  findID(ID, output, friendList, accounts);
                  if(commandCount < num){
                    command = in.nextLine();
                  }
                  else{
                    quit = true;
                  }
              } else if (command.equals("FRIEND") == true ) {
                  commandCount ++;
                  firstName = in.next();
                  lastName = in.next();
                  firstName1 = in.next();
                  lastName1 = in.next();
                  friend(firstName, lastName, firstName1, lastName1, output, friendList, accounts);
                  if(commandCount < num){
                    command = in.nextLine();
                  }
                  else{
                    quit = true;
                  }
              } else if (command.equals("UNFRIEND") == true) {
                  commandCount ++;
                  firstName = in.next();
                  lastName = in.next();
                  firstName1 = in.next();
                  lastName1 = in.next();
                  unfriend(firstName, lastName, firstName1, lastName1, output, friendList, accounts);
                  if(commandCount < num){
                    command = in.nextLine();
                  }
                  else{
                    quit = true;
                  }
              } else if (command.equals("DELETE") == true) {
                  commandCount ++;
                  firstName = in.next();
                  lastName = in.next();
                  delete(firstName, lastName, output, friendList, accounts);
                  if(commandCount < num){
                    command = in.nextLine();
                  }
                  else{
                    quit = true;
                  }
              } else if (command.equals("PRINTFRIENDS") == true) {
                commandCount++;
                  firstName = in.next();
                  lastName = in.next();
                  printFriends(firstName, lastName, output, friendList, accounts);
                  if(commandCount < num){
                    command = in.nextLine();
                  }
                  else{
                    quit = true;
                  }
              } else if (command.equals("PRINTMEMBERS") == true) {
                commandCount++;
                // System.out.println(commandCount);
                  printMembers( output, friendList, accounts);
                  if(commandCount < num){
                    command = in.nextLine();
                  }
                  else{
                    quit = true;
                  }
              }
              else {
                commandCount++;
                  System.out.println("Invalid Command: input invalid." + command);
                  if(commandCount < num){
                    command = in.nextLine();
                  }
                  else{
                    quit = true;
                  }
              }

          } while (quit != true);

          // Close input and output
          in.close();
          output.close();
      }

  }

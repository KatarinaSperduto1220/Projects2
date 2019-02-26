// Katarina Sperduto
//3380 001
//katarinasperduto@bellsouth.net
// package fscbook;
import java.util.*;
import java.io.*;

class FSCbook{
  // Method used to add a new node of type FSCstudent to the subTree
    public static void add(int ID, String firstName, String lastName, String department, PrintWriter output, FSCfriends friendList, FSCbookBST accounts) {
          output.println("ADD Command");
          if(accounts.isEmpty()|| accounts.search(ID) == false){
          accounts.insert(ID, firstName, lastName, department);
          output.printf("\t%s %s (ID %d), from the %s department, joined FSCbook.\n\n", firstName, lastName, ID, department );
        }
        else{
          output.println("\tCannot Perform ADD Command:");
          output.printf("\t\tID %d, %s %s - already a member of FSCbook.\n\n", ID, firstName, lastName );
        }
      }
// Method used to find a student by name (AKA findNodeByName method)
      public static void findName(String firstName, String lastName, PrintWriter output, FSCfriends friendList, FSCbookBST accounts) {
          output.println("FINDNAME Command");
          if(accounts.isEmpty() || accounts.findNodeByName(lastName, firstName) == null){
            output.printf("\t%s %s was not found in FSCbook.\n\n", firstName, lastName);
          }
          else{
            FSCstudent student = accounts.findNodeByName(lastName, firstName);
            int i = student.getID();
            String d = student.getDepartment();
            output.printf("\tFound:  ID %d, %s %s (%s Department)\n\n",i, firstName, lastName, d );
          }
        }

// Method used to find a student by ID number (AKA findNode method)
      public static void findID(int ID, PrintWriter output, FSCfriends friendList, FSCbookBST accounts) {
          output.println("FINDID Command");
          if(accounts.isEmpty() || accounts.search(ID) == false ){
            output.printf("\tID %d was not found in FSCbook.\n\n", ID);
          }
          else{
            FSCstudent student = accounts.findNode(ID);
            String f = student.getFirstName();
            String l = student.getLastName();
            String d = student.getDepartment();
            output.printf("\tFound:  ID %d, %s %s (%s Department)\n\n", ID, f, l, d );
          }
    }

// Method used to create new friends
      public static void friend(String firstName, String lastName, String firstName1, String lastName1, PrintWriter output, FSCfriends friendList, FSCbookBST accounts) {
          output.println("FRIEND Command");
          // Check if both students exit and have freinds
          if(accounts.isEmpty() || accounts.findNodeByName(lastName, firstName) == null || accounts.findNodeByName(lastName1, firstName1) == null){
            output.println("\tCannot Perform FRIEND Command:");
            if(accounts.findNodeByName(lastName, firstName) == null){
            output.printf("\t\t%s %s - this student is not in FSCbook.\n",firstName, lastName );
            }
            if(accounts.findNodeByName(lastName1, firstName1) == null){
              output.printf("\t\t%s %s - this Student is not in FSCbook.\n",firstName1, lastName1 );
            }
            output.println("");
          }
          else{
            // If both accounts exist and have friends
            FSCstudent student1 = accounts.findNodeByName(lastName, firstName);
            FSCstudent student2 = accounts.findNodeByName(lastName1, firstName1);
            int ID1 = student1.getID();
            int ID2 =student2.getID();
            // Check to see if they are already friends
          if(student1.findFriend(ID2) == true || student2.findFriend(ID1) == true){
            output.println("\tCannot Perform FRIEND Command:");
            output.printf("\t\t%s %s and %s %s are already friends.\n\n", firstName, lastName, firstName1, lastName1);
          }
          else{
            // If they are not freinds add them to eachothers friends list
            student1.addFriend(ID2);
            student2.addFriend(ID1);
            output.printf("\t%s %s and %s %s are now friends.\n\n", firstName, lastName, firstName1, lastName1);
          }
        }

      }

// Method used to unfriend two friends
      public static void unfriend(String firstName, String lastName, String firstName1, String lastName1, PrintWriter output, FSCfriends friendList, FSCbookBST accounts) {
        output.println("UNFRIEND Command");
        // Check if both students exit and have freinds
        if(accounts.isEmpty() || accounts.findNodeByName(lastName, firstName) == null || accounts.findNodeByName(lastName1, firstName1) == null){
          output.println("\tCannot Perform UNFRIEND Command:");
          if(accounts.findNodeByName(lastName, firstName) == null){
          output.printf("\t\t%s %s - this student is not in FSCbook.\n",firstName, lastName );
          }
          if(accounts.findNodeByName(lastName1, firstName1) == null){
            output.printf("\t\t%s %s - this Student is not in FSCbook.\n",firstName1, lastName1 );
          }
          output.println("");
        }
        else{
          // If both accounts exist and have friends
          FSCstudent student1 = accounts.findNodeByName(lastName, firstName);
          FSCstudent student2 = accounts.findNodeByName(lastName1, firstName1);
          int ID1 = student1.getID();
          int ID2 =student2.getID();
          // Check to see if they are in fact friends
          if(student1.getNumFriends() == 0 || student2.getNumFriends() == 0 || student1.findFriend(ID2) == false || student2.findFriend(ID1) == false){
            output.println("\tCannot Perform UNFRIEND Command:");
            output.printf("\t%s %s and %s %s are not currently friends.\n\n", firstName, lastName, firstName1, lastName1);
          }
          else{
          // If they are freinds delete them from eachothers friends list
          student1.deleteFriend(ID2);
          student2.deleteFriend(ID1);
          output.printf("\t%s %s and %s %s are no longer friends.\n\n", firstName, lastName, firstName1, lastName1);
        }
        }

      }

// Method used to delete a node of type FSCstudent from the tree
      public static void delete(String firstName, String lastName, PrintWriter output, FSCfriends friendList, FSCbookBST accounts) {
          output.println("DELETE Command");
          if(accounts.isEmpty() || accounts.findNodeByName(lastName, firstName) == null){
            output.println("\tCannot Perform DELETE Command:");
            output.printf("\t\t%s %s was not found in FSCbook.\n\n",firstName, lastName );
          }
          else{
            FSCstudent student = accounts.findNodeByName(lastName, firstName);
            int i = student.getID();
            output.printf("\t%s %s has been removed from FSCbook.\n\n", firstName, lastName);
            accounts.delete(i);
          }
      }

// Method used to print the friends list of a given student
      public static void printFriends(String firstName, String lastName, PrintWriter output, FSCfriends friendList, FSCbookBST accounts) {
          output.println("PRINTFRIENDS Command");
          if(accounts.isEmpty()||accounts.findNodeByName(lastName, firstName)==null){
            output.println("\tCannot Perform PRINTFRIENDS Command:");
            output.printf("\t\t%s %s was not found in FSCbook.\n\n",firstName, lastName );
          }
          else{
            FSCstudent student = accounts.findNodeByName(lastName, firstName);
            int numFriends = student.getNumFriends();
              // System.out.println(numFriends);
            if(student.getMyFriends().isEmpty() || numFriends == 0){
              output.printf("\t%s %s has no friends.\n\n", student.getFirstName(), student.getLastName());
            }
            else{
            output.printf("\tFriends for ID %d, %s %s (%s Department):\n", student.getID(), student.getFirstName(), student.getLastName(), student.getDepartment());
            // int numFriends = student.getNumFriends();

            output.printf("\t\tThere are a total of %d friends(s).\n", numFriends);
            student.getMyFriends().PrintList2(output, accounts);
            output.println("");
            // System.out.println("\n");
          }
          }
      }

// Method used to print out the current members of the FSCbook (all remaining nodes in the tree)
      public static void printMembers(PrintWriter output, FSCfriends friendList, FSCbookBST accounts) {
          output.println("PRINTMEMBERS Command");
          if(accounts.isEmpty()){
            output.println("\tCannot Perform PRINTMEMBERS Command:");
            output.println("\t\tThere are currently no members of FSCbook.\n");
          }
          else{
            output.println("\tMembers of FSCbook:");
            accounts.printOrder(output);
            output.println("");
            // output.println(accounts.inorder());
            // accounts.inorder();

          }
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
          File outputFile = new File("FSCbook.out");

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

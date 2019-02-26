// Katarina Sperduto
//3380 001
//katarinasperduto@bellsouth.net
// package fsctelecom;

import java.util.*;
import java.io.*;

class FSCTelecom {
    //
    // METHODS USED TO PROCESS THE COMMANDS IN THE INPUT FILE.
    //    - All we really do is print a small message for each command
    //

    public static void addAccount(int ID, String firstName, String lastName, String phoneNumber, PrintWriter output, FSCTelecomAccounts accounts) {
        output.println("Command: ADDACCOUNT");
        Student tempStudent = new Student(ID, firstName, lastName, phoneNumber);
        accounts.insert(tempStudent);
        output.printf("\tName:          %s %s\n"
                + "\tStudent ID:    %d\n"
                + "\tPhone Number:  %s\n"
                + "\tBalance:       $%.2f\n\n", firstName, lastName, ID, phoneNumber, 20.00);
    }

    public static void makeCall(int ID, String phoneNumber, int length, PrintWriter output, FSCTelecomAccounts accounts) {
        output.println("Command: MAKECALL");
        if(accounts.isEmpty() || accounts.search(ID) == false){
          output.println("	Cannot perform MAKECALL. Account does not exist in FSC Telecom System.\n");
        }
        else{
          Student student = accounts.findStudent(ID);
          student.addCall(phoneNumber,length);
          if (student.getBalance() <= 0.05){
              output.println("	Cannot perform MAKECALL. Account has insufficeient balance.\n");
          }
          else if(student.getBalance() < length*0.05 ){
            int newLength = 0;
            for(int i =length; i > 0;i --){
              if(student.getBalance() > i*0.05){
                newLength = i;
                break;
              }
            }
            double cost = newLength*0.05;
            student.setBalance(student.getBalance()-cost);
            output.printf("\tName:          %s %s\n"
                    + "\tPhone Number:  %s\n"
                    + "\tNumber Called: %s\n"
                    + "\tCall Duration: %d minutes\n"
                    + "\tCall Cost:     $%.2f\n"
                    + "\tNew Balance:   $%.2f\n", student.getFirstName(), student.getLastName(), student.getPhoneNumber(), phoneNumber, newLength, cost, student.getBalance());
                    output.println("***Call Terminated due to low balance.\n");
          }
          else{
            double cost = length*0.05;
            // output.println(student.getBalance());
            student.setBalance(student.getBalance()-cost);
            output.printf("\tName:          %s %s\n"
                    + "\tPhone Number:  %s\n"
                    + "\tNumber Called: %s\n"
                    + "\tCall Duration: %d minutes\n"
                    + "\tCall Cost:     $%.2f\n"
                    + "\tNew Balance:   $%.2f\n\n", student.getFirstName(), student.getLastName(), student.getPhoneNumber(), phoneNumber, length, cost, student.getBalance());

          }
        }
      }


    public static void sendText(int ID, String phoneNumber, PrintWriter output, FSCTelecomAccounts accounts) {
        output.println("Command: SENDTEXT");
        // student.setNumTexts(;
        if(accounts.isEmpty() || accounts.search(ID) == false){
          output.println("	Cannot perform SENDTEXT. Account does not exist in FSC Telecom System.\n");
        }
        else{
         Student student = accounts.findStudent(ID);
         student.addTextedNumber(phoneNumber);
         if(student.getBalance() < 0.02 ){
          output.println("	Cannot perform SENDTEXT. Account has insufficeient balance.\n");
        }
        else{
        double cost = 0.02;
        student.setBalance(student.getBalance()-cost);
        output.printf("\tName:          %s %s\n"
                + "\tPhone Number:  %s\n"
                + "\tNumber Texted: %s\n"
                + "\tText Cost:     $%.2f\n"
                + "\tNew Balance:   $%.2f\n\n", student.getFirstName(), student.getLastName(), student.getPhoneNumber(), phoneNumber, cost, student.getBalance());
      }
    }
  }

    public static void useData(int ID, int KB, PrintWriter output, FSCTelecomAccounts accounts) {
        output.println("Command: USEDATA");
        if(accounts.isEmpty() || accounts.search(ID) == false){
          output.println("	Cannot perform USEDATA. Account does not exist in FSC Telecom System.\n");
        }
        else{
        Student student = accounts.findStudent(ID);
        double mb = (KB*1.0)/1024;
        double cost = (mb/100);
        if(student.getBalance() < cost){
          output.println("	Cannot perform USEDATA. Account has insufficeient balance.\n");
        }
        else{
        student.setBalance(student.getBalance()-cost);
        output.printf("\tName:          %s %s\n"
                + "\tPhone Number:  %s\n"
                + "\tKilobytes:     %s\n"
                + "\tData Cost:     $%f\n"
                + "\tNew Balance:   $%.2f\n\n", student.getFirstName(), student.getLastName(), student.getPhoneNumber(), KB, cost, student.getBalance());
        }
      }
    }

    public static void recharge(int ID, int rechargeAmount, PrintWriter output, FSCTelecomAccounts accounts) {
        output.println("Command: RECHARGE");
        if(accounts.isEmpty()|| accounts.search(ID) == false){
          output.println("	Cannot perform RECHARGE. Account does not exist in FSC Telecom System.\n");
        }
        else{
        Student student = accounts.findStudent(ID);
        student.setBalance(student.getBalance()+rechargeAmount);
        double rechargeAmount2 = rechargeAmount*1.0;
        output.printf("\tName:            %s %s\n"
                + "\tPhone Number:    %s\n"
                + "\tRecharge Amount: $%.2f\n"
                + "\tNew Balance:     $%.2f\n\n", student.getFirstName(), student.getLastName(), student.getPhoneNumber(),  rechargeAmount2, student.getBalance());
      }
    }

    public static void deleteAccount(int ID, PrintWriter output, FSCTelecomAccounts accounts) {
        output.println("Command: DELETEACCOUNT");
        if(accounts.isEmpty() || accounts.search(ID) == false){
          output.println("	Cannot perform DELETEACCOUNT. Account does not exist in FSC Telecom System.\n");
        }
        else{
        Student student = accounts.findStudent(ID);
        accounts.delete(ID);
        output.printf("\tName:            %s %s\n"
                + "\tStudent ID:    %s\n"
                + "\tPhone Number:    %s\n"
                + "\tBalance:     $%.2f\n\n", student.getFirstName(), student.getLastName(), student.getID(), student.getPhoneNumber(), student.getBalance());
        output.println("***Account has been deleted.");

      }
    }

    public static void search(int ID, PrintWriter output, FSCTelecomAccounts accounts) {
        output.println("Command: SEARCH");
        if(accounts.isEmpty() || accounts.search(ID) == false){
          output.println("	Cannot perform SEARCH. Account does not exist in FSC Telecom System.\n");
        }
        else{
          Student student = accounts.findStudent(ID);
          output.printf("\tName:          %s %s\n"
                  + "\tStudent ID:    %d\n"
                  + "\tPhone Number:  %s\n"
                  + "\tBalance:       $%.2f\n\n", student.getFirstName(), student.getLastName(), student.getID(), student.getPhoneNumber(),  student.getBalance());
        }
    }

    public static void displayDetails(int ID, PrintWriter output, FSCTelecomAccounts accounts) {
        output.println("Command: DISPLAYDETAILS");
        if(accounts.isEmpty() || accounts.search(ID) == false){
          output.println("	Cannot perform DISPLAYDETAILS. Account does not exist in FSC Telecom System.\n");
        }
        else{
        Student student = accounts.findStudent(ID);
        output.printf("\tName:          %s %s\n"
                + "\tStudent ID:    %d\n"
                + "\tPhone Number:  %s\n", student.getFirstName(), student.getLastName(), student.getID(), student.getPhoneNumber());
        output.println("\tCalled Numbers and Duration:");
        if(student.callEmpty() == true){
          output.println("\t\t(user has not made and calls yet)");
        }
        else{
        for(int i=0; i <student.getDuration().length; i++){
          if(student.printCall(i).equals("0")){
            break;
        }
        else{
          output.println(student.printCall(i));
        }
        }
      }

        output.println("\tTexted Numbers:");
        if(student.textEmpty() == true){
          output.println("\t\t(user has not made and texts yet)\n");
        }

        else{

        for(int i=0; i < student.getTextedNumbers().length; i++){
          if(student.printText(i).equals("0")){
            break;
          }
          else{
            output.println(student.printText(i));
          }
          // output.println('\n');
        }
        output.println("\n");
      }
        // student.printTextes();
    }
  }


    public static void main(String[] args) throws Exception {
        // Variables needed for program
        String command;
        int ID;
        String firstName;
        String lastName;
        String phoneNumber;
        double balance;
        int KB;
        int rechargeAmount;
        int length;

        File inputFile = new File("FSCTelecom.in");
        if (!inputFile.exists()) {
            System.out.println("Input file, " + inputFile + ", does not exist.");
            System.exit(0);
        }
        // Output File:
        File outputFile = new File("FSCTelecom2.out");

        Scanner in = new Scanner(inputFile);
        PrintWriter output = new PrintWriter(outputFile);

        FSCTelecomAccounts accounts = new FSCTelecomAccounts();

        do {
            command = in.next();

            if (command.equals("ADDACCOUNT") == true) {
                ID = Integer.parseInt(in.next());
                firstName = in.next();
                lastName = in.next();
                phoneNumber = in.next();
                addAccount(ID, firstName, lastName, phoneNumber, output, accounts);
                command = in.nextLine();
            } else if (command.equals("MAKECALL") == true) {
                ID = Integer.parseInt(in.next());
                phoneNumber = in.next();
                length = Integer.parseInt(in.next());
                makeCall(ID, phoneNumber, length, output, accounts);
                command = in.nextLine();
            } else if (command.equals("SENDTEXT") == true) {
                ID = Integer.parseInt(in.next());
                phoneNumber = in.next();
                sendText(ID, phoneNumber, output, accounts);
                command = in.nextLine();
            } else if (command.equals("USEDATA") == true) {
                ID = Integer.parseInt(in.next());
                KB = Integer.parseInt(in.next());
                useData(ID, KB, output, accounts);
                command = in.nextLine();
            } else if (command.equals("RECHARGE") == true) {
                ID = Integer.parseInt(in.next());
                rechargeAmount = Integer.parseInt(in.next());
                recharge(ID, rechargeAmount, output, accounts);
                command = in.nextLine();
            } else if (command.equals("DELETEACCOUNT") == true) {
                ID = Integer.parseInt(in.next());
                deleteAccount(ID, output, accounts);
                command = in.nextLine();
            } else if (command.equals("SEARCH") == true) {
                ID = Integer.parseInt(in.next());
                search(ID, output, accounts);
                command = in.nextLine();
            } else if (command.equals("DISPLAYDETAILS") == true) {
                ID = Integer.parseInt(in.next());
                displayDetails(ID, output, accounts);
                command = in.nextLine();
            } else if (command.equals("QUIT") == true) {
                output.println("Command: QUIT");
                output.println("\tExiting the FSC Telecom System... ");
                output.println("\tGoodbye.");
            } // Invalid Command

            else {
                System.out.println("Invalid Command: input invalid." + command);
            }

        } while (command.equals("QUIT") != true);

        // Close input and output
        in.close();
        output.close();
    }

}

// Katarina Sperduto
//3380 001
//katarinasperduto@bellsouth.net
 package fsctelecom;

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
        if(accounts.isEmpty()){
          output.println("	Cannot perform MAKECALL. Account does not exist in FSC Telecom System.\n");
        }
    }

    public static void sendText(int ID, String phoneNumber, PrintWriter output, FSCTelecomAccounts accounts) {
        output.println("Command: SENDTEXT");
        if(accounts.isEmpty()){
          output.println("	Cannot perform SENDTEXT. Account does not exist in FSC Telecom System.\n");
        }
    }

    public static void useData(int ID, int KB, PrintWriter output, FSCTelecomAccounts accounts) {
        output.println("Command: USEDATA");
        if(accounts.isEmpty()){
          output.println("	Cannot perform USEDATA. Account does not exist in FSC Telecom System.\n");
        }
    }

    public static void recharge(int ID, int rechargeAmount, PrintWriter output, FSCTelecomAccounts accounts) {
        output.println("Command: RECHARGE");
        if(accounts.isEmpty()){
          output.println("	Cannot perform RECHARGE. Account does not exist in FSC Telecom System.\n");
        }
    }

    public static void deleteAccount(int ID, PrintWriter output, FSCTelecomAccounts accounts) {
        output.println("Command: DELETEACCOUNT");
        if(accounts.isEmpty()){
          output.println("	Cannot perform DELETEACCOUNT. Account does not exist in FSC Telecom System.\n");
        }
    }

    public static void search(int ID, PrintWriter output, FSCTelecomAccounts accounts) {
        output.println("Command: SEARCH");
        if(accounts.isEmpty()){
          output.println("	Cannot perform SEARCH. Account does not exist in FSC Telecom System.\n");
        }
    }

    public static void displayDetails(int ID, PrintWriter output, FSCTelecomAccounts accounts) {
        output.println("Command: DISPLAYDETAILS");
        if(accounts.isEmpty()){
          output.println("	Cannot perform DISPLAYDETAILS. Account does not exist in FSC Telecom System.\n");
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
                output.println("Goodbye.");
            } // Invalid Command
            else {
                System.out.println("Invalid Command: input invalid.");
            }

        } while (command.equals("QUIT") != true);

        // Close input and output
        in.close();
        output.close();
    }

}

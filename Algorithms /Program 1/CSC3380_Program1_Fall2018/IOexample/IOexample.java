// IOexample.java
// Author: Dr. Jonathan Cazalas
// Creation Date: 09/13/2013
// Date Last Modified: 09/13/2013

// Description:
// This is a program to demonstrate how to read from an input file and how to write
// to an input file. Specifically, we open and input file, read commands from the
// input file, and we then process each of the commands, which includes writing 
// to the output file as necessary.

package ioexample;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class IOexample {
	
	//
	// METHODS USED TO PROCESS THE COMMANDS IN THE INPUT FILE.
	//    - All we really do is print a small message for each command
	//
	
	// Method to Proccess COMMAND1
	public static void methodToProcessCOMMAND1(PrintWriter output) {
		output.println("Processing COMMAND1...");
	}
	
	// Method to Proccess COMMAND2
	public static void methodToProcessCOMMAND2(PrintWriter output) {
		output.println("Processing COMMAND2...");
	}
	
	// Method to Proccess COMMAND3
	public static void methodToProcessCOMMAND3(PrintWriter output) {
		output.println("Processing COMMAND3...");
	}

	
	//*************//
	// MAIN METHOD //
	//*************//
	public static void main(String[] args) throws Exception {
		// Variables needed for program
		String command; // used to save the command read from input file
		
		// OPEN FILES
		// Input File:
		File inputFile = new File("IOexample.in");
		if (!inputFile.exists()) {
			System.out.println("Input file, " + inputFile + ", does not exist.");
			System.exit(0);
		}
		// Output File:
		File outputFile = new File("IOexample.out");
		
		// Make Scanner variable to read from input file, and 
		// make Printwriter variable to print to output
		Scanner input = new Scanner(inputFile);
		PrintWriter output = new PrintWriter(outputFile);

		// Here is how you can print text to the output file
		output.println("IO Example Program to Process Commands from Input.");
		output.println();
		// Here, "output" is the PrintWriter variable defined just above
		
		// Now we have a DO/WHILE loop
		// In this loop, we read the next command from the input
		// Then we have IF/ELSE statements to check which command was just read from
		// the input, and we then invoke a method to process that command
		do {
			command = input.next();

			// COMMAND1
			if (command.equals("COMMAND1") == true) {
				methodToProcessCOMMAND1(output);
			}
			// *NOTE:
			// Notice, that we send the "output" variable (the PrintWriter variable) to the
			// method. This allows us to print to the file from inside the method.
			// You can also send the "input" variable to the method, which would allow you to 
			// read from the file from inside the method also.
			
			// COMMAND2
			else if (command.equals("COMMAND2") == true) {
				methodToProcessCOMMAND2(output);
			}
			
			// COMMAND3
			else if (command.equals("COMMAND3") == true) {
				methodToProcessCOMMAND3(output);
			}
			
			// Command QUIT: Quit the Program
			else if (command.equals("QUIT") == true) {
				output.println("Hope this example helps understanding and processing commands from input.");
				output.println("Goodbye.");
			}
			
			// Invalid Command
			else {
				System.out.println("Invalid Command: input invalid.");
			}
			
		} while (command.equals("QUIT") != true);

		// Close input and output
		input.close();
		output.close();
	}
}

import java.util.*;
import java.io.*;

public class PizzaMain {
    public static void main(String[] args) throws Exception{
      PrintWriter output = null;
      File inputFile = new File("pizzaInput.txt");
      try {
        Scanner in = new Scanner(inputFile);
        File outputFile = new File("PizzaOutput.out");
        output = new PrintWriter(outputFile);
        output.println("Welcome to the FSC Grade Book.\n");
    }
      catch(Exception e){}

    }
}

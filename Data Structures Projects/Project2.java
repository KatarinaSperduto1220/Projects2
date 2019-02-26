//Katarina Sperduto: Project 2

import java.util.*;

public class Project2{
  public static void main(String [] args) {

// some initial variables
  Scanner s = new Scanner(System.in);
  int computerScore = 0;
  int playerScore = 0;
    //Title
    System.out.println("Rock Paper Sissors Lizard Spock"+ "\n");
    // Loop for running the game
    for (int roundNum = 1;roundNum <= 20; roundNum++){
      // Randomly generating a move for the computer
      String[] moves= {"rock", "paper", "sissors"};
      Random num = new Random();
      String computerMove = moves[num.nextInt(3)];
      // If/Else statment determinig if anyone has won
      if (computerScore == 3 || playerScore == 3){
        // If/Else statment determinning who one once one score has hit 3
        if (computerScore==3){
          System.out.println("Game Over: The Computer has Won");
          break;
        }
        else{
          System.out.println("Game Over: You have Won");
          break;
        }
      }
      //Continuing running the round if no one has 3
      else {
        System.out.println("Round" + roundNum);
        System.out.println("Enter Your Move");
          String playerMove = s.nextLine();
          //Determing if there is a tie
          if (playerMove.equals(computerMove)){
            System.out.println(computerMove);
            System.out.println("Tie");
            System.out.println(playerScore);
            System.out.println(computerScore + "\n");
          }
          //When there is not a tie
          else{
            // Determoning if the players move triumphs over the computer move and incrementing the player score if so
            if (playerMove.equals("rock") && computerMove.equals("sissors") || playerMove.equals("sissors") && computerMove.equals("paper") || playerMove.equals("paper") && computerMove.equals("rock")){
              playerScore += 1;
              System.out.println(computerMove);
              System.out.println(playerScore);
              System.out.println(computerScore + "\n");
            }
            //if the player move does not beat the computer move the computer gets one point
            else{
              computerScore += 1;
              System.out.println(computerMove);
              System.out.println(playerScore);
              System.out.println(computerScore + "\n");
            }
          }
        }
      }
    }
}

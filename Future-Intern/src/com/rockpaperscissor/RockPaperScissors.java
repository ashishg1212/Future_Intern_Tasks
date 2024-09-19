package com.rockpaperscissor;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    // Method to generate the computer's choice
    public static String getComputerChoice() {
        Random random = new Random();
        int choice = random.nextInt(3);

        switch (choice) {
            case 0: return "Rock";
            case 1: return "Paper";
            case 2: return "Scissors";
            default: return "Rock"; 
        }
    }

    // Method to determine the winner
    public static String determineWinner(String userChoice, String computerChoice) {
        if (userChoice.equalsIgnoreCase(computerChoice)) {
            return "It's a tie!";
        }

        switch (userChoice.toLowerCase()) {
            case "rock":
                return (computerChoice.equalsIgnoreCase("Scissors")) ? "You win!" : "Computer wins!";
            case "paper":
                return (computerChoice.equalsIgnoreCase("Rock")) ? "You win!" : "Computer wins!";
            case "scissors":
                return (computerChoice.equalsIgnoreCase("Paper")) ? "You win!" : "Computer wins!";
            default:
                return "Invalid choice!";
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userChoice, computerChoice, playAgain = "no";
        int computer = 0, user = 0;

        System.out.println("Welcome to Rock, Paper, Scissors Game!");

        do {
            // Take user input
            System.out.print("Enter your choice (Rock, Paper, Scissors): ");
            userChoice = scanner.nextLine().trim();

            // Ensure the user input is one of the valid choices
            if (!userChoice.equalsIgnoreCase("Rock") && 
                !userChoice.equalsIgnoreCase("Paper") && 
                !userChoice.equalsIgnoreCase("Scissors")) {
                System.out.println("Invalid input! Please enter Rock, Paper, or Scissors.");
                continue;
            }

            // Get the computer's choice
            computerChoice = getComputerChoice();

            // Display the computer's choice
            System.out.println("Computer chose: " + computerChoice);

            // Determine and display the result
            String result = determineWinner(userChoice, computerChoice);
            System.out.println(result);
            
            if(result.equals("You win!")) {
            	user++; 
            } else if(result.equals("Computer wins!")){
            	computer++;
            }

            // Ask if the user wants to play again
            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = scanner.nextLine().trim();

            
        } while (playAgain.equalsIgnoreCase("yes"));
        
        System.out.println("Score : [User : "+user+"], [computer : "+computer+"]");
        System.out.println("Thanks for playing!");
        scanner.close();
    }
}

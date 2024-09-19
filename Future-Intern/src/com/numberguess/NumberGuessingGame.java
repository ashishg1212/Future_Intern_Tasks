package com.numberguess;
import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
	
	// Main method 
    public static void main(String[] args) {
        playGame();
    }
    
    // method to start the game
    public static void playGame() {
    	
        // its Generate a random number
        Random random = new Random();
        int correctNumber = random.nextInt(100) + 1;

        Scanner scanner = new Scanner(System.in);
        int userGuess = 0;  
        int attempts = 0;  

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Try to guess the number (between 1 and 100):");

        
        while (userGuess != correctNumber) {
        	
            System.out.print("Enter your guess: ");
            userGuess = scanner.nextInt();
            attempts++;

            if (userGuess < correctNumber) {
                System.out.println("Your guess is too low. Try again.");
            } else if (userGuess > correctNumber) {
                System.out.println("Your guess is too high. Try again.");
            } else {
                System.out.println("Congratulations! You guessed the correct number: " + correctNumber);
                System.out.println("You took " + attempts + " attempts to guess the correct number.");
            }
        }

        scanner.close();
    }
}

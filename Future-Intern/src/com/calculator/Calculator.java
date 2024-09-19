package com.calculator;
import java.util.Scanner;

public class Calculator {

    // Method for addition
    public static double add(double a, double b) {
        return a + b;
    }

    // Method for subtraction
    public static double subtract(double a, double b) {
        return a - b;
    }

    // Method for multiplication
    public static double multiply(double a, double b) {
        return a * b;
    }

    // Method for division with exception handling
    public static double divide(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Error: Division by zero is not allowed.");
        }
        return a / b;
    }

    // Main method 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Display the menu for the user
        System.out.println("Select an operation:");
        System.out.println("1. Addition (+)");
        System.out.println("2. Subtraction (-)");
        System.out.println("3. Multiplication (*)");
        System.out.println("4. Division (/)");

        System.out.print("Enter the operation (1/2/3/4): ");
        int operation = scanner.nextInt();
       
        // Taking input 1
        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();
        
        // Taking input 2
        System.out.print("Enter the second number: ");
        double num2 = scanner.nextDouble();

        double result = 0;

        // Handling operations with try-catch for exceptions
        try {
            switch (operation) {
                case 1:
                    result = add(num1, num2);
                    System.out.println("Result: " + num1 + " + " + num2 + " = " + result);
                    break;
                case 2:
                    result = subtract(num1, num2);
                    System.out.println("Result: " + num1 + " - " + num2 + " = " + result);
                    break;
                case 3:
                    result = multiply(num1, num2);
                    System.out.println("Result: " + num1 + " * " + num2 + " = " + result);
                    break;
                case 4:
                    result = divide(num1, num2);
                    System.out.println("Result: " + num1 + " / " + num2 + " = " + result);
                    break;
                default:
                    System.out.println("Invalid operation. Please select a valid option.");
            }
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}

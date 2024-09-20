package com.passwordgenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RandomPasswordGenerator {

    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+<>?";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the password length: ");
        int length = scanner.nextInt();

        System.out.println("Select character types to include in the password:");
        System.out.print("Include uppercase letters? (yes/no): ");
        boolean includeUppercase = scanner.next().equalsIgnoreCase("yes");

        System.out.print("Include lowercase letters? (yes/no): ");
        boolean includeLowercase = scanner.next().equalsIgnoreCase("yes");

        System.out.print("Include numbers? (yes/no): ");
        boolean includeNumbers = scanner.next().equalsIgnoreCase("yes");

        System.out.print("Include special characters? (yes/no): ");
        boolean includeSpecialChars = scanner.next().equalsIgnoreCase("yes");

        // Generate and display the password
        String password = generatePassword(length, includeUppercase, includeLowercase, includeNumbers, includeSpecialChars);
        System.out.println("Generated Password: " + password);
        
        scanner.close();
    }

    // Method to generate the password
    public static String generatePassword(int length, boolean includeUppercase, boolean includeLowercase, boolean includeNumbers, boolean includeSpecialChars) {
        StringBuilder password = new StringBuilder();
        Random random = new Random();

        List<String> charPool = new ArrayList<>();
        if (includeUppercase) {
            charPool.add(UPPERCASE);
        }
        if (includeLowercase) {
            charPool.add(LOWERCASE);
        }
        if (includeNumbers) {
            charPool.add(NUMBERS);
        }
        if (includeSpecialChars) {
            charPool.add(SPECIAL_CHARACTERS);
        }
        if (charPool.isEmpty()) {
            throw new IllegalArgumentException("You must include at least one character type.");
        }
        for (int i = 0; i < length; i++) {
            String currentPool = charPool.get(random.nextInt(charPool.size()));
            char randomChar = currentPool.charAt(random.nextInt(currentPool.length()));
            password.append(randomChar);
        }

        return password.toString();
    }
}

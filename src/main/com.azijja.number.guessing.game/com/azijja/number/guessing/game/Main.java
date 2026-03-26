package com.azijja.number.guessing.game;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Try to guess the number between 1 and 100.");   
        System.out.print("Select a difficulty level: \n"); 

        for (Attempts attempt : Attempts.values()) {
            System.out.println(attempt.ordinal() + 1 + ". " + attempt.name() + " (" + attempt.getAttempts() + " attempts)");
        }

        System.out.print("Difficulty: ");
        Scanner scanner = new Scanner(System.in);
        int difficulty = scanner.nextInt();

        int attempts = Attempts.values()[difficulty - 1].getAttempts();
        System.out.println(Attempts.values()[difficulty - 1].name() + " difficulty selected. You have " + attempts + " attempts to guess the number.");
        System.out.println("Good luck!");
        System.out.println("-----------------------------------");

        int numberToGuess = (int) (Math.random() * 100) + 1;
        boolean hasWon = false;

        while (attempts > 0) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();

            if (userGuess == numberToGuess) {
                hasWon = true;
                break;
            } else if (userGuess < numberToGuess) {
                System.out.println("The number is greater than " + userGuess + ". Try again.");
            } else {
                System.out.println("The number is less than " + userGuess + ". Try again.");
            }
            attempts--;
            System.out.println("Attempts remaining: " + attempts);
        }

        if (hasWon) {
            System.out.println("Congratulations! You guessed the number!");
        } else {
            System.out.println("Game over! The number was: " + numberToGuess);
        }

        scanner.close();
    }
}

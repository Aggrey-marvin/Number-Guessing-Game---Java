package com.azijja.number.guessing.game;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Round {
    private boolean hasWon;
    private int userGuesses;
    private Attempts difficulty;
    
    public Round(Attempts difficulty) {
        this.difficulty = difficulty;
    }

    public boolean isWon() {
        return hasWon;
    }

    public void setHasWon(boolean hasWon) {
        this.hasWon = hasWon;
    }

    public int getUserGuesses() {
        return userGuesses;
    }

    public void setUserGuesses(int userGuesses) {
        this.userGuesses = userGuesses;
    }

    public Attempts getDifficulty() {
        return difficulty;
    }

    public void playRound(int numberToGuess, Scanner scanner) {
        int attempts = difficulty.getAttempts();
        while (attempts > 0) {
            int userGuess = 0;
            System.out.print("Enter your guess: ");
            try {
                userGuess = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // Clear the invalid input
                continue; // Skip the rest of the loop and prompt again
            }

            int invalidInputCount = 0;

            while (invalidInputCount < 3 && (userGuess < 1 || userGuess > 100)) {
                System.out.println("Please enter a number between 1 and 100.");
                invalidInputCount++;
                if (invalidInputCount == 3) {
                    System.out.println("Too many invalid attempts. That counts as a wrong guess.");
                    userGuess = numberToGuess + 1; // Set to an invalid guess to ensure it counts as wrong
                    break;
                }
                System.out.print("Enter your guess: ");
                try {
                    userGuess = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.next(); // Clear the invalid input
                    continue; // Skip the rest of the loop and prompt again
                }
            }

            userGuesses++;

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
    }
}

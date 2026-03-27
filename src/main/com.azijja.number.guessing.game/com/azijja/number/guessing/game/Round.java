package com.azijja.number.guessing.game;

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
            
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
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

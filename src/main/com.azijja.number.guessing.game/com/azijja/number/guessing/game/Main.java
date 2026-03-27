package com.azijja.number.guessing.game;

import java.util.ArrayList;
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

        int failureCount = 0;
        while (failureCount < 3 && (difficulty < 1 || difficulty > Attempts.values().length)) {
            System.out.println("Invalid difficulty level. Please select a valid option.");
            System.out.print("Difficulty: ");
            difficulty = scanner.nextInt();
            failureCount++;
        }

        int attempts = Attempts.values()[difficulty - 1].getAttempts();
        System.out.println(Attempts.values()[difficulty - 1].name() + " difficulty selected. You have " + attempts + " attempts to guess the number.");
        System.out.println("Good luck!");
        System.out.println("-----------------------------------");

        int numberToGuess = (int) (Math.random() * 100) + 1;

        boolean continueGame = true;
        ArrayList<Round> rounds = new ArrayList<>();

        while (continueGame) {
            Round round = new Round(Attempts.values()[difficulty - 1]);
            round.playRound(numberToGuess, scanner);
            rounds.add(round);

            System.out.println("Do you want to play another round? (y/any other key to exit)");
            String response = scanner.next();
            if (!response.equalsIgnoreCase("y")) {
                continueGame = false;
            } else {
                numberToGuess = (int) (Math.random() * 100) + 1;
            }
        }  
        
        System.out.println("Thank you for playing! Here are your results:");
        System.out.println("Round\tDifficulty\tGuesses\tResult");
        for (int i = 0; i < rounds.size(); i++) {
            Round round = rounds.get(i);
            System.out.println((i + 1) + "\t" + round.getDifficulty() + "\t" + round.getUserGuesses() + "\t" + (round.isWon() ? "Won" : "Lost"));
        }
        
        scanner.close();
    }
}

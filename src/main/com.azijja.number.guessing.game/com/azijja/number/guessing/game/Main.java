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

        Round round = new Round(Attempts.values()[difficulty - 1]);
        round.playRound(numberToGuess, scanner.nextInt());

        scanner.close();
    }
}

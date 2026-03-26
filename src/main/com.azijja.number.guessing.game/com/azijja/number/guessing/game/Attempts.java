package com.azijja.number.guessing.game;

public enum Attempts {
    EASY(10),
    MEDIUM(7),
    HARD(5);

    private final int attempts;

    Attempts(int attempts) {
        this.attempts = attempts;
    }

    public int getAttempts() {
        return attempts;
    }
}

package org.bohdanrakov.gamemvc.model;

public class MoreOrLessGame {

    private int lastGuess;
    private boolean lastGuessSmaller;
    private boolean guessed = false;

    private int rangeMin;
    private int rangeMax;

    private int numberToGuess;
    private int numberOfTries = 0;
    private int[] tries;

    public MoreOrLessGame(int minValue, int maxValue) {
        this.numberToGuess = RandomGenerator.rand(minValue, maxValue);
        this.tries = new int[maxValue + 1];
        this.rangeMin = minValue;
        this.rangeMax = maxValue;
    }

    /**
     * Method that checks User's guess to be equal to the {@code numberToGuess}.
     * If guess is correct, return {@code true} else adjust the
     * range for user to guess from appropriately with {@code adjustRange()}.
     * This method also saves the guessed number to {@code tries array} and
     * saves last try to {@code lastGuess} variable
     * @param guess
     * @return
     */
    public boolean makeGuess(int guess) {
        tries[numberOfTries] = guess;
        numberOfTries++;
        lastGuess = guess;

        if (guess == numberToGuess) {
            guessed = true;
            return true;
        } else {
            adjustRange();
            return false;
        }
    }

    /**
     * Adjusts range for player to guess from
     * depending on the las guess he made. If his guess is greater than
     * actual number, make a {@code rangeMax} maximum range bound
     * smaller than {@code lastGuess} by one. If the guess is smaller, make
     * {@code rangeMin} minimum range bound greater than lastGuess by one
     */
    private void adjustRange() {
        if (lastGuess > numberToGuess) {
            rangeMax = lastGuess - 1;
            lastGuessSmaller = false;
        } else {
            rangeMin = lastGuess + 1;
            lastGuessSmaller = true;
        }
    }

    /**
     * Returns String representation of tries array, to get rid of
     * trailing zeroes
     * @return {@code String} representing tries array
     */
    public String getTriesAsString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numberOfTries; i++) {
            sb.append(tries[i]).append(" ");
        }
        return sb.toString();
    }

    public int getLastGuess() {
        return this.lastGuess;
    }

    public int getNumberOfTries() {
        return this.numberOfTries;
    }

    public boolean isGuessed() {
        return this.guessed;
    }

    public int getRangeMin() {
        return rangeMin;
    }

    public int getRangeMax() {
        return rangeMax;
    }

    public boolean isLastGuessSmaller() {
        return this.lastGuessSmaller;
    }
}

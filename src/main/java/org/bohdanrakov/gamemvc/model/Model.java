package org.bohdanrakov.gamemvc.model;

public class Model {

    /** Holds last guess made by user*/
    private int lastGuess;

    /** Range for user to make guess. Changes after each try with adjustRange() */
    private int rangeMin, rangeMax;

    private int numberToGuess;
    private int numberOfTries = 0;
    /** Array that holds users tries to guess the number*/
    private int[] tries;

    /**
     * Sets the game range
     * @param minimum minimum bound (exclusive)
     * @param maximum maximum bound (exclusive)
     */
    public void setRange(int minimum, int maximum) {
        rangeMin = minimum;
        rangeMax = maximum;
    }

    /**
     * Sets the number which user has to guess
     * From (rangeMin to rangeMax) exclusive
     */
    public void setNumberToGuess() {
        numberToGuess = RandomGenerator.rand(rangeMin + 1, rangeMax - 1);
    }

    /**
     * Method required to initialize the user's history of tries.
     * Required because customer wanted array implementation instead of {@code List}
     */
    public void initializeHistoryOfTries() {
        tries = new int[rangeMax];
    }

    /**
     * Method that checks User's guess to be equal to the {@code numberToGuess}.
     * If guess is correct, return {@code true} else adjust the
     * range for user to guess from appropriately with {@code adjustRange()}.
     * @param guess Users guess
     * @return {@code true} if number is guessed
     */
    public boolean makeGuess(int guess) {
        addToHistoryOfGuesses(guess);

        if (guess == numberToGuess) {
            return true;
        } else {
            adjustRange();
            return false;
        }
    }

    /**
     * This method saves the guessed number to {@code tries array} and
     * saves last try to {@code lastGuess} variable
     * @param guess guess made by user
     */
    private void addToHistoryOfGuesses(int guess) {
        tries[numberOfTries] = guess;
        numberOfTries++;
        lastGuess = guess;
    }

    /**
     * Checks if the last user guess is smaller than number to guess
     * @return true if lastGuess < numberToGuess
     */
    public boolean isLastGuessSmaller() {
        return lastGuess < numberToGuess;
    }

    /**
     * Adjusts range for player to guess from
     * depending on the last guess he made. If his guess is greater than
     * actual number, make a {@code rangeMax} maximum range bound equal to {@code lastGuess}.
     * If the guess is smaller, make {@code rangeMin} minimum range bound equal to {@code lastGuess}
     */
    private void adjustRange() {
        if (lastGuess > numberToGuess) {
            rangeMax = lastGuess;
        } else {
            rangeMin = lastGuess;
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

    public int getRangeMin() {
        return rangeMin;
    }

    public int getRangeMax() {
        return rangeMax;
    }

    int getNumberToGuess() {
        return numberToGuess;
    }
}

package org.bohdanrakov.gamemvc.model;

public class MoreOrLess {

    private int lastGuess;
    private boolean guessed = false;

    private int numberToGuess;
    private int numberOfTries = 0;
    private int[] tries;

    public MoreOrLess(int minValue, int maxValue) {
        this.numberToGuess = RandomGenerator.rand(minValue, maxValue);
        this.tries = new int[maxValue];
    }

    /**
     *
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
     *
     */
    private void adjustRange() {

    }

    public int[] getTries() {
        return this.tries;
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
}

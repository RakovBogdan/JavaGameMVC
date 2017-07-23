package org.bohdanrakov.gamemvc;

import org.bohdanrakov.gamemvc.model.*;

import java.util.Scanner;

public class Controller {

    private Model game;
    private View view;

    public Controller(Model model, View view) {
        this.view = view;
        this.game = model;
    }

    /**
     * Working method of the game
     */
    public void processUser() {
        view.printMessage(View.WELCOME);

        //Initialize game
        game.setRange(BoundsConstants.MIN_VALUE, BoundsConstants.MAX_VALUE);
        game.setNumberToGuess();
        game.initializeHistoryOfTries();

        Scanner scanner = new Scanner(System.in);

        while (!game.makeGuess(getUserInput(scanner))) { showStatistics(); }

        showGameOver();
    }

    //Utility Methods

    public int inputIntValue(Scanner scanner) {
        view.printMessage(View.INPUT_INT_DATA);
        while (!scanner.hasNextInt()) {
            view.printMessage(View.WRONG_INPUT_TYPE);
            scanner.next();
        }
        return scanner.nextInt();
    }

    /**
     * Checks the value to be in given range (exclusive)
     * @param value value to check
     * @param rangeMin minimum value (bound) of range
     * @param rangeMax maximum value (bound) of range
     * @return {@code true} if value is in range
     */
    public boolean isValueInRange(int value, int rangeMin, int rangeMax) {
        if (value <= rangeMin || value >= rangeMax) {
            view.printMessageAndTwoInts(View.WRONG_INPUT_RANGE, rangeMin, rangeMax);
            return false;
        } else {
            return true;
        }
    }

    /**
     * Gets user input with {@code inputIntValue()}
     * and performs checking if the user input is in game's range with {@code isValueInRange()}
     * @param scanner {@code Scanner}
     * @return {@code int} guess made by user
     */
    public int getUserInput(Scanner scanner) {
        view.printMessageAndTwoInts(View.RANGE, game.getRangeMin(),
                game.getRangeMax());

        int guess = inputIntValue(scanner);

        while (!isValueInRange(guess, game.getRangeMin(), game.getRangeMax())) {
            guess = inputIntValue(scanner);
        }

        return guess;
    }

    /**
     * Method that calls {@code View} to show game statistics
     */
    public void showStatistics() {
        view.printMessage(View.STATISTICS);
        view.printMessageAndInt(View.NUMBER_OF_TRIES, game.getNumberOfTries());
        view.printMessage(View.TRIES + game.getTriesAsString());
        view.printMessageAndInt(View.LAST_GUESS, game.getLastGuess());
        view.printMessage(View.STATISTICS_LOWER);
        view.printMessage("");
        if (game.isLastGuessSmaller()) {
            view.printMessage(View.IS_SMALLER);
        } else {
            view.printMessage(View.IS_BIGGER);
        }
    }

    /**
     * Method that calls {@code View} to show end of the game
     */
    public void showGameOver() {
        view.printMessageAndInt(View.GAME_OVER, game.getLastGuess());
        view.printMessageAndInt(View.NUMBER_OF_TRIES, game.getNumberOfTries());
        view.printMessage(View.TRIES + game.getTriesAsString());
    }
}

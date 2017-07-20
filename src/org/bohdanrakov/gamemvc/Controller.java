package org.bohdanrakov.gamemvc;

import org.bohdanrakov.gamemvc.model.*;

import java.util.Scanner;

public class Controller {

    private MoreOrLessGame game;
    private View view;

    public Controller(View view) {
        this.view = view;
        this.game = new MoreOrLessGame(0, 100);
    }

    /**
     * Working method of the game
     */
    public void processUser() {
        view.printMessage(View.WELCOME);
        Scanner scanner = new Scanner(System.in);

        makeGuess(scanner);

        while (!game.isGuessed()) {
            showStatistics();

            if (game.isLastGuessSmaller()) view.printMessage(View.IS_SMALLER);
            else view.printMessage(View.IS_BIGGER);
            view.printMessageAndTwoInts(View.RANGE, game.getRangeMin(),
                    game.getRangeMax());

            makeGuess(scanner);
        }

        showGameOver();
    }

    //Utility Methods

    /**
     * Method that uses {@code View} to show game statistics
     */
    public void showStatistics() {
        view.printMessage(View.STATISTICS);
        view.printMessageAndInt(View.NUMBER_OF_TRIES, game.getNumberOfTries());
        view.printMessage(View.TRIES + game.getTriesAsString());
        view.printMessageAndInt(View.LAST_GUESS, game.getLastGuess());
        view.printMessage(View.STATISTICS_LOWER);
        view.printMessage("");
    }

    /**
     * Method that uses {@code View} to show end of the game
     */
    public void showGameOver() {
        view.printMessageAndInt(View.GAME_OVER, game.getLastGuess());
        view.printMessageAndInt(View.NUMBER_OF_TRIES, game.getNumberOfTries());
        view.printMessage(View.TRIES + game.getTriesAsString());
    }

    public int inputIntValue(Scanner scanner) {
        view.printMessage(View.INPUT_INT_DATA);
        while (!scanner.hasNextInt()) {
            view.printMessage(View.WRONG_INPUT_TYPE);
            scanner.next();
        }
        return scanner.nextInt();
    }

    /**
     * Checks the value to be in given range (inclusive)
     * @param value value to check
     * @param rangeMin minimum value (bound) of range
     * @param rangeMax maximum value (bound) of range
     * @return {@code true} if value is in range
     */
    public boolean isValueInRange(int value, int rangeMin, int rangeMax) {
        if (value < rangeMin || value > rangeMax) {
            view.printMessageAndTwoInts(View.WRONG_INPUT_RANGE, rangeMin, rangeMax);
            return false;
        } else {
            return true;
        }
    }

    /**
     * Method that makes guess call to model.
     * Gets user input with {@code inputIntValue()}
     * and performs checking if the user input is in game's range with {@code isValueInRange()}
     * @param scanner {@code Scanner}
     */
    public void makeGuess(Scanner scanner) {
        int guess;
        do {
            guess = inputIntValue(scanner);
        } while (!isValueInRange(guess, game.getRangeMin(), game.getRangeMax()));
        game.makeGuess(guess);
    }
}

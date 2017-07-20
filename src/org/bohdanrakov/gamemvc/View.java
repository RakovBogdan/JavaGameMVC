package org.bohdanrakov.gamemvc;

public class View {

    public static final String WELCOME = "Welcome to More or less game!\n" +
            "Enter a number to guess from 0 to 100:";
    public static final String INPUT_INT_DATA = "Input INT value: ";
    public static final String WRONG_INPUT_TYPE = "Wrong input! Input INTEGER value: ";
    public static final String WRONG_INPUT_RANGE = "Wrong input! Input value in given range: ";
    public static final String IS_SMALLER = "Nope! Try bigger number";
    public static final String IS_BIGGER = "Nope! Try smaller number";
    public static final String TRIES = "Your tries are: ";
    public static final String NUMBER_OF_TRIES = "Number of tries: ";
    public static final String LAST_GUESS = "Your last guess is: ";
    public static final String STATISTICS = "-------Statistics-------";
    public static final String STATISTICS_LOWER = "------------------------";
    public static final String GAME_OVER = "Congratulations! You've got the number: ";
    public static final String RANGE = "Your range is: ";
    private static final String DELIMITER = " ";

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printMessageAndInt(String message, int value) {
        System.out.println(message + value);
    }

    public void printMessageAndTwoInts(String message, int value1, int value2) {
        System.out.println(message + value1 + DELIMITER + value2);
    }
}

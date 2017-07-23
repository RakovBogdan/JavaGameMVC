package org.bohdanrakov.gamemvc.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ModelTest {

    private Model model;
    private int numberToGuess;
    private int wrongGuessHigher;
    private int wrongGuessLower;

    /**
     * Model initialization before every test
     */
    @Before
    public void setUp() {
        model = new Model();
        model.setRange(BoundsConstants.MIN_VALUE, BoundsConstants.MAX_VALUE);
        model.initializeHistoryOfTries();
        model.setNumberToGuess();
        numberToGuess = model.getNumberToGuess();
        wrongGuessHigher = numberToGuess + 1;
        wrongGuessLower = numberToGuess - 1;
    }

    /**
     * Checks the number to be guessed to be BETWEEN range values of model
     */
    @Test
    public void testGuessedNumberInRangeExclusive() {
        for (int i = 0; i < 10000; i++) {
            model.setNumberToGuess();
            int number = model.getNumberToGuess();
            if (number <= BoundsConstants.MIN_VALUE || number >= BoundsConstants.MAX_VALUE) {
                fail("guessed number " + number + " is out of bounds");
            }
        }
    }

    /**
     * Tests if makeGuess returns true properly when number is guessed
     */
    @Test
    public void testGuessingRight() {
        assertTrue(model.makeGuess(numberToGuess));
    }

    /**
     * Tests if makeGuess returns false properly when number is not guessed
     */
    @Test
    public void testGuessingWrong() {
        assertFalse(model.makeGuess(wrongGuessHigher));
    }

    /**
     * Tests proper range adjustment by model, if wrong guess is higher
     */
    @Test
    public void testRangeAdjustmentUpper() {
        model.makeGuess(wrongGuessHigher);
        assertEquals(wrongGuessHigher, model.getRangeMax());
    }

    /**
     * Tests proper range adjustment by model, if wrong guess is lower
     */
    @Test
    public void testRangeAdjustmentLower() {
        model.makeGuess(wrongGuessLower);
        assertEquals(wrongGuessLower, model.getRangeMin());
    }

    /**
     * tests isLastGuessSmaller method to return true
     * if last wrong guess was smaller
     */
    @Test
    public void testLastGuessSmaller() {
        model.makeGuess(wrongGuessLower);
        assertTrue(model.isLastGuessSmaller());
    }

    /**
     * tests isLastGuessSmaller method to return false
     * if last wrong guess was bigger
     */
    @Test
    public void testLastGuessBigger() {
        model.makeGuess(wrongGuessHigher);
        assertFalse(model.isLastGuessSmaller());
    }

    /**
     * Tests the numberOfTries field to be set properly after
     * calls to makeGuess
     */
    @Test
    public void testNumberOfTriesIncrementing() {
        model.makeGuess(wrongGuessHigher);
        model.makeGuess(wrongGuessLower);
        assertEquals(2, model.getNumberOfTries());
    }

    /**
     * Test the proper saving of users history of tries
     */
    @Test
    public void testTriesArrayStringRepresentation() {
        model.makeGuess(wrongGuessHigher);
        model.makeGuess(wrongGuessLower);
        String expectedString = wrongGuessHigher + " " +
                wrongGuessLower + " ";
        assertEquals(expectedString, model.getTriesAsString());
    }

}

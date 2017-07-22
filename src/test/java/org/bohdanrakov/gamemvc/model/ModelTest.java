package org.bohdanrakov.gamemvc.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ModelTest {

    private Model model;
    private int numberToGuess;

    @Before
    public void setUp() {
        model = new Model();
        model.setRange(BoundsConstants.MIN_VALUE, BoundsConstants.MAX_VALUE);
        model.initializeHistoryOfTries();
        model.setNumberToGuess();
        numberToGuess = model.getNumberToGuess();
    }

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

    @Test
    public void testGuessingRight() {
        assertTrue(model.makeGuess(numberToGuess));
    }

    @Test
    public void testGuessingWrong() {
        assertFalse(model.makeGuess(numberToGuess - 1));
    }

    @Test
    public void testRangeAdjustmentUpper() {
        model.makeGuess(numberToGuess + 1);
        assertEquals(numberToGuess + 1, model.getRangeMax());
    }

    @Test
    public void testRangeAdjustmentLower() {
        model.makeGuess(numberToGuess - 1);
        assertEquals(numberToGuess - 1, model.getRangeMin());
    }

    @Test
    public void testLastGuessSmaller() {
        model.makeGuess(numberToGuess - 1);
        assertTrue(model.isLastGuessSmaller());
    }

    @Test
    public void testLastGuessBigger() {
        model.makeGuess(numberToGuess + 1);
        assertFalse(model.isLastGuessSmaller());
    }

}

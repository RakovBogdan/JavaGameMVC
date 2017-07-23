package org.bohdanrakov.gamemvc.model;

import org.junit.Test;
import static org.junit.Assert.fail;


public class RandomGeneratorTest {

    /**
     * Checks RandomGenerator.rand() not to return negative values
     */
    @Test
    public void testRandomIsNotNegative() {
        for (int i = 0; i < 100000; i++) {
            int value = RandomGenerator.rand();
            if (value < 0) {
                fail("Value " + value + " is smaller than 0");
            }
        }
    }

    /**
     * Checks the return of RandomGenerator.rand(min, max) to be in
     * range of min and max values
     */
    @Test
    public void testIfReturnIsNotInRange() {
        for (int i = 0; i < 100000; i++) {
            int value = RandomGenerator.rand(0, 100);
            if (value < 0 || value > 100) {
                fail("Value " + value + " is not in range");
            }
        }
    }
}

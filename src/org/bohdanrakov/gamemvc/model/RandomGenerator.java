package org.bohdanrakov.gamemvc.model;

import java.util.Random;

public class RandomGenerator {

    private static final int RAND_MAX = Integer.MAX_VALUE;

    /**
     * Method that generates random {@code int} value
     * @return random {@code int} between [0, RAND_MAX] inclusive
     */
    public static int rand() {
        return new Random().nextInt(RAND_MAX);
    }

    /**
     * Method which generates random value on given parameters
     * @param min minimum bound for random value (inclusive)
     * @param max maximum bound for random value (inclusive)
     * @return random {@code int} between [min, max] inclusive
     */
    public static int rand(int min, int max) {
        return new Random().nextInt(max + 1 - min) + min;
    }
}

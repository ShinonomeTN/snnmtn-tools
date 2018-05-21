package com.shinonometn.commons.tools;

import java.util.Random;
import java.util.UUID;

public final class Randoms {
    private final static Random random = new Random(System.currentTimeMillis());

    private final static char[] alphaSet = "asdfghjklqwertyuiopzxcvbnm1234567890mnbvcxzlkjhgfdsapoiuytrewq0987654321".toCharArray();
    private final static char[] numberSet = "6574839201".toCharArray();

    /**
     *
     * Generate an random timestamp id
     *
     * @param ms a snapshot time
     * @return string
     */
    public static String randomTimeId(long ms) {
        return String.format("%011d%06d", ms, random.nextInt(999999));
    }

    /**
     *
     * Generate an random timestamp id using current timestamp
     *
     * @return string
     */
    public static String randomTimeId() {
        return randomTimeId(System.currentTimeMillis());
    }

    /**
     *
     * Generate random UUID
     *
     * @return uuid
     */
    public static String randomUUID() {
        return UUID.randomUUID().toString();
    }

    /**
     *
     * Generate random string using numbers and small-case alphas
     *
     * @param length how long the string is
     * @return random string
     */
    public static String randomString(int length) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            stringBuilder.append(alphaSet[random.nextInt(alphaSet.length)]);
        }
        return stringBuilder.toString();
    }

    /**
     *
     * Generate random string using numbers
     *
     * @param length how long
     * @return random number
     */
    public static String randomNumber(int length) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            stringBuilder.append(numberSet[random.nextInt(numberSet.length)]);
        }
        return stringBuilder.toString();
    }
}

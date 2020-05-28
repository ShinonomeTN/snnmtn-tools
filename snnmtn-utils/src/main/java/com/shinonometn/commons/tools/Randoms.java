package com.shinonometn.commons.tools;

import java.util.Random;
import java.util.UUID;

public final class Randoms {
    private Randoms() {}

    private final static ThreadLocal<Random> randomPool = ThreadLocal.withInitial(() -> new Random(System.currentTimeMillis()));

    private final static char[] alphaSet = "zpqal1ksowmx2cneijd3ufurbv4ytg780965".toCharArray();
    private final static char[] numberSet = "6574839201".toCharArray();

    /**
     * Get current thread instance
     *
     * @return java random instance
     */
    public static Random instance() {
        return randomPool.get();
    }

    /**
     * Generate an random timestamp id
     *
     * @param ms a time snapshot
     * @return string
     */
    public static String randomTimeId(long ms) {
        return String.format("%011d%06d", ms, instance().nextInt(999999));
    }

    /**
     * Generate an random timestamp id using current timestamp
     *
     * @return string
     */
    public static String randomTimeId() {
        return randomTimeId(System.currentTimeMillis());
    }

    /**
     * Generate random UUID
     *
     * @return uuid
     */
    public static String randomUUID() {
        return UUID.randomUUID().toString();
    }

    /**
     * Generate random string using numbers and small-case alphas
     *
     * @param length how long the string is
     * @return random string
     */
    public static String randomString(int length) {
        Random random = instance();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            stringBuilder.append(alphaSet[random.nextInt(alphaSet.length)]);
        }
        return stringBuilder.toString();
    }

    /**
     *
     * Generate random string using given charset
     *
     * @param length length
     * @param charset given charset
     * @return random string
     */
    public static String randomString(int length, char[] charset) {
        Random random = instance();
        char[] result = new char[length];
        for (int i = 0; i < length; i++) {
            result[i] = charset[random.nextInt(charset.length)];
        }
        return new String(result);
    }

    /**
     * Generate random string using numbers
     *
     * @param length how long
     * @return random number
     */
    public static String randomNumberInString(int length) {
        Random random = instance();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            stringBuilder.append(numberSet[random.nextInt(numberSet.length)]);
        }
        return stringBuilder.toString();
    }

    /**
     * Get random int in bound
     *
     * @param min bottom of bound
     * @param max ceiling of bound
     * @return int in bound
     */
    public static int randomInt(int min, int max) {
        Random random = instance();
        if (min > max) throw new IllegalArgumentException("The smaller one could not bigger than the bigger one");
        return random.nextInt(max - min) + min;
    }

    /**
     * Get the random instance
     *
     * @return
     */
    @Deprecated
    public static Random random() {
        return instance();
    }
}

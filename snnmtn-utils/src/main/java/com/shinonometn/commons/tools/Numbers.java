package com.shinonometn.commons.tools;

public final class Numbers {
    /**
     *
     * Scale a double to integer
     *
     * @param n double number
     * @param factor exp, base on 10
     * @return integer
     */
    public static int scaleUpToInt(double n, int factor) {
        return Math.toIntExact(Math.round(n * factor));
    }

    /**
     *
     * Scale down a integer to double
     *
     * @param n integer number
     * @param factor exp, base on 10
     * @return double
     */
    public static double scaleDownToDouble(double n, int factor) {
        return n / factor;
    }

    /**
     *
     * Parse a string to double, if failed, return 0.0
     *
     * @param number number represented in string
     * @return double
     */
    public static double parseDoubleOrZero(String number) {
        if (number == null) return 0.0;
        try {
            return Double.parseDouble(number);
        } catch (Exception e) {
            return 0.0;
        }
    }

    /**
     *
     * Truncate double number by given factor
     *
     * @param n double number
     * @param factor exp, 10 for 0.1, 100 for 0.01, etc.
     * @return double number
     */
    public static double truncate(double n, int factor) {
        return ((double) Math.round(n * factor)) / factor;
    }

//    Maybe we don't need this
//    public static Double floor(Double n, int factor) {
//        return ((double) Math.floor(n * factor)) / factor;
//    }
}

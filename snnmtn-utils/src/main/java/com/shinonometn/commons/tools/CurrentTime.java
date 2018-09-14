package com.shinonometn.commons.tools;

import java.util.concurrent.TimeUnit;

/**
 *
 * Tools for get current timestamp
 *
 */
public final class CurrentTime {

    /**
     *
     * Get current timestamp in seconds
     *
     * @return seconds
     */
    public static long second() {
        return TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
    }

    /**
     *
     * Get current timestamp in milliseconds
     *
     * @return milliseconds
     */
    public static long milli(){
        return System.currentTimeMillis();
    }

    /**
     *
     * Get current timestamp in nano-seconds
     *
     * @return nano-seconds
     */
    public static long nano(){
        return System.nanoTime();
    }
}

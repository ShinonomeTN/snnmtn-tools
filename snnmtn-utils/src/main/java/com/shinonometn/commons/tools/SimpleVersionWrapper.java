package com.shinonometn.commons.tools;

/**
 *
 * Simple implement of VersionWrapper
 *
 * @param <T> T
 */
public class SimpleVersionWrapper<T> implements VersionWrapper<T> {

    private long timestamp;
    private T data;

    /**
     *
     * Create with empty content , timestamp is current
     *
     */
    public SimpleVersionWrapper() {
        timestamp = CurrentTime.milli();
    }

    /**
     *
     * Create with timestamp presented
     *
     * @param timestamp timestamp, milliseconds
     */
    public SimpleVersionWrapper(long timestamp) {
        this.timestamp = timestamp;
    }

    /**
     *
     * Create with timestamp and content
     *
     * @param timestamp timestamp, milliseconds
     * @param data data
     */
    public SimpleVersionWrapper(long timestamp, T data) {
        this.timestamp = timestamp;
        this.data = data;
    }

    /*
    *
    * Implementations
    *
    * */

    @Override
    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public T getData() {
        return data;
    }

    @Override
    public void setData(T data) {
        this.data = data;
    }
}

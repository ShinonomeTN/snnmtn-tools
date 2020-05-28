package com.shinonometn.commons.models;

/**
 * A object that store an object with timestamp
 *
 * @param <T> T
 */
public interface VersionWrapper<T> {

    /**
     * Get latest changed timestamp
     *
     * @return timestamp in milliseconds
     */
    long getTimestamp();

    /**
     * Change timestamp.
     * <p>
     * Normally, the implement should change the version
     * timestamp when new content was apply, and the timestamp
     * should not be changed manually.
     * <p>
     * Implement this method if necessary
     *
     * @param timestamp timestamp, milliseconds
     */
    default void setTimestamp(long timestamp) {
    }

    /**
     * Alias of getData()
     *
     * @param data content
     */
    default void put(T data) {
        setData(data);
    }

    /**
     * Get content
     *
     * @return content
     */
    T getData();

    /**
     * Put a content and update timestamp
     *
     * @param data content
     */
    void setData(T data);
}

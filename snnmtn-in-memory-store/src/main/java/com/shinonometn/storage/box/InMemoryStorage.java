package com.shinonometn.storage.box;

/**
 *
 * InMemoryStorage interface, provides some method to manage instances
 *
 * InMemoryStorage is a concept for managing some global information in CMS systems that
 * need to be update and change frequently.
 *
 * It is using in ReSSIM course data system for storing and managing term info, visitor statistics,
 * school calendar and other global information.
 *
 * It recommenced to inherit the children of InMemoryStorageAdapter for usage
 *
 */
public interface InMemoryStorage {

    /**
     *
     * Provide a domain name to manage those storage
     *
     * @return string
     */
    String domain();

    /**
     * Clear all data
     */
    void clear();

    /**
     *
     * Reset the storage to it's initial state
     *
     * default is clear all data
     *
     */
    default void reset(){
        clear();
    }

}

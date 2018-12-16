package com.shinonometn.storage.box;

/**
 * ValueStorageProvider interface
 *
 * Provide a storage only store single bean
 */
public interface ValueStorageProvider {

    /**
     * Store a bean
     *
     * @param storeKey main store scope
     * @param bean bean
     */
    void store(String storeKey,Object bean);

    /**
     *
     * Get a bean
     *
     * @param storeKey main store scope
     * @param typeInfo bean type info
     * @param <T> bean type
     * @return bean
     */
    <T> T get(String storeKey, Class<T> typeInfo);
}

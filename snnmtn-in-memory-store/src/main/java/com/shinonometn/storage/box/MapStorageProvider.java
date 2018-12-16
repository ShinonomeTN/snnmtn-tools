package com.shinonometn.storage.box;

import java.util.Collection;

public interface MapStorageProvider {

    /**
     * Store a bean
     *
     * @param storeKey the main store scope
     * @param scope    sub scope
     * @param bean     bean
     */
    void store(String storeKey, String scope, Object bean);

    /**
     * Get a bean
     *
     * @param storeKey    main store scope
     * @param scope       sub scope
     * @param contentType bean type info
     * @param <T>         bean type
     * @return bean
     */
    <T> T get(String storeKey, String scope, Class<?> contentType);

    /**
     * Get a collection of stored bean
     *
     * @param storeKey    main store scope
     * @param contentType bean type info
     * @param <T>         bean type
     * @return Collection of bean
     */
    <T> Collection<T> values(String storeKey, Class<?> contentType);

    /**
     * Get a collection of stored keys
     *
     * @param storeKey main store scope
     * @return Collection of scopes
     */
    Collection<String> scopes(String storeKey);


}

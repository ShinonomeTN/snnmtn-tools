package com.shinonometn.storage.box.impl;

import com.shinonometn.storage.box.InMemoryStorage;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * InMemoryStorage adapter, base class.
 *
 * @param <T> the type of content that mainly stored
 */
public abstract class InMemoryStorageAdapter<T> implements InMemoryStorage {

    private final String domain;

    /**
     * For access the storage scope
     * Children readable field, initialized at constructing.
     */
    protected final String storeKey;

    /**
     * The main content type of this storage
     */
    protected final Class<?> contentType;

    public InMemoryStorageAdapter(String domain) {
        this.domain = domain;
        this.storeKey = String.format("%s.%s",getStoreKey(),domain);

        this.contentType = getSelfMainType();
    }

    /**
     * Generate the store key for identify the storage, it usually
     * for Redis key or Map key
     *
     * @return store key
     */
    protected abstract String getStoreKey();

    @Override
    public String domain() {
        return domain;
    }

    public abstract void clear();

    /*
     *
     * Private procedures
     *
     * */

    @SuppressWarnings("unchecked")
    private Class<?> getSelfMainType() {
        Type mainType = getClass().getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) mainType;
        return (Class<T>) parameterizedType.getActualTypeArguments()[0];
    }
}

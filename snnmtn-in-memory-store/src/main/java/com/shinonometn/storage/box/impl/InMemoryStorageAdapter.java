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

    private final String globalScope;
    private final String domain;

    /**
     * For access the storage scope
     * Children readable field, initialized at constructing.
     */
    protected final String storeKey;

    /**
     * The main content type of this storage
     */
    protected final Class<T> contentType;

    public InMemoryStorageAdapter(String globalScope,String domain) {
        this.domain = domain;
        this.globalScope = globalScope;

        this.storeKey = String.format("%s.%s", globalScope,domain);

        this.contentType = getSelfMainType();
    }

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
    private Class<T> getSelfMainType() {
        Type mainType = getClass().getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) mainType;
        return (Class<T>) parameterizedType.getActualTypeArguments()[0];
    }
}

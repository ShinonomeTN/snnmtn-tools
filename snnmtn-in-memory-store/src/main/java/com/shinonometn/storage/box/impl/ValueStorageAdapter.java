package com.shinonometn.storage.box.impl;

import com.shinonometn.storage.box.ValueStorageProvider;

public abstract class ValueStorageAdapter<T> extends InMemoryStorageAdapter<T> {

    private ValueStorageProvider valueStorageProvider;

    public ValueStorageAdapter(String domain, ValueStorageProvider valueStorageProvider) {
        super(domain);
        this.valueStorageProvider = valueStorageProvider;
    }

    public T store(T bean) {
        valueStorageProvider.store(storeKey, bean);
        return bean;
    }

    @SuppressWarnings("unchecked")
    public T get() {
        return (T) valueStorageProvider.get(storeKey, contentType);
    }

    @Override
    public void clear() {
        store(null);
    }
}

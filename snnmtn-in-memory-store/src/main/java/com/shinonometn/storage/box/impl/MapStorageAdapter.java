package com.shinonometn.storage.box.impl;

import com.shinonometn.storage.box.MapStorageProvider;

import java.util.Collection;

public abstract class MapStorageAdapter<T> extends InMemoryStorageAdapter<T> {

    private MapStorageProvider mapStorageProvider;

    public MapStorageAdapter(String domain, MapStorageProvider mapStorageProvider) {
        super(domain);
        this.mapStorageProvider = mapStorageProvider;
    }

    public T store(String scope, T bean){
        mapStorageProvider.store(storeKey,scope,bean);
        return bean;
    }

    public T get(String scope){
        return mapStorageProvider.get(storeKey,scope,contentType);
    }

    public Collection<T> values(){
        return mapStorageProvider.values(storeKey,contentType);
    }

    public Collection<String> scopes(){
        return mapStorageProvider.scopes(storeKey);
    }
}

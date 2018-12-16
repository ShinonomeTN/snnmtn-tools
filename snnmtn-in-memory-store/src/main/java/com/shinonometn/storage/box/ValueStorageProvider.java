package com.shinonometn.storage.box;

public interface ValueStorageProvider {
    
    void store(String storeKey,Object bean);
    <T> T get(String storeKey, Class<T> typeInfo);
}

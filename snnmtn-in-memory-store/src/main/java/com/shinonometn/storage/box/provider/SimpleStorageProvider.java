package com.shinonometn.storage.box.provider;

import com.shinonometn.storage.box.MapStorageProvider;
import com.shinonometn.storage.box.ValueStorageProvider;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class SimpleStorageProvider implements ValueStorageProvider, MapStorageProvider {

    private final String MAP = "@[M";

    private final Map<String, Object> storage = new ConcurrentHashMap<>();

    /*
     *
     * ValueStorageProvider implements
     *
     * */

    @Override
    public void store(String storeKey, Object bean) {
        storage.put(storeKey, bean);
    }

    @Override
    public <T> T get(String storeKey, Class<T> typeInfo) {
        Object target = storage.get(storeKey);
        return target == null ? null : typeInfo.cast(target);
    }

    /*
     *
     * MapStorageProvider implement
     *
     * */

    @Override
    public void store(String storeKey, String scope, Object bean) {
        store(mapKey(storeKey, scope), bean);
    }

    @Override
    public <T> T get(String storeKey, String scope, Class<T> contentType) {
        return get(mapKey(storeKey, scope), contentType);
    }

    @Override
    public <T> Collection<T> values(String storeKey, Class<T> contentType) {
        return storage.entrySet().stream()
                .filter(e -> e.getKey().startsWith(mapPrefix(storeKey)))
                .map(e -> contentType.cast(e.getValue()))
                .collect(Collectors.toList());
    }

    @Override
    public Collection<String> scopes(String storeKey) {
        return storage.entrySet().stream()
                .filter(e -> e.getKey().startsWith(mapPrefix(storeKey)))
                .map(e -> e.getKey().replace(mapPrefix(storeKey), ""))
                .collect(Collectors.toList());
    }

    @Override
    public void clear(String storeKey) {
        storage.entrySet().stream()
                .filter(e -> e.getKey().startsWith(mapPrefix(storeKey)))
                .forEach(e -> {
                    if(e.getValue() != null) storage.remove(e.getValue());
                });
    }

    /*
    *
    * Private procedure
    *
    * */

    private String mapKey(String storeKey, String scope) {
        return MAP + storeKey + ":" + scope;
    }

    private String mapPrefix(String storeKey) {
        return MAP + storeKey + ":";
    }
}

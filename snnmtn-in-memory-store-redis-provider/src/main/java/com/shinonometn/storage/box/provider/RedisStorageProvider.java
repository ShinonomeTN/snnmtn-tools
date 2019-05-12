package com.shinonometn.storage.box.provider;

import com.shinonometn.storage.box.MapStorageProvider;
import com.shinonometn.storage.box.ValueStorageProvider;
import redis.clients.jedis.Jedis;

import java.util.Collection;
import java.util.function.BiFunction;
import java.util.function.Function;

public class RedisStorageProvider implements MapStorageProvider, ValueStorageProvider {

    private final Jedis redis;
    private Function<Object,String> serializer;
    private BiFunction<String,Class<?>,Object> desrializer;


    public RedisStorageProvider(Jedis redis) {
        this.redis = redis;
    }

    /*
    *
    * ValueStorageProvider
    *
    * */

    @Override
    public void store(String storeKey, Object bean) {
        redis.set(storeKey,serializer.apply(bean));
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T get(String storeKey, Class<T> typeInfo) {
        return (T) desrializer.apply(redis.get(storeKey),typeInfo);
    }

    /*
    *
    * MapStorageProvider impl
    *
    * */

    @Override
    public void store(String storeKey, String scope, Object bean) {
        redis.hset(storeKey,scope,serializer.apply(bean));
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T get(String storeKey, String scope, Class<T> contentType) {
        return (T) desrializer.apply(redis.hget(storeKey,scope),contentType);
    }

    @Override
    public <T> Collection<T> values(String storeKey, Class<T> contentType) {
        return null;
    }

    @Override
    public Collection<String> scopes(String storeKey) {
        return null;
    }

    @Override
    public void clear(String storeKey) {

    }

}

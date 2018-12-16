package com.shinonometn.storage.box.provider;

import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleStorageProviderTest {

    @Test
    public void clear() {
        SimpleStorageProvider simpleStorageProvider = new SimpleStorageProvider();
        simpleStorageProvider.store("mapping","item","item");
        simpleStorageProvider.clear("mapping");

        assertTrue(simpleStorageProvider.isEmpty());
    }

    @Test
    public void storeNull() {
        SimpleStorageProvider simpleStorageProvider = new SimpleStorageProvider();
        simpleStorageProvider.store("item","null");
        simpleStorageProvider.store("item",null);

        assertTrue(simpleStorageProvider.isEmpty());
    }
}
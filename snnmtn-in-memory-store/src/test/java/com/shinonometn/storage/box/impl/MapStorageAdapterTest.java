package com.shinonometn.storage.box.impl;

import com.shinonometn.storage.box.provider.SimpleStorageProvider;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MapStorageAdapterTest {

    private class StringMapStorage extends MapStorageAdapter<String> {
        public StringMapStorage() {
            super("testScope", "test", new SimpleStorageProvider());
        }
    }

    @Test
    public void store() {
        StringMapStorage stringMapStorage = new StringMapStorage();
        stringMapStorage.store("item1", "content");
        assertEquals("content", stringMapStorage.get("item1"));
    }

    @Test
    public void values() {
        StringMapStorage stringMapStorage = new StringMapStorage();
        stringMapStorage.store("item1", "content");
        stringMapStorage.store("item2", "item2");

        assertTrue(stringMapStorage.values().contains("content"));
        assertTrue(stringMapStorage.values().contains("item2"));
    }

    @Test
    public void scopes() {
        StringMapStorage stringMapStorage = new StringMapStorage();
        stringMapStorage.store("item1", "content");
        stringMapStorage.store("item2", "item2");

        assertTrue(stringMapStorage.scopes().contains("item1"));
        assertTrue(stringMapStorage.scopes().contains("item2"));
    }
}
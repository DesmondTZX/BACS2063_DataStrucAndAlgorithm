package adt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 *  Author: Wong Fu Lim
 *   Double Hashing of HashMap
 * */

public class HashMap<K, V> implements HashMapInterface<K, V> {

    private class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private Entry<K, V>[] entries;
    private int numberOfEntries;
    private double loadFactor = 0.75;
    private int primeNumber;
    private static final int DEFAULT_CAPACITY = 10;


    public HashMap() {
        this(DEFAULT_CAPACITY);
    }

    public HashMap(int capacity) {
        entries = new Entry[capacity];
        numberOfEntries = 0;
        primeNumber = getPrimeNumber();
    }

    public HashMap(int capacity, double loadFactor) {
        entries = new Entry[capacity];
        numberOfEntries = 0;
        primeNumber = getPrimeNumber();
        this.loadFactor = loadFactor;
    }

    @Override
    public void put(K key, V value) {
        //Update Value
        int index = getIndexForExistingEntries(key);
        if (index != -1) {
            entries[index].value = value;
            return;
        }

        // Add new entry
        if (numberOfEntries >= loadFactor * entries.length) {
            rehash();
        }
        index = getIndexForNullEntries(key);
        while (index == -1) {
            rehash();
            index = getIndexForNullEntries(key);
        }

        entries[index] = new Entry<>(key, value);
        numberOfEntries++;


    }

    @Override
    public V get(K key) {
        int index = getIndexForExistingEntries(key);
        if (index != -1) {
            return entries[index].value;
        }
        return null;
    }

    @Override
    public V remove(K key) {
        V removedValue = null;
        int index = getIndexForExistingEntries(key);
        if (index != -1) {
            removedValue = entries[index].value;
            entries[index] = null;
            numberOfEntries--;
        }
        return removedValue;
    }

    @Override
    public List<K> keys() {
        List<K> keys = new ArrayList<>();
        for (int i = 0; i < entries.length; i++) {
            if (entries[i] != null) {
                keys.add(entries[i].key);
            }
        }
        return keys;
    }

    @Override
    public List<V> values() {
        List<V> values = new ArrayList<>();
        for (int i = 0; i < entries.length; i++) {
            if (entries[i] != null) {
                values.add(entries[i].value);
            }
        }
        return values;
    }

    @Override
    public boolean containsKey(K key) {
        return getIndexForExistingEntries(key) != -1;
    }

    @Override
    public boolean containsValue(V value) {
        for (int i = 0; i < entries.length; i++) {
            if (entries[i] != null && entries[i].value.equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return numberOfEntries;
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    @Override
    public boolean isFull() {
        return entries.length == numberOfEntries;
    }

    @Override
    public void clear() {
        for (int i = 0; i < entries.length; i++) {
            entries[i] = null;
        }
        numberOfEntries = 0;
    }

    // Get the prime number that is closest to the size of the array
    private int getPrimeNumber() {
        for (int i = entries.length - 1; i >= 1; i--) {
            int count = 0;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    count++;
                    break;
                }
            }
            if (count == 0) {
                return i;
            }
        }
        return 3;
    }


    private void rehash() {
        Entry<K, V>[] oldEntries = entries;
        entries = new Entry[oldEntries.length * 2];

        for (int i = 0; i < oldEntries.length; i++) {
            if (oldEntries[i] != null) {
                int index = getIndexForNullEntries(oldEntries[i].key);
                entries[index] = oldEntries[i];
            }
        }
    }

    private int getIndexForNullEntries(K key) {
        int steps = 0;

        while (steps < entries.length) {
            int index = index(key, steps++);
            Entry<K, V> entry = entries[index];
            if (entry == null) {
                return index;
            }
        }
        return -1;
    }

    private int getIndexForExistingEntries(K key) {
        int steps = 0;

        while (steps < entries.length) {
            int index = index(key, steps++);
            Entry<K, V> entry = entries[index];
            if (entry != null && entry.key.equals(key)) {
                return index;
            }
        }
        return -1;
    }

    private int index(K key, int i) {
        int hash1 = hash1(key);
        int hash2 = hash2(key);
        return (hash1 + i * hash2) % entries.length;
    }

    private int hash1(K key) {
        return key.hashCode() % entries.length;
    }

    private int hash2(K key) {
        return primeNumber - (key.hashCode() % primeNumber);
    }

    @Override
    public String toString() {
        return Arrays.toString(entries);
    }
}

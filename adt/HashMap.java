package adt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    private int count;

    public HashMap() {
        entries = new Entry[10];
        count = 0;
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
        if (isFull()) {
            doubleSize();
        }
        index = getIndexForNullEntries(key);
        while(index == -1) {
            doubleSize();
            index = getIndexForNullEntries(key);
        }

        entries[index] = new Entry<>(key, value);
        count++;


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
    public void remove(K key) {
        int index = getIndexForExistingEntries(key);
        if (index != -1) {
            entries[index] = null;
            count--;
        }
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
        return count;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public boolean isFull() {
        return entries.length == count;
    }

    @Override
    public void clear() {
        for(int i = 0; i < entries.length; i++){
            entries[i] = null;
        }
        count = 0;
    }


    private void doubleSize() {
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
            if (entry == null ) {
                return index;
            }
        }
        return -1;
    }

    private int getIndexForExistingEntries(K key){
        for(int i = 0; i < entries.length; i++){
            if(entries[i] != null && entries[i].key.equals(key)){
                return i;
            }
        }
        return -1;
    }

    private int index(K key, int i) {
        return (hash(key) + i) % entries.length;
    }

    private int hash(K key) {
        return key.hashCode() % entries.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(entries);
    }
}

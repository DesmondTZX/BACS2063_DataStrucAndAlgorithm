package adt;

import java.util.List;

public interface HashMapInterface<K,V> {
    public void put(K key, V value);
    public V get(K key);
    public V remove(K key);
    public List<K> keys();
    public List<V> values();
    public boolean containsKey(K key);
    public boolean containsValue(V value);
    public int size();
    public boolean isEmpty();
    public boolean isFull();
    public void clear();
}

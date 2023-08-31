package adt;

public interface HashMapInterface<K,V> {
    public void put(K key, V value);
    public V get(K key);
    public void remove(K key);
    public boolean containsKey(K key);
    public boolean containsValue(V value);
    public int size();
    public boolean isEmpty();
    public boolean isFull();
    public void clear();
}

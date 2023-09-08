package adt;

/**
 * @author Wong Fu Lim
 */

import adt.ListInterface;

public interface MapInterface<K, V> {
    public void put(K key, V value);

    public V get(K key);

    public V remove(K key);

    public ListInterface<K> keys();

    public ListInterface<V> values();

    public boolean containsKey(K key);

    public boolean containsValue(V value);

    public int size();

    public boolean isEmpty();

    public boolean isFull();

    public void clear();
}

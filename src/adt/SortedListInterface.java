package adt;

import java.util.Iterator;

/**
 *
 * @author Dong Wei Jie, Desmond Tan Zhe Xuan
 * @param <T>
 */
public interface SortedListInterface<T extends Comparable<T>> {
    
    public boolean add(T newEntry); //add
    
    public boolean remove(T anEntry); //remove
    
    public void clear();
    
    public boolean contains(T anEntry);//find
    
    public int getNumberOfEntries();
    
    public boolean isEmpty();
    
    public Iterator<T> getIterator();

 
    
}

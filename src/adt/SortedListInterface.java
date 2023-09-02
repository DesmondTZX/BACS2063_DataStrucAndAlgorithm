/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

import java.util.Iterator;

/**
 *
 * @author Jack
 * @param <T>
 */
public interface SortedListInterface<T extends Comparable<T>> {
    
    public boolean add(T newEntry);
    
    public boolean remove(T anEntry);
    
    public void clear();
    
    public boolean replace(int givenPosition, T newEntry);
    
    public boolean contains(T anEntry);
    
    public int getNumberOfEntries();
    
    public boolean isEmpty();
    
    public Iterator<T> getIterator();

 
    
}

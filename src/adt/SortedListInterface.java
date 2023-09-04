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
    
    public boolean add(T newEntry); //add
    
    public boolean remove(T anEntry); //remove
    
    public void clear();
    
    public boolean contains(T anEntry);//find
    
    public int getNumberOfEntries();
    
    public boolean isEmpty();
    
    public Iterator<T> getIterator();

 
    
}

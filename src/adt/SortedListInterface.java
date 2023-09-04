package adt;

/**
 *
 * @author Desmond Tan Zhe Xuan
 * This code is partially taken from Chapter 7's SortedListInterface.java and modified 
 */

import java.util.Iterator;

/**
 * SortedListInterface - An interface for the ADT sorted list.
 * @param <T>
 */
public interface SortedListInterface<T extends Comparable<T>> {

  /**
   * Task: Adds a new entry to the sorted list in its proper order.
   *
   * @param newEntry the object to be added as a new entry
   * @return true if the addition is successful
   */
  public boolean add(T newEntry);

  /**
   * Task: Removes a specified entry from the sorted list.
   *
   * @param anEntry the object to be removed
   * @return true if anEntry was located and removed
   */
  public boolean remove(T anEntry);

  public boolean contains(T anEntry);

  public void clear();

  public int getNumberOfEntries();

  public boolean isEmpty();

  public Iterator<T> getIterator();

} 

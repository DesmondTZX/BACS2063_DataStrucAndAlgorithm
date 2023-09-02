package adt;

import java.util.Iterator;

public class SortedLinkedList<T extends Comparable<T>> implements SortedListInterface<T> {

  private Node firstNode;
  private int numberOfEntries;

  public SortedLinkedList() {
    firstNode = null;
    numberOfEntries = 0;
  }

  @Override
  public boolean add(T newEntry) {
    Node newNode = new Node(newEntry);

    Node nodeBefore = null;
    Node currentNode = firstNode;
    while (currentNode != null && newEntry.compareTo(currentNode.data) > 0) {
      nodeBefore = currentNode;
      currentNode = currentNode.next;
    }

    if (isEmpty() || (nodeBefore == null)) { // CASE 1: add at beginning
      newNode.next = firstNode;
      firstNode = newNode;
    } else {	// CASE 2: add in the middle or at the end, i.e. after nodeBefore
      newNode.next = currentNode;
      nodeBefore.next = newNode;
    }
    numberOfEntries++;
    return true;
  }

  @Override
  public boolean remove(T anEntry) {
    boolean stop = false;
    Node previousNode = null;
    Node currentNode = firstNode;
    
    while (currentNode != null && !stop) {
        if (currentNode.data.compareTo(anEntry) >= 0) {
            stop = true;
        } else {
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
    }
    
    if (currentNode != null && currentNode.data.compareTo(anEntry) == 0) {
        if (currentNode == firstNode) {
            firstNode = currentNode.next;
        } else {
            previousNode.next = currentNode.next;
        }
        numberOfEntries--;
        return true;
    }
    return false;
  }

  @Override
  public boolean contains(T anEntry) {
    boolean found = false;
    Node tempNode = firstNode;

    while (!found && (tempNode != null)) {
      if (anEntry.compareTo(tempNode.data) <= 0) {
        found = true;
      } else {
        tempNode = tempNode.next;
      }
    }
      return tempNode != null && tempNode.data.equals(anEntry);
  }

  @Override
  public final void clear() {
    firstNode = null;
    numberOfEntries = 0;
  }

  @Override
  public int getNumberOfEntries() {
    return numberOfEntries;
  }

  @Override
  public boolean isEmpty() {
    return (numberOfEntries == 0);
  }

  @Override
  public String toString() {
    String outputStr = "";
    Node currentNode = firstNode;
    while (currentNode != null) {
      outputStr += currentNode.data + "\n";
      currentNode = currentNode.next;
    }
    return outputStr;
  }

  @Override
  public Iterator<T> getIterator() {
      return new LinkedIterator();
  }
  
  private class LinkedIterator implements Iterator<T> {
        private Node currentNode = firstNode;
      
      
        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public T next() {
            T currentElement = null;
            if (hasNext()) {
                currentElement = currentNode.data;
                currentNode = currentNode.next;
            }
            return currentElement;
        }
      
  }

  private class Node {

    private T data;
    private Node next;

    private Node(T data) {
      this.data = data;
      next = null;
    }

    private Node(T data, Node next) {
      this.data = data;
      this.next = next;
    }
  }
}

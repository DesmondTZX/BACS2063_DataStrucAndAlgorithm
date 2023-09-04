/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

import java.io.Serializable;
import java.util.Iterator;

/**
 *
 * @author Jack
 * @param <T>
 */
public class SortedLinkedList<T extends Comparable<T>> implements Serializable, SortedListInterface<T> {

    private Node firstNode;
    private int numberOfEntries;

    public SortedLinkedList() {
        firstNode = null;
        numberOfEntries = 0;
    }

    /**
     *
     * @param newEntry
     * @return
     */
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
        if (isEmpty()) {
            return false; // List is empty, nothing to remove
        }

        // Check if the first node matches
        if (firstNode.data.compareTo(anEntry) == 0) {
            firstNode = firstNode.next;
            numberOfEntries--;
            return true;
        }

        Node previousNode = firstNode;
        Node currentNode = firstNode.next;

        while (currentNode != null && currentNode.data.compareTo(anEntry) < 0) {
            previousNode = currentNode;
            currentNode = currentNode.next;
        }

        if (currentNode != null && currentNode.data.compareTo(anEntry) == 0) {
            previousNode.next = currentNode.next;
            numberOfEntries--;
            return true;
        }

        return false; // Element not found
    }

    @Override
    public void clear() {
        firstNode = null;
        numberOfEntries = 0;
    }

    @Override
    public boolean replace(int givenPosition, T newEntry) {
        boolean isSuccessful = true;

        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            Node currentNode = firstNode;
            for (int i = 0; i < givenPosition - 1; ++i) {
                currentNode = currentNode.next;		// advance currentNode to next node
            }
            currentNode.data = newEntry;	// currentNode is pointing to the node at givenPosition
        } else {
            isSuccessful = false;
        }
        return isSuccessful;
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
    public int getNumberOfEntries() {
        return numberOfEntries;
    }

    @Override
    public boolean isEmpty() {
        return (numberOfEntries == 0);
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

    private class Node implements Serializable {

        private T data;
        private Node next;

        private Node(T data) {
            this.data = data;
            next = null;
        }
    }

}

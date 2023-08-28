package adt;

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
    throw new UnsupportedOperationException();	// Left as Practical exercise
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

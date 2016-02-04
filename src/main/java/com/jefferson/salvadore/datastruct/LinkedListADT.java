/*
 * Copyright © 2015 Salvadore Jefferson
 */
package com.jefferson.salvadore.datastruct;

import static com.google.common.base.Preconditions.checkArgument;

import java.util.Iterator;
import java.util.NoSuchElementException;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * <p>
 * The <code>LinkedListImpl</code> class is used to create graphs for storing and manipulating
 * objects.
 * </p>
 * 
 * @version 2.0.0 10-08-2015
 * @author Salvadore Jefferson
 * @param <E> the type of <code>element</code> stored in the list
 */
public class LinkedListADT<E> implements ListADT<E> {

  private LinkedListNode<E> firstNode = null;

  /**
   * static factory method for building the list of <code>Objects</code>
   * 
   * @param objects An array of objects to add to the list
   * @return list The new list created by calling this method
   */

  @SafeVarargs
  public static <T> LinkedListADT<T> of(final T... elements) {
    LinkedListADT<T> list = new LinkedListADT<T>();
    for (T element : elements) {
      list.add(element);
    }
    return list;
  }

  /**
   * Get the first <code>LinkedListNode</code> in the list.
   * 
   * @return The first <code>LinkedListNode</code> in the list, or <code>null</code> if the list is
   *         empty.
   */
  public @Nullable LinkedListNode<E> getFirstNode() {
    return firstNode;
  }

  @Override
  public void add(final E object) {

    final LinkedListNode<E> newNode = new LinkedListNode<E>(object);

    if (firstNode == null) {
      firstNode = newNode;
      return;
    }
    LinkedListNode<E> node = firstNode;
    while (node.getNextNode() != null) {
      node = node.getNextNode();
    }
    assert node.getNextNode() == null; // confirm end of list
    node.setNext(newNode);
  }

  /**
   * Gets the length of the list
   * 
   * @return The length of the list.
   */
  @Override
  public int getLength() {
    if (firstNode == null) {
      return 0;
    } else {
      return getLength(firstNode);
    }
  }

  /**
   * A utility method for calculating the length of the list recursively. Used by the
   * {@link #getLength()} method.
   * 
   * @param node
   * @return
   */
  static <E> int getLength(@Nonnull final LinkedListNode<E> node) {
    if (node.getNextNode() == null) {
      return 1;
    } else {
      return 1 + getLength(node.getNextNode());
    }
  }


  @Override
  public E get(int index) {
    checkArgument(index < this.getLength() && index >= 0, "invalid argument : index");

    LinkedListNode<E> activeNode = firstNode;
    int increment = 0;
    if (index == 0) {
      return firstNode.getValue();
    } else {
      while (increment < index) {
        activeNode = activeNode.getNextNode();
        increment++;
      }
    }
    return activeNode.getValue();
  }


  @Override
  public void insert(int index, @Nullable E object) {
    checkArgument(index <= this.getLength() && index >= 0, "invalid argument : index");

    LinkedListNode<E> newNode = new LinkedListNode<E>(object);
    LinkedListNode<E> activeNode = firstNode;
    if (index == 0) {
      newNode.setNext(firstNode);
      firstNode = newNode;
    } else if (index == this.getLength()) {
      add(object);
    } else {
      activeNode = getNode(index - 1);
      newNode.setNext(activeNode.getNextNode());
      activeNode.setNext(newNode);
    }
  }


  /**
   * Remove an item from the list at the given index
   * 
   * @param index The index at which to insert the object in the list
   * @param object The item to be removed
   * @throws IndexOutOfBoundsException if the given index is less than zero; or greater that the
   *         length of the list.
   */
  public void removeNode(int index) {
    checkArgument(index < this.getLength() && index >= 0, "invalid argument : index");

    LinkedListNode<E> activeNode = firstNode;
    if (index == 0) {
      firstNode = activeNode.getNextNode();
      activeNode.setNext(null);
    } else {
      LinkedListNode<E> previousNode = getNode(index - 1);
      activeNode = previousNode.getNextNode();
      previousNode.setNext(activeNode.getNextNode());
      activeNode.setNext(null);
    }
  }

  /**
   * Traverse through the list for the <code>Node</code> at <code>index</code>
   * 
   * @param index The position in the list of the desired <code>Node</code>
   * @return Node The <code>Node</code> located at the given <code>index</code>
   */
  private LinkedListNode<E> getNode(int index) throws IllegalArgumentException {
    checkArgument(index < this.getLength() && index >= 0, "invalid argument : index");

    LinkedListNode<E> activeNode = firstNode;
    for (int i = 0; i < index; i++) {
      activeNode = activeNode.getNextNode();
    }
    return activeNode;
  }

  @Override
  public Iterator<E> iterator() {
    return new IteratorImpl();
  }

  private class IteratorImpl implements Iterator<E> {

    private LinkedListNode<E> currentNode = firstNode;

    @Override
    public boolean hasNext() {
      return currentNode != null;
    }

    @Override
    public E next() {
      if (currentNode == null) {
        throw new NoSuchElementException();
      }
      final E nodeValue = currentNode.getValue();
      currentNode = currentNode.getNextNode();

      return nodeValue;
    }

  }
}

/*
 * HashTable with 3 items.
 * 
 * Whats happening inside HashTable:
 * 
 * ListADT[] theArrayOfLists = new LinkedListADT[27];
 * 
 * list[0] = LinkedListNode 1
 * 
 * list[1] = LinkedListNode 2
 * 
 * list[2] = LinkedListNode 3
 * 
 * list[3] = null
 * 
 * list[4] = null
 * 
 * \/ \/
 * 
 * list[26] = null
 */

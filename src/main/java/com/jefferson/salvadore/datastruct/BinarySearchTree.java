package com.jefferson.salvadore.datastruct;

import javax.annotation.Nonnull;

/**
 * A binary search tree.
 * 
 * @param <T> The type of object contained in the BST.
 */
public interface BinarySearchTree<T> {
  /**
   * Adds an object to the BST. The object will be sorted in the tree based upon the BST
   * implementation. If an object is already in the tree with the same comparison characteristics,
   * no object is added.
   * 
   * @param object The object to add.
   */
  void add(@Nonnull T object);

  /**
   * Determines if an equivalent object is contained in the tree.
   * 
   * @param object The object to search for based upon its comparison characteristics and the BST
   *        implementation.
   * @return true if an object is contained in the tree that compares equally with the given object.
   */
  boolean contains(@Nonnull T object);

  /**
   * Prints all objects in the tree using depth-first in-order traversal. This implementation uses
   * the <code>toString()</code> method of each object in the tree.
   */
  void printAll();
}

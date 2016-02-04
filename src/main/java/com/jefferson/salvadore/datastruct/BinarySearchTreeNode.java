/*
 * Copyright © 2015 Salvadore Jefferson
 */

package com.jefferson.salvadore.datastruct;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;


/**
 * <p>
 * A wrapper class that holds an object. Used to create graphs with {@link BinarySearchTreeImpl}
 * </p>
 * 
 * @version 2.0.0 10-18-2015
 * 
 * @author Salvadore Jefferson
 * 
 * @param <T> The type of <code>Object</code> stored in the <code>BinarySearchTreeNode</code>
 */
public class BinarySearchTreeNode<T> {

  private final T object;
  private BinarySearchTreeNode<T> leftChild = null;
  private BinarySearchTreeNode<T> rightChild = null;


  /**
   * Constructs a new <code>BinarySearchTreeNode</code> object
   * 
   * @param object The object this node represents
   */
  public BinarySearchTreeNode(@Nonnull final T object) {
    this.object = object;
  }

  /**
   * Returns the object represented by this <code>BinarySearchTreeNode</code>
   * 
   * @return object
   */
  public @Nonnull T getValue() {
    return object;
  }

  /**
   * Sets the right child <code>BinarySearchTreeNode</code>.
   * 
   * @param rightChild The right child <code>BinarySearchTreeNode</code>, or <code>null</code> if
   *        there is no right child <code>BinarySearchTreeNode</code>.
   */
  public void setRightChild(@Nullable final BinarySearchTreeNode<T> rightChild) {
    this.rightChild = rightChild;
  }

  /**
   * Sets the left child <code>BinarySearchTreeNode</code>.
   * 
   * @param leftChild The left child <code>BinarySearchTreeNode</code>, or <code>null</code> if
   *        there is no left child <code>BinarySearchTreeNode</code>.
   */
  public void setLeftChild(@Nullable final BinarySearchTreeNode<T> leftChild) {
    this.leftChild = leftChild;
  }

  /**
   * @return The right child <code>BinarySearchTreeNode</code>, or <code>null</code> if there is no
   *         right child <code>BinarySearchTreeNode</code>.
   */
  public @Nullable BinarySearchTreeNode<T> getRightChild() {
    return rightChild;
  }

  /**
   * @return The left child <code>BinarySearchTreeNode</code>, or <code>null</code> if there is no
   *         left child <code>BinarySearchTreeNode</code>.
   */
  public @Nullable BinarySearchTreeNode<T> getLeftChild() {
    return leftChild;
  }
}

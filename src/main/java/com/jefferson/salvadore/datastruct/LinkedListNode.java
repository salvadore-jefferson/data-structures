/*
 * Copyright © 2015 Salvadore Jefferson
 */
package com.jefferson.salvadore.datastruct;

import static com.google.common.base.Preconditions.checkNotNull;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * <p>
 * A wrapper class that holds a <code>type</code> of <code>Object</code>. Used to create graphs with
 * {@link LinkedListADT}
 * </p>
 * 
 * @version 2.0.0 10-08-2015
 * 
 * @author Salvadore Jefferson
 * @param <V> The type of <code>value</code> stored in the <code>LinkedListNode</code>
 */
public class LinkedListNode<V> {

  private final V value;
  private LinkedListNode<V> next = null;

  /**
   * Creates a <code>LinkedListNode</code> containing an object.
   * 
   * @param value The <code>Object</code> to store in the <code>LinkedListNode</code>
   * 
   */
  public LinkedListNode(@Nonnull final V value) {
    this.value = checkNotNull(value);
  }

  /**
   * Gets the <code>Object</code> stored in this <code>LinkedListNode</code>
   * 
   * @return The <code>Object</code> represented in this <code>LinkedListNode</code>
   */
  public @Nonnull V getValue() {
    return value;
  }


  /**
   * Get the <code>LinkedListNode</code> the calling LinkedListNode points to
   * 
   * @return The next <code>LinkedListNode</code> in the list, or <code>null</code> if this
   *         <code>LinkedListNode</code> is the end of the list
   */
  public @Nullable LinkedListNode<V> getNextNode() {
    return next;
  }

  /**
   * Sets the link to the next <code>LinkedListNode</code> in the list.
   * 
   * @param next The next <code>LinkedListNode</code> in the list, or <code>null</code> if this
   *        <code>LinkedListNode</code> is at the end of the list
   */
  public void setNext(@Nullable final LinkedListNode<V> next) {
    this.next = next;
  }
}

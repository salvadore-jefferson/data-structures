/*
 * Copyright © 2015 Salvadore Jefferson
 */
package com.jefferson.salvadore.datastruct;

import java.util.Iterator;

import javax.annotation.Nullable;

/**
 * <p>
 * A Interface used to define the contract for {@link LinkedListADT} users
 * </p>
 * 
 * @version 2.0.0 10-08-2015
 * 
 * @author Salvadore Jefferson
 * @param <E> the type of <code>element</code> stored in the list
 */
public interface ListADT<E> extends Iterable<E> {

  /**
   * @return the length of the list
   */
  int getLength();

  /**
   * Retrieves the object at the given index
   * 
   * @param index The index at which to retrieve the object.
   * @return The object at the given index, which may be <code>null</code>.
   * @throws IndexOutOfBoundsException if the given index is less then zero; or greater than or
   *         equal to the number or elements in the list
   */
  @Nullable
  E get(int index);

  /**
   * Add an item to the end of the list
   * 
   * @param object the item to add.
   */
  default void add(@Nullable E object) {
    insert(getLength(), object);
  }

  /**
   * Inserts an item into the list at the given index
   * 
   * @param index The index at which to insert the object in the list
   * @param object The item to be inserted
   * @throws IndexOutOfBoundsException if the given index is less than zero; or greater that the
   *         length of the list.
   */
  void insert(int index, @Nullable E object);

}

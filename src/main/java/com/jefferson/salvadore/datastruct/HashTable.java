/*
 * Copyright © 2015 Garret Wilson
 */

package com.jefferson.salvadore.datastruct;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * An interface used to define a contract for Hash Table
 * 
 * @author Salvadore Jefferson
 * @version 2.0.0 10-08-2015
 * @param <E>
 * 
 * @param <K, V> the Key and Value used for hashing <code>Objects</code> in the
 *        <code>HashTable</code>.
 */
public interface HashTable<K, V> {
  /**
   * Stores a value in the hash table and associates it with the given key.
   * <p>
   * If a value is already associated with the given key, it will be discarded and replaced with the
   * new value.
   * </p>
   * 
   * @param key The input value.
   * @param value The output value to associate with the given key.
   */
  void put(@Nonnull K key, @Nonnull V value);

  /**
   * Retrieves the value associated with a given key.
   * 
   * @param key The input value.
   * @return The output value associated with the key, or <code>null</code> if the key is not
   *         present in the table.
   */
  @Nullable
  V get(@Nonnull K key);

  /**
   * Determines if a value is associated with the given key.
   * <p>
   * Overriding this method is optional; an implementation may have a more efficient way of checking
   * to see if a value exists.
   * </p>
   * 
   * @param key The input value.
   * @return <code>true</code> if there exists an output value associated with the key.
   */
  default boolean contains(@Nonnull K key) {
    return get(key) != null;
  }

  /**
   * Prints all <Code>Values</code> in the table to the standard output
   */
  void printAllValues();

  /**
   * Prints all <code>Keys</code> in the table to the standard output
   */
  void printAllKeys();
}

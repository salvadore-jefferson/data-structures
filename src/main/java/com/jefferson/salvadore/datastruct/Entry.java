/*
 * Copyright © 2015 Salvadore Jefferson
 */

package com.jefferson.salvadore.datastruct;

import static com.google.common.base.Preconditions.checkNotNull;
import javax.annotation.Nonnull;

/**
 * A class to hold a <code>key</code> / <code>value</code> pair for use in {@link HashTableImpl}
 * 
 * @author Salvadore Jefferson
 * @version 2.0.0 10-08-2015
 */
public class Entry<K, V> {

  private final K key;
  private final V value;

  /**
   * A private constructor of Entry class. Use {@link #of} for creating new Entry instances
   * 
   * @param key The object to be used for hashing
   * @param value The value the key represents
   */
  private Entry(@Nonnull final K key, @Nonnull final V value) {
    this.key = key;
    this.value = value;
  }

  /**
   * Static factory method for creating instances of {@link Entry}.
   * 
   * @param key The object to be used for hashing
   * @param value The value the key represents
   * @return Entry a new Entry is created
   */
  public static <K, V> Entry<K, V> of(@Nonnull K key, @Nonnull V value) {
    checkNotNull(key, "the key cannot be null");
    checkNotNull(value, "the value cannot be null");
    return new Entry<K, V>(key, value);
  }

  /**
   * Returns the {@link #key} from this {@link Entry}
   * 
   * @return key The object to be used for hashing
   */
  public K getKey() {
    return key;
  }

  /**
   * Returns the {@link #value} from this {@link Entry}
   * 
   * @return value The value the key represents
   */
  public V getValue() {
    return value;
  }
}

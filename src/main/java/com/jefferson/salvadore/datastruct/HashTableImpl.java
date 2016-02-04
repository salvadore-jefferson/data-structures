/*
 * Copyright © 2015 Salvadore Jefferson
 */

package com.jefferson.salvadore.datastruct;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Iterator;
import java.util.NoSuchElementException;

import javax.annotation.Nonnull;


/**
 * A hash table implementation using a simple array of buckets with a linked list of entries for
 * each bucket.
 * 
 * @author Salvadore Jefferson
 * @version 2.0.0 10-08-2015
 *
 */
public class HashTableImpl<K, V> implements HashTable<K, V> {

  private static final int BUCKET_COUNT = 27;
  private final LinkedListADT<Entry<K, V>>[] buckets = new LinkedListADT[BUCKET_COUNT];

  @Override
  public void put(@Nonnull K key, @Nonnull V value) {
    checkNotNull(key, "the key cannot be null");
    checkNotNull(value, "the value cannot be null");

    final int hashCode = Math.abs(key.hashCode() % BUCKET_COUNT);
    LinkedListADT<Entry<K, V>> entries = buckets[hashCode];
    if (entries == null) {
      entries = new LinkedListADT<Entry<K, V>>();
      buckets[hashCode] = entries;
    }

    LinkedListNode<Entry<K, V>> node = buckets[hashCode].getFirstNode();
    int index = 0;
    while (node != null) {
      final Entry<K, V> entry = node.getValue();
      if (entry.getKey().equals(key)) {
        ((LinkedListADT<Entry<K, V>>) entries).removeNode(index);
        entries.add(Entry.of(key, value));
        return;
      } else {
        index++;
        node = node.getNextNode();
      }
    }
    entries.add(Entry.of(key, value));
  }

  @Override
  public V get(@Nonnull K key) {
    checkNotNull(key, "cannot find a value associated with null");

    final int hashCode = Math.abs(key.hashCode() % BUCKET_COUNT);
    final LinkedListADT<Entry<K, V>> entries = buckets[hashCode];
    if (entries == null) {
      return null;
    }
    LinkedListNode<Entry<K, V>> node = entries.getFirstNode();

    while (node != null) {
      final Entry<K, V> entry = node.getValue();
      if (entry.getKey().equals(key)) {
        return entry.getValue();
      } else {
        node = node.getNextNode();
      }
    }
    return null;
  }

  @Override
  public void printAllValues() {
    for (final V value : getValues()) {
      System.out.println(value);
    }
  }

  @Override
  public void printAllKeys() {
    for (final K key : getKeys()) {
      System.out.println(key);
    }
  }

  public Iterable<V> getValues() {
    return new Iterable<V>() {
      @Override
      public Iterator<V> iterator() {
        return new ValueIterator();
      }
    };
  }

  public Iterator<K> keyIterator() {
    return new KeyIterator();
  }

  public Iterator<V> valueIterator() {
    return new ValueIterator();
  }

  public Iterable<K> getKeys() {
    return new Iterable<K>() {
      @Override
      public Iterator<K> iterator() {
        return new KeyIterator();
      }
    };
  }

  private class ValueIterator implements Iterator<V> {

    int index;
    Iterator<Entry<K, V>> entryIterator;

    /**
     * Initializes and sets a new <code>Iterator</code> to point to the first non-null index of the
     * array and the first <code>Entry<K,V></code> in that index's <code>LinkedListADT</code>
     */
    ValueIterator() {
      index = 0;
      while (index < buckets.length) {
        if (buckets[index] != null) {
          entryIterator = buckets[index].iterator();
          if (entryIterator.hasNext()) {
            return;
          }
        }
        index++;
      }
    }

    @Override
    public boolean hasNext() {
      assert index <= buckets.length;
      return index < buckets.length;
    }

    @Override
    public V next() {
      if (index == buckets.length) {
        throw new NoSuchElementException();
      }
      final V value = entryIterator.next().getValue();
      if (!entryIterator.hasNext()) {
        index++;
        while (index < buckets.length) {
          if (buckets[index] != null) {
            entryIterator = buckets[index].iterator();
            if (entryIterator.hasNext()) {
              return value;
            }
          }
          index++;
        }
      }
      return value;
    }
  }

  private class KeyIterator implements Iterator<K> {
    int index;
    Iterator<Entry<K, V>> entryIterator;

    /**
     * Initializes and sets a new <code>Iterator</code> to point to the first non-null index of the
     * array and the first <code>Entry<K,V></code> in that index's <code>LinkedListADT</code>
     */
    KeyIterator() {
      index = 0;
      while (index < buckets.length) {
        if (buckets[index] != null) {
          entryIterator = buckets[index].iterator();
          if (entryIterator.hasNext()) {
            return;
          }
        }
        index++;
      }
    }

    @Override
    public boolean hasNext() {
      assert index <= buckets.length;
      return index < buckets.length;
    }

    @Override
    public K next() {
      if (index == buckets.length) {
        throw new NoSuchElementException();
      }
      final K key = entryIterator.next().getKey();
      if (!entryIterator.hasNext()) {
        index++;
        while (index < buckets.length) {
          if (buckets[index] != null) {
            entryIterator = buckets[index].iterator();
            if (entryIterator.hasNext()) {
              return key;
            }
          }
          index++;
        }
      }
      return key;
    }
  }
}

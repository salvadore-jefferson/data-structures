package com.jefferson.salvadore.datastruct;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Ignore;

import static org.hamcrest.Matchers.*;
import com.jefferson.salvadore.datastruct.Entry;

public class EntryTest<K, V> {

  @Test
  public void testEntryOfMethod() {
    Entry<String, String> entry1 = Entry.of("Test", "color");
    assertThat(entry1.getKey(), is(equalTo("Test")));
    assertThat(entry1.getValue(), is(equalTo("color")));

  }

  @Test
  public void testAddingEntryToLinkedListNode() {
    Entry<String, String> entry = Entry.of("Test", "red");
    LinkedListNode<String> node1 = new LinkedListNode<String>(entry.getKey());
    LinkedListNode<String> node2 = new LinkedListNode<String>(entry.getValue());
    node1.setNext(node2);
    assertThat(node1.getValue(), is(equalTo("Test")));
    assertThat(node1.getNextNode().getValue(), is(equalTo("red")));
  }

  @Test
  public void testAddingEntryToLinkedListImpl() {
    ListADT<Entry<String, String>>[] list = new LinkedListADT[3];
    list[0] = LinkedListADT.of(Entry.of("Jane", "red"));
    list[1] = LinkedListADT.of(Entry.of("Sam", "blue"));
    list[2] = LinkedListADT.of(Entry.of("Mark", "pink"));
    Entry<String, String> entry = list[0].get(0);
    assertThat(entry.getKey(), is(equalTo("Jane")));

  }
}

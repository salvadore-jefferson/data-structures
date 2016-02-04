package com.jefferson.salvadore.datastruct;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.Iterator;

import org.junit.Test;

public class LinkedListTest {

  @Test
  public void testSingleNodeGetLength() {
    final LinkedListNode<String> node = new LinkedListNode<String>("foo");
    assertThat(LinkedListADT.getLength(node), is(1));
  }

  @Test
  public void testTwoNodesGetLength() {
    final LinkedListNode<String> node1 = new LinkedListNode<String>("foo");
    final LinkedListNode<String> node2 = new LinkedListNode<String>("bar");
    node1.setNext(node2);
    assertThat(LinkedListADT.getLength(node1), is(2));
  }

  @Test
  public void testFiveNodesGetLength() {
    final LinkedListNode<String> node1 = new LinkedListNode<String>("foo bar1");
    final LinkedListNode<String> node2 = new LinkedListNode<String>("foo bar2");
    final LinkedListNode<String> node3 = new LinkedListNode<String>("foo bar3");
    final LinkedListNode<String> node4 = new LinkedListNode<String>("foo bar4");
    final LinkedListNode<String> node5 = new LinkedListNode<String>("foo bar5");
    node1.setNext(node2);
    node2.setNext(node3);
    node3.setNext(node4);
    node4.setNext(node5);
    assertThat(LinkedListADT.getLength(node1), is(5));
  }

  @Test
  public void testGetNodeAtIndexThree() {
    LinkedListADT<String> list = new LinkedListADT<String>();
    list.add("foo bar1");// index 0
    list.add("foo bar2");// index 1
    list.add("foo bar3");// index 2
    list.add("foo bar4");// index 3
    list.add("foo bar5");// index 4

    assertThat(list.get(3), is("foo bar4"));
    assertThat(list.get(0), is("foo bar1"));
    assertThat(list.get(4), is("foo bar5"));

  }

  @Test
  public void testInsertAtIndexThree() {
    LinkedListADT<String> list = new LinkedListADT<String>();
    list.add("foo bar1");// index 0
    list.add("foo bar2");// index 1
    list.add("foo bar3");// index 2
    list.add("foo bar4");// index 4
    list.add("foo bar5");// index 5
    list.insert(3, "new foo bar3"); // new foo bar3 is now index 3


    assertThat(list.getLength(), is(6));
    assertThat(list.get(3), is("new foo bar3"));
    assertThat(list.get(0), is("foo bar1"));
    assertThat(list.get(2), is("foo bar3"));
    assertThat(list.get(4), is("foo bar4"));
  }

  @Test
  public void testInsertAtIndexZero() {
    LinkedListADT<String> list = new LinkedListADT<String>();
    list.add("foo bar1");// index 1
    list.add("foo bar2");// index 2
    list.add("foo bar3");// index 3
    list.add("foo bar4");// index 4
    list.add("foo bar5");// index 5
    list.insert(0, "new foo bar1"); // new foo bar1 is now index 0

    assertThat(list.getLength(), is(6));
    assertThat(list.get(0), is("new foo bar1"));
    assertThat(list.get(1), is("foo bar1"));
    assertThat(list.get(2), is("foo bar2"));
    assertThat(list.get(5), is("foo bar5"));
  }

  @Test
  public void testRemoveNodeAtIndexZero() {
    LinkedListADT<String> list = new LinkedListADT<String>();
    list.add("foo bar1");// index 0
    list.add("foo bar2");// index 1
    list.add("foo bar3");// index 2
    list.add("foo bar4");// index 3
    list.add("foo bar5");// index 4
    list.removeNode(0);

    assertThat(list.getLength(), is(4));
    assertThat(list.get(0), is("foo bar2"));
    assertThat(list.get(1), is("foo bar3"));
    assertThat(list.get(2), is("foo bar4"));
    assertThat(list.get(3), is("foo bar5"));
  }

  @Test
  public void testRemoveNodeAtIndexTwo() {
    LinkedListADT<String> list = new LinkedListADT<String>();
    list.add("foo bar1");// index 0
    list.add("foo bar2");// index 1
    list.add("foo bar3");// index 2
    list.add("foo bar4");// index 3
    list.add("foo bar5");// index 4
    list.removeNode(1);

    assertThat(list.getLength(), is(4));
    assertThat(list.get(0), is("foo bar1"));
    assertThat(list.get(1), is("foo bar3"));
    assertThat(list.get(2), is("foo bar4"));
    assertThat(list.get(3), is("foo bar5"));
  }

  @Test
  public void testInsertAtEndOfList() {
    LinkedListADT<String> list = new LinkedListADT<String>();
    list.add("foo bar1");// index 0
    list.add("foo bar2");// index 1
    list.add("foo bar3");// index 2
    list.add("foo bar4");// index 3
    list.add("foo bar5");// index 4
    list.insert(5, "foo bar6"); // index 5
    assertThat(list.getLength(), is(6));
    assertThat(list.get(0), is("foo bar1"));
    assertThat(list.get(1), is("foo bar2"));
    assertThat(list.get(2), is("foo bar3"));
    assertThat(list.get(3), is("foo bar4"));
    assertThat(list.get(4), is("foo bar5"));
    assertThat(list.get(5), is("foo bar6"));
  }

  @Test
  public void testIterator() {
    LinkedListADT<String> list = new LinkedListADT<String>();
    list.add("foo bar1");// index 0
    list.add("foo bar2");// index 1
    list.add("foo bar3");// index 2
    list.add("foo bar4");// index 3
    list.add("foo bar5");// index 4
    Iterator<String> listIterator = list.iterator();
    assertThat(listIterator.next(), is("foo bar1"));
    assertThat(listIterator.next(), is("foo bar2"));
    assertThat(listIterator.hasNext(), is(true));
    assertThat(listIterator.next(), is("foo bar3"));
    assertThat(listIterator.next(), is("foo bar4"));
    assertThat(listIterator.next(), is("foo bar5"));
    assertThat(listIterator.hasNext(), is(false));


  }
}

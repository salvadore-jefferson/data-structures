package com.jefferson.salvadore.datastruct;

import org.junit.Test;
import static org.junit.Assert.*;
import com.jefferson.salvadore.datastruct.HashTableImpl.*;
import java.util.Iterator;

import org.junit.Ignore;

import static org.hamcrest.Matchers.*;

public class HashTableTest {

  @Test
  public void testHashTablePutMethod() {
    HashTableImpl<String, String> table = new HashTableImpl<String, String>();
    table.put("Jane Doe", "red");
    table.put("Jim Jones", "gray");
    assertThat(table.contains("Jane Doe"), is(true));
    assertThat(table.contains("Jim Jones"), is(true));
  }

  @Test
  public void testHashTableGetMethod() {
    HashTableImpl<String, String> table = new HashTableImpl<String, String>();
    table.put("Jane Doe", "red");
    table.put("Jim Jones", "blue");
    table.put("Tom tom", "yello");
    table.put("Harry", "black");

    assertThat(table.get("Jane Doe"), is("red"));
    assertThat(table.get("Jim Jones"), is("blue"));
    assertThat(table.get("Tom tom"), is("yello"));
    assertThat(table.get("Harry"), is("black"));
  }

  @Test
  public void testHashTableContainsMethod() {
    HashTableImpl<String, String> table = new HashTableImpl<String, String>();
    table.put("Jane Doe", "green");
    table.put("Jim Jones", "blue");
    table.put("Tom tom", "gold");
    table.put("Harry", "black");

    assertThat(table.contains("Jane Doe"), is(true));
    assertThat(table.contains("Jim Jones"), is(true));
    assertThat(table.contains("Tom tom"), is(true));
    assertThat(table.contains("Harry"), is(true));
  }

  @Test
  public void testHashTableAddDuplicateKeysAndUniqueValues() {
    HashTableImpl<String, String> table = new HashTableImpl<String, String>();
    table.put("Jane Doe", "red");
    table.put("Jim Jones", "blue");
    table.put("Tom tom", "yello");
    table.put("Harry", "black");

    assertThat(table.get("Jane Doe"), is("red"));
    assertThat(table.get("Jim Jones"), is("blue"));
    assertThat(table.get("Tom tom"), is("yello"));
    assertThat(table.get("Harry"), is("black"));

    table.put("Jim Jones", "green");
    table.put("Harry", "orange");
    assertThat(table.get("Jane Doe"), is("red"));
    assertThat(table.get("Jim Jones"), is("green"));
    assertThat(table.get("Tom tom"), is("yello"));
    assertThat(table.get("Harry"), is("orange"));
  }

  @Test
  public void testHashTableAddUniqueKeysAndDuplicateValues() {
    HashTableImpl<String, String> table = new HashTableImpl<String, String>();
    table.put("Jane Doe", "red");
    table.put("Jim Jones", "red");
    table.put("Tom tom", "yello");
    table.put("Harry", "yello");

    assertThat(table.get("Jane Doe"), is("red"));
    assertThat(table.get("Jim Jones"), is("red"));
    assertThat(table.get("Tom tom"), is("yello"));
    assertThat(table.get("Harry"), is("yello"));

  }

  @Test
  public void testHashTableAddDuplicateKeysAndDuplicateValues() {
    HashTableImpl<String, String> table = new HashTableImpl<String, String>();
    table.put("Jane Doe", "red");
    table.put("Jane Doe", "red");
    table.put("Harry", "yello");
    table.put("Harry", "yello");

    assertThat(table.get("Jane Doe"), is("red"));
    assertThat(table.get("Harry"), is("yello"));
  }

  @Test(expected = NullPointerException.class)
  public void testHashTableAddNullForKeyThrowsException() {

    HashTableImpl<?, String> table = new HashTableImpl<>();
    table.put(null, "green");

  }

  @Test(expected = NullPointerException.class)
  public void testHashTableAddNullForValueThrowsException() {

    HashTableImpl<String, ?> table = new HashTableImpl<>();
    table.put("Jane Doe", null);

  }

  @Test
  public void testFoo() {
    HashTableImpl<Foo, String> hashTable = new HashTableImpl<Foo, String>();
    final Foo foo1 = new Foo("foo");
    final Foo foo2 = new Foo("bar");
    final Foo foo3 = new Foo("fooBar");
    final Foo foo4 = new Foo("foo");

    hashTable.put(foo1, "123");
    hashTable.put(foo2, "abc");
    hashTable.put(foo3, "345");

    assertThat(hashTable.get(foo1), is("123"));
    assertThat(hashTable.get(foo2), is("abc"));
    assertThat(hashTable.get(foo3), is("345"));

    hashTable.put(foo4, "def");
    assertThat(hashTable.get(foo1), is("def"));
    assertThat(hashTable.get(foo2), is("abc"));
    assertThat(hashTable.get(foo3), is("345"));

    hashTable.put(foo1, "4");
    assertThat(hashTable.get(foo4), is(equalTo("4")));
  }

  @Test
  public void testIteratingTableWithKeyIterator() {
    HashTableImpl<String, Integer> table = new HashTableImpl<String, Integer>();
    table.put("Number 1", new Integer(1));
    table.put("Number 2", new Integer(2));
    table.put("Number 3", new Integer(3));
    Iterator<String> tableIterator = table.keyIterator();
    assertThat(tableIterator.next(), is(equalTo("Number 3")));
    assertThat(tableIterator.next(), is(equalTo("Number 2")));
    assertThat(tableIterator.next(), is(equalTo("Number 1")));
  }

  @Test
  public void testIteratingTableWithValueIterator() {
    HashTableImpl<String, Integer> table = new HashTableImpl<String, Integer>();
    table.put("Number 1", new Integer(1));
    table.put("Number 2", new Integer(2));
    table.put("Number 3", new Integer(3));
    Iterator<Integer> tableIterator = table.valueIterator();
    assertThat(tableIterator.next(), is(equalTo(3)));
    assertThat(tableIterator.next(), is(equalTo(2)));
    assertThat(tableIterator.next(), is(equalTo(1)));

  }
}

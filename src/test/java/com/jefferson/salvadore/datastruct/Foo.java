// Copyright © 2015 Salvadore Jefferson
package com.jefferson.salvadore.datastruct;

import javax.annotation.Nonnull;

/**
 * A simple class used for testing
 * 
 * @author Salvadore Jefferson @version1.0.0 10-5-2015
 */
public class Foo {

  private final String name;

  public Foo(@Nonnull final String name) {
    this.name = name;
  }


  public String getName() {
    return name;
  }

  @Override
  public boolean equals(Object otherObject) {
    if (this == otherObject) {
      return true;
    }
    if (!(otherObject instanceof Foo)) {
      return false;
    }
    final Foo foo = (Foo) otherObject;
    return this.getName().equals(foo.getName());
  }

  @Override
  public int hashCode() {
    return 1;
  }
}

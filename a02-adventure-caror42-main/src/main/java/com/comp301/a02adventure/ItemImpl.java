package com.comp301.a02adventure;

public class ItemImpl implements Item {
  private final String name;

  public ItemImpl(String name) {
    if (name == null) {
      throw new IllegalArgumentException();
    }
    this.name = name;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return name;
  }

  @Override
  public boolean equals(Object other) {
    if (other == null) {
      return false;
    }
    return this.getName().equals(other.toString());
  }
}

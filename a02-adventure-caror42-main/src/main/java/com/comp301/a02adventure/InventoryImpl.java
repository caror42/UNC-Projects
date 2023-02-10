package com.comp301.a02adventure;

import java.util.ArrayList;
import java.util.List;

public class InventoryImpl implements Inventory {
  private ArrayList<Item> items;

  public InventoryImpl() {
    this.items = new ArrayList<Item>();
  }

  public boolean isEmpty() {
    return items.size() == 0;
  }

  public int getNumItems() {
    return items.size();
  }

  public List<Item> getItems() {
    return new ArrayList<Item>(this.items);
  }

  public void addItem(Item item) {
    items.add(item);
  }

  public void removeItem(Item item) {
    items.remove(item);
  }

  public void clear() {
    this.items = new ArrayList<Item>();
  }

  public void transferFrom(Inventory other) {
    this.items.addAll(other.getItems());
    other.clear();
  }
}

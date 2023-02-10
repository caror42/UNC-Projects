package com.comp301.a02adventure;

public class PlayerImpl implements Player {
  private final String name;
  private final Inventory inventory;
  private Position position;

  public PlayerImpl(String name, int startX, int startY) {
    if (name == null) {
      throw new IllegalArgumentException();
    }
    this.name = name;
    this.position = new PositionImpl(startX, startY);
    this.inventory = new InventoryImpl();
  }

  public Position getPosition() {
    return this.position;
  }

  public Inventory getInventory() {
    return this.inventory;
  }

  public String getName() {
    return this.name;
  }

  public void move(Direction direction) {
    this.position = position.getNeighbor(direction);
  }
}

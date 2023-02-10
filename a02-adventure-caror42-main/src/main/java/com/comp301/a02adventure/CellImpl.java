package com.comp301.a02adventure;

public class CellImpl implements Cell {
  private final Position position;
  private String name;
  private String description;
  private Inventory chest;
  private boolean visited;

  public CellImpl(int x, int y) {
    this.position = new PositionImpl(x, y);
    this.name = "";
    this.description = "";
    this.visited = false;
  }

  public CellImpl(int x, int y, String name, String description) {
    if (name == null || description == null) {
      throw new IllegalArgumentException();
    }
    this.position = new PositionImpl(x, y);
    this.name = name;
    this.description = description;
    this.visited = false;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    if (name == null) {
      throw new IllegalArgumentException();
    }
    this.name = name;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    if (description == null) {
      throw new IllegalArgumentException();
    }
    this.description = description;
  }

  public Position getPosition() {
    return this.position;
  }

  public Inventory getChest() {
    return this.chest;
  }

  public void setChest(Inventory chest) {
    if (chest == null) {
      throw new IllegalArgumentException();
    }
    this.chest = chest;
  }

  public boolean getIsVisited() {
    return this.visited;
  }

  public boolean hasChest() {
    return this.chest != null;
  }

  public void visit() {
    this.visited = true;
  }
}

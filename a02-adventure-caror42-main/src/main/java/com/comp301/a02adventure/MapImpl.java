package com.comp301.a02adventure;

public class MapImpl implements Map {
  private final int width;
  private final int height;
  private final int numItems;
  private final Cell[][] cells;

  public MapImpl(int width, int height, int numItems) {
    if (width <= 0 || height <= 0) {
      throw new IllegalArgumentException();
    }
    this.width = width;
    this.height = height;
    this.numItems = numItems;
    this.cells = new Cell[width][height];
  }

  public int getWidth() {
    return this.width;
  }

  public int getHeight() {
    return this.height;
  }

  public Cell getCell(int x, int y) {
    return cells[x][y];
  }

  public Cell getCell(Position position) {
    return cells[position.getX()][position.getY()];
  }

  public void initCell(int x, int y) {
    this.cells[x][y] = new CellImpl(x, y);
  }

  public int getNumItems() {
    return this.numItems;
  }
}

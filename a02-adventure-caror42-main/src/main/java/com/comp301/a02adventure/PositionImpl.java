package com.comp301.a02adventure;

public class PositionImpl implements Position {
  private final int y;
  private final int x;

  public PositionImpl(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public Position getNeighbor(Direction direction) {
    if (direction == Direction.NORTH) {
      return new PositionImpl(this.x, this.y + 1);
    } else if (direction == Direction.SOUTH) {
      return new PositionImpl(this.x, this.y - 1);
    } else if (direction == Direction.EAST) {
      return new PositionImpl(this.x + 1, this.y);
    } else if (direction == Direction.WEST) {
      return new PositionImpl(this.x - 1, this.y);
    }
    return null;
  }
}

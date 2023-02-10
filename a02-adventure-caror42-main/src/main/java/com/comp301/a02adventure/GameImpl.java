package com.comp301.a02adventure;

import java.util.List;

public class GameImpl implements Game {
  private final Map map;
  private final Player player;

  public GameImpl(Map map, Player player) {
    if (map == null || player == null) {
      throw new IllegalArgumentException();
    }
    this.map = map;
    this.player = player;
  }

  public Position getPlayerPosition() {
    return this.player.getPosition();
  }

  public String getPlayerName() {
    return this.player.getName();
  }

  public List<Item> getPlayerItems() {
    return this.player.getInventory().getItems();
  }

  public boolean getIsWinner() {
    return this.map.getNumItems() == this.player.getInventory().getNumItems();
  }

  public void printCellInfo() {
    System.out.println("Location: " + this.map.getCell(player.getPosition()).getName());
    System.out.println(this.map.getCell(player.getPosition()).getDescription());
    if (this.map.getCell(player.getPosition()).getIsVisited()) {
      System.out.println("You have already visited this location.");
    }
    if (this.map.getCell(player.getPosition()).hasChest()) {
      System.out.println("You found a chest! Type 'open' to see what's inside, or keep moving.");
    }
    this.map.getCell(player.getPosition()).visit();
  }

  public void openChest() {
    if (!this.map.getCell(this.player.getPosition()).hasChest()) {
      System.out.println("No chest to open, sorry!");
    } else {
      if (this.map.getCell(this.player.getPosition()).getChest().isEmpty()) {
        System.out.println("The chest is empty.");
      } else {
        System.out.println(
            "You collected these items: "
                + this.map.getCell(this.player.getPosition()).getChest().getItems());
      }
      this.player
          .getInventory()
          .transferFrom(this.map.getCell(this.player.getPosition()).getChest());
    }
  }

  public boolean canMove(Direction direction) {
    boolean track = true;
    Position neighbor = this.getPlayerPosition().getNeighbor(direction);
    if (direction == Direction.NORTH) {
      if (neighbor.getY() >= this.map.getHeight()) {
        track = false;
      }
    } else if (direction == Direction.SOUTH) {
      if (neighbor.getY() < 0) {
        track = false;
      }
    } else if (direction == Direction.EAST) {
      if (neighbor.getX() >= this.map.getWidth()) {
        track = false;
      }
    } else {
      if (neighbor.getX() < 0) {
        track = false;
      }
    }
    if (track) {
      if (this.map.getCell(neighbor) == null) {
        track = false;
      }
    }
    return track;
    // return this.player.getPosition().getNeighbor(direction).getX() < this.map.getWidth() &&
    // this.player.getPosition().getNeighbor(direction).getX() >= 0 &&
    // this.player.getPosition().getNeighbor(direction).getY() >= 0 &&
    // this.player.getPosition().getNeighbor(direction).getY() < this.map.getHeight();
  }

  public void move(Direction direction) {
    if (this.canMove(direction)) {
      this.player.move(direction);
      this.printCellInfo();
    } else {
      System.out.println("You can't go that way! Try another direction.");
    }
  }
}

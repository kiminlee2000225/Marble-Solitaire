package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.GameSlot;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import java.util.ArrayList;

/**
 * An abstract class for the MarbleSolitaireModel. Contains the fullLengthPosition,
 * emptySpacePosition, armThickness (which is also the side length for a triangle model), sRow and
 * sCol as the row and column element of initial empty slot, and the board. This class writes the
 * public method for MarbleSolitaireModel, which can be overwritten in extended classes.
 */
public abstract class AbstractSolitaireModelImpl implements MarbleSolitaireModel {

  protected int fullLengthPosition;
  protected int emptySpacePosition;
  protected int armThickness;
  protected int sRow;
  protected int sCol;
  protected ArrayList<ArrayList<GameSlot>> board;

  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    this.invalidMoveCheck(fromRow, fromCol, toRow, toCol);
    this.setInitEmpty(fromCol, fromRow);
    this.setToMarble(toCol, toRow);
    this.setBetweenEmpty(fromRow, fromCol, toRow, toCol);
  }

  /**
   * Sets the 'from' position of the move to be empty, from a marble.
   *
   * @param fromCol the column position of the 'from' position
   * @param fromRow the row position of the 'from' position
   */
  protected void setInitEmpty(int fromCol, int fromRow) {
    if (this.board.get(fromRow).get(fromCol) == GameSlot.MARBLE) {
      this.board.get(fromRow).set(fromCol, GameSlot.EMPTY);
    } else {
      this.board.get(fromRow).set(fromCol, GameSlot.EMPTYSPACE);
    }
  }

  /**
   * Sets the 'to' position of the move to be a marble, from an empty slot.
   *
   * @param toCol the column position of the 'to' position
   * @param toRow the row position of the 'to' position
   */
  protected void setToMarble(int toCol, int toRow) {
    if (this.board.get(toRow).get(toCol) == GameSlot.EMPTY) {
      this.board.get(toRow).set(toCol, GameSlot.MARBLE);
    } else {
      this.board.get(toRow).set(toCol, GameSlot.MARBLESPACE);
    }
  }

  /**
   * Sets the position in between the 'from' and 'to' position to be empty.
   *
   * @param fromRow the row position of the 'from' position
   * @param fromCol the column position of the 'from' position
   * @param toRow the row position of the 'to' position
   * @param toCol the column position of the 'to' position
   */
  private void setBetweenEmpty(int fromRow, int fromCol, int toRow, int toCol) {
    if (this.movedUp(fromCol, toCol)) {
      if (this.board.get(toRow).get(toCol + 1) == GameSlot.MARBLE) {
        this.board.get(toRow).set(toCol + 1, GameSlot.EMPTY);
      } else {
        this.board.get(toRow).set(toCol + 1, GameSlot.EMPTYSPACE);
      }
    } else if (this.movedDown(fromCol, toCol)) {
      if (this.board.get(toRow).get(toCol - 1) == GameSlot.MARBLE) {
        this.board.get(toRow).set(toCol - 1, GameSlot.EMPTY);
      } else {
        this.board.get(toRow).set(toCol - 1, GameSlot.EMPTYSPACE);
      }
    } else if (this.movedRight(fromRow, toRow)) {
      if (this.board.get(toRow - 1).get(toCol) == GameSlot.MARBLE) {
        this.board.get(toRow - 1).set(toCol, GameSlot.EMPTY);
      } else {
        this.board.get(toRow - 1).set(toCol, GameSlot.EMPTYSPACE);
      }
    } else {
      if (this.board.get(toRow + 1).get(toCol) == GameSlot.MARBLE) {
        this.board.get(toRow + 1).set(toCol, GameSlot.EMPTY);
      } else {
        this.board.get(toRow + 1).set(toCol, GameSlot.EMPTYSPACE);
      }
    }
  }

  /**
   * Determines if the move brings the marble upwards or not.
   *
   * @param fromCol the column position of the 'from' position
   * @param toCol the column position of the 'to' position
   * @return true if the fromCol is greater than to toCol, which suggests that the move is upwards.
   */
  private boolean movedUp(int fromCol, int toCol) {
    return fromCol > toCol;
  }

  /**
   * Determines if the move brings the marble downwards or not.
   *
   * @param fromCol the column position of the 'from' position
   * @param toCol the column position of the 'to' position
   * @return true if the fromCol is less than to toCol, which suggests that the move is downwards.
   */
  private boolean movedDown(int fromCol, int toCol) {
    return fromCol < toCol;
  }

  /**
   * Determines if the move brings the marble to the right direction or not.
   *
   * @param fromRow the row position of the 'from' position
   * @param toRow the row position of the 'to' position
   * @return true if the fromRow is less than to toRow, which suggests that the move is in the right
   *                                 direction.
   */
  protected boolean movedRight(int fromRow, int toRow) {
    return fromRow < toRow;
  }

  /**
   * Determines if the move brings the marble to the left direction or not.
   *
   * @param fromRow the row position of the 'from' position
   * @param toRow the row position of the 'to' position
   * @return true if the toRow is less than to fromRow, which suggests that the move is in the left
   *                                 direction.
   */
  protected boolean movedLeft(int fromRow, int toRow) {
    return fromRow > toRow;
  }

  /**
   * Checks if the given from and to positions result in an invalid move. A move is invalid if any
   * of these are false. The “from” and/or “to” positions are valid. There is a marble at the
   * specified “from” position. The “to” position is empty. The “to” and “from” positions are
   * exactly two positions away (horizontally or vertically). There is a marble in the slot between
   * the “to” and “from” positions. Throws an IllegalArgumentException if the move is not possible.
   *
   * @param fromRow the row of the "from" position
   * @param fromCol the column of the "from" position
   * @param toRow the row of the "to" position
   * @param toCol the column of the "to" position
   * @throws IllegalArgumentException if the move is invalid, including the reason for the
   *                                 invalidity
   */
  private void invalidMoveCheck(int fromRow, int fromCol, int toRow, int toCol)
      throws IllegalArgumentException {
    if (!((fromRow == toRow) || (fromCol == toCol))) {
      throw new IllegalArgumentException("The move cannot be diagonal!");
    } else if (this.invalidPosition(fromRow, fromCol)) {
      throw new IllegalArgumentException("The from position is not valid!");
    } else if (this.invalidPosition(toRow, toCol)) {
      throw new IllegalArgumentException("The to position is not valid!");
    } else if (!this.fromIsMarble(fromRow, fromCol)) {
      throw new IllegalArgumentException("The from position is not a marble!");
    } else if (!this.toIsEmpty(toRow, toCol)) {
      throw new IllegalArgumentException("The to position is not empty!");
    } else if (!this.twoPositionsApart(fromRow, fromCol, toRow, toCol)) {
      throw new IllegalArgumentException("The move is not exactly two positions apart!");
    } else if (!this.marbleBetweenPositions(fromRow, fromCol, toRow, toCol)) {
      throw new IllegalArgumentException(
          "The position in between the from and to positions does not include a marble!");
    }
  }

  /**
   * Determines if the “to” and “from” positions are exactly two positions away (horizontally or
   * vertically) or not.
   *
   * @param fromRow the row of the "from" position
   * @param fromCol the column of the "from" position
   * @param toRow the row of the "to" position
   * @param toCol the column of the "to" position
   * @return true if the 'from' and 'to' positions have 2 differences, depending on which direction
   *                                 the move is
   */
  private boolean twoPositionsApart(int fromRow, int fromCol, int toRow, int toCol) {
    if (this.movedUp(fromCol, toCol)) {
      return fromCol - 2 == toCol;
    } else if (this.movedDown(fromCol, toCol)) {
      return fromCol + 2 == toCol;
    } else if (this.movedRight(fromRow, toRow)) {
      return fromRow + 2 == toRow;
    } else if (this.movedLeft(fromRow, toRow)) {
      return fromRow - 2 == toRow;
    } else {
      return false;
    }
  }

  /**
   * Determines if there is a marble in the slot between the “to” and “from” positions or not.
   *
   * @param fromRow the row of the "from" position
   * @param fromCol the column of the "from" position
   * @param toRow the row of the "to" position
   * @param toCol the column of the "to" position
   * @return true if there is a marble at the position in between the 'to' and 'from' positions
   */
  private boolean marbleBetweenPositions(int fromRow, int fromCol, int toRow, int toCol) {
    if (this.movedUp(fromCol, toCol)) {
      return this.board.get(fromRow).get(fromCol - 1) == GameSlot.MARBLE ||
          this.board.get(fromRow).get(fromCol - 1) == GameSlot.MARBLESPACE;
    } else if (this.movedDown(fromCol, toCol)) {
      return this.board.get(fromRow).get(fromCol + 1) == GameSlot.MARBLE ||
          this.board.get(fromRow).get(fromCol + 1) == GameSlot.MARBLESPACE;
    } else if (this.movedRight(fromRow, toRow)) {
      return this.board.get(fromRow + 1).get(fromCol) == GameSlot.MARBLE ||
          this.board.get(fromRow + 1).get(fromCol) == GameSlot.MARBLESPACE;
    } else {
      return this.board.get(fromRow - 1).get(fromCol) == GameSlot.MARBLE ||
          this.board.get(fromRow - 1).get(fromCol) == GameSlot.MARBLESPACE;
    }
  }

  /**
   * Determines if the given position with the row and column element is a marble ("O" or "O ").
   *
   * @param fromRow the row of the position
   * @param fromCol the column of the position
   * @return true if the given position is a marble
   */
  protected boolean fromIsMarble(int fromRow, int fromCol) {
    return this.board.get(fromRow).get(fromCol) == GameSlot.MARBLE ||
        this.board.get(fromRow).get(fromCol) == GameSlot.MARBLESPACE;
  }

  /**
   * Determines if the given position with the row and column element is empty ("_" or "_ ").
   *
   * @param toRow the row of the position
   * @param toCol the column of the position
   * @return true if the given position is empty
   */
  protected boolean toIsEmpty(int toRow, int toCol) {
    return this.board.get(toRow).get(toCol) == GameSlot.EMPTY || this.board.get(toRow).get(toCol)
        == GameSlot.EMPTYSPACE;
  }


  @Override
  public boolean isGameOver() {
    if (this.getScore() == 1) {
      return true;
    } else {
      boolean movesUnavailable = false;
      for (int i = 0; i <= this.fullLengthPosition; i++) {
        for (int j = 0; j <= this.fullLengthPosition; j++) {
          movesUnavailable = movesUnavailable || this.hasMoves(i, j);
        }
      }
      return !movesUnavailable;
    }
  }

  /**
   * Determines if the given position (from the parameters column and row) has a valid move or more
   * moves available. A position has a valid move or more if it is able to move to any of the four
   * directions (up, down, right, left). A move is valid if the 'from' position is a marble, if the
   * 'to' position is empty, and if there is a marble in between the 'from' and 'to' positions.
   *
   * @param row row element of the position
   * @param column column element of the position
   * @return true if the given position (from the parameters column and row) has a valid move or
   *                                 more available
   */
  private boolean hasMoves(int row, int column) {
    if ((this.board.get(row).get(column) == GameSlot.EMPTY
        || this.board.get(row).get(column) == GameSlot.EMPTYSPACE)
        ||
        this.board.get(row).get(column) == GameSlot.SPACE || this.board.get(row).get(column)
        == GameSlot.SPACESPACE || this.board.get(row).get(column) == GameSlot.NONE) {
      return false;
    } else {
      return this.upMoveCheck(column, row) || this.downMoveCheck(column, row) || this
          .rightMoveCheck(column, row) || this.leftMoveCheck(column, row);
    }
  }


  /**
   * Determines if the given position has a valid move upwards.
   *
   * @param column column element of the position
   * @param row row element of the position
   * @return true if the given position has a valid upward move available.
   */
  private boolean upMoveCheck(int column, int row) {
    if (column < this.emptySpacePosition + 1) {
      return false;
    } else {
      return (this.board.get(row).get(column - 1) == GameSlot.MARBLE
          || this.board.get(row).get(column - 1)
          == GameSlot.MARBLESPACE) &&
          (this.board.get(row).get(column - 2) == GameSlot.EMPTY
              || this.board.get(row).get(column - 2)
              == GameSlot.EMPTYSPACE);
    }
  }

  /**
   * Determines if the given position has a valid move downwards.
   *
   * @param column column element of the position
   * @param row row element of the position
   * @return true if the given position has a valid downward move available.
   */
  private boolean downMoveCheck(int column, int row) {
    if (column > this.fullLengthPosition - this.emptySpacePosition - 1) {
      return false;
    } else {
      return (this.board.get(row).get(column + 1) == GameSlot.MARBLE
          || this.board.get(row).get(column + 1)
          == GameSlot.MARBLESPACE) &&
          (this.board.get(row).get(column + 2) == GameSlot.EMPTY
              || this.board.get(row).get(column + 2)
              == GameSlot.EMPTYSPACE);
    }
  }

  /**
   * Determines if the given position has a valid move to the right.
   *
   * @param column column element of the position
   * @param row row element of the position
   * @return true if the given position has a valid right move available.
   */
  private boolean rightMoveCheck(int column, int row) {
    if (row > this.fullLengthPosition - this.emptySpacePosition - 1) {
      return false;
    } else {
      return (this.board.get(row + 1).get(column) == GameSlot.MARBLE
          || this.board.get(row + 1).get(column)
          == GameSlot.MARBLESPACE) &&
          (this.board.get(row + 2).get(column) == GameSlot.EMPTY
              || this.board.get(row + 2).get(column)
              == GameSlot.EMPTYSPACE);
    }
  }

  /**
   * Determines if the given position has a valid move to the left.
   *
   * @param column column element of the position
   * @param row row element of the position
   * @return true if the given position has a valid left move available.
   */
  private boolean leftMoveCheck(int column, int row) {
    if (row < this.emptySpacePosition + 1) {
      return false;
    } else {
      return (this.board.get(row - 1).get(column) == GameSlot.MARBLE
          || this.board.get(row - 1).get(column)
          == GameSlot.MARBLESPACE) &&
          (this.board.get(row - 2).get(column) == GameSlot.EMPTY
              || this.board.get(row - 2).get(column)
              == GameSlot.EMPTYSPACE);
    }
  }

  @Override
  public String getGameState() {
    StringBuilder sb = new StringBuilder();
    for (ArrayList<GameSlot> row : this.board) {
      for (GameSlot gs : row) {
        sb.append(gs.getStringSlot());
      }
      sb.append("\n");
    }
    String stringBoard = sb.toString();
    return stringBoard.substring(0, stringBoard.length() - 1);
  }

  @Override
  public int getScore() {
    int score = 0;
    for (ArrayList<GameSlot> row : this.board) {
      for (GameSlot gs : row) {
        if (gs == GameSlot.MARBLE || gs == GameSlot.MARBLESPACE) {
          score += 1;
        }
      }
    }
    return score;
  }

  /**
   * Determines if the given position is a valid position on the board or not. Return false if
   * either the row or column elements for the positions are negative, if either the row or column
   * elements for the positions exceed the length of the board, or if the position is a "  ". " ",
   * or a "" which means it is an invalid position.
   *
   * @param row the row of the position
   * @param col the column of the position
   * @return true if the given position is an invalid position on the board
   */
  protected boolean invalidPosition(int row, int col) throws IllegalArgumentException {
    return row < 0 || col < 0 || row > this.fullLengthPosition || col > this.fullLengthPosition ||
        this.board.get(row).get(col) == GameSlot.SPACESPACE
        || this.board.get(row).get(col) == GameSlot.SPACE
        || this.board.get(row).get(col) == GameSlot.NONE;
  }

  /**
   * Sets the initial empty slot for the game by replacing the sCol and sRow position with "_".
   */
  protected void setInitEmptySlot() {
    if (this.board.get(this.sRow).get(this.sCol) == GameSlot.SPACE || this.board.get(this.sRow)
        .get(this.sCol) == GameSlot.MARBLE
        || this.board.get(this.sRow).get(this.sCol) == GameSlot.EMPTY) {
      this.board.get(this.sRow).set(this.sCol, GameSlot.EMPTY);
    } else {
      this.board.get(this.sRow).set(this.sCol, GameSlot.EMPTYSPACE);
    }
  }

  /**
   * Creates a column using a ArrayList of Strings. There should be a " " in between every position.
   * Every position should be represented as "O" since there are no invalid positions in this row.
   * This column is the column with marbles at all positions.
   *
   * @return the column created as an ArrayList of Strings
   */
  protected ArrayList<GameSlot> createAllMarbleColumns() {
    ArrayList<GameSlot> column = new ArrayList<GameSlot>();
    for (int i = 0; i <= this.fullLengthPosition; i++) {
      if (i != this.fullLengthPosition) {
        column.add(GameSlot.MARBLESPACE);
      } else {
        column.add(GameSlot.MARBLE);
      }
    }
    return column;
  }

  /**
   * Creates a column using a ArrayList of Strings. There should be a " " in between every position.
   * There should be a "O" for the positions where there are marbles. There should be a " " for the
   * invalid positions.This column is the column with armThickness number of marbles.
   *
   * @return the column created as an ArrayList of Strings
   */
  protected ArrayList<GameSlot> createUniqueColumns() {
    ArrayList<GameSlot> column = new ArrayList<GameSlot>();
    for (int i = 0; i <= this.fullLengthPosition; i++) {
      if (i <= this.emptySpacePosition) {
        column.add(GameSlot.SPACESPACE);
      } else if (i > (this.emptySpacePosition + this.armThickness)) {
        column.add(GameSlot.NONE);
      } else {
        if (i == this.armThickness + this.emptySpacePosition) {
          column.add(GameSlot.MARBLE);
        } else if (i != this.fullLengthPosition) {
          column.add(GameSlot.MARBLESPACE);
        } else {
          column.add(GameSlot.MARBLE);
        }
      }
    }
    return column;
  }

}

package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.GameSlot;
import java.util.ArrayList;

/**
 * Implementation of the MarbleSolitaireModel interface. Creates a triangle marble solitaire board
 * depending on the dimension, the initial empty slot, and/or both. Implements the method to move
 * the marbles, determine if the game is over, and find the score.
 */
public class TriangleSolitaireModelImpl extends AbstractSolitaireModelImpl {

  /**
   * Constructor for the the triangle marble solitaire model with no parameters. The dimension is 5
   * with the empty slot at the (0, 0).
   */
  public TriangleSolitaireModelImpl() {
    this.fullLengthPosition = 4;
    this.sRow = 0;
    this.sCol = 0;
    this.board = new ArrayList<ArrayList<GameSlot>>();
    this.createBoard();
    this.setInitEmptySlot();
  }

  /**
   * Constructor for the the triangle marble solitaire model with dimensions as a parameter. The
   * dimension is the given dimension value with the empty slot at the (0, 0).
   *
   * @param dimensions the dimension of the triangle model
   * @throws IllegalArgumentException if the dimension is not a positive value
   */
  public TriangleSolitaireModelImpl(int dimensions) throws IllegalArgumentException {
    if (dimensions < 2) {
      throw new IllegalArgumentException("The given dimension is invalid!");
    }
    this.fullLengthPosition = dimensions - 1;
    this.sRow = 0;
    this.sCol = 0;
    this.board = new ArrayList<ArrayList<GameSlot>>();
    this.createBoard();
    this.setInitEmptySlot();
  }

  /**
   * Constructor for the the triangle marble solitaire model with row and col as a parameter. The
   * dimension is 5 with the empty slot at the (row, col) position.
   *
   * @param row the row position of the initial empty slot
   * @param col the col position of the initial empty slot
   * @throws IllegalArgumentException if the given initial empty slot is invalid
   */
  public TriangleSolitaireModelImpl(int row, int col) throws IllegalArgumentException {
    this.fullLengthPosition = 4;
    this.sRow = row;
    this.sCol = col;
    this.board = new ArrayList<ArrayList<GameSlot>>();
    this.createBoard();
    this.invalidPositionTriangle(row, col);
    if (this.invalidPosition(row, col)) {
      throw new IllegalArgumentException(
          "Invalid empty cell position (" + sRow + ", " + sCol + ")");
    }
    this.setInitEmptySlot();
  }

  /**
   * Constructor for the the triangle marble solitaire model with dimensions, row, and col as a
   * parameter. The dimension is the given dimension parameter with the empty slot at the (row, col)
   * position.
   *
   * @param dimensions the dimension of the triangle model
   * @param row the row position of the initial empty slot
   * @param col the col position of the initial empty slot
   * @throws IllegalArgumentException if the given initial empty slot is invalid or if the dimension
   *                                    is not a positive value
   */
  public TriangleSolitaireModelImpl(int dimensions, int row, int col)
      throws IllegalArgumentException {
    if (dimensions < 2) {
      throw new IllegalArgumentException("The given dimension is invalid!");
    }
    this.fullLengthPosition = dimensions - 1;
    this.sRow = row;
    this.sCol = col;
    this.board = new ArrayList<ArrayList<GameSlot>>();
    this.createBoard();
    this.invalidPositionTriangle(row, col);
    if (this.invalidPosition(row, col)) {
      throw new IllegalArgumentException(
          "Invalid empty cell position (" + sRow + ", " + sCol + ")");
    }
    this.setInitEmptySlot();
  }

  /**
   * Creates the board for the game by adding each column for every row element. Begins to create a
   * row with only 1 element, then 2, then 3, up until the dimension number of elements is
   * existing.
   */
  private void createBoard() {
    int currDimension = 0;

    for (int i = 0; i <= this.fullLengthPosition; i++) {
      this.board.add(this.createTriangleColumn(currDimension));
      currDimension++;
    }
  }

  /**
   * Creates a column for the triangle model. The column elements consists of a marble or a marble
   * space. These elements are utilized in getGameState() to build a triangle shape for the model.
   *
   * @param currDimension the current dimension of the row
   * @return the column of the row of the board
   */
  private ArrayList<GameSlot> createTriangleColumn(int currDimension) {
    ArrayList<GameSlot> column = new ArrayList<GameSlot>();

    for (int i = 0; i <= currDimension; i++) {
      if (i != currDimension) {
        column.add(GameSlot.MARBLESPACE);
      } else {
        column.add(GameSlot.MARBLE);
      }
    }
    return column;
  }

  @Override
  /**
   * The board in String form will be in a triangle shape.
   */
  public String getGameState() {
    int spaceCount = this.fullLengthPosition - 1;
    int colCount = 0;

    StringBuilder sb = new StringBuilder();

    for (ArrayList<GameSlot> row : this.board) {

      for (int i = 0; i <= this.fullLengthPosition; i++) {
        if (i <= spaceCount) {
          sb.append(" ");
        } else {
          sb.append(row.get(colCount).getStringSlot());
          if (i == this.fullLengthPosition) {
            sb.append("\n");
          }
          colCount++;
        }
      }

      colCount = 0;
      spaceCount--;
    }

    String stringBoard = sb.toString();
    return stringBoard.substring(0, stringBoard.length() - 1);
  }

  /**
   * Tries to find the given position on the board. Checks for index boundaries. If a position is
   * invalid due to the index boundaries, throw an IllegalArgumentException since the position is
   * invalid.
   *
   * @param row the row of the position
   * @param col the column of the position
   * @throws IllegalArgumentException if the given position is invalid
   */
  private void invalidPositionTriangle(int row, int col) throws IllegalArgumentException {
    try {
      this.board.get(row).get(col);
    } catch (IndexOutOfBoundsException e) {
      throw new IllegalArgumentException("Invalid empty cell position (" + row + ", " + col + ")");
    }
  }

  @Override
  /**
   * Checks if the from and to position exists in the index of the board. If it doesn't it catches
   * the exception and returns a new exception.
   */
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    try {
      this.invalidPositionTriangle(fromRow, fromCol);
    } catch (IllegalArgumentException e) {
      throw new IllegalArgumentException("The from position is not valid!");
    }
    try {
      this.invalidPositionTriangle(toRow, toCol);
    } catch (IllegalArgumentException e) {
      throw new IllegalArgumentException("The to position is not valid!");
    }
    this.invalidMoveCheckTriangle(fromRow, fromCol, toRow, toCol);
    this.setInitEmpty(fromCol, fromRow);
    this.setToMarble(toCol, toRow);
    this.setBetweenEmptyTriangle(fromRow, fromCol, toRow, toCol);
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
   *                                    invalidity
   */
  private void invalidMoveCheckTriangle(int fromRow, int fromCol, int toRow, int toCol)
      throws IllegalArgumentException {
    if (this.invalidPosition(fromRow, fromCol)) {
      throw new IllegalArgumentException("The from position is not valid!");
    } else if (this.invalidPosition(toRow, toCol)) {
      throw new IllegalArgumentException("The to position is not valid!");
    } else if (!this.fromIsMarble(fromRow, fromCol)) {
      throw new IllegalArgumentException("The from position is not a marble!");
    } else if (!this.toIsEmpty(toRow, toCol)) {
      throw new IllegalArgumentException("The to position is not empty!");
    } else if (!this.twoPositionsApartTriangle(fromRow, fromCol, toRow, toCol)) {
      throw new IllegalArgumentException("The move is not exactly two positions apart!");
    } else if (!this.marbleBetweenPositionsTriangle(fromRow, fromCol, toRow, toCol)) {
      throw new IllegalArgumentException(
          "The position in between the from and to positions does not include a marble!");
    }
  }

  /**
   * Determines if the “to” and “from” positions are exactly two positions away (horizontally or
   * diagonally) or not.
   *
   * @param fromRow the row of the "from" position
   * @param fromCol the column of the "from" position
   * @param toRow the row of the "to" position
   * @param toCol the column of the "to" position
   * @return true if the 'from' and 'to' positions have 2 differences, depending on which direction
   *                  the move is
   */
  private boolean twoPositionsApartTriangle(int fromRow, int fromCol, int toRow, int toCol) {
    if (this.movedUpRight(fromCol, fromRow, toCol, toRow)) {
      return fromRow - 2 == toRow && fromCol == toCol;
    } else if (this.movedUpLeft(fromCol, fromRow, toCol, toRow)) {
      return fromCol - 2 == toCol && fromRow - 2 == toRow;
    } else if (this.movedDownRight(fromCol, fromRow, toCol, toRow)) {
      return toCol - 2 == fromCol && toRow - 2 == fromRow;
    } else if (this.movedDownLeft(fromCol, fromRow, toCol, toRow)) {
      return toRow - 2 == fromRow && toCol == fromCol;
    } else if (this.movedRight(fromCol, toCol)) {
      return fromCol + 2 == toCol;
    } else if (this.movedLeft(fromCol, toCol)) {
      return fromCol - 2 == toCol;
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
  private boolean marbleBetweenPositionsTriangle(int fromRow, int fromCol, int toRow, int toCol) {
    if (this.movedUpRight(fromCol, fromRow, toCol, toRow)) {
      return this.board.get(fromRow - 1).get(fromCol) == GameSlot.MARBLE ||
          this.board.get(fromRow - 1).get(fromCol) == GameSlot.MARBLESPACE;
    } else if (this.movedUpLeft(fromCol, fromRow, toCol, toRow)) {
      return this.board.get(fromRow - 1).get(fromCol - 1) == GameSlot.MARBLE ||
          this.board.get(fromRow - 1).get(fromCol - 1) == GameSlot.MARBLESPACE;
    } else if (this.movedDownRight(fromCol, fromRow, toCol, toRow)) {
      return this.board.get(fromRow + 1).get(fromCol + 1) == GameSlot.MARBLE ||
          this.board.get(fromRow + 1).get(fromCol + 1) == GameSlot.MARBLESPACE;
    } else if (this.movedDownLeft(fromCol, fromRow, toCol, toRow)) {
      return this.board.get(fromRow + 1).get(fromCol) == GameSlot.MARBLE ||
          this.board.get(fromRow + 1).get(fromCol) == GameSlot.MARBLESPACE;
    } else if (this.movedRight(fromCol, toCol)) {
      return this.board.get(fromRow).get(fromCol + 1) == GameSlot.MARBLE ||
          this.board.get(fromRow).get(fromCol + 1) == GameSlot.MARBLESPACE;
    } else {
      return this.board.get(fromRow).get(fromCol - 1) == GameSlot.MARBLE ||
          this.board.get(fromRow).get(fromCol - 1) == GameSlot.MARBLESPACE;
    }
  }

  /**
   * Determines if the move brings the marble to the up right direction or not.
   *
   * @param fromRow the row position of the 'from' position
   * @param toRow the row position of the 'to' position
   * @param fromCol the column position of the 'from' position
   * @param toCol the column position of the 'to' position
   * @return true if the fromRow is less than to toRow, which suggests that the move is in the up
   *                    right direction.
   */
  private boolean movedUpRight(int fromRow, int fromCol, int toRow, int toCol) {
    return fromCol > toCol && fromRow == toRow;
  }

  /**
   * Determines if the move brings the marble to the up left direction or not.
   *
   * @param fromRow the row position of the 'from' position
   * @param toRow the row position of the 'to' position
   * @param fromCol the column position of the 'from' position
   * @param toCol the column position of the 'to' position
   * @return true if the fromRow is less than to toRow, which suggests that the move is in the up
   *                  left direction.
   */
  private boolean movedUpLeft(int fromRow, int fromCol, int toRow, int toCol) {
    return fromCol > toCol && fromRow > toRow;
  }

  /**
   * Determines if the move brings the marble to the down right direction or not.
   *
   * @param fromRow the row position of the 'from' position
   * @param toRow the row position of the 'to' position
   * @param fromCol the column position of the 'from' position
   * @param toCol the column position of the 'to' position
   * @return true if the fromRow is less than to toRow, which suggests that the move is in the down
   *                  right direction.
   */
  private boolean movedDownRight(int fromRow, int fromCol, int toRow, int toCol) {
    return fromCol < toCol && fromRow < toRow;
  }

  /**
   * Determines if the move brings the marble to the down left direction or not.
   *
   * @param fromRow the row position of the 'from' position
   * @param toRow the row position of the 'to' position
   * @param fromCol the column position of the 'from' position
   * @param toCol the column position of the 'to' position
   * @return true if the fromRow is less than to toRow, which suggests that the move is in the down
   *                left direction.
   */
  private boolean movedDownLeft(int fromRow, int fromCol, int toRow, int toCol) {
    return fromCol < toCol && fromRow == toRow;
  }

  /**
   * Sets the position in between the 'from' and 'to' position to be empty by replacing the GameSlot
   * element to EMPTY or EMPTYSPACE.
   *
   * @param fromRow the row position of the 'from' position
   * @param fromCol the column position of the 'from' position
   * @param toRow the row position of the 'to' position
   * @param toCol the column position of the 'to' position
   */
  private void setBetweenEmptyTriangle(int fromRow, int fromCol, int toRow, int toCol) {
    if (this.movedUpRight(fromCol, fromRow, toCol, toRow)) {
      if (this.board.get(fromRow - 1).get(toCol) == GameSlot.MARBLE) {
        this.board.get(fromRow - 1).set(toCol, GameSlot.EMPTY);
      } else {
        this.board.get(fromRow - 1).set(toCol, GameSlot.EMPTYSPACE);
      }
    } else if (this.movedUpLeft(fromCol, fromRow, toCol, toRow)) {
      if (this.board.get(fromRow - 1).get(fromCol - 1) == GameSlot.MARBLE) {
        this.board.get(fromRow - 1).set(fromCol - 1, GameSlot.EMPTY);
      } else {
        this.board.get(fromRow - 1).set(fromCol - 1, GameSlot.EMPTYSPACE);
      }
    } else if (this.movedDownRight(fromCol, fromRow, toCol, toRow)) {
      if (this.board.get(fromRow + 1).get(fromCol + 1) == GameSlot.MARBLE) {
        this.board.get(fromRow + 1).set(fromCol + 1, GameSlot.EMPTY);
      } else {
        this.board.get(fromRow + 1).set(fromCol + 1, GameSlot.EMPTYSPACE);
      }
    } else if ((this.movedDownLeft(fromCol, fromRow, toCol, toRow))) {
      if (this.board.get(fromRow + 1).get(toCol) == GameSlot.MARBLE) {
        this.board.get(fromRow + 1).set(toCol, GameSlot.EMPTY);
      } else {
        this.board.get(fromRow + 1).set(toCol, GameSlot.EMPTYSPACE);
      }
    } else if (this.movedRight(fromCol, toCol)) {
      if (this.board.get(toRow).get(toCol - 1) == GameSlot.MARBLE) {
        this.board.get(toRow).set(toCol - 1, GameSlot.EMPTY);
      } else {
        this.board.get(toRow).set(toCol - 1, GameSlot.EMPTYSPACE);
      }
    } else {
      if (this.board.get(toRow).get(fromCol - 1) == GameSlot.MARBLE) {
        this.board.get(toRow).set(fromCol - 1, GameSlot.EMPTY);
      } else {
        this.board.get(toRow).set(fromCol - 1, GameSlot.EMPTYSPACE);
      }

    }
  }

  @Override
  public boolean isGameOver() {
    if (this.getScore() == 1) {
      return true;
    } else {
      boolean movesUnavailable = false;
      int currDimension = 0;
      for (int i = 0; i <= this.fullLengthPosition; i++) {
        for (int j = 0; j <= currDimension; j++) {
          movesUnavailable = movesUnavailable || this
              .hasMovesTriangle(i, j, currDimension, this.fullLengthPosition);
        }
        currDimension++;
      }
      return !movesUnavailable;
    }
  }

  /**
   * Determines if the given position (from the parameters column and row) has a valid move or more
   * moves available. A position has a valid move or more if it is able to move to any of the 6
   * directions (right, left, up right, up left, down right, down left). A move is valid if the
   * 'from' position is a marble, if the 'to' position is empty, and if there is a marble in between
   * the 'from' and 'to' positions.
   *
   * @param row row element of the position
   * @param column column element of the position
   * @return true if the given position (from the parameters column and row) has a valid move or
   *                more available
   */
  private boolean hasMovesTriangle(int row, int column, int currDimension, int fullDimension) {
    if ((this.board.get(row).get(column) == GameSlot.EMPTY
        || this.board.get(row).get(column) == GameSlot.EMPTYSPACE)
        ||
        this.board.get(row).get(column) == GameSlot.SPACE || this.board.get(row).get(column)
        == GameSlot.SPACESPACE || this.board.get(row).get(column) == GameSlot.NONE) {
      return false;
    } else {
      return this.rightMoveCheck(row, column, currDimension) || this.leftMoveCheck(row, column) ||
          this.upRightMoveCheck(row, column) || this.upLeftMoveCheck(row, column) ||
          this.downRightMoveCheck(row, column, fullDimension) || this
          .downLeftMoveCheck(row, column, currDimension);
    }
  }

  /**
   * Determines if the given position has a valid move to the up right.
   *
   * @param col column element of the position
   * @param row row element of the position
   * @return true if the given position has a valid up right move is available.
   */
  private boolean upRightMoveCheck(int row, int col) {
    if (col - 2 < 0) {
      return false;
    } else {
      return (this.board.get(row).get(col - 1) == GameSlot.MARBLE
          || this.board.get(row).get(col - 1)
          == GameSlot.MARBLESPACE) &&
          (this.board.get(row).get(col - 2) == GameSlot.EMPTY
              || this.board.get(row).get(col - 2)
              == GameSlot.EMPTYSPACE);
    }
  }

  /**
   * Determines if the given position has a valid move to the up left.
   *
   * @param col column element of the position
   * @param row row element of the position
   * @return true if the given position has a valid up left move is available.
   */
  private boolean upLeftMoveCheck(int row, int col) {
    if (row - 2 < 0 || col - 2 < 0) {
      return false;
    } else {
      return (this.board.get(row - 1).get(col - 1) == GameSlot.MARBLE
          || this.board.get(row - 1).get(col - 1)
          == GameSlot.MARBLESPACE) &&
          (this.board.get(row - 2).get(col - 2) == GameSlot.EMPTY
              || this.board.get(row - 2).get(col - 2)
              == GameSlot.EMPTYSPACE);
    }
  }

  /**
   * Determines if the given position has a valid move to the down right.
   *
   * @param col column element of the position
   * @param row row element of the position
   * @param dimension the current dimension value of the row/column
   * @return true if the given position has a valid down right move is available.
   */
  private boolean downRightMoveCheck(int row, int col, int dimension) {
    if (row + 2 > dimension || col + 2 > dimension) {
      return false;
    } else {
      return (this.board.get(row + 1).get(col + 1) == GameSlot.MARBLE
          || this.board.get(row + 1).get(col + 1)
          == GameSlot.MARBLESPACE) &&
          (this.board.get(row + 2).get(col + 2) == GameSlot.EMPTY
              || this.board.get(row + 2).get(col + 2)
              == GameSlot.EMPTYSPACE);
    }
  }

  /**
   * Determines if the given position has a valid move to the down left.
   *
   * @param col column element of the position
   * @param row row element of the position
   * @param dimension the current dimension value of the row/column
   * @return true if the given position has a valid down left move is available.
   */
  private boolean downLeftMoveCheck(int row, int col, int dimension) {
    if (row + 2 > dimension) {
      return false;
    } else {
      return (this.board.get(row + 1).get(col) == GameSlot.MARBLE
          || this.board.get(row + 1).get(col)
          == GameSlot.MARBLESPACE) &&
          (this.board.get(row + 2).get(col) == GameSlot.EMPTY
              || this.board.get(row + 2).get(col)
              == GameSlot.EMPTYSPACE);
    }
  }

  /**
   * Determines if the given position has a valid move to the right.
   *
   * @param col column element of the position
   * @param row row element of the position
   * @param dimension the current dimension value of the row/column
   * @return true if the given position has a valid right move.
   */
  private boolean rightMoveCheck(int row, int col, int dimension) {
    if (col + 2 > dimension) {
      return false;
    } else {
      return (this.board.get(row).get(col + 1) == GameSlot.MARBLE
          || this.board.get(row).get(col + 1)
          == GameSlot.MARBLESPACE) &&
          (this.board.get(row).get(col + 2) == GameSlot.EMPTY
              || this.board.get(row).get(col + 2)
              == GameSlot.EMPTYSPACE);
    }
  }

  /**
   * Determines if the given position has a valid move to the left.
   *
   * @param col column element of the position
   * @param row row element of the position
   * @return true if the given position has a valid left move.
   */
  private boolean leftMoveCheck(int row, int col) {
    if (col - 2 < 0) {
      return false;
    } else {
      return (this.board.get(row).get(col - 1) == GameSlot.MARBLE
          || this.board.get(row).get(col - 1)
          == GameSlot.MARBLESPACE) &&
          (this.board.get(row).get(col - 2) == GameSlot.EMPTY
              || this.board.get(row).get(col - 2)
              == GameSlot.EMPTYSPACE);
    }
  }


}
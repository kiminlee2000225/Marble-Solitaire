package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.GameSlot;
import java.util.ArrayList;

/**
 * Implementation of the EuropeanSolitaireModelImpl interface. Creates a European MarbleSolitaire
 * board depending on the arm thickness (or side length), the initial empty slot, and/or both.
 * Implements the method to move the marbles, determine if the game is over, and find the score.
 */
public class EuropeanSolitaireModelImpl extends AbstractSolitaireModelImpl {

  /**
   * Constructor for the the European marble solitaire model with no parameters. The arm thickness,
   * or the side length, is 3 with the empty slot at the center of the board.
   */
  public EuropeanSolitaireModelImpl() {
    this.fullLengthPosition = 6;
    this.emptySpacePosition = 1;
    this.armThickness = 3;
    this.sRow = 3;
    this.sCol = 3;
    this.board = new ArrayList<ArrayList<GameSlot>>();
    this.createBoard();
    this.setInitEmptySlot();
  }

  /**
   * Constructor for the the European marble solitaire model with armThickness as the arm thickness,
   * or side length. The arm thickness, or side length, is invalid if it is not a positive odd
   * number. The empty slot becomes the center of the board.
   *
   * @param armThickness the arm thickness for the board
   * @throws IllegalArgumentException if the given arm thickness or side length is invalid
   */
  public EuropeanSolitaireModelImpl(int armThickness) throws IllegalArgumentException {
    if (armThickness == 1) {
      throw new IllegalArgumentException("The arm thickness cannot be 1!");
    }
    if (armThickness <= 0 || (armThickness % 2 == 0)) {
      throw new IllegalArgumentException("The arm thickness is not a positive odd number!");
    }
    this.armThickness = armThickness;
    this.fullLengthPosition = ((2 * this.armThickness) + (this.armThickness - 2)) - 1;
    this.emptySpacePosition = this.armThickness - 2;
    int centerPosition = (fullLengthPosition / 2);
    this.sRow = centerPosition;
    this.sCol = centerPosition;
    this.board = new ArrayList<ArrayList<GameSlot>>();
    this.createBoard();
    this.setInitEmptySlot();
  }

  /**
   * Constructor for the the European marble solitaire model with sRow and sCol as the row and
   * column element of the empty slot. The empty slot is invalid if the slot does not exist on the
   * board.
   *
   * @param sRow the row element of the empty slot
   * @param sCol the column element of the empty slot
   * @throws IllegalArgumentException if the given empty slot elements reference an invalid
   *                                 position
   */
  public EuropeanSolitaireModelImpl(int sRow, int sCol) throws IllegalArgumentException {
    this.fullLengthPosition = 6;
    this.emptySpacePosition = 1;
    this.armThickness = 3;
    this.sRow = sRow;
    this.sCol = sCol;
    this.board = new ArrayList<ArrayList<GameSlot>>();
    this.createBoard();
    if (this.invalidPosition(sRow, sCol)) {
      throw new IllegalArgumentException(
          "Invalid empty cell position (" + sRow + ", " + sCol + ")");
    }
    this.setInitEmptySlot();
  }

  /**
   * Constructor for the the European marble solitaire model with armThickness as the arm thickness,
   * or the side length, sRow as the row element of the empty slot, and sCol as the column element
   * of the empty slot. The arm thickness, or the side length, is invalid if it is not a positive
   * odd number. The empty slot is invalid if the slot does not exist on the board.
   *
   * @param armThickness the arm thickness for the board
   * @param sRow the row element of the empty slot
   * @param sCol the column element of the empty slot
   * @throws IllegalArgumentException if the given arm thickness or side length is invalid or if the
   *                                 given empty slot elements reference an invalid position.
   */
  public EuropeanSolitaireModelImpl(int armThickness, int sRow, int sCol)
      throws IllegalArgumentException {
    if (armThickness == 1) {
      throw new IllegalArgumentException("The arm thickness cannot be 1!");
    }
    this.armThickness = armThickness;
    this.fullLengthPosition = ((2 * this.armThickness) + (this.armThickness - 2)) - 1;
    this.emptySpacePosition = this.armThickness - 2;
    this.sRow = sRow;
    this.sCol = sCol;
    this.board = new ArrayList<ArrayList<GameSlot>>();
    this.createBoard();
    if (armThickness <= 0 || (armThickness % 2 == 0)) {
      throw new IllegalArgumentException("The arm thickness is not a positive odd number!");
    }
    if (this.invalidPosition(sRow, sCol)) {
      throw new IllegalArgumentException(
          "Invalid empty cell position (" + sRow + ", " + sCol + ")");
    }
    this.setInitEmptySlot();
  }

  /**
   * Creates the board for the game by adding each column for every row element. Create a unique
   * column on the first and very last row. Create unique columns to create an octagon shape for the
   * other rows. The center column (or the side length columns) should have all position as the
   * marble.
   */
  private void createBoard() {

    int newEmptySpacePosition = emptySpacePosition;

    for (int i = 0; i <= this.fullLengthPosition; i++) {
      if (i == 0 || i == fullLengthPosition) {
        this.board.add(this.createUniqueColumns());
      } else if (i <= this.emptySpacePosition || i > (this.emptySpacePosition
          + this.armThickness)) {

        this.board.add(this.diffColumnHelper(newEmptySpacePosition));

        if (this.armThickness == 3) {
          newEmptySpacePosition = emptySpacePosition;
        } else if (i < (this.fullLengthPosition / 2)) {
          newEmptySpacePosition--;
        } else {
          newEmptySpacePosition++;
        }
      } else {
        this.board.add(this.createAllMarbleColumns());
        newEmptySpacePosition = 1;
      }
    }
  }

  /**
   * Creates a column using a ArrayList of Strings. There should be a " " in between every position.
   * There should be a "O" for the positions where there are marbles. There should be a " " for the
   * invalid positions.This column is the column with armThickness number of marbles. This column
   * creates a unique column depending on which row it is, to create a model with an octagon shape.
   *
   * @param newEmptySpacePosition the emptySpacePosition for this row
   * @return the column created as an ArrayList of Strings
   */
  private ArrayList<GameSlot> diffColumnHelper(int newEmptySpacePosition) {
    ArrayList<GameSlot> column = new ArrayList<GameSlot>();

    for (int i = 0; i <= this.fullLengthPosition; i++) {
      if (i < newEmptySpacePosition) {
        column.add(GameSlot.SPACESPACE);
      } else if (i > (this.fullLengthPosition - newEmptySpacePosition)) {
        column.add(GameSlot.NONE);
      } else {
        if (i == this.fullLengthPosition - newEmptySpacePosition) {
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
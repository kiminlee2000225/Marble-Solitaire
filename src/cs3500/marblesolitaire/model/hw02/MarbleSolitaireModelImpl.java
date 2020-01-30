package cs3500.marblesolitaire.model.hw02;

import cs3500.marblesolitaire.model.hw04.AbstractSolitaireModelImpl;
import java.util.ArrayList;

/**
 * Implementation of the MarbleSolitaireModel interface. Creates a MarbleSolitaire board depending
 * on the arm thickness, the initial empty slot, and/or both. Implements the method to move the
 * marbles, determine if the game is over, and find the score.
 */
public class MarbleSolitaireModelImpl extends AbstractSolitaireModelImpl {

  /**
   * Constructor for the the marble solitaire model with no parameters. The arm thickness is 3 with
   * the empty slot at the center of the board.
   */
  public MarbleSolitaireModelImpl() {
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
   * Constructor for the the marble solitaire model with sRow and sCol as the row and column element
   * of the empty slot. The empty slot is invalid if the slot does not exist on the board.
   *
   * @param sRow the row element of the empty slot
   * @param sCol the column element of the empty slot
   * @throws IllegalArgumentException if the given empty slot elements reference an invalid
   *                                 position
   */
  public MarbleSolitaireModelImpl(int sRow, int sCol) throws IllegalArgumentException {
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
   * Constructor for the the marble solitaire model with armThickness as the arm thickness. The arm
   * thickness is invalid if it is not a positive odd number. The empty slot becomes the center of
   * the board.
   *
   * @param armThickness the arm thickness for the board
   * @throws IllegalArgumentException if the given arm thickness is invalid
   */
  public MarbleSolitaireModelImpl(int armThickness) throws IllegalArgumentException {
    if (armThickness == 1) {
      throw new IllegalArgumentException("The arm thickness cannot be 1!");
    }
    this.armThickness = armThickness;
    this.fullLengthPosition = ((2 * this.armThickness) + (this.armThickness - 2)) - 1;
    this.emptySpacePosition = this.armThickness - 2;
    int centerPosition = (fullLengthPosition / 2);
    this.sRow = centerPosition;
    this.sCol = centerPosition;
    this.board = new ArrayList<ArrayList<GameSlot>>();
    this.createBoard();
    if (armThickness <= 0 || (armThickness % 2 == 0)) {
      throw new IllegalArgumentException("The arm thickness is not a positive odd number!");
    }
    this.setInitEmptySlot();
  }

  /**
   * Constructor for the the marble solitaire model with armThickness as the arm thickness, sRow as
   * the row element of the empty slot, and sCol as the column element of the empty slot. The arm
   * thickness is invalid if it is not a positive odd number. The empty slot is invalid if the slot
   * does not exist on the board.
   *
   * @param armThickness the arm thickness for the board
   * @param sRow the row element of the empty slot
   * @param sCol the column element of the empty slot
   * @throws IllegalArgumentException if the given arm thickness is invalid or if the given empty
   *                                  slot elements reference an invalid position.
   */
  public MarbleSolitaireModelImpl(int armThickness, int sRow, int sCol)
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
   * column if the row position of the board is in an invalid position. Otherwise, create a simple
   * column with all position as the marble.
   */
  private void createBoard() {
    for (int i = 0; i <= this.fullLengthPosition; i++) {
      if (i <= this.emptySpacePosition || i > (this.emptySpacePosition + this.armThickness)) {
        this.board.add(this.createUniqueColumns());
      } else {
        this.board.add(this.createAllMarbleColumns());
      }
    }
  }


}
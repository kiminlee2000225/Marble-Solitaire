package cs3500.marblesolitaire.controller;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Controller for the MarbleSolitaireModel, which stores Readable and Appendable as input and output
 * for the model/game. The controller runs the program and represent every game state by effectively
 * facilitating it through a sequence of operations.
 */
public class MarbleSolitaireControllerImpl implements MarbleSolitaireController {

  private final Readable input;
  private final Appendable output;

  /**
   * The constructor for MarbleSolitaireControllerImpl with rd as Readable for input, and ap as
   * Appendable for output. It throws an IllegalArgumentException if and only either of its
   * arguments are null.
   *
   * @param rd Readable as the input for the model/game
   * @param ap Output as the output for the model/game
   * @throws IllegalArgumentException if and only either of the argument is null.
   */
  public MarbleSolitaireControllerImpl(Readable rd, Appendable ap) throws IllegalArgumentException {
    if (rd == null || ap == null) {
      throw new IllegalArgumentException("Either the Readable or Appendable is a null!");
    }
    this.input = rd;
    this.output = ap;
  }

  @Override
  /**
   * The player can play the game by typing and inputting inputs as strings, separated by spaces or
   * the enter button. The player can quit the game any time by inputting "q" or "Q". The player can
   * move marbles by typing in the from row, from column, to row, and to column elements in order.
   * If the inputted from and/or to positions are invalid, and/or the move is invalid, the game
   * gives a message indicating that the move is invalid. If the player inputs a invalid value for
   * the positions such as a character,the game gives a message indicating that the entered value
   * is invalid. After initiating the game, making a move, and attempting to making an invalid
   * move, it shows the game state. The game state also comes with the current score.
   */
  public void playGame(MarbleSolitaireModel model)
      throws IllegalArgumentException, IllegalStateException {

    try {
      Scanner scan = new Scanner(this.input);

      ArrayList<Integer> movePositions = new ArrayList<Integer>();

      // returns the initial board state with the score
      this.initialBoard(model);

      // if the input is empty from the beginning, throw an IllegalStateException
      if (!scan.hasNext()) {
        throw new IllegalStateException("Readable is unable to provide inputs!");
      }

      while (scan.hasNext()) {
        String nextInput = scan.next();

        switch (nextInput) {
          case "q":
          case "Q":
            this.gameQuit(model);
            return;
          default:
            this.parseIntOrReenter(movePositions, nextInput);
            break;
        }

        if (movePositions.size() == 4) {
          int fromRow;
          int fromCol;
          int toRow;
          int toCol;

          // Set the position values to specific rows and columns for the 'from' and 'to' positions.
          // Negate 1 from every given position value as the count begins from 0 in the model.
          fromRow = movePositions.get(0) - 1;
          fromCol = movePositions.get(1) - 1;
          toRow = movePositions.get(2) - 1;
          toCol = movePositions.get(3) - 1;

          // Resets the position values for new move(s).
          movePositions = new ArrayList<Integer>();

          //attempt to make a move
          this.attemptMove(model, fromRow, fromCol, toRow, toCol);
        }

        // check if the game is over
        if (model.isGameOver()) {
          this.gameOverString(model);
          return;
        }
      }

      // if the while loop is over, the game did not finish, but there are no more inputs, so throw
      // an IllegalStateException
      throw new IllegalStateException("Readable is unable to provide inputs!");
    } catch (NullPointerException npe) {
      throw new IllegalArgumentException("The model is a null!");
    }
  }

  /**
   * Attempts to make a move. If the move is not possible, indicate that the move inputs to be
   * reentered. If possible, execute the move.
   *
   * @param model the model for the solitaire game
   * @param fromRow the row element of the from position
   * @param fromCol the column element of the from position
   * @param toRow the row element of the to position
   * @param toCol the column element of the to position
   */
  private void attemptMove(MarbleSolitaireModel model, int fromRow, int fromCol, int toRow,
      int toCol) {
    String gameString;
    try {
      model.move(fromRow, fromCol, toRow, toCol);
      gameString = model.getGameState() + "\nScore: " + model.getScore();
      this.tryAppending(gameString);
    } catch (IllegalArgumentException iae) {
      gameString = "Invalid move. Play again. " + iae.getLocalizedMessage();
      this.tryAppending(gameString);
    }
  }

  /**
   * Indicate that the game has been quitted and show the state of game when it quits with the
   * score.
   *
   * @param model the model for the solitaire game
   */
  private void gameQuit(MarbleSolitaireModel model) {
    String gameString;
    gameString =
        "Game quit!\n" + "State of game when quit:\n" + model.getGameState() + "\nScore: "
            + model.getScore();
    this.tryAppending(gameString);
  }

  /**
   * If the next input is an integer, add it to the movePositions list. If not, indicate the player
   * to reenter a move value.
   *
   * @param movePositions the current positions holder for moving a marble
   * @param nextInput The next input for the possible move element
   */
  private void parseIntOrReenter(ArrayList<Integer> movePositions, String nextInput) {
    String gameString;

    try {
      int nextInteger = Integer.parseInt(nextInput);
      movePositions.add(nextInteger);
    } catch (NumberFormatException iae) {
      gameString = "Please re-enter the value!";
      this.tryAppending(gameString);
    }
  }

  /**
   * Shows the initial board with the given model with the score.
   *
   * @param model the model for the solitaire game
   */
  private void initialBoard(MarbleSolitaireModel model) {
    String gameString = model.getGameState() + "\nScore: " + model.getScore();
    this.tryAppending(gameString);
  }

  /**
   * Shows that the game has ended with the board when the game is over withe the score.
   *
   * @param model the model for the solitaire game
   */
  private void gameOverString(MarbleSolitaireModel model) {
    String gameString;
    gameString = "Game over!\n" + model.getGameState() + "\nScore: " + model.getScore();
    this.tryAppending(gameString);
  }

  /**
   * Tries appending the given gameString to output as an Appendable. If the appending throws an
   * IOException, throw a new IllegalStateException.
   *
   * @param gameString the String that is trying to be appended to Appendable (output)
   * @throws IllegalStateException if the appending of the argument to Appendable (output) is not
   *                                possible. In other words, if appending throws an IOException
   */
  private void tryAppending(String gameString) throws IllegalStateException {
    try {
      gameString += "\n";
      this.output.append(gameString);
    } catch (IOException ioe) {
      throw new IllegalStateException("Appendable is unable to transmit the output!");
    }
  }
}

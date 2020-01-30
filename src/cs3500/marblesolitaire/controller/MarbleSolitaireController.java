package cs3500.marblesolitaire.controller;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * The Controller for the MarbleSolitaire game/model that allows storage of the inputs by the player
 * and the output that the game gives/shows to the player. The controller runs the program and
 * represent every game state by effectively facilitating it through a sequence of operations.
 */
public interface MarbleSolitaireController {

  /**
   * Plays a new game of Marble Solitaire using the provided model. It should
   * throw an IllegalArgumentException if the provided model is null. It should throw an
   * IllegalStateException only if the controller is unable to successfully receive input or
   * transmit output.
   *
   * @param model the model that the game is played
   * @throws IllegalArgumentException if the given model is null
   * @throws IllegalStateException only if the controller is unable to successfully receive input
   *                    or transmit output
   */
  void playGame(MarbleSolitaireModel model) throws IllegalArgumentException, IllegalStateException;
}

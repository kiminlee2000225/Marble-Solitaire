package cs3500.marblesolitaire.model.hw02;

/**
 * An enumeration for the GameSlot. In other words, the possible slot for each position on the
 * board.
 */
public enum GameSlot {

  MARBLE("O"),
  EMPTY("_"),
  SPACE(" "),
  NONE(""),
  MARBLESPACE("O "),
  EMPTYSPACE("_ "),
  SPACESPACE("  ");

  private final String stringSlot;

  /**
   * Constructs the enum with the according String as the stringSlot.
   *
   * @param stringSlot the String for the GameSlot
   */
  GameSlot(String stringSlot) {
    this.stringSlot = stringSlot;
  }

  /**
   * Gets the String of the specific enum.
   *
   * @return the stringSlot for this GameSlot
   */
  public String getStringSlot() {
    return this.stringSlot;
  }
}

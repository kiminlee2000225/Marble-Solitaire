import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModelImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests for the MarbleSolitaireModelImpl.
 */
public class EuropeanSolitaireModelImplTest {

  EuropeanSolitaireModelImpl ex1;
  EuropeanSolitaireModelImpl ex2;
  EuropeanSolitaireModelImpl ex3;
  EuropeanSolitaireModelImpl ex4;

  // get gameState() test
  @Test
  public void getGameStateTest() {
    this.ex1 = new EuropeanSolitaireModelImpl();
    this.ex2 = new EuropeanSolitaireModelImpl(5);
    this.ex3 = new EuropeanSolitaireModelImpl(3, 4);
    this.ex4 = new EuropeanSolitaireModelImpl(7, 10, 10);
    assertEquals("    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O", this.ex1.getGameState());
    assertEquals("        O O O O O\n"
        + "      O O O O O O O\n"
        + "    O O O O O O O O O\n"
        + "  O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O O _ O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "  O O O O O O O O O O O\n"
        + "    O O O O O O O O O\n"
        + "      O O O O O O O\n"
        + "        O O O O O", this.ex2.getGameState());
    assertEquals("    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O O _ O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O", this.ex3.getGameState());
    assertEquals("            O O O O O O O\n"
        + "          O O O O O O O O O\n"
        + "        O O O O O O O O O O O\n"
        + "      O O O O O O O O O O O O O\n"
        + "    O O O O O O O O O O O O O O O\n"
        + "  O O O O O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O _ O O O O O O O O\n"
        + "O O O O O O O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O O O O O O O\n"
        + "  O O O O O O O O O O O O O O O O O\n"
        + "    O O O O O O O O O O O O O O O\n"
        + "      O O O O O O O O O O O O O\n"
        + "        O O O O O O O O O O O\n"
        + "          O O O O O O O O O\n"
        + "            O O O O O O O", this.ex4.getGameState());
  }

  @Test
  public void initValidTests() {
    this.ex1 = new EuropeanSolitaireModelImpl();
    this.ex2 = new EuropeanSolitaireModelImpl(5);
    this.ex3 = new EuropeanSolitaireModelImpl(3, 4);
    this.ex4 = new EuropeanSolitaireModelImpl(7, 10, 10);
    assertEquals("    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O", this.ex1.getGameState());
  }

  // invalid constructor tests
  @Test(expected = IllegalArgumentException.class)
  public void invalidEmptySlot() {
    this.ex1 = new EuropeanSolitaireModelImpl(0, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidEmptySlot2() {
    this.ex1 = new EuropeanSolitaireModelImpl(-1, -2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidEmptySlot3() {
    this.ex1 = new EuropeanSolitaireModelImpl(3, -1, -2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidArmLength() {
    this.ex1 = new EuropeanSolitaireModelImpl(2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidArmLength2() {
    this.ex1 = new EuropeanSolitaireModelImpl(2, 3, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidNegativeArmLength() {
    this.ex1 = new EuropeanSolitaireModelImpl(-3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidNegativeArmLength2() {
    this.ex1 = new EuropeanSolitaireModelImpl(-5, 3, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidZeroArmLength() {
    this.ex1 = new EuropeanSolitaireModelImpl(0);
  }

  // Invalid move tests
  @Test(expected = IllegalArgumentException.class)
  public void fromPositionInvalidMove() {
    this.initValidTests();
    this.ex1.move(0, 0, 0, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void fromPositionInvalidMov2() {
    this.initValidTests();
    this.ex1.move(1, 6, 3, 6);
  }

  @Test(expected = IllegalArgumentException.class)
  public void toPositionInvalidMove() {
    this.initValidTests();
    this.ex1.move(2, 0, 0, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void toPositionInvalidMove2() {
    this.initValidTests();
    this.ex1.move(3, 6, 1, 6);
  }

  @Test(expected = IllegalArgumentException.class)
  public void fromPositionNotMarbleMove() {
    this.initValidTests();
    this.ex1.move(3, 3, 3, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void toPositionNotEmptyMove() {
    this.initValidTests();
    this.ex1.move(1, 4, 3, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void toPositionNotEmptyMove2() {
    this.initValidTests();
    this.ex1.move(0, 3, 2, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void diagonalMove() {
    this.initValidTests();
    this.ex1.move(3, 1, 5, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void diagonalMove2() {
    this.initValidTests();
    this.ex1.move(0, 2, 2, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void noMarbleInBetweenMove() {
    this.initValidTests();
    this.ex1.move(3, 2, 3, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void negPositionMove() {
    this.initValidTests();
    this.ex1.move(0, 1, -2, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void negPositionMove2() {
    this.initValidTests();
    this.ex1.move(-2, -3, -2, -1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void exceedingBoardLengthMove() {
    this.initValidTests();
    this.ex1.move(6, 3, 8, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void exceedingBoardLengthMove2() {
    this.initValidTests();
    this.ex1.move(8, 3, 6, 3);
  }

  // valid move test
  @Test
  public void moveTest() {
    this.ex1 = new EuropeanSolitaireModelImpl(2, 6);
    this.ex1.move(2, 4, 2, 6);
    assertEquals(
        "    O O O\n"
            + "  O O O O O\n"
            + "O O O O _ _ O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "  O O O O O\n"
            + "    O O O", this.ex1.getGameState());
    this.ex1.move(4, 4, 2, 4);
    assertEquals(
        "    O O O\n"
            + "  O O O O O\n"
            + "O O O O O _ O\n"
            + "O O O O _ O O\n"
            + "O O O O _ O O\n"
            + "  O O O O O\n"
            + "    O O O", this.ex1.getGameState());
    this.ex1.move(4, 6, 4, 4);
    assertEquals(
        "    O O O\n"
            + "  O O O O O\n"
            + "O O O O O _ O\n"
            + "O O O O _ O O\n"
            + "O O O O O _ _\n"
            + "  O O O O O\n"
            + "    O O O", this.ex1.getGameState());
    this.ex1.move(3, 6, 3, 4);
    assertEquals(
        "    O O O\n"
            + "  O O O O O\n"
            + "O O O O O _ O\n"
            + "O O O O O _ _\n"
            + "O O O O O _ _\n"
            + "  O O O O O\n"
            + "    O O O", this.ex1.getGameState());
    this.ex1.move(2, 3, 2, 5);
    assertEquals(
        "    O O O\n"
            + "  O O O O O\n"
            + "O O O _ _ O O\n"
            + "O O O O O _ _\n"
            + "O O O O O _ _\n"
            + "  O O O O O\n"
            + "    O O O", this.ex1.getGameState());
    this.ex1.move(2, 6, 2, 4);
    assertEquals(
        "    O O O\n"
            + "  O O O O O\n"
            + "O O O _ O _ _\n"
            + "O O O O O _ _\n"
            + "O O O O O _ _\n"
            + "  O O O O O\n"
            + "    O O O", this.ex1.getGameState());
    this.ex1.move(0, 3, 2, 3);
    assertEquals(
        "    O _ O\n"
            + "  O O _ O O\n"
            + "O O O O O _ _\n"
            + "O O O O O _ _\n"
            + "O O O O O _ _\n"
            + "  O O O O O\n"
            + "    O O O", this.ex1.getGameState());
    this.ex1.move(1, 5, 1, 3);
    assertEquals(
        "    O _ O\n"
            + "  O O O _ _\n"
            + "O O O O O _ _\n"
            + "O O O O O _ _\n"
            + "O O O O O _ _\n"
            + "  O O O O O\n"
            + "    O O O", this.ex1.getGameState());
    this.ex1.move(3, 4, 1, 4);
    assertEquals(
        "    O _ O\n"
            + "  O O O O _\n"
            + "O O O O _ _ _\n"
            + "O O O O _ _ _\n"
            + "O O O O O _ _\n"
            + "  O O O O O\n"
            + "    O O O", this.ex1.getGameState());
    this.ex1.move(0, 4, 2, 4);
    assertEquals(
        "    O _ _\n"
            + "  O O O _ _\n"
            + "O O O O O _ _\n"
            + "O O O O _ _ _\n"
            + "O O O O O _ _\n"
            + "  O O O O O\n"
            + "    O O O", this.ex1.getGameState());
    this.ex1.move(1, 2, 1, 4);
    assertEquals(
        "    O _ _\n"
            + "  O _ _ O _\n"
            + "O O O O O _ _\n"
            + "O O O O _ _ _\n"
            + "O O O O O _ _\n"
            + "  O O O O O\n"
            + "    O O O", this.ex1.getGameState());
    this.ex1.move(1, 4, 3, 4);
    assertEquals(
        "    O _ _\n"
            + "  O _ _ _ _\n"
            + "O O O O _ _ _\n"
            + "O O O O O _ _\n"
            + "O O O O O _ _\n"
            + "  O O O O O\n"
            + "    O O O", this.ex1.getGameState());
    this.ex1.move(3, 2, 1, 2);
    assertEquals(
        "    O _ _\n"
            + "  O O _ _ _\n"
            + "O O _ O _ _ _\n"
            + "O O _ O O _ _\n"
            + "O O O O O _ _\n"
            + "  O O O O O\n"
            + "    O O O", this.ex1.getGameState());
    this.ex1.move(0, 2, 2, 2);
    assertEquals(
        "    _ _ _\n"
            + "  O _ _ _ _\n"
            + "O O O O _ _ _\n"
            + "O O _ O O _ _\n"
            + "O O O O O _ _\n"
            + "  O O O O O\n"
            + "    O O O", this.ex1.getGameState());
    this.ex1.move(3, 0, 3, 2);
    assertEquals(
        "    _ _ _\n"
            + "  O _ _ _ _\n"
            + "O O O O _ _ _\n"
            + "_ _ O O O _ _\n"
            + "O O O O O _ _\n"
            + "  O O O O O\n"
            + "    O O O", this.ex1.getGameState());
    this.ex1.move(1, 1, 3, 1);
    assertEquals(
        "    _ _ _\n"
            + "  _ _ _ _ _\n"
            + "O _ O O _ _ _\n"
            + "_ O O O O _ _\n"
            + "O O O O O _ _\n"
            + "  O O O O O\n"
            + "    O O O", this.ex1.getGameState());
    this.ex1.move(2, 3, 2, 1);
    assertEquals(
        "    _ _ _\n"
            + "  _ _ _ _ _\n"
            + "O O _ _ _ _ _\n"
            + "_ O O O O _ _\n"
            + "O O O O O _ _\n"
            + "  O O O O O\n"
            + "    O O O", this.ex1.getGameState());
    this.ex1.move(2, 0, 2, 2);
    assertEquals(
        "    _ _ _\n"
            + "  _ _ _ _ _\n"
            + "_ _ O _ _ _ _\n"
            + "_ O O O O _ _\n"
            + "O O O O O _ _\n"
            + "  O O O O O\n"
            + "    O O O", this.ex1.getGameState());
    this.ex1.move(4, 1, 2, 1);
    assertEquals(
        "    _ _ _\n"
            + "  _ _ _ _ _\n"
            + "_ O O _ _ _ _\n"
            + "_ _ O O O _ _\n"
            + "O _ O O O _ _\n"
            + "  O O O O O\n"
            + "    O O O", this.ex1.getGameState());
    this.ex1.move(4, 3, 4, 1);
    assertEquals(
        "    _ _ _\n"
            + "  _ _ _ _ _\n"
            + "_ O O _ _ _ _\n"
            + "_ _ O O O _ _\n"
            + "O O _ _ O _ _\n"
            + "  O O O O O\n"
            + "    O O O", this.ex1.getGameState());
    this.ex1.move(6, 2, 4, 2);
    assertEquals(
        "    _ _ _\n"
            + "  _ _ _ _ _\n"
            + "_ O O _ _ _ _\n"
            + "_ _ O O O _ _\n"
            + "O O O _ O _ _\n"
            + "  O _ O O O\n"
            + "    _ O O", this.ex1.getGameState());
    this.ex1.move(6, 3, 4, 3);
    assertEquals(
        "    _ _ _\n"
            + "  _ _ _ _ _\n"
            + "_ O O _ _ _ _\n"
            + "_ _ O O O _ _\n"
            + "O O O O O _ _\n"
            + "  O _ _ O O\n"
            + "    _ _ O", this.ex1.getGameState());
    this.ex1.move(5, 5, 5, 3);
    assertEquals(
        "    _ _ _\n"
            + "  _ _ _ _ _\n"
            + "_ O O _ _ _ _\n"
            + "_ _ O O O _ _\n"
            + "O O O O O _ _\n"
            + "  O _ O _ _\n"
            + "    _ _ O", this.ex1.getGameState());
    this.ex1.move(3, 4, 5, 4);
    assertEquals(
        "    _ _ _\n"
            + "  _ _ _ _ _\n"
            + "_ O O _ _ _ _\n"
            + "_ _ O O _ _ _\n"
            + "O O O O _ _ _\n"
            + "  O _ O O _\n"
            + "    _ _ O", this.ex1.getGameState());
    this.ex1.move(6, 4, 4, 4);
    assertEquals(
        "    _ _ _\n"
            + "  _ _ _ _ _\n"
            + "_ O O _ _ _ _\n"
            + "_ _ O O _ _ _\n"
            + "O O O O O _ _\n"
            + "  O _ O _ _\n"
            + "    _ _ _", this.ex1.getGameState());
    this.ex1.move(3, 2, 5, 2);
    assertEquals(
        "    _ _ _\n"
            + "  _ _ _ _ _\n"
            + "_ O O _ _ _ _\n"
            + "_ _ _ O _ _ _\n"
            + "O O _ O O _ _\n"
            + "  O O O _ _\n"
            + "    _ _ _", this.ex1.getGameState());
    this.ex1.move(5, 2, 5, 4);
    assertEquals(
        "    _ _ _\n"
            + "  _ _ _ _ _\n"
            + "_ O O _ _ _ _\n"
            + "_ _ _ O _ _ _\n"
            + "O O _ O O _ _\n"
            + "  O _ _ O _\n"
            + "    _ _ _", this.ex1.getGameState());
    this.ex1.move(5, 4, 3, 4);
    assertEquals(
        "    _ _ _\n"
            + "  _ _ _ _ _\n"
            + "_ O O _ _ _ _\n"
            + "_ _ _ O O _ _\n"
            + "O O _ O _ _ _\n"
            + "  O _ _ _ _\n"
            + "    _ _ _", this.ex1.getGameState());
    this.ex1.move(3, 4, 3, 2);
    assertEquals(
        "    _ _ _\n"
            + "  _ _ _ _ _\n"
            + "_ O O _ _ _ _\n"
            + "_ _ O _ _ _ _\n"
            + "O O _ O _ _ _\n"
            + "  O _ _ _ _\n"
            + "    _ _ _", this.ex1.getGameState());
    this.ex1.move(2, 2, 4, 2);
    assertEquals(
        "    _ _ _\n"
            + "  _ _ _ _ _\n"
            + "_ O _ _ _ _ _\n"
            + "_ _ _ _ _ _ _\n"
            + "O O O O _ _ _\n"
            + "  O _ _ _ _\n"
            + "    _ _ _", this.ex1.getGameState());
    this.ex1.move(5, 1, 3, 1);
    assertEquals(
        "    _ _ _\n"
            + "  _ _ _ _ _\n"
            + "_ O _ _ _ _ _\n"
            + "_ O _ _ _ _ _\n"
            + "O _ O O _ _ _\n"
            + "  _ _ _ _ _\n"
            + "    _ _ _", this.ex1.getGameState());
    this.ex1.move(4, 3, 4, 1);
    assertEquals(
        "    _ _ _\n"
            + "  _ _ _ _ _\n"
            + "_ O _ _ _ _ _\n"
            + "_ O _ _ _ _ _\n"
            + "O O _ _ _ _ _\n"
            + "  _ _ _ _ _\n"
            + "    _ _ _", this.ex1.getGameState());
    this.ex1.move(4, 0, 4, 2);
    assertEquals(
        "    _ _ _\n"
            + "  _ _ _ _ _\n"
            + "_ O _ _ _ _ _\n"
            + "_ O _ _ _ _ _\n"
            + "_ _ O _ _ _ _\n"
            + "  _ _ _ _ _\n"
            + "    _ _ _", this.ex1.getGameState());
    this.ex1.move(2, 1, 4, 1);
    assertEquals(
        "    _ _ _\n"
            + "  _ _ _ _ _\n"
            + "_ _ _ _ _ _ _\n"
            + "_ _ _ _ _ _ _\n"
            + "_ O O _ _ _ _\n"
            + "  _ _ _ _ _\n"
            + "    _ _ _", this.ex1.getGameState());
    this.ex1.move(4, 2, 4, 0);
    assertEquals(
        "    _ _ _\n"
            + "  _ _ _ _ _\n"
            + "_ _ _ _ _ _ _\n"
            + "_ _ _ _ _ _ _\n"
            + "O _ _ _ _ _ _\n"
            + "  _ _ _ _ _\n"
            + "    _ _ _", this.ex1.getGameState());

    this.ex2 = new EuropeanSolitaireModelImpl(5);
    this.ex2.move(6, 4, 6, 6);
    assertEquals(
        "        O O O O O\n"
            + "      O O O O O O O\n"
            + "    O O O O O O O O O\n"
            + "  O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O _ _ O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "  O O O O O O O O O O O\n"
            + "    O O O O O O O O O\n"
            + "      O O O O O O O\n"
            + "        O O O O O", this.ex2.getGameState());
  }

  // getScore() test
  @Test
  public void getScoreTest() {
    this.ex1 = new EuropeanSolitaireModelImpl(2, 6);

    assertEquals(36, this.ex1.getScore());
    this.ex1.move(2, 4, 2, 6);
    assertEquals(35, this.ex1.getScore());
    this.ex1.move(4, 4, 2, 4);
    assertEquals(34, this.ex1.getScore());
    this.ex1.move(4, 6, 4, 4);
    assertEquals(33, this.ex1.getScore());
    this.ex1.move(3, 6, 3, 4);
    assertEquals(32, this.ex1.getScore());
    this.ex1.move(2, 3, 2, 5);
    assertEquals(31, this.ex1.getScore());
    this.ex1.move(2, 6, 2, 4);
    assertEquals(30, this.ex1.getScore());
    this.ex1.move(0, 3, 2, 3);
    assertEquals(29, this.ex1.getScore());
    this.ex1.move(1, 5, 1, 3);
    assertEquals(28, this.ex1.getScore());
    this.ex1.move(3, 4, 1, 4);
    assertEquals(27, this.ex1.getScore());
    this.ex1.move(0, 4, 2, 4);
    assertEquals(26, this.ex1.getScore());
    this.ex1.move(1, 2, 1, 4);
    assertEquals(25, this.ex1.getScore());
    this.ex1.move(1, 4, 3, 4);
    assertEquals(24, this.ex1.getScore());
    this.ex1.move(3, 2, 1, 2);
    assertEquals(23, this.ex1.getScore());
    this.ex1.move(0, 2, 2, 2);
    assertEquals(22, this.ex1.getScore());
    this.ex1.move(3, 0, 3, 2);
    assertEquals(21, this.ex1.getScore());
    this.ex1.move(1, 1, 3, 1);
    assertEquals(20, this.ex1.getScore());
    this.ex1.move(2, 3, 2, 1);
    assertEquals(19, this.ex1.getScore());
    this.ex1.move(2, 0, 2, 2);
    assertEquals(18, this.ex1.getScore());
    this.ex1.move(4, 1, 2, 1);
    assertEquals(17, this.ex1.getScore());
    this.ex1.move(4, 3, 4, 1);
    assertEquals(16, this.ex1.getScore());
    this.ex1.move(6, 2, 4, 2);
    assertEquals(15, this.ex1.getScore());
    this.ex1.move(6, 3, 4, 3);
    assertEquals(14, this.ex1.getScore());
    this.ex1.move(5, 5, 5, 3);
    assertEquals(13, this.ex1.getScore());
    this.ex1.move(3, 4, 5, 4);
    assertEquals(12, this.ex1.getScore());
    this.ex1.move(6, 4, 4, 4);
    assertEquals(11, this.ex1.getScore());
    this.ex1.move(3, 2, 5, 2);
    assertEquals(10, this.ex1.getScore());
    this.ex1.move(5, 2, 5, 4);
    assertEquals(9, this.ex1.getScore());
    this.ex1.move(5, 4, 3, 4);
    assertEquals(8, this.ex1.getScore());
    this.ex1.move(3, 4, 3, 2);
    assertEquals(7, this.ex1.getScore());
    this.ex1.move(2, 2, 4, 2);
    assertEquals(6, this.ex1.getScore());
    this.ex1.move(5, 1, 3, 1);
    assertEquals(5, this.ex1.getScore());
    this.ex1.move(4, 3, 4, 1);
    assertEquals(4, this.ex1.getScore());
    this.ex1.move(4, 0, 4, 2);
    assertEquals(3, this.ex1.getScore());
    this.ex1.move(2, 1, 4, 1);
    assertEquals(2, this.ex1.getScore());
    this.ex1.move(4, 2, 4, 0);
    assertEquals(1, this.ex1.getScore());

    this.ex2 = new EuropeanSolitaireModelImpl(5);
    assertEquals(128, this.ex2.getScore());

    this.ex2 = new EuropeanSolitaireModelImpl(7, 10, 10);
    assertEquals(276, this.ex2.getScore());
  }

  // isGameOver() test
  @Test
  public void isGameOverTest() {
    this.ex1 = new EuropeanSolitaireModelImpl(2, 6);

    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(2, 4, 2, 6);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(4, 4, 2, 4);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(4, 6, 4, 4);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(3, 6, 3, 4);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(2, 3, 2, 5);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(2, 6, 2, 4);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(0, 3, 2, 3);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(1, 5, 1, 3);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(3, 4, 1, 4);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(0, 4, 2, 4);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(1, 2, 1, 4);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(1, 4, 3, 4);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(3, 2, 1, 2);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(0, 2, 2, 2);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(3, 0, 3, 2);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(1, 1, 3, 1);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(2, 3, 2, 1);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(2, 0, 2, 2);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(4, 1, 2, 1);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(4, 3, 4, 1);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(6, 2, 4, 2);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(6, 3, 4, 3);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(5, 5, 5, 3);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(3, 4, 5, 4);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(6, 4, 4, 4);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(3, 2, 5, 2);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(5, 2, 5, 4);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(5, 4, 3, 4);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(3, 4, 3, 2);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(2, 2, 4, 2);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(5, 1, 3, 1);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(4, 3, 4, 1);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(4, 0, 4, 2);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(2, 1, 4, 1);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(4, 2, 4, 0);
    assertEquals(true, this.ex1.isGameOver());

  }

  @Test
  public void isGameOverTest2() {

    this.ex1 = new EuropeanSolitaireModelImpl(2, 6);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(2, 4, 2, 6);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(4, 4, 2, 4);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(4, 6, 4, 4);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(3, 6, 3, 4);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(2, 3, 2, 5);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(2, 6, 2, 4);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(0, 3, 2, 3);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(1, 5, 1, 3);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(3, 4, 1, 4);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(0, 4, 2, 4);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(1, 2, 1, 4);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(1, 4, 3, 4);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(3, 2, 1, 2);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(0, 2, 2, 2);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(3, 0, 3, 2);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(1, 1, 3, 1);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(2, 3, 2, 1);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(2, 0, 2, 2);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(4, 1, 2, 1);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(4, 3, 4, 1);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(6, 2, 4, 2);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(6, 3, 4, 3);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(5, 1, 3, 1);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(3, 1, 1, 1);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(4, 4, 2, 4);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(3, 2, 1, 2);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(4, 3, 4, 1);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(4, 0, 4, 2);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(1, 1, 1, 3);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(5, 5, 5, 3);
    assertEquals(true, this.ex1.isGameOver());
    assertEquals(
        "    _ _ _\n"
            + "  _ _ O _ _\n"
            + "_ _ _ _ O _ _\n"
            + "_ _ _ O _ _ _\n"
            + "_ _ O _ _ _ _\n"
            + "  _ _ O _ _\n"
            + "    _ _ O", this.ex1.getGameState());

  }


}
import cs3500.marblesolitaire.model.hw02.GameSlot;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelImpl;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests for the MarbleSolitaireModelImpl.
 */
public class MarbleSolitaireModelImplTest {

  MarbleSolitaireModelImpl ex1;
  MarbleSolitaireModelImpl ex2;
  MarbleSolitaireModelImpl ex3;
  MarbleSolitaireModelImpl ex4;
  MarbleSolitaireModelImpl ex6;
  MarbleSolitaireModelImpl ex7;
  MarbleSolitaireModelImpl ex8;
  MarbleSolitaireModelImpl ex10;
  MarbleSolitaireModelImpl ex11;
  MarbleSolitaireModelImpl ex12;

  MarbleSolitaireModelImpl errorExceed1;
  MarbleSolitaireModelImpl errorExceed2;
  MarbleSolitaireModelImpl errorExceed3;
  MarbleSolitaireModelImpl errorExceed4;
  MarbleSolitaireModelImpl errorExceed5;
  MarbleSolitaireModelImpl errorExceed6;

  MarbleSolitaireModelImpl errorNeg0;
  MarbleSolitaireModelImpl errorNeg1;
  MarbleSolitaireModelImpl errorNeg2;
  MarbleSolitaireModelImpl errorNeg3;
  MarbleSolitaireModelImpl errorNeg4;
  MarbleSolitaireModelImpl errorNeg5;

  MarbleSolitaireModelImpl errorEven1;
  MarbleSolitaireModelImpl errorEven2;

  MarbleSolitaireModelImpl errorNegAndEven1;
  MarbleSolitaireModelImpl errorNegAndEven2;

  MarbleSolitaireModelImpl errorTopRight1;
  MarbleSolitaireModelImpl errorTopRight2;
  MarbleSolitaireModelImpl errorTopLeft1;
  MarbleSolitaireModelImpl errorTopLeft2;
  MarbleSolitaireModelImpl errorBottomLeft1;
  MarbleSolitaireModelImpl errorBottomLeft2;
  MarbleSolitaireModelImpl errorBottomRight1;
  MarbleSolitaireModelImpl errorBottomRight2;

  MarbleSolitaireModelImpl armThickness1Error1;
  MarbleSolitaireModelImpl armThickness1Error2;
  MarbleSolitaireModelImpl armThickness1Error3;

  MarbleSolitaireModelImpl error1;
  MarbleSolitaireModelImpl error2;
  MarbleSolitaireModelImpl error3;
  MarbleSolitaireModelImpl error4;
  MarbleSolitaireModelImpl error5;
  MarbleSolitaireModelImpl error6;


  @Test
  public void getGameStateTest() {
    this.ex1 = new MarbleSolitaireModelImpl();
    this.ex2 = new MarbleSolitaireModelImpl(1, 3);
    this.ex3 = new MarbleSolitaireModelImpl(4, 4);
    this.ex4 = new MarbleSolitaireModelImpl(0, 4);
    this.ex6 = new MarbleSolitaireModelImpl(3, 1, 3);
    this.ex7 = new MarbleSolitaireModelImpl(5, 5, 6);
    this.ex8 = new MarbleSolitaireModelImpl(9, 13, 13);
    this.ex10 = new MarbleSolitaireModelImpl(5);
    this.ex11 = new MarbleSolitaireModelImpl(7);
    this.ex12 = new MarbleSolitaireModelImpl(3);

    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O", this.ex1.getGameState());
    assertEquals("    O O O\n"
        + "    O _ O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O", this.ex2.getGameState());
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O O O _ O O\n"
        + "    O O O\n"
        + "    O O O", this.ex3.getGameState());
    assertEquals("    O O _\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O", this.ex4.getGameState());
    assertEquals("    O O O\n"
        + "    O _ O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O", this.ex6.getGameState());
    assertEquals(
        "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O _ O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O", this.ex7.getGameState());
    assertEquals("                O O O O O O O O O\n"
        + "                O O O O O O O O O\n"
        + "                O O O O O O O O O\n"
        + "                O O O O O O O O O\n"
        + "                O O O O O O O O O\n"
        + "                O O O O O O O O O\n"
        + "                O O O O O O O O O\n"
        + "                O O O O O O O O O\n"
        + "O O O O O O O O O O O O O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O _ O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O O O O O O O O O O O O O\n"
        + "                O O O O O O O O O\n"
        + "                O O O O O O O O O\n"
        + "                O O O O O O O O O\n"
        + "                O O O O O O O O O\n"
        + "                O O O O O O O O O\n"
        + "                O O O O O O O O O\n"
        + "                O O O O O O O O O\n"
        + "                O O O O O O O O O", this.ex8.getGameState());
    assertEquals("        O O O O O\n"
        + "        O O O O O\n"
        + "        O O O O O\n"
        + "        O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O O _ O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "        O O O O O\n"
        + "        O O O O O\n"
        + "        O O O O O\n"
        + "        O O O O O", this.ex10.getGameState());
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O", this.ex12.getGameState());
  }

  @Test
  public void initValidTests() {
    this.ex1 = new MarbleSolitaireModelImpl();
    this.ex2 = new MarbleSolitaireModelImpl(1, 3);
    this.ex3 = new MarbleSolitaireModelImpl(4, 4);
    this.ex4 = new MarbleSolitaireModelImpl(0, 4);
    this.ex6 = new MarbleSolitaireModelImpl(3, 1, 3);
    this.ex7 = new MarbleSolitaireModelImpl(5, 5, 6);
    this.ex8 = new MarbleSolitaireModelImpl(9, 13, 13);
    this.ex10 = new MarbleSolitaireModelImpl(5);
    this.ex11 = new MarbleSolitaireModelImpl(7);
    this.ex12 = new MarbleSolitaireModelImpl(3);
    // purpose for JUnitTestsShouldIncludeAssert
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O", this.ex1.getGameState());
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidModel() {
    this.error1 = new MarbleSolitaireModelImpl(0, 0);
    this.error2 = new MarbleSolitaireModelImpl(1, 2, 5);
    this.error3 = new MarbleSolitaireModelImpl(3, 6, 6);
    this.error4 = new MarbleSolitaireModelImpl(3, 0, 0);
    this.error5 = new MarbleSolitaireModelImpl(3, 0, 5);
    this.error6 = new MarbleSolitaireModelImpl(3, 5, 0);
    // purpose for JUnitTestsShouldIncludeAssert
    assertEquals("", this.error1.getGameState());
  }

  @Test(expected = IllegalArgumentException.class)
  public void armThickness1Error() {
    this.armThickness1Error1 = new MarbleSolitaireModelImpl(1);
    this.armThickness1Error2 = new MarbleSolitaireModelImpl(1, 1, 0);
    this.armThickness1Error3 = new MarbleSolitaireModelImpl(1, 0, 0);
    assertEquals("", this.armThickness1Error1.getGameState());
  }

  @Test(expected = IllegalArgumentException.class)
  public void positionExceedFullLengthError() {
    this.errorExceed1 = new MarbleSolitaireModelImpl(3, 9, 4);
    this.errorExceed2 = new MarbleSolitaireModelImpl(3, 4, 9);
    this.errorExceed3 = new MarbleSolitaireModelImpl(3, 9, 9);
    this.errorExceed4 = new MarbleSolitaireModelImpl(4, 9);
    this.errorExceed5 = new MarbleSolitaireModelImpl(9, 4);
    this.errorExceed6 = new MarbleSolitaireModelImpl(9, 9);
    assertEquals("", this.errorExceed1.getGameState());
  }

  @Test(expected = IllegalArgumentException.class)
  public void negativePositionValues() {
    this.errorNeg0 = new MarbleSolitaireModelImpl(-0, -0);
    this.errorNeg1 = new MarbleSolitaireModelImpl(-1, 0);
    this.errorNeg2 = new MarbleSolitaireModelImpl(5, -9);
    this.errorNeg3 = new MarbleSolitaireModelImpl(-3, -15);
    this.errorNeg4 = new MarbleSolitaireModelImpl(-1, 3, 0);
    this.errorNeg5 = new MarbleSolitaireModelImpl(-3);
    assertEquals("", this.errorNeg0.getGameState());
  }

  @Test(expected = IllegalArgumentException.class)
  public void evenPositionValues() {
    this.errorEven1 = new MarbleSolitaireModelImpl(2);
    this.errorEven2 = new MarbleSolitaireModelImpl(4, 3, 0);
    assertEquals("", this.errorEven1.getGameState());
  }

  @Test(expected = IllegalArgumentException.class)
  public void evenAndNegativePositionValues() {
    this.errorNegAndEven1 = new MarbleSolitaireModelImpl(2, -3, -4);
    this.errorNegAndEven2 = new MarbleSolitaireModelImpl(-1, -3, -6);
    assertEquals("", this.errorNegAndEven1.getGameState());
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidPositionTest() {
    this.errorTopRight1 = new MarbleSolitaireModelImpl(6, 1);
    this.errorTopRight2 = new MarbleSolitaireModelImpl(5, 12, 1);
    this.errorTopLeft1 = new MarbleSolitaireModelImpl(1, 0);
    this.errorTopLeft2 = new MarbleSolitaireModelImpl(5, 2, 2);
    this.errorBottomLeft1 = new MarbleSolitaireModelImpl(0, 5);
    this.errorBottomLeft2 = new MarbleSolitaireModelImpl(5, 0, 10);
    this.errorBottomRight1 = new MarbleSolitaireModelImpl(5, 6);
    this.errorBottomRight2 = new MarbleSolitaireModelImpl(5, 12, 12);
    assertEquals("", this.errorTopLeft1.getGameState());
  }

  @Test(expected = IllegalArgumentException.class)
  public void fromPositionInvalidMoveTest() {
    this.initValidTests();
    this.ex1.move(0, 0, 0, 2);
    this.ex1.move(5, 6, 5, 4);
    this.ex1.move(6, 0, 6, 2);
    this.ex1.move(1, 5, 3, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void toPositionInvalidMoveTest() {
    this.initValidTests();
    this.ex1.move(2, 0, 0, 0);
    this.ex1.move(3, 6, 5, 6);
    this.ex1.move(6, 2, 6, 0);
    this.ex1.move(3, 5, 1, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void fromPositionNotMarbleMoveTest() {
    this.initValidTests();
    this.ex1.move(3, 3, 3, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void toPositionNotEmptyMoveTest() {
    this.initValidTests();
    this.ex1.move(1, 4, 3, 4);
    this.ex1.move(0, 3, 2, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void diagonalMoveTest() {
    // or not 2 positions apart
    this.initValidTests();
    this.ex1.move(3, 1, 5, 3);
    this.ex1.move(6, 3, 1, 3);
    this.ex1.move(3, 3, 4, 2);
    this.ex1.move(0, 2, 2, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void noMarbleAtFromAndToMoveTest() {
    this.initValidTests();
    this.ex1.move(3, 2, 3, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void negPositionMoveTest() {
    this.initValidTests();
    this.ex1.move(0, 1, -2, 1);
    this.ex1.move(2, 0, 2, -2);
    this.ex1.move(-2, 1, 0, 1);
    this.ex1.move(2, -2, 2, 0);
    this.ex1.move(-2, -3, -2, -1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void exceedingBoardLengthMoveTest() {
    this.initValidTests();
    this.ex1.move(6, 3, 8, 3);
    this.ex1.move(3, 8, 3, 8);
    this.ex1.move(2, 6, 2, 8);
    this.ex1.move(8, 3, 6, 3);
    this.ex1.move(9, 9, 11, 9);
  }

  @Test
  public void moveTest() {
    this.initValidTests();
    this.ex1.move(3, 1, 3, 3);
    assertEquals(
        "    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O _ _ O O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O", this.ex1.getGameState());
    this.ex1.move(1, 2, 3, 2);
    assertEquals(
        "    O O O\n"
            + "    _ O O\n"
            + "O O _ O O O O\n"
            + "O _ O O O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O", this.ex1.getGameState());
    this.ex1.move(2, 0, 2, 2);
    assertEquals(
        "    O O O\n"
            + "    _ O O\n"
            + "_ _ O O O O O\n"
            + "O _ O O O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O", this.ex1.getGameState());
    this.ex1.move(4, 0, 2, 0);
    assertEquals(
        "    O O O\n"
            + "    _ O O\n"
            + "O _ O O O O O\n"
            + "_ _ O O O O O\n"
            + "_ O O O O O O\n"
            + "    O O O\n"
            + "    O O O", this.ex1.getGameState());
    this.ex1.move(2, 3, 2, 1);
    assertEquals(
        "    O O O\n"
            + "    _ O O\n"
            + "O O _ _ O O O\n"
            + "_ _ O O O O O\n"
            + "_ O O O O O O\n"
            + "    O O O\n"
            + "    O O O", this.ex1.getGameState());
    this.ex1.move(2, 0, 2, 2);
    assertEquals(
        "    O O O\n"
            + "    _ O O\n"
            + "_ _ O _ O O O\n"
            + "_ _ O O O O O\n"
            + "_ O O O O O O\n"
            + "    O O O\n"
            + "    O O O", this.ex1.getGameState());
    this.ex1.move(2, 5, 2, 3);
    assertEquals(
        "    O O O\n"
            + "    _ O O\n"
            + "_ _ O O _ _ O\n"
            + "_ _ O O O O O\n"
            + "_ O O O O O O\n"
            + "    O O O\n"
            + "    O O O", this.ex1.getGameState());
    this.ex1.move(0, 4, 2, 4);
    assertEquals(
        "    O O _\n"
            + "    _ O _\n"
            + "_ _ O O O _ O\n"
            + "_ _ O O O O O\n"
            + "_ O O O O O O\n"
            + "    O O O\n"
            + "    O O O", this.ex1.getGameState());
    this.ex1.move(0, 2, 0, 4);
    assertEquals(
        "    _ _ O\n"
            + "    _ O _\n"
            + "_ _ O O O _ O\n"
            + "_ _ O O O O O\n"
            + "_ O O O O O O\n"
            + "    O O O\n"
            + "    O O O", this.ex1.getGameState());
    this.ex1.move(3, 4, 1, 4);
    assertEquals(
        "    _ _ O\n"
            + "    _ O O\n"
            + "_ _ O O _ _ O\n"
            + "_ _ O O _ O O\n"
            + "_ O O O O O O\n"
            + "    O O O\n"
            + "    O O O", this.ex1.getGameState());
    this.ex1.move(0, 4, 2, 4);
    assertEquals(
        "    _ _ _\n"
            + "    _ O _\n"
            + "_ _ O O O _ O\n"
            + "_ _ O O _ O O\n"
            + "_ O O O O O O\n"
            + "    O O O\n"
            + "    O O O", this.ex1.getGameState());
    this.ex1.move(5, 4, 3, 4);
    assertEquals(
        "    _ _ _\n"
            + "    _ O _\n"
            + "_ _ O O O _ O\n"
            + "_ _ O O O O O\n"
            + "_ O O O _ O O\n"
            + "    O O _\n"
            + "    O O O", this.ex1.getGameState());
    this.ex1.move(4, 6, 4, 4);
    assertEquals(
        "    _ _ _\n"
            + "    _ O _\n"
            + "_ _ O O O _ O\n"
            + "_ _ O O O O O\n"
            + "_ O O O O _ _\n"
            + "    O O _\n"
            + "    O O O", this.ex1.getGameState());
    this.ex1.move(2, 6, 4, 6);
    assertEquals(
        "    _ _ _\n"
            + "    _ O _\n"
            + "_ _ O O O _ _\n"
            + "_ _ O O O O _\n"
            + "_ O O O O _ O\n"
            + "    O O _\n"
            + "    O O O", this.ex1.getGameState());
    this.ex1.move(4, 3, 4, 5);
    assertEquals(
        "    _ _ _\n"
            + "    _ O _\n"
            + "_ _ O O O _ _\n"
            + "_ _ O O O O _\n"
            + "_ O O _ _ O O\n"
            + "    O O _\n"
            + "    O O O", this.ex1.getGameState());
    this.ex1.move(4, 6, 4, 4);
    assertEquals(
        "    _ _ _\n"
            + "    _ O _\n"
            + "_ _ O O O _ _\n"
            + "_ _ O O O O _\n"
            + "_ O O _ O _ _\n"
            + "    O O _\n"
            + "    O O O", this.ex1.getGameState());
    this.ex1.move(4, 1, 4, 3);
    assertEquals(
        "    _ _ _\n"
            + "    _ O _\n"
            + "_ _ O O O _ _\n"
            + "_ _ O O O O _\n"
            + "_ _ _ O O _ _\n"
            + "    O O _\n"
            + "    O O O", this.ex1.getGameState());
    this.ex1.move(6, 2, 4, 2);
    assertEquals(
        "    _ _ _\n"
            + "    _ O _\n"
            + "_ _ O O O _ _\n"
            + "_ _ O O O O _\n"
            + "_ _ O O O _ _\n"
            + "    _ O _\n"
            + "    _ O O", this.ex1.getGameState());
    this.ex1.move(6, 4, 6, 2);
    assertEquals(
        "    _ _ _\n"
            + "    _ O _\n"
            + "_ _ O O O _ _\n"
            + "_ _ O O O O _\n"
            + "_ _ O O O _ _\n"
            + "    _ O _\n"
            + "    O _ _", this.ex1.getGameState());
    this.ex1.move(3, 2, 5, 2);
    assertEquals(
        "    _ _ _\n"
            + "    _ O _\n"
            + "_ _ O O O _ _\n"
            + "_ _ _ O O O _\n"
            + "_ _ _ O O _ _\n"
            + "    O O _\n"
            + "    O _ _", this.ex1.getGameState());
    this.ex1.move(6, 2, 4, 2);
    assertEquals(
        "    _ _ _\n"
            + "    _ O _\n"
            + "_ _ O O O _ _\n"
            + "_ _ _ O O O _\n"
            + "_ _ O O O _ _\n"
            + "    _ O _\n"
            + "    _ _ _", this.ex1.getGameState());
    this.ex1.move(3, 4, 5, 4);
    assertEquals(
        "    _ _ _\n"
            + "    _ O _\n"
            + "_ _ O O O _ _\n"
            + "_ _ _ O _ O _\n"
            + "_ _ O O _ _ _\n"
            + "    _ O O\n"
            + "    _ _ _", this.ex1.getGameState());
    this.ex1.move(5, 4, 5, 2);
    assertEquals(
        "    _ _ _\n"
            + "    _ O _\n"
            + "_ _ O O O _ _\n"
            + "_ _ _ O _ O _\n"
            + "_ _ O O _ _ _\n"
            + "    O _ _\n"
            + "    _ _ _", this.ex1.getGameState());
    this.ex1.move(5, 2, 3, 2);
    assertEquals(
        "    _ _ _\n"
            + "    _ O _\n"
            + "_ _ O O O _ _\n"
            + "_ _ O O _ O _\n"
            + "_ _ _ O _ _ _\n"
            + "    _ _ _\n"
            + "    _ _ _", this.ex1.getGameState());
    this.ex1.move(3, 2, 1, 2);
    assertEquals(
        "    _ _ _\n"
            + "    O O _\n"
            + "_ _ _ O O _ _\n"
            + "_ _ _ O _ O _\n"
            + "_ _ _ O _ _ _\n"
            + "    _ _ _\n"
            + "    _ _ _", this.ex1.getGameState());
    this.ex1.move(1, 2, 1, 4);
    assertEquals(
        "    _ _ _\n"
            + "    _ _ O\n"
            + "_ _ _ O O _ _\n"
            + "_ _ _ O _ O _\n"
            + "_ _ _ O _ _ _\n"
            + "    _ _ _\n"
            + "    _ _ _", this.ex1.getGameState());
    this.ex1.move(1, 4, 3, 4);
    assertEquals(
        "    _ _ _\n"
            + "    _ _ _\n"
            + "_ _ _ O _ _ _\n"
            + "_ _ _ O O O _\n"
            + "_ _ _ O _ _ _\n"
            + "    _ _ _\n"
            + "    _ _ _", this.ex1.getGameState());
    this.ex1.move(3, 3, 5, 3);
    assertEquals(
        "    _ _ _\n"
            + "    _ _ _\n"
            + "_ _ _ O _ _ _\n"
            + "_ _ _ _ O O _\n"
            + "_ _ _ _ _ _ _\n"
            + "    _ O _\n"
            + "    _ _ _", this.ex1.getGameState());
    this.ex1.move(3, 5, 3, 3);
    assertEquals(
        "    _ _ _\n"
            + "    _ _ _\n"
            + "_ _ _ O _ _ _\n"
            + "_ _ _ O _ _ _\n"
            + "_ _ _ _ _ _ _\n"
            + "    _ O _\n"
            + "    _ _ _", this.ex1.getGameState());
    this.ex1.move(2, 3, 4, 3);
    assertEquals(
        "    _ _ _\n"
            + "    _ _ _\n"
            + "_ _ _ _ _ _ _\n"
            + "_ _ _ _ _ _ _\n"
            + "_ _ _ O _ _ _\n"
            + "    _ O _\n"
            + "    _ _ _", this.ex1.getGameState());
    this.ex1.move(5, 3, 3, 3);
    assertEquals(
        "    _ _ _\n"
            + "    _ _ _\n"
            + "_ _ _ _ _ _ _\n"
            + "_ _ _ O _ _ _\n"
            + "_ _ _ _ _ _ _\n"
            + "    _ _ _\n"
            + "    _ _ _", this.ex1.getGameState());

    this.ex10.move(6, 4, 6, 6);
    assertEquals(
        "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O _ _ O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O", this.ex10.getGameState());
  }

  @Test
  public void getScoreTest() {
    this.initValidTests();
    assertEquals(32, this.ex1.getScore());
    this.ex1.move(3, 1, 3, 3);
    assertEquals(31, this.ex1.getScore());
    this.ex1.move(1, 2, 3, 2);
    assertEquals(30, this.ex1.getScore());
    this.ex1.move(2, 0, 2, 2);
    assertEquals(29, this.ex1.getScore());
    this.ex1.move(4, 0, 2, 0);
    assertEquals(28, this.ex1.getScore());
    this.ex1.move(2, 3, 2, 1);
    assertEquals(27, this.ex1.getScore());
    this.ex1.move(2, 0, 2, 2);
    assertEquals(26, this.ex1.getScore());
    this.ex1.move(2, 5, 2, 3);
    assertEquals(25, this.ex1.getScore());
    this.ex1.move(0, 4, 2, 4);
    assertEquals(24, this.ex1.getScore());
    this.ex1.move(0, 2, 0, 4);
    assertEquals(23, this.ex1.getScore());
    this.ex1.move(3, 4, 1, 4);
    assertEquals(22, this.ex1.getScore());
    this.ex1.move(0, 4, 2, 4);
    assertEquals(21, this.ex1.getScore());
    this.ex1.move(5, 4, 3, 4);
    assertEquals(20, this.ex1.getScore());
    this.ex1.move(4, 6, 4, 4);
    assertEquals(19, this.ex1.getScore());
    this.ex1.move(2, 6, 4, 6);
    assertEquals(18, this.ex1.getScore());
    this.ex1.move(4, 3, 4, 5);
    assertEquals(17, this.ex1.getScore());
    this.ex1.move(4, 6, 4, 4);
    assertEquals(16, this.ex1.getScore());
    this.ex1.move(4, 1, 4, 3);
    assertEquals(15, this.ex1.getScore());
    this.ex1.move(6, 2, 4, 2);
    assertEquals(14, this.ex1.getScore());
    this.ex1.move(6, 4, 6, 2);
    assertEquals(13, this.ex1.getScore());
    this.ex1.move(3, 2, 5, 2);
    assertEquals(12, this.ex1.getScore());
    this.ex1.move(6, 2, 4, 2);
    assertEquals(11, this.ex1.getScore());
    this.ex1.move(3, 4, 5, 4);
    assertEquals(10, this.ex1.getScore());
    this.ex1.move(5, 4, 5, 2);
    assertEquals(9, this.ex1.getScore());
    this.ex1.move(5, 2, 3, 2);
    assertEquals(8, this.ex1.getScore());
    this.ex1.move(3, 2, 1, 2);
    assertEquals(7, this.ex1.getScore());
    this.ex1.move(1, 2, 1, 4);
    assertEquals(6, this.ex1.getScore());
    this.ex1.move(1, 4, 3, 4);
    assertEquals(5, this.ex1.getScore());
    this.ex1.move(3, 3, 5, 3);
    assertEquals(4, this.ex1.getScore());
    this.ex1.move(3, 5, 3, 3);
    assertEquals(3, this.ex1.getScore());
    this.ex1.move(2, 3, 4, 3);
    assertEquals(2, this.ex1.getScore());
    this.ex1.move(5, 3, 3, 3);
    assertEquals(1, this.ex1.getScore());

    assertEquals(32, this.ex2.getScore());
    assertEquals(104, this.ex7.getScore());
    assertEquals(216, this.ex11.getScore());
  }

  @Test
  public void isGameOverTest() {
    this.initValidTests();

    this.ex1.move(3, 1, 3, 3);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(1, 2, 3, 2);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(2, 0, 2, 2);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(2, 3, 2, 1);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(1, 4, 1, 2);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(0, 2, 2, 2);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(2, 2, 2, 0);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(4, 2, 2, 2);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(4, 0, 4, 2);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(3, 4, 1, 4);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(2, 0, 4, 0);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(0, 4, 2, 4);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(2, 5, 2, 3);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(3, 3, 1, 3);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(0, 3, 2, 3);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(2, 3, 2, 1);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(3, 6, 3, 4);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(4, 4, 2, 4);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(4, 6, 4, 4);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(5, 2, 3, 2);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(5, 4, 3, 4);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(3, 4, 1, 4);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(5, 3, 3, 3);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(3, 2, 3, 4);
    assertEquals(
        "    _ _ _\n"
            + "    _ _ O\n"
            + "_ O _ _ _ _ O\n"
            + "_ _ _ _ O _ _\n"
            + "O _ _ _ _ _ _\n"
            + "    _ _ _\n"
            + "    O O O", this.ex1.getGameState());
    assertEquals(true, this.ex1.isGameOver());

    // case where the game is over since the player wins the game.
    this.initValidTests();
    this.getScoreTest();
    assertEquals(true, this.ex1.isGameOver());
  }

  @Test
  public void gameSlotTest() {
    assertEquals("O", GameSlot.MARBLE.getStringSlot());
    assertEquals("O ", GameSlot.MARBLESPACE.getStringSlot());
    assertEquals("_", GameSlot.EMPTY.getStringSlot());
    assertEquals("_ ", GameSlot.EMPTYSPACE.getStringSlot());
    assertEquals("", GameSlot.NONE.getStringSlot());
    assertEquals(" ", GameSlot.SPACE.getStringSlot());
    assertEquals("  ", GameSlot.SPACESPACE.getStringSlot());
  }

}
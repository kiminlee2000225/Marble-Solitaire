import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModelImpl;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests for the TriangleSolitaireModelImpl.
 */
public class TriangleSolitaireModelImplTest {

  TriangleSolitaireModelImpl ex1;
  TriangleSolitaireModelImpl ex2;
  TriangleSolitaireModelImpl ex3;
  TriangleSolitaireModelImpl ex4;
  TriangleSolitaireModelImpl ex5;
  TriangleSolitaireModelImpl ex6;

  @Test
  public void getGameStateTest() {
    this.ex1 = new TriangleSolitaireModelImpl();
    this.ex2 = new TriangleSolitaireModelImpl(6);
    this.ex3 = new TriangleSolitaireModelImpl(2);
    this.ex4 = new TriangleSolitaireModelImpl(8);
    this.ex5 = new TriangleSolitaireModelImpl(1, 1);
    this.ex6 = new TriangleSolitaireModelImpl(8, 3, 3);

    assertEquals("    _\n"
        + "   O O\n"
        + "  O O O\n"
        + " O O O O\n"
        + "O O O O O", this.ex1.getGameState());
    assertEquals("     _\n"
        + "    O O\n"
        + "   O O O\n"
        + "  O O O O\n"
        + " O O O O O\n"
        + "O O O O O O", this.ex2.getGameState());
    assertEquals(" _\n"
        + "O O", this.ex3.getGameState());
    assertEquals("       _\n"
        + "      O O\n"
        + "     O O O\n"
        + "    O O O O\n"
        + "   O O O O O\n"
        + "  O O O O O O\n"
        + " O O O O O O O\n"
        + "O O O O O O O O", this.ex4.getGameState());
    assertEquals("    O\n"
        + "   O _\n"
        + "  O O O\n"
        + " O O O O\n"
        + "O O O O O", this.ex5.getGameState());
    assertEquals("       O\n"
        + "      O O\n"
        + "     O O O\n"
        + "    O O O _\n"
        + "   O O O O O\n"
        + "  O O O O O O\n"
        + " O O O O O O O\n"
        + "O O O O O O O O", this.ex6.getGameState());
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidDimension() {
    this.ex1 = new TriangleSolitaireModelImpl(0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidDimension2() {
    this.ex1 = new TriangleSolitaireModelImpl(-5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidDimension3() {
    this.ex1 = new TriangleSolitaireModelImpl(0, 1, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidDimension4() {
    this.ex1 = new TriangleSolitaireModelImpl(-3, 1, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidDimension5() {
    this.ex1 = new TriangleSolitaireModelImpl(1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidInitEmptyPosition() {
    this.ex1 = new TriangleSolitaireModelImpl(1, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidInitEmptyPosition2() {
    this.ex1 = new TriangleSolitaireModelImpl(4, 5, 10);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidInitEmptyPosition3() {
    this.ex1 = new TriangleSolitaireModelImpl(4, -1, -1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidInitEmptyPosition4() {
    this.ex1 = new TriangleSolitaireModelImpl(-2, -1);
  }


  @Test(expected = IllegalArgumentException.class)
  public void fromPosInvalidMove() {
    this.ex1 = new TriangleSolitaireModelImpl();
    this.ex1.move(0, 2, 0, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void fromPosInvalidMove2() {
    this.ex1 = new TriangleSolitaireModelImpl();
    this.ex1.move(0, -2, 0, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void toPosInvalidMove() {
    this.ex1 = new TriangleSolitaireModelImpl();
    this.ex1.move(0, 0, 0, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void toPosInvalidMove2() {
    this.ex1 = new TriangleSolitaireModelImpl();
    this.ex1.move(1, 0, -1, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void fromPositionNotMarbleMove() {
    this.ex1 = new TriangleSolitaireModelImpl();
    this.ex1.move(0, 0, 2, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void toPositionNotEmptyMove() {
    this.ex1 = new TriangleSolitaireModelImpl();
    this.ex1.move(2, 0, 2, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void diagonalMove() {
    this.ex1 = new TriangleSolitaireModelImpl();
    this.ex1.move(1, 0, 2, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void noMarbleInBetweenMove() {
    this.ex1 = new TriangleSolitaireModelImpl();
    this.ex1.move(2, 0, 0, 0);
    this.ex1.move(2, 2, 2, 0);
    // for visualization
    assertEquals("    O\n"
        + "   _ O\n"
        + "  O _ _\n"
        + " O O O O\n"
        + "O O O O O", this.ex1.getGameState());
    //error move
    this.ex1.move(3, 2, 1, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void negPositionMove() {
    this.ex1 = new TriangleSolitaireModelImpl();
    this.ex1.move(0, 0, -2, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void negPositionMove2() {
    this.ex1 = new TriangleSolitaireModelImpl();
    this.ex1.move(-1, -1, -1, -3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void exceedingBoardLengthMove() {
    this.ex1 = new TriangleSolitaireModelImpl();
    this.ex1.move(6, 3, 8, 3);
  }

  @Test
  public void moveTest() {
    this.ex1 = new TriangleSolitaireModelImpl();
    this.ex1.move(2, 0, 0, 0);
    assertEquals("    O\n"
        + "   _ O\n"
        + "  _ O O\n"
        + " O O O O\n"
        + "O O O O O", this.ex1.getGameState());
    this.ex1.move(2, 2, 2, 0);
    assertEquals("    O\n"
        + "   _ O\n"
        + "  O _ _\n"
        + " O O O O\n"
        + "O O O O O", this.ex1.getGameState());
    this.ex1.move(4, 4, 2, 2);
    assertEquals("    O\n"
        + "   _ O\n"
        + "  O _ O\n"
        + " O O O _\n"
        + "O O O O _", this.ex1.getGameState());
    this.ex1.move(1, 1, 3, 3);
    assertEquals("    O\n"
        + "   _ _\n"
        + "  O _ _\n"
        + " O O O O\n"
        + "O O O O _", this.ex1.getGameState());
    this.ex1.move(4, 2, 2, 2);
    assertEquals("    O\n"
        + "   _ _\n"
        + "  O _ O\n"
        + " O O _ O\n"
        + "O O _ O _", this.ex1.getGameState());
    this.ex1.move(4, 0, 4, 2);
    assertEquals("    O\n"
        + "   _ _\n"
        + "  O _ O\n"
        + " O O _ O\n"
        + "_ _ O O _", this.ex1.getGameState());
    this.ex1.move(4, 3, 4, 1);
    assertEquals("    O\n"
        + "   _ _\n"
        + "  O _ O\n"
        + " O O _ O\n"
        + "_ O _ _ _", this.ex1.getGameState());
    this.ex1.move(4, 1, 2, 1);
    assertEquals("    O\n"
        + "   _ _\n"
        + "  O O O\n"
        + " O _ _ O\n"
        + "_ _ _ _ _", this.ex1.getGameState());
    this.ex1.move(3, 3, 1, 1);
    assertEquals("    O\n"
        + "   _ O\n"
        + "  O O _\n"
        + " O _ _ _\n"
        + "_ _ _ _ _", this.ex1.getGameState());
    this.ex1.move(3, 0, 1, 0);
    assertEquals("    O\n"
        + "   O O\n"
        + "  _ O _\n"
        + " _ _ _ _\n"
        + "_ _ _ _ _", this.ex1.getGameState());
    this.ex1.move(0, 0, 2, 0);
    assertEquals("    _\n"
        + "   _ O\n"
        + "  O O _\n"
        + " _ _ _ _\n"
        + "_ _ _ _ _", this.ex1.getGameState());
    this.ex1.move(2, 0, 2, 2);
    assertEquals("    _\n"
        + "   _ O\n"
        + "  _ _ O\n"
        + " _ _ _ _\n"
        + "_ _ _ _ _", this.ex1.getGameState());
    this.ex1.move(2, 2, 0, 0);
    assertEquals("    O\n"
        + "   _ _\n"
        + "  _ _ _\n"
        + " _ _ _ _\n"
        + "_ _ _ _ _", this.ex1.getGameState());

    this.ex6 = new TriangleSolitaireModelImpl(8, 3, 3);
    // right move
    this.ex6.move(3, 1, 3, 3);
    assertEquals("       O\n"
        + "      O O\n"
        + "     O O O\n"
        + "    O _ _ O\n"
        + "   O O O O O\n"
        + "  O O O O O O\n"
        + " O O O O O O O\n"
        + "O O O O O O O O", this.ex6.getGameState());
    // up right move
    this.ex6.move(5, 1, 3, 1);
    assertEquals("       O\n"
        + "      O O\n"
        + "     O O O\n"
        + "    O O _ O\n"
        + "   O _ O O O\n"
        + "  O _ O O O O\n"
        + " O O O O O O O\n"
        + "O O O O O O O O", this.ex6.getGameState());
    // left move
    this.ex6.move(3, 0, 3, 2);
    assertEquals("       O\n"
        + "      O O\n"
        + "     O O O\n"
        + "    _ _ O O\n"
        + "   O _ O O O\n"
        + "  O _ O O O O\n"
        + " O O O O O O O\n"
        + "O O O O O O O O", this.ex6.getGameState());
    // up left move
    this.ex6.move(5, 3, 3, 1);
    assertEquals("       O\n"
        + "      O O\n"
        + "     O O O\n"
        + "    _ O O O\n"
        + "   O _ _ O O\n"
        + "  O _ O _ O O\n"
        + " O O O O O O O\n"
        + "O O O O O O O O", this.ex6.getGameState());
    // down left move
    this.ex6.move(2, 1, 4, 1);
    assertEquals("       O\n"
        + "      O O\n"
        + "     O _ O\n"
        + "    _ _ O O\n"
        + "   O O _ O O\n"
        + "  O _ O _ O O\n"
        + " O O O O O O O\n"
        + "O O O O O O O O", this.ex6.getGameState());
    // left move again
    this.ex6.move(4, 4, 4, 2);
    assertEquals("       O\n"
        + "      O O\n"
        + "     O _ O\n"
        + "    _ _ O O\n"
        + "   O O O _ _\n"
        + "  O _ O _ O O\n"
        + " O O O O O O O\n"
        + "O O O O O O O O", this.ex6.getGameState());
    // down right move
    this.ex6.move(2, 2, 4, 4);
    assertEquals("       O\n"
        + "      O O\n"
        + "     O _ _\n"
        + "    _ _ O _\n"
        + "   O O O _ O\n"
        + "  O _ O _ O O\n"
        + " O O O O O O O\n"
        + "O O O O O O O O", this.ex6.getGameState());
  }

  @Test
  public void getScoreTest() {
    this.ex1 = new TriangleSolitaireModelImpl();
    assertEquals(14, this.ex1.getScore());
    this.ex1.move(2, 0, 0, 0);
    assertEquals(13, this.ex1.getScore());
    this.ex1.move(2, 2, 2, 0);
    assertEquals(12, this.ex1.getScore());
    this.ex1.move(4, 4, 2, 2);
    assertEquals(11, this.ex1.getScore());
    this.ex1.move(1, 1, 3, 3);
    assertEquals(10, this.ex1.getScore());
    this.ex1.move(4, 2, 2, 2);
    assertEquals(9, this.ex1.getScore());
    this.ex1.move(4, 0, 4, 2);
    assertEquals(8, this.ex1.getScore());
    this.ex1.move(4, 3, 4, 1);
    assertEquals(7, this.ex1.getScore());
    this.ex1.move(4, 1, 2, 1);
    assertEquals(6, this.ex1.getScore());
    this.ex1.move(3, 3, 1, 1);
    assertEquals(5, this.ex1.getScore());
    this.ex1.move(3, 0, 1, 0);
    assertEquals(4, this.ex1.getScore());
    this.ex1.move(0, 0, 2, 0);
    assertEquals(3, this.ex1.getScore());
    this.ex1.move(2, 0, 2, 2);
    assertEquals(2, this.ex1.getScore());
    this.ex1.move(2, 2, 0, 0);
    assertEquals(1, this.ex1.getScore());

    this.ex2 = new TriangleSolitaireModelImpl(8);
    assertEquals(35, this.ex2.getScore());
  }

  @Test
  public void isGameOverTest() {
    this.ex1 = new TriangleSolitaireModelImpl();
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(2, 0, 0, 0);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(2, 2, 2, 0);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(4, 4, 2, 2);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(1, 1, 3, 3);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(4, 2, 2, 2);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(4, 0, 4, 2);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(4, 3, 4, 1);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(4, 1, 2, 1);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(3, 3, 1, 1);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(3, 0, 1, 0);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(0, 0, 2, 0);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(2, 0, 2, 2);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(2, 2, 0, 0);
    assertEquals(true, this.ex1.isGameOver());
    assertEquals("    O\n"
        + "   _ _\n"
        + "  _ _ _\n"
        + " _ _ _ _\n"
        + "_ _ _ _ _", this.ex1.getGameState());
  }

  @Test
  public void isGameOverTest2() {
    this.ex1 = new TriangleSolitaireModelImpl();
    this.ex1.move(2, 0, 0, 0);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(2, 2, 2, 0);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(4, 4, 2, 2);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(1, 1, 3, 3);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(4, 2, 2, 2);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(4, 0, 4, 2);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(4, 3, 4, 1);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(2, 2, 4, 4);
    assertEquals(false, this.ex1.isGameOver());
    this.ex1.move(3, 0, 3, 2);
    assertEquals(true, this.ex1.isGameOver());
    assertEquals("    O\n"
        + "   _ _\n"
        + "  O _ _\n"
        + " _ _ O _\n"
        + "_ O _ _ O", this.ex1.getGameState());

  }

}

import static org.junit.Assert.assertEquals;

import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModelImpl;
import java.io.StringReader;
import org.junit.Test;

/**
 * In depth tests for the MarbleSolitaireControllerImpl for the Triangle model. Including end
 * cases.
 */
public class TriangleMarbleSolitaireControllerImplTest {

  Readable input;

  Appendable output = new StringBuilder();

  MarbleSolitaireController initController;

  MarbleSolitaireModel model1 = new TriangleSolitaireModelImpl();
  MarbleSolitaireModel model2 = new TriangleSolitaireModelImpl(1, 1);
  MarbleSolitaireModel model3 = new TriangleSolitaireModelImpl(13);
  MarbleSolitaireModel model4 = new TriangleSolitaireModelImpl(6, 4, 2);


  // Successful constructor tests for MarbleSolitaireControllerImpl for TriangleSolitaireModelImpl
  @Test
  public void goodConstructorTriangleSolitaireControllerImpl() {
    this.input = new StringReader("");
    this.initController = new MarbleSolitaireControllerImpl(input, output);

    this.input = new StringReader("3 1 1 1 q");
    this.initController = new MarbleSolitaireControllerImpl(input, output);

    this.initController.playGame(model1);

    Appendable outputAp = new StringBuilder("    _\n"
        + "   O O\n"
        + "  O O O\n"
        + " O O O O\n"
        + "O O O O O\n"
        + "Score: 14\n"
        + "    O\n"
        + "   _ O\n"
        + "  _ O O\n"
        + " O O O O\n"
        + "O O O O O\n"
        + "Score: 13\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O\n"
        + "   _ O\n"
        + "  _ O O\n"
        + " O O O O\n"
        + "O O O O O\n"
        + "Score: 13\n");

    assertEquals(this.output.toString(), outputAp.toString());
  }

  // append errors for TriangleSolitaireModelImpl controller
  @Test(expected = IllegalStateException.class)
  public void appendError() {
    Appendable badOutput = new MarbleSolitaireControllerImplTest.AppendableMock();
    this.input = new StringReader("2 4 4 4 q");
    this.initController = new MarbleSolitaireControllerImpl(input, badOutput);
    this.initController.playGame(model1);
  }

  @Test(expected = IllegalStateException.class)
  public void emptyRd() {
    this.input = new StringReader("");
    this.initController = new MarbleSolitaireControllerImpl(input, output);
    this.initController.playGame(model1);
  }

  @Test(expected = IllegalStateException.class)
  public void rdBecomesEmptyAfterMove() {
    this.input = new StringReader("2 4 4 4");
    this.initController = new MarbleSolitaireControllerImpl(input, output);
    this.initController.playGame(model1);
  }

  @Test(expected = IllegalStateException.class)
  public void rdBecomesEmptyWithoutMove() {
    this.input = new StringReader("2 a 4 b 4 p ");
    this.initController = new MarbleSolitaireControllerImpl(input, output);
    this.initController.playGame(model1);
  }


  // successful tests for the playGame method
  @Test
  public void quitGameTest() {
    this.input = new StringReader("Q");
    Appendable outputAp = new StringBuilder("    _\n"
        + "   O O\n"
        + "  O O O\n"
        + " O O O O\n"
        + "O O O O O\n"
        + "Score: 14\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    _\n"
        + "   O O\n"
        + "  O O O\n"
        + " O O O O\n"
        + "O O O O O\n"
        + "Score: 14\n");

    this.initController = new MarbleSolitaireControllerImpl(input, output);

    this.initController.playGame(model1);

    assertEquals(this.output.toString(), outputAp.toString());
  }

  @Test
  public void quitGameTestFromRow() {
    this.input = new StringReader("q");
    Appendable outputAp = new StringBuilder("    _\n"
        + "   O O\n"
        + "  O O O\n"
        + " O O O O\n"
        + "O O O O O\n"
        + "Score: 14\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    _\n"
        + "   O O\n"
        + "  O O O\n"
        + " O O O O\n"
        + "O O O O O\n"
        + "Score: 14\n");

    this.initController = new MarbleSolitaireControllerImpl(input, output);

    this.initController.playGame(model1);

    assertEquals(this.output.toString(), outputAp.toString());
  }

  @Test
  public void quitGameTestFromCol() {
    this.input = new StringReader("1 q");
    Appendable outputAp = new StringBuilder("    _\n"
        + "   O O\n"
        + "  O O O\n"
        + " O O O O\n"
        + "O O O O O\n"
        + "Score: 14\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    _\n"
        + "   O O\n"
        + "  O O O\n"
        + " O O O O\n"
        + "O O O O O\n"
        + "Score: 14\n");

    this.initController = new MarbleSolitaireControllerImpl(input, output);

    this.initController.playGame(model1);

    assertEquals(this.output.toString(), outputAp.toString());
  }

  @Test
  public void quitGameTestToRow() {
    this.input = new StringReader("2 3 Q");
    Appendable outputAp = new StringBuilder("    _\n"
        + "   O O\n"
        + "  O O O\n"
        + " O O O O\n"
        + "O O O O O\n"
        + "Score: 14\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    _\n"
        + "   O O\n"
        + "  O O O\n"
        + " O O O O\n"
        + "O O O O O\n"
        + "Score: 14\n");

    this.initController = new MarbleSolitaireControllerImpl(input, output);

    this.initController.playGame(model1);

    assertEquals(this.output.toString(), outputAp.toString());
  }

  @Test
  public void quitGameTestToCol() {
    this.input = new StringReader("1 2 1 q");
    Appendable outputAp = new StringBuilder("    _\n"
        + "   O O\n"
        + "  O O O\n"
        + " O O O O\n"
        + "O O O O O\n"
        + "Score: 14\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    _\n"
        + "   O O\n"
        + "  O O O\n"
        + " O O O O\n"
        + "O O O O O\n"
        + "Score: 14\n");

    this.initController = new MarbleSolitaireControllerImpl(input, output);

    this.initController.playGame(model1);

    assertEquals(this.output.toString(), outputAp.toString());
  }


  @Test
  public void moveRightQuitTest() {

    this.input = new StringReader(" 5 1 5 3 q");

    Appendable outputAp = new StringBuilder("     O\n"
        + "    O O\n"
        + "   O O O\n"
        + "  O O O O\n"
        + " O O _ O O\n"
        + "O O O O O O\n"
        + "Score: 20\n"
        + "     O\n"
        + "    O O\n"
        + "   O O O\n"
        + "  O O O O\n"
        + " _ _ O O O\n"
        + "O O O O O O\n"
        + "Score: 19\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "     O\n"
        + "    O O\n"
        + "   O O O\n"
        + "  O O O O\n"
        + " _ _ O O O\n"
        + "O O O O O O\n"
        + "Score: 19\n");

    this.initController = new MarbleSolitaireControllerImpl(input, output);

    this.initController.playGame(model4);

    assertEquals(this.output.toString(), outputAp.toString());
  }

  @Test
  public void moveLeftQuitTest() {

    this.input = new StringReader(" 5 5 5 3 q");

    Appendable outputAp = new StringBuilder("     O\n"
        + "    O O\n"
        + "   O O O\n"
        + "  O O O O\n"
        + " O O _ O O\n"
        + "O O O O O O\n"
        + "Score: 20\n"
        + "     O\n"
        + "    O O\n"
        + "   O O O\n"
        + "  O O O O\n"
        + " O O O _ _\n"
        + "O O O O O O\n"
        + "Score: 19\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "     O\n"
        + "    O O\n"
        + "   O O O\n"
        + "  O O O O\n"
        + " O O O _ _\n"
        + "O O O O O O\n"
        + "Score: 19\n");

    this.initController = new MarbleSolitaireControllerImpl(input, output);

    this.initController.playGame(model4);

    assertEquals(this.output.toString(), outputAp.toString());
  }

  @Test
  public void moveUpRightQuitTest() {

    this.input = new StringReader(" 3 1 1 1 q");

    Appendable outputAp = new StringBuilder("    _\n"
        + "   O O\n"
        + "  O O O\n"
        + " O O O O\n"
        + "O O O O O\n"
        + "Score: 14\n"
        + "    O\n"
        + "   _ O\n"
        + "  _ O O\n"
        + " O O O O\n"
        + "O O O O O\n"
        + "Score: 13\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O\n"
        + "   _ O\n"
        + "  _ O O\n"
        + " O O O O\n"
        + "O O O O O\n"
        + "Score: 13\n");

    this.initController = new MarbleSolitaireControllerImpl(input, output);

    this.initController.playGame(model1);

    assertEquals(this.output.toString(), outputAp.toString());
  }


  @Test
  public void moveUpLeftQuitTest() {

    this.input = new StringReader(" 3 3 1 1 q");

    Appendable outputAp = new StringBuilder("    _\n"
        + "   O O\n"
        + "  O O O\n"
        + " O O O O\n"
        + "O O O O O\n"
        + "Score: 14\n"
        + "    O\n"
        + "   O _\n"
        + "  O O _\n"
        + " O O O O\n"
        + "O O O O O\n"
        + "Score: 13\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O\n"
        + "   O _\n"
        + "  O O _\n"
        + " O O O O\n"
        + "O O O O O\n"
        + "Score: 13\n");

    this.initController = new MarbleSolitaireControllerImpl(input, output);

    this.initController.playGame(model1);

    assertEquals(this.output.toString(), outputAp.toString());
  }

  @Test
  public void moveDownRightQuitTest() {

    this.input = new StringReader(" 3 1 5 3 q");

    Appendable outputAp = new StringBuilder("     O\n"
        + "    O O\n"
        + "   O O O\n"
        + "  O O O O\n"
        + " O O _ O O\n"
        + "O O O O O O\n"
        + "Score: 20\n"
        + "     O\n"
        + "    O O\n"
        + "   _ O O\n"
        + "  O _ O O\n"
        + " O O O O O\n"
        + "O O O O O O\n"
        + "Score: 19\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "     O\n"
        + "    O O\n"
        + "   _ O O\n"
        + "  O _ O O\n"
        + " O O O O O\n"
        + "O O O O O O\n"
        + "Score: 19\n");

    this.initController = new MarbleSolitaireControllerImpl(input, output);

    this.initController.playGame(model4);

    assertEquals(this.output.toString(), outputAp.toString());
  }


  @Test
  public void moveDownLeftQuitTest() {

    this.input = new StringReader(" 3 3 5 3 q");

    Appendable outputAp = new StringBuilder("     O\n"
        + "    O O\n"
        + "   O O O\n"
        + "  O O O O\n"
        + " O O _ O O\n"
        + "O O O O O O\n"
        + "Score: 20\n"
        + "     O\n"
        + "    O O\n"
        + "   O O _\n"
        + "  O O _ O\n"
        + " O O O O O\n"
        + "O O O O O O\n"
        + "Score: 19\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "     O\n"
        + "    O O\n"
        + "   O O _\n"
        + "  O O _ O\n"
        + " O O O O O\n"
        + "O O O O O O\n"
        + "Score: 19\n");

    this.initController = new MarbleSolitaireControllerImpl(input, output);

    this.initController.playGame(model4);

    assertEquals(this.output.toString(), outputAp.toString());
  }

  @Test
  public void gameWonTest() {

    this.input = new StringReader(
        "3 1 1 1  3 3 3 1  5 5 3 3  2 2 4 4  5 3 3 3  5 1 5 3  5 4 5 2  5 2 3 2  4 4 2 2  "
            + "4 1 2 1  1 1 3 1  3 1 3 3  3 3 1 1");

    Appendable outputAp = new StringBuilder("    _\n"
        + "   O O\n"
        + "  O O O\n"
        + " O O O O\n"
        + "O O O O O\n"
        + "Score: 14\n"
        + "    O\n"
        + "   _ O\n"
        + "  _ O O\n"
        + " O O O O\n"
        + "O O O O O\n"
        + "Score: 13\n"
        + "    O\n"
        + "   _ O\n"
        + "  O _ _\n"
        + " O O O O\n"
        + "O O O O O\n"
        + "Score: 12\n"
        + "    O\n"
        + "   _ O\n"
        + "  O _ O\n"
        + " O O O _\n"
        + "O O O O _\n"
        + "Score: 11\n"
        + "    O\n"
        + "   _ _\n"
        + "  O _ _\n"
        + " O O O O\n"
        + "O O O O _\n"
        + "Score: 10\n"
        + "    O\n"
        + "   _ _\n"
        + "  O _ O\n"
        + " O O _ O\n"
        + "O O _ O _\n"
        + "Score: 9\n"
        + "    O\n"
        + "   _ _\n"
        + "  O _ O\n"
        + " O O _ O\n"
        + "_ _ O O _\n"
        + "Score: 8\n"
        + "    O\n"
        + "   _ _\n"
        + "  O _ O\n"
        + " O O _ O\n"
        + "_ O _ _ _\n"
        + "Score: 7\n"
        + "    O\n"
        + "   _ _\n"
        + "  O O O\n"
        + " O _ _ O\n"
        + "_ _ _ _ _\n"
        + "Score: 6\n"
        + "    O\n"
        + "   _ O\n"
        + "  O O _\n"
        + " O _ _ _\n"
        + "_ _ _ _ _\n"
        + "Score: 5\n"
        + "    O\n"
        + "   O O\n"
        + "  _ O _\n"
        + " _ _ _ _\n"
        + "_ _ _ _ _\n"
        + "Score: 4\n"
        + "    _\n"
        + "   _ O\n"
        + "  O O _\n"
        + " _ _ _ _\n"
        + "_ _ _ _ _\n"
        + "Score: 3\n"
        + "    _\n"
        + "   _ O\n"
        + "  _ _ O\n"
        + " _ _ _ _\n"
        + "_ _ _ _ _\n"
        + "Score: 2\n"
        + "    O\n"
        + "   _ _\n"
        + "  _ _ _\n"
        + " _ _ _ _\n"
        + "_ _ _ _ _\n"
        + "Score: 1\n"
        + "Game over!\n"
        + "    O\n"
        + "   _ _\n"
        + "  _ _ _\n"
        + " _ _ _ _\n"
        + "_ _ _ _ _\n"
        + "Score: 1\n");

    this.initController = new MarbleSolitaireControllerImpl(input, output);

    this.initController.playGame(model1);

    assertEquals(this.output.toString(), outputAp.toString());
  }

  @Test
  public void gameOverTest() {

    this.input = new StringReader(
        "3 1 1 1  3 3 3 1  5 5 3 3  2 2 4 4  5 3 3 3  5 1 5 3  5 4 5 2  3 3 5 5  4 1 4 3");

    Appendable outputAp = new StringBuilder("    _\n"
        + "   O O\n"
        + "  O O O\n"
        + " O O O O\n"
        + "O O O O O\n"
        + "Score: 14\n"
        + "    O\n"
        + "   _ O\n"
        + "  _ O O\n"
        + " O O O O\n"
        + "O O O O O\n"
        + "Score: 13\n"
        + "    O\n"
        + "   _ O\n"
        + "  O _ _\n"
        + " O O O O\n"
        + "O O O O O\n"
        + "Score: 12\n"
        + "    O\n"
        + "   _ O\n"
        + "  O _ O\n"
        + " O O O _\n"
        + "O O O O _\n"
        + "Score: 11\n"
        + "    O\n"
        + "   _ _\n"
        + "  O _ _\n"
        + " O O O O\n"
        + "O O O O _\n"
        + "Score: 10\n"
        + "    O\n"
        + "   _ _\n"
        + "  O _ O\n"
        + " O O _ O\n"
        + "O O _ O _\n"
        + "Score: 9\n"
        + "    O\n"
        + "   _ _\n"
        + "  O _ O\n"
        + " O O _ O\n"
        + "_ _ O O _\n"
        + "Score: 8\n"
        + "    O\n"
        + "   _ _\n"
        + "  O _ O\n"
        + " O O _ O\n"
        + "_ O _ _ _\n"
        + "Score: 7\n"
        + "    O\n"
        + "   _ _\n"
        + "  O _ _\n"
        + " O O _ _\n"
        + "_ O _ _ O\n"
        + "Score: 6\n"
        + "    O\n"
        + "   _ _\n"
        + "  O _ _\n"
        + " _ _ O _\n"
        + "_ O _ _ O\n"
        + "Score: 5\n"
        + "Game over!\n"
        + "    O\n"
        + "   _ _\n"
        + "  O _ _\n"
        + " _ _ O _\n"
        + "_ O _ _ O\n"
        + "Score: 5\n");

    this.initController = new MarbleSolitaireControllerImpl(input, output);

    this.initController.playGame(model1);

    assertEquals(this.output.toString(), outputAp.toString());
  }


  @Test
  public void reenterValueGameTest() {
    this.input = new StringReader("a + | @ / D ^ . \n q");
    Appendable outputAp = new StringBuilder("    _\n"
        + "   O O\n"
        + "  O O O\n"
        + " O O O O\n"
        + "O O O O O\n"
        + "Score: 14\n"
        + "Please re-enter the value!\n"
        + "Please re-enter the value!\n"
        + "Please re-enter the value!\n"
        + "Please re-enter the value!\n"
        + "Please re-enter the value!\n"
        + "Please re-enter the value!\n"
        + "Please re-enter the value!\n"
        + "Please re-enter the value!\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    _\n"
        + "   O O\n"
        + "  O O O\n"
        + " O O O O\n"
        + "O O O O O\n"
        + "Score: 14\n");

    this.initController = new MarbleSolitaireControllerImpl(input, output);

    this.initController.playGame(model1);

    assertEquals(this.output.toString(), outputAp.toString());
  }


  @Test
  public void spaceAndEnterHasNoEffectGameTest() {
    this.input = new StringReader("     \n      \n q");
    Appendable outputAp = new StringBuilder("    _\n"
        + "   O O\n"
        + "  O O O\n"
        + " O O O O\n"
        + "O O O O O\n"
        + "Score: 14\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    _\n"
        + "   O O\n"
        + "  O O O\n"
        + " O O O O\n"
        + "O O O O O\n"
        + "Score: 14\n");

    this.initController = new MarbleSolitaireControllerImpl(input, output);

    this.initController.playGame(model1);

    assertEquals(this.output.toString(), outputAp.toString());
  }

  @Test
  public void fromPositionInvalidGameTest() {
    this.input = new StringReader("0 0 2 2 q");
    Appendable outputAp = new StringBuilder("    _\n"
        + "   O O\n"
        + "  O O O\n"
        + " O O O O\n"
        + "O O O O O\n"
        + "Score: 14\n"
        + "Invalid move. Play again. The from position is not valid!\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    _\n"
        + "   O O\n"
        + "  O O O\n"
        + " O O O O\n"
        + "O O O O O\n"
        + "Score: 14\n");

    this.initController = new MarbleSolitaireControllerImpl(input, output);

    this.initController.playGame(model1);

    assertEquals(this.output.toString(), outputAp.toString());
  }


  @Test
  public void toPositionInvalidGameTest() {
    this.input = new StringReader("3 3 0 0 q");
    Appendable outputAp = new StringBuilder("    _\n"
        + "   O O\n"
        + "  O O O\n"
        + " O O O O\n"
        + "O O O O O\n"
        + "Score: 14\n"
        + "Invalid move. Play again. The to position is not valid!\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    _\n"
        + "   O O\n"
        + "  O O O\n"
        + " O O O O\n"
        + "O O O O O\n"
        + "Score: 14\n");

    this.initController = new MarbleSolitaireControllerImpl(input, output);

    this.initController.playGame(model1);

    assertEquals(this.output.toString(), outputAp.toString());
  }


  @Test
  public void fromPositionNotMarbleGameTest() {
    this.input = new StringReader("1 1 3 3 q");
    Appendable outputAp = new StringBuilder("    _\n"
        + "   O O\n"
        + "  O O O\n"
        + " O O O O\n"
        + "O O O O O\n"
        + "Score: 14\n"
        + "Invalid move. Play again. The from position is not a marble!\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    _\n"
        + "   O O\n"
        + "  O O O\n"
        + " O O O O\n"
        + "O O O O O\n"
        + "Score: 14\n");

    this.initController = new MarbleSolitaireControllerImpl(input, output);

    this.initController.playGame(model1);

    assertEquals(this.output.toString(), outputAp.toString());
  }


  @Test
  public void toPositionNotEmptyGameTest() {
    this.input = new StringReader("3 3 3 2 q");
    Appendable outputAp = new StringBuilder("    _\n"
        + "   O O\n"
        + "  O O O\n"
        + " O O O O\n"
        + "O O O O O\n"
        + "Score: 14\n"
        + "Invalid move. Play again. The to position is not empty!\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    _\n"
        + "   O O\n"
        + "  O O O\n"
        + " O O O O\n"
        + "O O O O O\n"
        + "Score: 14\n");

    this.initController = new MarbleSolitaireControllerImpl(input, output);

    this.initController.playGame(model1);

    assertEquals(this.output.toString(), outputAp.toString());
  }

  @Test
  public void moveNotTwoPositionsApartGameTest() {
    this.input = new StringReader("3 3 2 2 q");
    Appendable outputAp = new StringBuilder("    O\n"
        + "   O _\n"
        + "  O O O\n"
        + " O O O O\n"
        + "O O O O O\n"
        + "Score: 14\n"
        + "Invalid move. Play again. The move is not exactly two positions apart!\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O\n"
        + "   O _\n"
        + "  O O O\n"
        + " O O O O\n"
        + "O O O O O\n"
        + "Score: 14\n");

    this.initController = new MarbleSolitaireControllerImpl(input, output);

    this.initController.playGame(model2);

    assertEquals(this.output.toString(), outputAp.toString());
  }


  @Test
  public void moveNotTwoPositionsApartGameTest2() {
    this.input = new StringReader("4 4 1 1 q");
    Appendable outputAp = new StringBuilder("    _\n"
        + "   O O\n"
        + "  O O O\n"
        + " O O O O\n"
        + "O O O O O\n"
        + "Score: 14\n"
        + "Invalid move. Play again. The move is not exactly two positions apart!\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    _\n"
        + "   O O\n"
        + "  O O O\n"
        + " O O O O\n"
        + "O O O O O\n"
        + "Score: 14\n");

    this.initController = new MarbleSolitaireControllerImpl(input, output);

    this.initController.playGame(model1);

    assertEquals(this.output.toString(), outputAp.toString());
  }


  @Test
  public void positionInBetweenMoveNotMarbleGameTest() {
    this.input = new StringReader("3 1 5 3  6 4 4 2  4 2 6 4 q");
    Appendable outputAp = new StringBuilder("     O\n"
        + "    O O\n"
        + "   O O O\n"
        + "  O O O O\n"
        + " O O _ O O\n"
        + "O O O O O O\n"
        + "Score: 20\n"
        + "     O\n"
        + "    O O\n"
        + "   _ O O\n"
        + "  O _ O O\n"
        + " O O O O O\n"
        + "O O O O O O\n"
        + "Score: 19\n"
        + "     O\n"
        + "    O O\n"
        + "   _ O O\n"
        + "  O O O O\n"
        + " O O _ O O\n"
        + "O O O _ O O\n"
        + "Score: 18\n"
        + "Invalid move. Play again. The position in between the from and to positions "
        + "does not include a marble!\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "     O\n"
        + "    O O\n"
        + "   _ O O\n"
        + "  O O O O\n"
        + " O O _ O O\n"
        + "O O O _ O O\n"
        + "Score: 18\n");

    this.initController = new MarbleSolitaireControllerImpl(input, output);

    this.initController.playGame(model4);

    assertEquals(this.output.toString(), outputAp.toString());
  }


  @Test
  public void largerModelTest() {
    this.input = new StringReader("2 5 4 5 t 5 a q");
    Appendable outputAp = new StringBuilder("            _\n"
        + "           O O\n"
        + "          O O O\n"
        + "         O O O O\n"
        + "        O O O O O\n"
        + "       O O O O O O\n"
        + "      O O O O O O O\n"
        + "     O O O O O O O O\n"
        + "    O O O O O O O O O\n"
        + "   O O O O O O O O O O\n"
        + "  O O O O O O O O O O O\n"
        + " O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "Score: 90\n"
        + "Invalid move. Play again. The from position is not valid!\n"
        + "Please re-enter the value!\n"
        + "Please re-enter the value!\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "            _\n"
        + "           O O\n"
        + "          O O O\n"
        + "         O O O O\n"
        + "        O O O O O\n"
        + "       O O O O O O\n"
        + "      O O O O O O O\n"
        + "     O O O O O O O O\n"
        + "    O O O O O O O O O\n"
        + "   O O O O O O O O O O\n"
        + "  O O O O O O O O O O O\n"
        + " O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "Score: 90\n");

    this.initController = new MarbleSolitaireControllerImpl(input, output);

    this.initController.playGame(model3);

    assertEquals(this.output.toString(), outputAp.toString());
  }

  @Test
  public void diffSizeAndInitSlotModelTest() {
    this.input = new StringReader("2 5 4 5 f  a q");
    Appendable outputAp = new StringBuilder("     O\n"
        + "    O O\n"
        + "   O O O\n"
        + "  O O O O\n"
        + " O O _ O O\n"
        + "O O O O O O\n"
        + "Score: 20\n"
        + "Invalid move. Play again. The from position is not valid!\n"
        + "Please re-enter the value!\n"
        + "Please re-enter the value!\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "     O\n"
        + "    O O\n"
        + "   O O O\n"
        + "  O O O O\n"
        + " O O _ O O\n"
        + "O O O O O O\n"
        + "Score: 20\n");

    this.initController = new MarbleSolitaireControllerImpl(input, output);

    this.initController.playGame(model4);

    assertEquals(this.output.toString(), outputAp.toString());
  }


}

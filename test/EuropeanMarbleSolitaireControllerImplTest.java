import static org.junit.Assert.assertEquals;

import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModelImpl;
import java.io.StringReader;
import org.junit.Test;

/**
 * In depth tests for the MarbleSolitaireControllerImpl for the European model. Including end
 * cases.
 */
public class EuropeanMarbleSolitaireControllerImplTest {

  Readable input;

  Appendable output = new StringBuilder();

  MarbleSolitaireController initController;

  MarbleSolitaireModel model1 = new EuropeanSolitaireModelImpl();
  MarbleSolitaireModel model2 = new EuropeanSolitaireModelImpl(2, 6);
  MarbleSolitaireModel model3 = new EuropeanSolitaireModelImpl(7);
  MarbleSolitaireModel model4 = new EuropeanSolitaireModelImpl(5, 5, 6);


  // Successful constructor tests for MarbleSolitaireControllerImpl for EuropeanSolitaireModelImpl
  @Test
  public void goodConstructorEuropeanSolitaireControllerImpl() {
    this.input = new StringReader("");
    this.initController = new MarbleSolitaireControllerImpl(input, output);

    this.input = new StringReader("2 4 4 4 q");
    this.initController = new MarbleSolitaireControllerImpl(input, output);

    this.initController.playGame(model1);

    Appendable outputAp = new StringBuilder("    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 36\n"
        + "    O O O\n"
        + "  O O _ O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 35\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "  O O _ O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 35\n");

    assertEquals(this.output.toString(), outputAp.toString());
  }

  // append errors for EuropeanSolitaireModelImpl controller
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
    Appendable outputAp = new StringBuilder("    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 36\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 36\n");

    this.initController = new MarbleSolitaireControllerImpl(input, output);

    this.initController.playGame(model1);

    assertEquals(this.output.toString(), outputAp.toString());
  }

  @Test
  public void quitGameTestFromRow() {
    this.input = new StringReader("q");
    Appendable outputAp = new StringBuilder("    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 36\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 36\n");

    this.initController = new MarbleSolitaireControllerImpl(input, output);

    this.initController.playGame(model1);

    assertEquals(this.output.toString(), outputAp.toString());
  }

  @Test
  public void quitGameTestFromCol() {
    this.input = new StringReader("1 q");
    Appendable outputAp = new StringBuilder("    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 36\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 36\n");

    this.initController = new MarbleSolitaireControllerImpl(input, output);

    this.initController.playGame(model1);

    assertEquals(this.output.toString(), outputAp.toString());
  }

  @Test
  public void quitGameTestToRow() {
    this.input = new StringReader("2 3 Q");
    Appendable outputAp = new StringBuilder("    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 36\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 36\n");

    this.initController = new MarbleSolitaireControllerImpl(input, output);

    this.initController.playGame(model1);

    assertEquals(this.output.toString(), outputAp.toString());
  }

  @Test
  public void quitGameTestToCol() {
    this.input = new StringReader("1 2 1 q");
    Appendable outputAp = new StringBuilder("    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 36\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 36\n");

    this.initController = new MarbleSolitaireControllerImpl(input, output);

    this.initController.playGame(model1);

    assertEquals(this.output.toString(), outputAp.toString());
  }


  @Test
  public void moveDownQuitTest() {

    this.input = new StringReader("2 4 4 4 q");

    Appendable outputAp = new StringBuilder("    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 36\n"
        + "    O O O\n"
        + "  O O _ O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 35\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "  O O _ O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 35\n");

    this.initController = new MarbleSolitaireControllerImpl(input, output);

    this.initController.playGame(model1);

    assertEquals(this.output.toString(), outputAp.toString());
  }

  @Test
  public void moveRightQuitTest() {

    this.input = new StringReader("4 2 4 4 q");

    Appendable outputAp = new StringBuilder("    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 36\n"
        + "    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O _ _ O O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 35\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O _ _ O O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 35\n");

    this.initController = new MarbleSolitaireControllerImpl(input, output);

    this.initController.playGame(model1);

    assertEquals(this.output.toString(), outputAp.toString());
  }

  @Test
  public void moveLeftQuitTest() {

    this.input = new StringReader("4 6 4 4 q");

    Appendable outputAp = new StringBuilder("    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 36\n"
        + "    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O O _ _ O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 35\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O O _ _ O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 35\n");

    this.initController = new MarbleSolitaireControllerImpl(input, output);

    this.initController.playGame(model1);

    assertEquals(this.output.toString(), outputAp.toString());
  }

  @Test
  public void moveUpQuitTest() {

    this.input = new StringReader("6 4 4 4 q");

    Appendable outputAp = new StringBuilder("    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 36\n"
        + "    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "  O O _ O O\n"
        + "    O O O\n"
        + "Score: 35\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "  O O _ O O\n"
        + "    O O O\n"
        + "Score: 35\n");

    this.initController = new MarbleSolitaireControllerImpl(input, output);

    this.initController.playGame(model1);

    assertEquals(this.output.toString(), outputAp.toString());
  }

  @Test
  public void gameWonTest() {

    this.input = new StringReader(
        "3 5 3 7  5 5 3 5  5 7 5 5  4 7 4 5  3 4 3 6  3 7 3 5  1 4 3 4  2 6 2 4 "
            + "4 5 2 5  1 5 3 5  2 3 2 5  2 5 4 5  4 3 2 3  1 3 3 3  4 1 4 3  2 2 4 2  "
            + "3 4 3 2  3 1 3 3 5 2 3 2  5 4 5 2  7 3 5 3  7 4 5 4  6 6 6 4  4 5 6 5  7 5 5 5  "
            + "4 3 6 3  6 3 6 5  6 5 4 5 4 5 4 3  3 3 5 3  6 2 4 2  5 4 5 2  5 1 5 3  3 2 5 2  "
            + "5 3 5 1");

    Appendable outputAp = new StringBuilder("    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O _\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 36\n"
        + "    O O O\n"
        + "  O O O O O\n"
        + "O O O O _ _ O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 35\n"
        + "    O O O\n"
        + "  O O O O O\n"
        + "O O O O O _ O\n"
        + "O O O O _ O O\n"
        + "O O O O _ O O\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 34\n"
        + "    O O O\n"
        + "  O O O O O\n"
        + "O O O O O _ O\n"
        + "O O O O _ O O\n"
        + "O O O O O _ _\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 33\n"
        + "    O O O\n"
        + "  O O O O O\n"
        + "O O O O O _ O\n"
        + "O O O O O _ _\n"
        + "O O O O O _ _\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "    O O O\n"
        + "  O O O O O\n"
        + "O O O _ _ O O\n"
        + "O O O O O _ _\n"
        + "O O O O O _ _\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 31\n"
        + "    O O O\n"
        + "  O O O O O\n"
        + "O O O _ O _ _\n"
        + "O O O O O _ _\n"
        + "O O O O O _ _\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 30\n"
        + "    O _ O\n"
        + "  O O _ O O\n"
        + "O O O O O _ _\n"
        + "O O O O O _ _\n"
        + "O O O O O _ _\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 29\n"
        + "    O _ O\n"
        + "  O O O _ _\n"
        + "O O O O O _ _\n"
        + "O O O O O _ _\n"
        + "O O O O O _ _\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 28\n"
        + "    O _ O\n"
        + "  O O O O _\n"
        + "O O O O _ _ _\n"
        + "O O O O _ _ _\n"
        + "O O O O O _ _\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 27\n"
        + "    O _ _\n"
        + "  O O O _ _\n"
        + "O O O O O _ _\n"
        + "O O O O _ _ _\n"
        + "O O O O O _ _\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 26\n"
        + "    O _ _\n"
        + "  O _ _ O _\n"
        + "O O O O O _ _\n"
        + "O O O O _ _ _\n"
        + "O O O O O _ _\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 25\n"
        + "    O _ _\n"
        + "  O _ _ _ _\n"
        + "O O O O _ _ _\n"
        + "O O O O O _ _\n"
        + "O O O O O _ _\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 24\n"
        + "    O _ _\n"
        + "  O O _ _ _\n"
        + "O O _ O _ _ _\n"
        + "O O _ O O _ _\n"
        + "O O O O O _ _\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 23\n"
        + "    _ _ _\n"
        + "  O _ _ _ _\n"
        + "O O O O _ _ _\n"
        + "O O _ O O _ _\n"
        + "O O O O O _ _\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 22\n"
        + "    _ _ _\n"
        + "  O _ _ _ _\n"
        + "O O O O _ _ _\n"
        + "_ _ O O O _ _\n"
        + "O O O O O _ _\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 21\n"
        + "    _ _ _\n"
        + "  _ _ _ _ _\n"
        + "O _ O O _ _ _\n"
        + "_ O O O O _ _\n"
        + "O O O O O _ _\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 20\n"
        + "    _ _ _\n"
        + "  _ _ _ _ _\n"
        + "O O _ _ _ _ _\n"
        + "_ O O O O _ _\n"
        + "O O O O O _ _\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 19\n"
        + "    _ _ _\n"
        + "  _ _ _ _ _\n"
        + "_ _ O _ _ _ _\n"
        + "_ O O O O _ _\n"
        + "O O O O O _ _\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 18\n"
        + "    _ _ _\n"
        + "  _ _ _ _ _\n"
        + "_ O O _ _ _ _\n"
        + "_ _ O O O _ _\n"
        + "O _ O O O _ _\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 17\n"
        + "    _ _ _\n"
        + "  _ _ _ _ _\n"
        + "_ O O _ _ _ _\n"
        + "_ _ O O O _ _\n"
        + "O O _ _ O _ _\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 16\n"
        + "    _ _ _\n"
        + "  _ _ _ _ _\n"
        + "_ O O _ _ _ _\n"
        + "_ _ O O O _ _\n"
        + "O O O _ O _ _\n"
        + "  O _ O O O\n"
        + "    _ O O\n"
        + "Score: 15\n"
        + "    _ _ _\n"
        + "  _ _ _ _ _\n"
        + "_ O O _ _ _ _\n"
        + "_ _ O O O _ _\n"
        + "O O O O O _ _\n"
        + "  O _ _ O O\n"
        + "    _ _ O\n"
        + "Score: 14\n"
        + "    _ _ _\n"
        + "  _ _ _ _ _\n"
        + "_ O O _ _ _ _\n"
        + "_ _ O O O _ _\n"
        + "O O O O O _ _\n"
        + "  O _ O _ _\n"
        + "    _ _ O\n"
        + "Score: 13\n"
        + "    _ _ _\n"
        + "  _ _ _ _ _\n"
        + "_ O O _ _ _ _\n"
        + "_ _ O O _ _ _\n"
        + "O O O O _ _ _\n"
        + "  O _ O O _\n"
        + "    _ _ O\n"
        + "Score: 12\n"
        + "    _ _ _\n"
        + "  _ _ _ _ _\n"
        + "_ O O _ _ _ _\n"
        + "_ _ O O _ _ _\n"
        + "O O O O O _ _\n"
        + "  O _ O _ _\n"
        + "    _ _ _\n"
        + "Score: 11\n"
        + "    _ _ _\n"
        + "  _ _ _ _ _\n"
        + "_ O O _ _ _ _\n"
        + "_ _ _ O _ _ _\n"
        + "O O _ O O _ _\n"
        + "  O O O _ _\n"
        + "    _ _ _\n"
        + "Score: 10\n"
        + "    _ _ _\n"
        + "  _ _ _ _ _\n"
        + "_ O O _ _ _ _\n"
        + "_ _ _ O _ _ _\n"
        + "O O _ O O _ _\n"
        + "  O _ _ O _\n"
        + "    _ _ _\n"
        + "Score: 9\n"
        + "    _ _ _\n"
        + "  _ _ _ _ _\n"
        + "_ O O _ _ _ _\n"
        + "_ _ _ O O _ _\n"
        + "O O _ O _ _ _\n"
        + "  O _ _ _ _\n"
        + "    _ _ _\n"
        + "Score: 8\n"
        + "    _ _ _\n"
        + "  _ _ _ _ _\n"
        + "_ O O _ _ _ _\n"
        + "_ _ O _ _ _ _\n"
        + "O O _ O _ _ _\n"
        + "  O _ _ _ _\n"
        + "    _ _ _\n"
        + "Score: 7\n"
        + "    _ _ _\n"
        + "  _ _ _ _ _\n"
        + "_ O _ _ _ _ _\n"
        + "_ _ _ _ _ _ _\n"
        + "O O O O _ _ _\n"
        + "  O _ _ _ _\n"
        + "    _ _ _\n"
        + "Score: 6\n"
        + "    _ _ _\n"
        + "  _ _ _ _ _\n"
        + "_ O _ _ _ _ _\n"
        + "_ O _ _ _ _ _\n"
        + "O _ O O _ _ _\n"
        + "  _ _ _ _ _\n"
        + "    _ _ _\n"
        + "Score: 5\n"
        + "    _ _ _\n"
        + "  _ _ _ _ _\n"
        + "_ O _ _ _ _ _\n"
        + "_ O _ _ _ _ _\n"
        + "O O _ _ _ _ _\n"
        + "  _ _ _ _ _\n"
        + "    _ _ _\n"
        + "Score: 4\n"
        + "    _ _ _\n"
        + "  _ _ _ _ _\n"
        + "_ O _ _ _ _ _\n"
        + "_ O _ _ _ _ _\n"
        + "_ _ O _ _ _ _\n"
        + "  _ _ _ _ _\n"
        + "    _ _ _\n"
        + "Score: 3\n"
        + "    _ _ _\n"
        + "  _ _ _ _ _\n"
        + "_ _ _ _ _ _ _\n"
        + "_ _ _ _ _ _ _\n"
        + "_ O O _ _ _ _\n"
        + "  _ _ _ _ _\n"
        + "    _ _ _\n"
        + "Score: 2\n"
        + "    _ _ _\n"
        + "  _ _ _ _ _\n"
        + "_ _ _ _ _ _ _\n"
        + "_ _ _ _ _ _ _\n"
        + "O _ _ _ _ _ _\n"
        + "  _ _ _ _ _\n"
        + "    _ _ _\n"
        + "Score: 1\n"
        + "Game over!\n"
        + "    _ _ _\n"
        + "  _ _ _ _ _\n"
        + "_ _ _ _ _ _ _\n"
        + "_ _ _ _ _ _ _\n"
        + "O _ _ _ _ _ _\n"
        + "  _ _ _ _ _\n"
        + "    _ _ _\n"
        + "Score: 1\n");

    this.initController = new MarbleSolitaireControllerImpl(input, output);

    this.initController.playGame(model2);

    assertEquals(this.output.toString(), outputAp.toString());
  }

  @Test
  public void gameOverTest() {

    this.input = new StringReader(
        "3 5 3 7  5 5 3 5  5 7 5 5  4 7 4 5  3 4 3 6  3 7 3 5  1 4 3 4  2 6 2 4 4 5 2 5  "
            + "1 5 3 5  2 3 2 5  2 5 4 5  4 3 2 3  1 3 3 3  4 1 4 3  2 2 4 2  3 4 3 2  3 1 3 3 "
            + "5 2 3 2  5 4 5 2  7 3 5 3  7 4 5 4  6 2 4 2  4 2 2 2  5 5 3 5  4 3 2 3  5 4 5 2 "
            + " 5 1 5 3  2 2 2 4  6 6 6 4");
    Appendable outputAp = new StringBuilder("    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O _\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 36\n"
        + "    O O O\n"
        + "  O O O O O\n"
        + "O O O O _ _ O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 35\n"
        + "    O O O\n"
        + "  O O O O O\n"
        + "O O O O O _ O\n"
        + "O O O O _ O O\n"
        + "O O O O _ O O\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 34\n"
        + "    O O O\n"
        + "  O O O O O\n"
        + "O O O O O _ O\n"
        + "O O O O _ O O\n"
        + "O O O O O _ _\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 33\n"
        + "    O O O\n"
        + "  O O O O O\n"
        + "O O O O O _ O\n"
        + "O O O O O _ _\n"
        + "O O O O O _ _\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "    O O O\n"
        + "  O O O O O\n"
        + "O O O _ _ O O\n"
        + "O O O O O _ _\n"
        + "O O O O O _ _\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 31\n"
        + "    O O O\n"
        + "  O O O O O\n"
        + "O O O _ O _ _\n"
        + "O O O O O _ _\n"
        + "O O O O O _ _\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 30\n"
        + "    O _ O\n"
        + "  O O _ O O\n"
        + "O O O O O _ _\n"
        + "O O O O O _ _\n"
        + "O O O O O _ _\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 29\n"
        + "    O _ O\n"
        + "  O O O _ _\n"
        + "O O O O O _ _\n"
        + "O O O O O _ _\n"
        + "O O O O O _ _\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 28\n"
        + "    O _ O\n"
        + "  O O O O _\n"
        + "O O O O _ _ _\n"
        + "O O O O _ _ _\n"
        + "O O O O O _ _\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 27\n"
        + "    O _ _\n"
        + "  O O O _ _\n"
        + "O O O O O _ _\n"
        + "O O O O _ _ _\n"
        + "O O O O O _ _\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 26\n"
        + "    O _ _\n"
        + "  O _ _ O _\n"
        + "O O O O O _ _\n"
        + "O O O O _ _ _\n"
        + "O O O O O _ _\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 25\n"
        + "    O _ _\n"
        + "  O _ _ _ _\n"
        + "O O O O _ _ _\n"
        + "O O O O O _ _\n"
        + "O O O O O _ _\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 24\n"
        + "    O _ _\n"
        + "  O O _ _ _\n"
        + "O O _ O _ _ _\n"
        + "O O _ O O _ _\n"
        + "O O O O O _ _\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 23\n"
        + "    _ _ _\n"
        + "  O _ _ _ _\n"
        + "O O O O _ _ _\n"
        + "O O _ O O _ _\n"
        + "O O O O O _ _\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 22\n"
        + "    _ _ _\n"
        + "  O _ _ _ _\n"
        + "O O O O _ _ _\n"
        + "_ _ O O O _ _\n"
        + "O O O O O _ _\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 21\n"
        + "    _ _ _\n"
        + "  _ _ _ _ _\n"
        + "O _ O O _ _ _\n"
        + "_ O O O O _ _\n"
        + "O O O O O _ _\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 20\n"
        + "    _ _ _\n"
        + "  _ _ _ _ _\n"
        + "O O _ _ _ _ _\n"
        + "_ O O O O _ _\n"
        + "O O O O O _ _\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 19\n"
        + "    _ _ _\n"
        + "  _ _ _ _ _\n"
        + "_ _ O _ _ _ _\n"
        + "_ O O O O _ _\n"
        + "O O O O O _ _\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 18\n"
        + "    _ _ _\n"
        + "  _ _ _ _ _\n"
        + "_ O O _ _ _ _\n"
        + "_ _ O O O _ _\n"
        + "O _ O O O _ _\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 17\n"
        + "    _ _ _\n"
        + "  _ _ _ _ _\n"
        + "_ O O _ _ _ _\n"
        + "_ _ O O O _ _\n"
        + "O O _ _ O _ _\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 16\n"
        + "    _ _ _\n"
        + "  _ _ _ _ _\n"
        + "_ O O _ _ _ _\n"
        + "_ _ O O O _ _\n"
        + "O O O _ O _ _\n"
        + "  O _ O O O\n"
        + "    _ O O\n"
        + "Score: 15\n"
        + "    _ _ _\n"
        + "  _ _ _ _ _\n"
        + "_ O O _ _ _ _\n"
        + "_ _ O O O _ _\n"
        + "O O O O O _ _\n"
        + "  O _ _ O O\n"
        + "    _ _ O\n"
        + "Score: 14\n"
        + "    _ _ _\n"
        + "  _ _ _ _ _\n"
        + "_ O O _ _ _ _\n"
        + "_ O O O O _ _\n"
        + "O _ O O O _ _\n"
        + "  _ _ _ O O\n"
        + "    _ _ O\n"
        + "Score: 13\n"
        + "    _ _ _\n"
        + "  O _ _ _ _\n"
        + "_ _ O _ _ _ _\n"
        + "_ _ O O O _ _\n"
        + "O _ O O O _ _\n"
        + "  _ _ _ O O\n"
        + "    _ _ O\n"
        + "Score: 12\n"
        + "    _ _ _\n"
        + "  O _ _ _ _\n"
        + "_ _ O _ O _ _\n"
        + "_ _ O O _ _ _\n"
        + "O _ O O _ _ _\n"
        + "  _ _ _ O O\n"
        + "    _ _ O\n"
        + "Score: 11\n"
        + "    _ _ _\n"
        + "  O O _ _ _\n"
        + "_ _ _ _ O _ _\n"
        + "_ _ _ O _ _ _\n"
        + "O _ O O _ _ _\n"
        + "  _ _ _ O O\n"
        + "    _ _ O\n"
        + "Score: 10\n"
        + "    _ _ _\n"
        + "  O O _ _ _\n"
        + "_ _ _ _ O _ _\n"
        + "_ _ _ O _ _ _\n"
        + "O O _ _ _ _ _\n"
        + "  _ _ _ O O\n"
        + "    _ _ O\n"
        + "Score: 9\n"
        + "    _ _ _\n"
        + "  O O _ _ _\n"
        + "_ _ _ _ O _ _\n"
        + "_ _ _ O _ _ _\n"
        + "_ _ O _ _ _ _\n"
        + "  _ _ _ O O\n"
        + "    _ _ O\n"
        + "Score: 8\n"
        + "    _ _ _\n"
        + "  _ _ O _ _\n"
        + "_ _ _ _ O _ _\n"
        + "_ _ _ O _ _ _\n"
        + "_ _ O _ _ _ _\n"
        + "  _ _ _ O O\n"
        + "    _ _ O\n"
        + "Score: 7\n"
        + "    _ _ _\n"
        + "  _ _ O _ _\n"
        + "_ _ _ _ O _ _\n"
        + "_ _ _ O _ _ _\n"
        + "_ _ O _ _ _ _\n"
        + "  _ _ O _ _\n"
        + "    _ _ O\n"
        + "Score: 6\n"
        + "Game over!\n"
        + "    _ _ _\n"
        + "  _ _ O _ _\n"
        + "_ _ _ _ O _ _\n"
        + "_ _ _ O _ _ _\n"
        + "_ _ O _ _ _ _\n"
        + "  _ _ O _ _\n"
        + "    _ _ O\n"
        + "Score: 6\n");

    this.initController = new MarbleSolitaireControllerImpl(input, output);

    this.initController.playGame(model2);

    assertEquals(this.output.toString(), outputAp.toString());
  }

  @Test
  public void reenterValueGameTest() {
    this.input = new StringReader("a + | @ / D ^ . \n q");
    Appendable outputAp = new StringBuilder("    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 36\n"
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
        + "    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 36\n");

    this.initController = new MarbleSolitaireControllerImpl(input, output);

    this.initController.playGame(model1);

    assertEquals(this.output.toString(), outputAp.toString());
  }


  @Test
  public void spaceAndEnterHasNoEffectGameTest() {
    this.input = new StringReader("     \n      \n q");
    Appendable outputAp = new StringBuilder("    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 36\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 36\n");

    this.initController = new MarbleSolitaireControllerImpl(input, output);

    this.initController.playGame(model1);

    assertEquals(this.output.toString(), outputAp.toString());
  }


  @Test
  public void diagonalMoveTest1() {
    this.input = new StringReader("2 3 4 4 q");
    Appendable outputAp = new StringBuilder("    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 36\n"
        + "Invalid move. Play again. The move cannot be diagonal!\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 36\n");

    this.initController = new MarbleSolitaireControllerImpl(input, output);

    this.initController.playGame(model1);

    assertEquals(this.output.toString(), outputAp.toString());
  }


  @Test
  public void diagonalMoveTest2() {
    this.input = new StringReader("4 2 5 4 q");
    Appendable outputAp = new StringBuilder("    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 36\n"
        + "Invalid move. Play again. The move cannot be diagonal!\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 36\n");

    this.initController = new MarbleSolitaireControllerImpl(input, output);

    this.initController.playGame(model1);

    assertEquals(this.output.toString(), outputAp.toString());
  }

  @Test
  public void fromPositionInvalidGameTest() {
    this.input = new StringReader("1 1 4 1 q");
    Appendable outputAp = new StringBuilder("    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 36\n"
        + "Invalid move. Play again. The from position is not valid!\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 36\n");

    this.initController = new MarbleSolitaireControllerImpl(input, output);

    this.initController.playGame(model1);

    assertEquals(this.output.toString(), outputAp.toString());
  }

  @Test
  public void fromPositionInvalidGameTest2() {
    this.input = new StringReader("-1 -1 -1 4 q");
    Appendable outputAp = new StringBuilder("    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 36\n"
        + "Invalid move. Play again. The from position is not valid!\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 36\n");

    this.initController = new MarbleSolitaireControllerImpl(input, output);

    this.initController.playGame(model1);

    assertEquals(this.output.toString(), outputAp.toString());
  }

  @Test
  public void fromPositionInvalidGameTest3() {
    this.input = new StringReader("5 20 5 7 q");
    Appendable outputAp = new StringBuilder("    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 36\n"
        + "Invalid move. Play again. The from position is not valid!\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 36\n");

    this.initController = new MarbleSolitaireControllerImpl(input, output);

    this.initController.playGame(model1);

    assertEquals(this.output.toString(), outputAp.toString());
  }

  @Test
  public void toPositionInvalidGameTest() {
    this.input = new StringReader("5 7 7 7 q");
    Appendable outputAp = new StringBuilder("    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 36\n"
        + "Invalid move. Play again. The to position is not valid!\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 36\n");

    this.initController = new MarbleSolitaireControllerImpl(input, output);

    this.initController.playGame(model1);

    assertEquals(this.output.toString(), outputAp.toString());
  }

  @Test
  public void toPositionInvalidGameTest2() {
    this.input = new StringReader("5 2 5 0 q");
    Appendable outputAp = new StringBuilder("    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 36\n"
        + "Invalid move. Play again. The to position is not valid!\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 36\n");

    this.initController = new MarbleSolitaireControllerImpl(input, output);

    this.initController.playGame(model1);

    assertEquals(this.output.toString(), outputAp.toString());
  }

  @Test
  public void fromPositionNotMarbleGameTest() {
    this.input = new StringReader("4 4 4 6 q");
    Appendable outputAp = new StringBuilder("    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 36\n"
        + "Invalid move. Play again. The from position is not a marble!\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 36\n");

    this.initController = new MarbleSolitaireControllerImpl(input, output);

    this.initController.playGame(model1);

    assertEquals(this.output.toString(), outputAp.toString());
  }

  @Test
  public void toPositionNotEmptyGameTest() {
    this.input = new StringReader("3 4 5 4 q");
    Appendable outputAp = new StringBuilder("    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 36\n"
        + "Invalid move. Play again. The to position is not empty!\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 36\n");

    this.initController = new MarbleSolitaireControllerImpl(input, output);

    this.initController.playGame(model1);

    assertEquals(this.output.toString(), outputAp.toString());
  }

  @Test
  public void moveNotTwoPositionsApartGameTest() {
    this.input = new StringReader("1 4 4 4 q");
    Appendable outputAp = new StringBuilder("    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 36\n"
        + "Invalid move. Play again. The move is not exactly two positions apart!\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 36\n");

    this.initController = new MarbleSolitaireControllerImpl(input, output);

    this.initController.playGame(model1);

    assertEquals(this.output.toString(), outputAp.toString());
  }

  @Test
  public void positionInBetweenMoveNotMarbleGameTest() {
    this.input = new StringReader("2 4 4 4  1 4 3 4 q");
    Appendable outputAp = new StringBuilder("    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 36\n"
        + "    O O O\n"
        + "  O O _ O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 35\n"
        + "Invalid move. Play again. The position in between the from and to "
        + "positions does not include a marble!\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "  O O _ O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O\n"
        + "Score: 35\n");

    this.initController = new MarbleSolitaireControllerImpl(input, output);

    this.initController.playGame(model1);

    assertEquals(this.output.toString(), outputAp.toString());
  }

  @Test
  public void largerModelTest() {
    this.input = new StringReader("2 5 4 5 t 5 a q");
    Appendable outputAp = new StringBuilder("            O O O O O O O\n"
        + "          O O O O O O O O O\n"
        + "        O O O O O O O O O O O\n"
        + "      O O O O O O O O O O O O O\n"
        + "    O O O O O O O O O O O O O O O\n"
        + "  O O O O O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O O O O O O O\n"
        + "O O O O O O O O O _ O O O O O O O O O\n"
        + "O O O O O O O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O O O O O O O\n"
        + "  O O O O O O O O O O O O O O O O O\n"
        + "    O O O O O O O O O O O O O O O\n"
        + "      O O O O O O O O O O O O O\n"
        + "        O O O O O O O O O O O\n"
        + "          O O O O O O O O O\n"
        + "            O O O O O O O\n"
        + "Score: 276\n"
        + "Invalid move. Play again. The from position is not valid!\n"
        + "Please re-enter the value!\n"
        + "Please re-enter the value!\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "            O O O O O O O\n"
        + "          O O O O O O O O O\n"
        + "        O O O O O O O O O O O\n"
        + "      O O O O O O O O O O O O O\n"
        + "    O O O O O O O O O O O O O O O\n"
        + "  O O O O O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O O O O O O O\n"
        + "O O O O O O O O O _ O O O O O O O O O\n"
        + "O O O O O O O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O O O O O O O\n"
        + "  O O O O O O O O O O O O O O O O O\n"
        + "    O O O O O O O O O O O O O O O\n"
        + "      O O O O O O O O O O O O O\n"
        + "        O O O O O O O O O O O\n"
        + "          O O O O O O O O O\n"
        + "            O O O O O O O\n"
        + "Score: 276\n");

    this.initController = new MarbleSolitaireControllerImpl(input, output);

    this.initController.playGame(model3);

    assertEquals(this.output.toString(), outputAp.toString());
  }

  @Test
  public void diffSizeAndInitSlotModelTest() {
    this.input = new StringReader("2 5 4 5 f  a q");
    Appendable outputAp = new StringBuilder("        O O O O O\n"
        + "      O O O O O O O\n"
        + "    O O O O O O O O O\n"
        + "  O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O O _ O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "  O O O O O O O O O O O\n"
        + "    O O O O O O O O O\n"
        + "      O O O O O O O\n"
        + "        O O O O O\n"
        + "Score: 128\n"
        + "Invalid move. Play again. The to position is not empty!\n"
        + "Please re-enter the value!\n"
        + "Please re-enter the value!\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "        O O O O O\n"
        + "      O O O O O O O\n"
        + "    O O O O O O O O O\n"
        + "  O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O O _ O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "  O O O O O O O O O O O\n"
        + "    O O O O O O O O O\n"
        + "      O O O O O O O\n"
        + "        O O O O O\n"
        + "Score: 128\n");

    this.initController = new MarbleSolitaireControllerImpl(input, output);

    this.initController.playGame(model4);

    assertEquals(this.output.toString(), outputAp.toString());
  }


}

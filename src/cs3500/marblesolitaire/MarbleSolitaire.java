package cs3500.marblesolitaire;

import static java.lang.Integer.parseInt;

import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelImpl;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModelImpl;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModelImpl;
import java.io.InputStreamReader;

/**
 * The class that holds the main method for the MarbleSolitaire game/program. Plays the game with
 * specific models which can be determined by the player. Connects to the model MarbleSolitaireModel
 * interface and the MarbleSolitaireController interface to play the game. If the board size is
 * unspecified, it creates a model with the default size for the chosen shape and initial empty
 * slot. If the initial empty slot is unspecified, it creates a model with the default initial empty
 * slot for the chosen shape and size.The board size and/or initial empty slot is unspecified if the
 * values are not inputted, or the inputted values for them are not integers.
 */
public final class MarbleSolitaire {

  /**
   * The entry point for the program. The program takes inputs as command-line arguments. It
   * determines what model the game program will be played on. The model shape can be called with
   * "english", "european", and "triangular". The size of the model and the initial empty slot can
   * also be inserted.
   *
   * @param args the String arguments in a list form that determines what the player does to play
   *                the game
   */
  public static void main(String[] args) {

    MarbleSolitaireModel model = null;
    String modelStr = "";

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(
        new InputStreamReader(System.in), System.out);

    // sets the model and the modelStr to the according model.
    switch (args[0]) {
      case "english":
        model = new MarbleSolitaireModelImpl();
        modelStr = "english";
        break;
      case "european":
        model = new EuropeanSolitaireModelImpl();
        modelStr = "european";
        break;
      case "triangular":
        model = new TriangleSolitaireModelImpl();
        modelStr = "triangular";
        break;
      default:
        break;
    }

    // depending on the length of the args, build a model and connect it to the controller.
    if (args.length == 1 || args.length == 2) {
      controller.playGame(model);

    } else if (args.length == 3) {
      length3Args(args, model, controller, modelStr);

    } else if (args.length == 4) {
      length4Args(args, model, controller, modelStr);

    } else if (args.length == 5 || args.length == 6) {
      length5Or6Args(args, model, controller, modelStr);
    } else {
      controller.playGame(model);
    }

  }

  /**
   * Determines if the given string is "-size" or not.
   *
   * @param str the given String
   * @return true if the given string is "-size"
   */
  private static boolean nextIsSize(String str) {
    return str.equals("-size");
  }

  /**
   * Depending on the chosen model shape, which is determined by modelStr, checks if the second arg
   * is "-size". If so, it creates a board with the chosen model shape and the given board size. If
   * not, it creates a board with the chosen model shape and the default board size.
   *
   * @param args the inputted args as a list of Strings that determines the solitaire game model
   * @param model the current model of the solitaire game
   * @param controller the controller for the solitaire game
   * @param modelStr the current model of the solitaire game in String form
   */
  private static void length3Args(String[] args, MarbleSolitaireModel model,
      MarbleSolitaireController controller, String modelStr) {

    if (nextIsSize(args[1])) {
      switch (modelStr) {
        case "english":
          try {
            int size = parseInt(args[2]);
            model = new MarbleSolitaireModelImpl(size);
            controller.playGame(model);
          } catch (NumberFormatException e) {
            model = new MarbleSolitaireModelImpl();
            controller.playGame(model);
          }
          break;

        case "european":
          try {
            int size = parseInt(args[2]);
            model = new EuropeanSolitaireModelImpl(size);
            controller.playGame(model);
          } catch (NumberFormatException e) {
            model = new EuropeanSolitaireModelImpl();
            controller.playGame(model);
          }
          break;

        case "triangular":
          try {
            int size = parseInt(args[2]);
            model = new TriangleSolitaireModelImpl(size);
            controller.playGame(model);
          } catch (NumberFormatException e) {
            model = new TriangleSolitaireModelImpl();
            controller.playGame(model);
          }
          break;

        default:
          break;
      }
    } else {
      controller.playGame(model);
    }
  }

  /**
   * Depending on the chosen model shape, which is determined by modelStr, checks if the second arg
   * is "-size". If so, it creates a board with the chosen model shape and the given board size. If
   * not, the second arg must be "-hole". So, it creates a board with the chosen model shape and the
   * given initial empty slot and the default board size.
   *
   * @param args the inputted args as a list of Strings that determines the solitaire game model
   * @param model the current model of the solitaire game
   * @param controller the controller for the solitaire game
   * @param modelStr the current model of the solitaire game in String form
   */
  private static void length4Args(String[] args, MarbleSolitaireModel model,
      MarbleSolitaireController controller, String modelStr) {
    if (nextIsSize(args[1])) {
      switch (modelStr) {
        case "english":
          try {
            int size = parseInt(args[2]);
            model = new MarbleSolitaireModelImpl(size);
            controller.playGame(model);
          } catch (NumberFormatException e) {
            controller.playGame(model);
          }
          break;

        case "european":
          try {
            int size = parseInt(args[2]);
            model = new EuropeanSolitaireModelImpl(size);
            controller.playGame(model);
          } catch (NumberFormatException e) {
            controller.playGame(model);
          }
          break;

        case "triangular":
          try {
            int size = parseInt(args[2]);
            model = new TriangleSolitaireModelImpl(size);
            controller.playGame(model);
          } catch (NumberFormatException e) {
            controller.playGame(model);
          }
          break;

        default:
          break;
      }
    } else {
      switch (modelStr) {
        case "english":
          try {
            int r = parseInt(args[2]) - 1;
            int c = parseInt(args[3]) - 1;
            model = new MarbleSolitaireModelImpl(r, c);
            controller.playGame(model);
          } catch (NumberFormatException e) {
            controller.playGame(model);
          }
          break;

        case "european":
          try {
            int r = parseInt(args[2]) - 1;
            int c = parseInt(args[3]) - 1;
            model = new EuropeanSolitaireModelImpl(r, c);
            controller.playGame(model);
          } catch (NumberFormatException e) {
            controller.playGame(model);
          }
          break;

        case "triangular":
          try {
            int r = parseInt(args[2]) - 1;
            int c = parseInt(args[3]) - 1;
            model = new TriangleSolitaireModelImpl(r, c);
            controller.playGame(model);
          } catch (NumberFormatException e) {
            controller.playGame(model);
          }
          break;

        default:
          break;
      }
    }
  }

  /**
   * Depending on the chosen model shape, which is determined by modelStr, checks if the second arg
   * is "-size". If so, takes the size for the model. Then, if the args length is 6, it must include
   * the initial empty slot positions. So it creates a model with the inputted size and the initial
   * empty slot. If the args length is not 6, creates a board with the chosen model shape and the
   * given board size. If the second arg is not "-size", the second arg must be "-hole". It takes
   * the initial empty slots for the model. Then, if the args length is 6, it must include the board
   * size. So it creates a model with the inputted size and the initial empty slot. If the args
   * length is not 6, creates a board with the chosen model shape and the given initial empty slot.
   *
   * @param args the inputted args as a list of Strings that determines the solitaire game model
   * @param model the current model of the solitaire game
   * @param controller the controller for the solitaire game
   * @param modelStr the current model of the solitaire game in String form
   */
  private static void length5Or6Args(String[] args, MarbleSolitaireModel model,
      MarbleSolitaireController controller, String modelStr) {
    if (nextIsSize(args[1])) {
      switch (modelStr) {
        case "english":
          try {
            int size = parseInt(args[2]);
            model = new MarbleSolitaireModelImpl(size);
            if (args.length == 6) {
              int r = parseInt(args[4]) - 1;
              int c = parseInt(args[5]) - 1;
              model = new MarbleSolitaireModelImpl(size, r, c);
              controller.playGame(model);
            } else {
              controller.playGame(model);
            }
          } catch (NumberFormatException e) {
            controller.playGame(model);
          }
          break;
        case "european":
          try {
            int size = parseInt(args[2]);
            model = new EuropeanSolitaireModelImpl(size);
            if (args.length == 6) {
              int r = parseInt(args[4]) - 1;
              int c = parseInt(args[5]) - 1;
              model = new EuropeanSolitaireModelImpl(size, r, c);
              controller.playGame(model);
            } else {
              controller.playGame(model);
            }
          } catch (NumberFormatException e) {
            controller.playGame(model);
          }
          break;
        case "triangular":
          try {
            int size = parseInt(args[2]);
            model = new TriangleSolitaireModelImpl(size);
            if (args.length == 6) {
              int r = parseInt(args[4]) - 1;
              int c = parseInt(args[5]) - 1;
              model = new TriangleSolitaireModelImpl(size, r, c);
              controller.playGame(model);
            } else {
              controller.playGame(model);
            }
          } catch (NumberFormatException e) {
            controller.playGame(model);
          }
          break;
        default:
          controller.playGame(model);
          break;
      }

    } else {
      switch (modelStr) {
        case "english":
          try {
            int r = parseInt(args[2]) - 1;
            int c = parseInt(args[3]) - 1;
            model = new MarbleSolitaireModelImpl(r, c);
            if (args.length == 6) {
              int size = parseInt(args[5]);
              model = new MarbleSolitaireModelImpl(size, r, c);
              controller.playGame(model);
            } else {
              controller.playGame(model);
            }
          } catch (NumberFormatException e) {
            controller.playGame(model);
          }
          break;
        case "european":
          try {
            int r = parseInt(args[2]) - 1;
            int c = parseInt(args[3]) - 1;
            model = new EuropeanSolitaireModelImpl(r, c);
            if (args.length == 6) {
              int size = parseInt(args[5]);
              model = new EuropeanSolitaireModelImpl(size, r, c);
              controller.playGame(model);
            } else {
              controller.playGame(model);
            }
          } catch (NumberFormatException e) {
            controller.playGame(model);
          }
          break;
        case "triangular":
          try {
            int r = parseInt(args[2]) - 1;
            int c = parseInt(args[3]) - 1;
            model = new TriangleSolitaireModelImpl(r, c);
            if (args.length == 6) {
              int size = parseInt(args[5]);
              model = new TriangleSolitaireModelImpl(size, r, c);
              controller.playGame(model);
            } else {
              controller.playGame(model);
            }
          } catch (NumberFormatException e) {
            controller.playGame(model);
          }
          break;
        default:
          controller.playGame(model);
          break;
      }
    }
  }


}
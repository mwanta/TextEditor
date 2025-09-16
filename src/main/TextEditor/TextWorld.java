package TextEditor;

import javalib.funworld.*;

/**
 * Represents the text editor. Has the ability to type, backspace, and shift
 * down a line. Includes a blue cursor to track current location.
 */
public class TextWorld extends World {
  private final AllText textSpace;
  private final int cursorPos;

  /**
   * A constructor to allow for manipulation of the text within the world
   * and the current cursor position.
   *
   * @param textSpace : the text being displayed in the world.
   * @param cursorPos : the current position of the cursor in the world.
   * @throws IllegalArgumentException if the cursor position is less than 0.
   */
  public TextWorld(AllText textSpace, int cursorPos) {
    this.textSpace = textSpace;

    if (cursorPos < 0) {
      throw new IllegalArgumentException("cursor position must be greater than zero");
    }
    this.cursorPos = cursorPos;
  }


  /**
   * Creates the worldScene for the editor.
   *
   * @return the worldScene with the text overlapped
   */
  public WorldScene makeScene() {
    WorldScene ws = new WorldScene(600,400);

    return ws.placeImageXY(this.textSpace.draw(this.cursorPos), 300, 200);

  }

  /**
   * Returns the typed action from the keyboard and updates the
   * World accordingly.
   *
   * @param key : the key input from the user.
   * @return the World with the updated information.
   */
  public World onKeyEvent(String key) {
    //to handle all single & printable characters (letters, digits, symbols, spaces, etc).
    if (key.length() == 1) {
      return new TextWorld(this.textSpace.type(key, this.cursorPos), this.cursorPos + 1);
    }

    //to handle special key cases
    return switch (key) {
      case "backspace" -> {
        if (this.cursorPos > 0) {
          yield new TextWorld(this.textSpace.backspace(this.cursorPos), this.cursorPos - 1);
        }
        yield this;
      }
      case "left" -> {
        if (this.cursorPos > 0) {
          yield new TextWorld(this.textSpace, cursorPos - 1);
        }
        yield this;
      }
      case "right" -> {
        if (this.cursorPos < this.textSpace.getLength()) {
          yield new TextWorld(this.textSpace, cursorPos + 1);
        }
        yield this;
      }
      default -> this;
    };
  }

  /**
   * Allows the user to click on a letter to move the cursor.
   *
   * @param pos : the position click with the mouse.
   * @return the world with the position of the cursor changed relative to where
   *     the user clicked.
   */
  public World onMouseClicked(Posn pos) {

    //adjusting the x-coordinate of the mouse as the text is centered.
    int textWidth = this.textSpace.getLength() * 12;
    int textXPosn = (600 - textWidth) / 2;

    int relativeMousePosn = pos.x - textXPosn;
    int indexClicked = relativeMousePosn / 12;

    //bounds checking and returning the new world.
    if (indexClicked < 0) {
      return new TextWorld(this.textSpace, 0);
    }
    else {
      if (indexClicked >= this.textSpace.getLength()) {
        return new TextWorld(this.textSpace, this.textSpace.getLength());
      }
      else {
        return new TextWorld(this.textSpace, indexClicked);
      }
    }
  }



}

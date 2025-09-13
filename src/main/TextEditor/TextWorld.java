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
   */
  public TextWorld(AllText textSpace, int cursorPos) {
    this.textSpace = textSpace;
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
    if (key.equals("backspace") && this.cursorPos > 0) {
      return new TextWorld(this.textSpace.backspace(this.cursorPos), this.cursorPos - 1);
    }
    if (key.equals("left") && this.cursorPos > 0) {
      return new TextWorld(this.textSpace, cursorPos - 1);
    }
    else {
      if (key.equals("right") && this.cursorPos < this.textSpace.getLength()) {
        return new TextWorld(this.textSpace, cursorPos + 1);
      }
    }

      return new TextWorld(this.textSpace.type(key, this.cursorPos), this.cursorPos + 1);
    }



}

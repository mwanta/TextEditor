package TextEditor;

import java.awt.Color;
import javalib.worldimages.*;

/**
 * To represent the main body visual text in the editor. Allows for variability of text
 * and visuals.
 */
public class BodyText implements AllText {
  private final String text;


  /**
   * The starting constructor, initializes data to the standard form.
   */
  public BodyText() {
    this.text = "hello";
  }

  /**
   * A constructor to allow for manipulation of text.
   *
   * @param text : the current displayed text.
   */
  public BodyText(String text) {
    this.text = text;


  }

  @Override
  public WorldImage draw(int cursorPos) {
    WorldImage bg = new RectangleImage(300, 200, "solid", Color.pink);

    WorldImage textImage = createTextWithCursor(cursorPos);
    bg = new OverlayImage(textImage, bg);

    return bg;
  }

  /**
   * Highlights the text that the cursor is currently on in blue or displays a
   * blue bar if the cursor is not on text.
   *
   * @param cursorPos : the current position of the cursor
   * @return a WorldImage with the correct character highlighted in regard to cursor position,
   *     or a blue bar displayed if the cursor is one space beyond the text.
   */
  private WorldImage createTextWithCursor(int cursorPos) {
    if (this.text.isEmpty()) {
      return new TextImage("|", 20, Color.blue);
    }

    //draws the blue bar if the cursor is one space beyond the text.
    if (cursorPos >= this.text.length()) {
      WorldImage textImage = new TextImage(this.text, 20, Color.black);
      WorldImage cursorLocation = new TextImage("|", 20, Color.blue);
      return new BesideImage(textImage, cursorLocation);
    }

    WorldImage result = new EmptyImage();
    int charWidth = 12;

    //creates each character of text individually to determine if it should be blue or black
    //depending on if its index matches the cursor position.
    for (int i = 0; i < this.text.length(); i++) {
      String letter = this.text.substring(i, i + 1);
      Color textColor = (i == cursorPos) ? Color.blue : Color.black;

      //to create proper spacing (standard width of 12).
      WorldImage charImg = new TextImage(letter, 20, textColor);
      WorldImage charBox = new RectangleImage(charWidth, 25, "outline", Color.pink);
      WorldImage centeredChar = new OverlayImage(charImg, charBox);

      result = new BesideImage(result, centeredChar);
    }
    return result;
  }



  /**
   * Adds the typed key one space before the cursor.
   *
   * @param key : the typed key.
   * @param cursorPos : the current position of the cursor.
   * @return a new BodyText object with character added to the text before the cursor.
   */
  public BodyText type(String key, int cursorPos) {
    String newText = this.text.substring(0, cursorPos) + key + this.text.substring(cursorPos);
    return new BodyText(newText);
  }

  /**
   * Removes the character one space before the cursor.
   *
   * @param cursorPos : the current position of the cursor.
   * @return a new BodyText object with character removed from the text before the cursor.
   */
  public AllText backspace(int cursorPos) {
    if (this.text.isEmpty() || cursorPos <= 0) {
      return this;
    }

    String newText = text.substring(0, cursorPos - 1) + this.text.substring(cursorPos);
    return new BodyText(newText);
  }

  @Override
  public int getLength() {
    return this.text.length();
  }

  @Override
  public String getText() {
    return this.text;
  }


}

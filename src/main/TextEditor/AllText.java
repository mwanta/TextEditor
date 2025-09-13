package TextEditor;

import javalib.worldimages.WorldImage;

/**
 * Represents the type of text that the text editor can process. These include body,
 * header, and notes.
 */
public interface AllText {

  /**
   * Draws this text onto a background of choice.
   *
   * @param cursorPos : the current position of the cursor.
   * @return the worldImage with this text visual displayed on it.
   */
  WorldImage draw(int cursorPos);

  /**
   * Adds the typed key one space before the cursor.
   *
   * @param key : the typed key.
   * @param cursorPos : the current position of the cursor.
   * @return a new AllText object with character added to the text before the cursor.
   */
  AllText type(String key, int cursorPos);

  /**
   * Removes the character one space before the cursor.
   *
   * @param cursorPos : the current position of the cursor.
   * @return a new AllText object with character removed from the text before the cursor.
   */
  AllText backspace(int cursorPos);

  /**
   * Returns the length of this text.
   *
   * @return the length as an integer of this text.
   */
  int getLength();

  /**
   * Returns the text of this text in the form of a String.
   *
   * @return the String representing this text.
   */
  String getText();
}

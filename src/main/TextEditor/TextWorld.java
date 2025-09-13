package TextEditor;

import javalib.impworld.*;

/**
 * Represents the word processor.
 */
public class TextWorld extends World {
  Header header;


  @Override
  public WorldScene makeScene() {
    WorldScene ws = new WorldScene(600,400);
    return ws.placeImageXY(this.header.draw(), 300, 200);
  }
}

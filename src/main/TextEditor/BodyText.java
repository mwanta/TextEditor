package TextEditor;

import java.awt.Color;
import javalib.funworld.World;
import javalib.worldimages.*;

public class TextSpace {
  private String text;
  private TextImage image;


  public TextSpace() {
    this.text = "hello";
    this.image = new TextImage(this.text, 20, Color.black);

  }

  public TextSpace(String text) {
    this.text = text;
    this.image = new TextImage(this.text, 20, Color.black);

  }

  /**
   * to draw the text
   */
  public WorldImage draw() {
    WorldImage bg = new RectangleImage(300, 200, "solid", Color.pink);
    bg = new OverlayImage(new TextImage(this.text, 20, Color.black), bg);
    return bg;
  }



  //types the given key
  public TextSpace type(String key) {
    return new TextSpace(this.text + key);
  }

}

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import TextEditor.AllText;
import TextEditor.BodyText;
import TextEditor.TextWorld;
import javalib.funworld.WorldScene;
import org.junit.Test;


/**
 * To test methods and constructors for TextWorld.
 * To run the world program of TextWorld.
 */
public class TextWorldTest {

  AllText b1 = new BodyText();
  AllText b2 = new BodyText();

  TextWorld w1 = new TextWorld(this.b1, 2);
  TextWorld w2 = new TextWorld(this.b1, 6);


  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructor() {
    TextWorld w1 = new TextWorld(new BodyText(), -3);
  }

  @Test
  public void testValidConstructor() {
    TextWorld w1 = new TextWorld(new BodyText(), 3);
    TextWorld w2 = new TextWorld(new BodyText(), 50);
  }

  @Test
  public void testGetCursorPos() {
    assertEquals(2, this.w1.getCursorPos());
    assertEquals(6, this.w2.getCursorPos());
  }

  @Test
  public void testMakeScene() {
    WorldScene ws = new WorldScene(600, 400);
    assertEquals(ws.placeImageXY(this.b1.draw(2), 300, 200), w1.makeScene());
    assertEquals(ws.placeImageXY(this.b1.draw(6), 300, 200), w2.makeScene());
  }
  
  // calls big bang to launch the text editor
  @Test
  public void testBigBang() {
    TextWorld world = new TextWorld(new BodyText(), 0);
    int worldWidth = 600;
    int worldHeight = 400;
    double tickRate = .1;
    world.bigBang(worldWidth, worldHeight, tickRate);
  }




}

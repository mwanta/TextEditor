import TextEditor.BodyText;
import TextEditor.TextWorld;
import org.junit.Test;

/**
 * To test and run TextWorld.
 */
public class TextWorldTest {

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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import TextEditor.AllText;
import TextEditor.BodyText;
import TextEditor.TextWorld;
import java.awt.Color;
import javalib.worldimages.RectangleImage;
import javalib.worldimages.WorldImage;
import org.junit.Test;


/**
 * to test methods and constructors in the BodyText class.
 */
public class BodyTextTest {

  AllText b1 = new BodyText();
  AllText b2 = new BodyText("text editor");


  @Test
  public void testValidConstructor() {
    AllText b0 = new BodyText();
    AllText t1 = new BodyText("hello");
    AllText t2 = new BodyText("");
    AllText t3 = new BodyText("hello, welcome to this editor");
  }

  @Test
  public void testType() {

    assertEquals(new BodyText("helllo").getText(),
        this.b1.type("l", 3).getText());
    assertEquals(new BodyText("Mhello").getText(),
        this.b1.type("M", 0).getText());
    assertEquals(new BodyText("hello%").getText(),
        this.b1.type("%", 5).getText());
    assertEquals(new BodyText("text 8editor").getText(),
        this.b2.type("8", 5).getText());
  }

  @Test
  public void testBackspace() {

    assertEquals(new BodyText("helo").getText(),
        this.b1.backspace(3).getText());
    assertEquals(new BodyText("hello").getText(),
        this.b1.backspace(0).getText());
    assertEquals(new BodyText("ello").getText(),
        this.b1.backspace(1).getText());
    assertEquals(new BodyText("hell").getText(),
        this.b1.backspace( 5).getText());
    assertEquals(new BodyText("text edior").getText(),
        this.b2.backspace( 9).getText());
    assertEquals(new BodyText("texteditor").getText(),
        this.b2.backspace( 5).getText());
  }

  @Test
  public void testGetText() {
    assertEquals("hello", this.b1.getText());
    assertEquals("text editor", this.b2.getText());

  }
}

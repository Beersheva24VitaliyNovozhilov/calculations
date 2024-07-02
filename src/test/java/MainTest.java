
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import io.p4r53c.beersheba24.calculations.Main;

import org.junit.After;

public class MainTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testMainMethod() {
        Main.main(new String[] {});
        assertEquals("Hello world!" + System.lineSeparator(), outContent.toString());
    }

    @Test
    public void testPrintGreeting() {
        Main.printGreeting();
        assertEquals("Hello world!" + System.lineSeparator(), outContent.toString());
    }

    @Test
    public void testPrintStringBuilderHellowMessage() {
        String message = Main.printStringBuilderHellowMessage();
        assertEquals("Hello\nTel Ran\nBeersheva24\nCuorse\n", message);
    }
}
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;

import io.p4r53c.beersheba24.calculations.Main;

public class MainTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private Method printGreetingMethod;
    private Method printStringBuilderHellowMessageMethod;
    private Method calculateShortWayByBFSMethod;

    @BeforeEach
    public void setUpStreams() throws Exception {
        System.setOut(new PrintStream(outContent));

        // Reflection to change method accessibility
        printGreetingMethod = Main.class.getDeclaredMethod("printGreeting");
        printGreetingMethod.setAccessible(true);

        printStringBuilderHellowMessageMethod = Main.class.getDeclaredMethod("printStringBuilderHellowMessage");
        printStringBuilderHellowMessageMethod.setAccessible(true);

        calculateShortWayByBFSMethod = Main.class.getDeclaredMethod("calculateShortWayByBFS", int.class, int.class);
        calculateShortWayByBFSMethod.setAccessible(true);
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);

        // Restore method accessibility
        printGreetingMethod.setAccessible(false);
        printStringBuilderHellowMessageMethod.setAccessible(false);
        calculateShortWayByBFSMethod.setAccessible(false);
    }

    @Test
    public void testPrintGreeting() throws Exception {
        printGreetingMethod.invoke(null);
        assertEquals("Hello world!" + System.lineSeparator(), outContent.toString());
    }

    @Test
    public void testPrintStringBuilderHellowMessage() throws Exception {
        String message = (String) printStringBuilderHellowMessageMethod.invoke(null);
        assertEquals("Hello\nTel Ran\nBeersheva24\nCourse\n", message);
    }

    @Test
    public void testCalculateShortWayByBFS() throws Exception {
        calculateShortWayByBFSMethod.invoke(null, 4, 7);
        String expectedOutput = "Shortest path from 4 to 7: [1, 3, 7]";
        assertEquals(expectedOutput, outContent.toString().trim());
    }
}

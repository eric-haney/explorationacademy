package org.theexplorationacademy.game.server;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.*;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for Server.
 */
public class ServerTest
{
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    /**
     * Intercept stdout and stderror for tests
     */
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

    /**
     * Calling main with no arguments should show usage.
     */
    @Test
    public void testServerMainWithNoArgsShowsUsage()
    {
        Server.main(new String[]{});
        assertTrue(0 <= outContent.toString().indexOf("USAGE"));
    }

    /**
     * Calling main with negative integer for first argument shows error
     */
    @Test
    public void testServerMainWithNegativeArgShowsError()
    {
        Server.main(new String[]{ "-5" });
        assertTrue(0 <= outContent.toString().indexOf("ERROR"));
    }
}

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class JunitTestCases {

    private Player playerA;
    private Player playerB;

    // Set up the test environment before each test
    @Before
    public void setUp() {
        // Initialize players with default values
        playerA = new Player(5000, 5, 10, "Player A");
        playerB = new Player(100, 10, 50, "Player B");
    }

    // Test the main method by simulating user input
    @Test
    public void testMain() {
        // Simulated user input
        String input = "5000\n5\n10\n100\n10\n50\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in); // Redirect System.in for user input simulation
        Main.main(new String[] {}); // Run the main method
        System.setIn(System.in); // Reset System.in to its original state
    }

    // Test a scenario where player A wins
    @Test
    public void testPlayerAWin() {
        playerA = new Player(5000, 5, 10, "Player A");
        playerB = new Player(100, 10, 50, "Player B");
        Match match = new Match(playerA, playerB);
        match.start();
        assertTrue(playerA.isAlive()); // Assert that player A is alive
        assertFalse(playerB.isAlive()); // Assert that player B is dead
    }

    // Test a scenario where player B wins
    @Test
    public void testPlayerBWin() {
        playerA = new Player(5, 5, 10, "Player A");
        playerB = new Player(100, 10, 50, "Player B");
        Match match = new Match(playerA, playerB);
        match.start();
        assertTrue(playerB.isAlive()); // Assert that player B is alive
        assertFalse(playerA.isAlive()); // Assert that player A is dead
    }

    // Test a scenario where both players have equal strengths
    @Test
    public void testEqualStrengths() {
        playerA = new Player(100, 10, 5, "Player A");
        playerB = new Player(100, 10, 5, "Player B");
        Match match = new Match(playerA, playerB);
        match.start();
        assertFalse(playerA.isAlive() && playerB.isAlive()); // Both can't be alive
    }

    // Test to check the initial health of player A
    @Test
    public void testPlayerAInitialHealth() {
        assertEquals(5000, playerA.getHealth()); // Assert that player A's initial health is 5000
    }

    // Test to check the initial health of player B
    @Test
    public void testPlayerBInitialHealth() {
        assertEquals(100, playerB.getHealth()); // Assert that player B's initial health is 100
    }
}

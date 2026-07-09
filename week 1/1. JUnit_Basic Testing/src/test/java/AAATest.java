import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

// Exercise 4: Arrange-Act-Assert (AAA) Pattern, Test Fixtures, Setup and Teardown Methods in JUnit
public class AAATest {

    private List<String> testList;

    // Setup method (runs before each test)
    @Before
    public void setUp() {
        // Initialize the test fixture
        testList = new ArrayList<>();
        testList.add("Initial Item");
        System.out.println("Setup completed: testList initialized.");
    }

    // Teardown method (runs after each test)
    @After
    public void tearDown() {
        // Clean up resources
        testList.clear();
        testList = null;
        System.out.println("Teardown completed: testList cleared.");
    }

    @Test
    public void testAddElement() {
        // ----------------------------------------
        // 1. Arrange: Set up the specific conditions
        // ----------------------------------------
        String newItem = "New Item";
        int expectedSize = 2;

        // ----------------------------------------
        // 2. Act: Execute the action being tested
        // ----------------------------------------
        testList.add(newItem);
        int actualSize = testList.size();

        // ----------------------------------------
        // 3. Assert: Verify the outcome
        // ----------------------------------------
        assertEquals("The size of the list should be 2 after adding one item", expectedSize, actualSize);
        assertEquals("The second item should be 'New Item'", newItem, testList.get(1));
    }
}

package src.test.java;

import org.testng.annotations.Test;
import src.main.java.SplitCheck;
import static org.testng.Assert.*;

@Test
public class SplitCheckTest {

	@Test
    public void splitCheck() {
        final String input = 
            "2 = Alice\n" +
            "8 = Bob, Charlie\n" +
            "15 = Alice, Bob, Charlie\n" +
            "1 = Charlie\n";

        SplitCheck splitCheck = new SplitCheck();

        final String output = splitCheck.split(input);
        assertTrue(output.contains("Alice = 7"));
        assertTrue(output.contains("Bob = 9"));
        assertTrue(output.contains("Charlie = 10"));
        
    }

	@Test
	public void inputInvalidWrongValue() {
		final String input = "? = Alice\n" + "1 = Charlie\n";

		SplitCheck splitCheck = new SplitCheck();

		final String output = splitCheck.split(input);
		assertNull(output);
	}

	@Test
	public void inputInvalidMissingName() {
		final String input = "1 = ,\n" + "1 = Charlie\n";

		SplitCheck splitCheck = new SplitCheck();

		final String output = splitCheck.split(input);
		assertNull(output);
	}

	@Test
	public void oneLineInputIndivisibleValue() {
		final String input = "1 = Charlie, Alice\n";

		SplitCheck splitCheck = new SplitCheck();

		final String output = splitCheck.split(input);
		assertEquals(output, "Alice = 1\nCharlie = 1\n");
	}

	@Test
	public void duplicateNames() {
		final String input = "2 = Alice\n" + "8 = Bob, Charlie,Bob ,Bob\n" + "15 = Alice, Bob, Charlie\n"
				+ "1 = Charlie\n";

		SplitCheck splitCheck = new SplitCheck();

		final String output = splitCheck.split(input);
		assertTrue(output.contains("Alice = 7"));
		assertTrue(output.contains("Bob = 9"));
		assertTrue(output.contains("Charlie = 10"));
	}

	@Test
	public void nothingToSplit() {
		final String input = "2 = Alice\n" + "8 = Bob\n" + "1 = Charlie\n";

		SplitCheck splitCheck = new SplitCheck();

		final String output = splitCheck.split(input);
		assertTrue(output.contains("Alice = 2"));
		assertTrue(output.contains("Bob = 8"));
		assertTrue(output.contains("Charlie = 1"));
	}
	@Test
	public void applyDiscountTest() {
		final String input = "1 = Lidiya\n" + "8 = Charlie, Bob\n" + "-2 = Charlie, Lidiya\n";

		SplitCheck splitCheck = new SplitCheck();

		final String output = splitCheck.split(input);
		assertTrue(!output.contains("Lidiya"));
	}

	@Test
	public void nullInputTest() {
		final String input = null;

		SplitCheck splitCheck = new SplitCheck();

		final String output = splitCheck.split(input);
		assertNull(output);
	}

	@Test
	public void incompleteInput() {
		final String input = "2 = ";

		SplitCheck splitCheck = new SplitCheck();

		final String output = splitCheck.split(input);
		assertNull(output);
	}
	
	@Test
	public void nonIntegerInputValues() {
		final String input = "2.5 = Charlie\n";

		SplitCheck splitCheck = new SplitCheck();

		final String output = splitCheck.split(input);
		assertNull(output);
	}

}

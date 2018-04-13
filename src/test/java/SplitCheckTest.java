import org.testng.annotations.Test;
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

}
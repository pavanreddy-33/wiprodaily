import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class Exercise7 {
    @Test
    public void testStringIsUpperCase() {
        String str = "HELLO";
        assertTrue(str.equals(str.toUpperCase()));
    }
}
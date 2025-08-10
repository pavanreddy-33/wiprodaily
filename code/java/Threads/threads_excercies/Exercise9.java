import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class Exercise9 {
    @Test
    public void testAllStringsLowerCase() {
        String[] arr = {"hello", "world"};
        for (String str : arr) {
            assertTrue(str.equals(str.toLowerCase()));
        }
    }
}
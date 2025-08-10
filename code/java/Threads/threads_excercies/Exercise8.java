import static org.junit.Assert.assertThrows;
import org.junit.Test;

public class Exercise8 {
    @Test
    public void testNullStringUpperCase() {
        String str = null;
        assertThrows(NullPointerException.class, () -> {
            str.toUpperCase();
        });
    }
}
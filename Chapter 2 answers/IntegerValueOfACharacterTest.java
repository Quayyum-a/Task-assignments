import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

public class IntegerValueOfACharacterTest {

    @Test
    public void testGetIntegerValueOfACharacter() {
        char actual = 'a';
        int expected = 97;
        assertEquals(expected, IntegerValueOfACharacter.getIntegerValueOfACharacter(actual));
    }
}

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class DuplicateEliminationTest {
    @Test
    public void testThatFunctionExists() {
        DuplicateElimination getElimination = new DuplicateElimination();
        int[] actual = {53, 63, 54, 23, 98, 36, 54, 9, 3, 57};
        int[] expected = {53, 63, 54, 23, 98, 36, -1, 9, 3, 57}; 

        assertArrayEquals(expected, getElimination.eliminate(actual));
    }
}

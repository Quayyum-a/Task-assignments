
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class AddingToArrayTest {

    @Test
    public void testAddingOneToArray() {
        int[] arr = {9,9,9,9};
        int[] expected = {1,0,0,0,0};
        int[] result = AddingToArray.addOne(arr);
        assertArrayEquals(expected, result);                        
    }
    @Test
    public void testAddingOneToArray2() {
        int[] arr = {5, 6, 7};
        int[] expected = {5, 6, 8};
        int[] result = AddingToArray.addOne(arr);
        assertArrayEquals(expected, result);
    }
    @Test
    public void testAddingOneToArray3() {
        int[] arr = {1, 2, 3};
        int[] expected = {1, 2, 4};
        int[] result = AddingToArray.addOne(arr);
        assertArrayEquals(expected, result);
    }
    @Test
    public void testAddingOneToArray4() {
        int[] arr = {1,0,0,9};
        int[] expected = {1,0,1,0};
        int[] result = AddingToArray.addOne(arr);
        assertArrayEquals(expected, result);
    }

}
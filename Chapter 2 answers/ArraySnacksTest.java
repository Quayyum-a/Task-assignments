import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ArraySnacksTest {
    @Test
    public void testThatFunctionFindsTheLargestElement() {
        ArraySnacks getLargest = new ArraySnacks();
        int[] actual = {53, 63, 54, 23, 98, 36, 54, 9, 3, 57};
        int expected = 98;
	
        assertEquals(expected, getLargest.largest(actual));
    }
	 @Test
    public void testThatFunctionReversesList() {
        ArraySnacks getReverse = new ArraySnacks();
        int[] actual = {53, 63, 54, 23, 98, 36, 54, 9, 3, 57};
		  int[] expected = {57, 3, 9, 54, 36, 98, 23, 54, 63, 53};

        assertArrayEquals(expected, getReverse.reverse(actual));
    }
	 @Test
    public void testThatFunctionChecksElement() {
        ArraySnacks getElement = new ArraySnacks();
        int[] actual = {53, 63, 54, 23, 98, 36, 54, 9, 3, 57};
		   boolean expected = true;
			
        assertEquals(expected, getElement.element(actual));
    }
	 @Test
    public void testThatFunctionPrintsEvenPosistionElements() {
        ArraySnacks arraySnacks = new ArraySnacks();
        int[] actual = {53, 63, 54, 23, 98, 36, 54, 9, 3, 57};
		   int[]expected = {53, 54, 98, 54, 3};
			
        assertArrayEquals(expected, arraySnacks.even(actual));
    }
	 @Test
    public void testThatFunctionPrintsOddPosistionElements() {
        ArraySnacks arraySnacks = new ArraySnacks();
        int[] actual = {53, 63, 54, 23, 98, 36, 54, 9, 3, 57};
		   int[]expected = {63, 23, 36, 9, 57};
			
        assertArrayEquals(expected, arraySnacks.odd(actual));
    }
	 @Test
    public void testThatFunctionReturnsRunningTotal() {
        ArraySnacks arraySnacks = new ArraySnacks();
        int[] actual = {53, 63, 54, 23, 98, 36, 54, 9, 3, 57};
		   int expected = 450;
			
        assertEquals(expected, arraySnacks.total(actual));
    }
	 @Test
    public void testThatFunctionReturnsPalindrome() {
        ArraySnacks arraySnacks = new ArraySnacks();
        String actual = "madam";
		   boolean expected = true;
			
        assertEquals(expected, arraySnacks.palindrome(actual));
    }
	 @Test
    public void testThatFunctionReturnsSumUsingForLoop() {
        ArraySnacks arraySnacks = new ArraySnacks();
        int[] actual = {53, 63, 54, 23, 98, 36, 54, 9, 3, 57};
		   int expected = 450;
			
        assertEquals(expected, arraySnacks.sumForLoop(actual));
    }
	 @Test
    public void testThatFunctionReturnsSumUsingWhileLoop() {
        ArraySnacks arraySnacks = new ArraySnacks();
        int[] actual = {53, 63, 54, 23, 98, 36, 54, 9, 3, 57};
		   int expected = 450;
			
        assertEquals(expected, arraySnacks.sumWhileLoop(actual));
    }
	 @Test
    public void testThatFunctionReturnsSumUsingDoWhileLoop() {
        ArraySnacks arraySnacks = new ArraySnacks();
        int[] actual = {53, 63, 54, 23, 98, 36, 54, 9, 3, 57};
		   int expected = 450;
			
        assertEquals(expected, arraySnacks.sumDoWhileLoop(actual));
    }
	 @Test
    public void testThatFunctionReturnsConcatenatedList() {
        ArraySnacks arraySnacks = new ArraySnacks();
        String[] actual = {"a", "b", "c"};
        int[] actual2 = {1, 2, 3};
		  Object[] expected = {"a", "b", "c", 1, 2, 3};
			
        assertArrayEquals(expected, arraySnacks.concatenates(actual, actual2));
    }
	 @Test
    public void testThatFunctionReturnsCombinedList() {
        ArraySnacks arraySnacks = new ArraySnacks();
        String[] actual = {"a", "b", "c"};
        int[] actual2 = {1, 2, 3};
		 Object[] expected = {"a", 1, "b", 2, "c", 3};
			
        assertArrayEquals(expected, arraySnacks.combine(actual, actual2));
    }
	 @Test
    public void testThatFunctionReturnsListOfDigits() {
        ArraySnacks arraySnacks = new ArraySnacks();
        int actual = 2342;
		 int[] expected = {2, 3, 4, 2};
			
        assertArrayEquals(expected, arraySnacks.list(actual));
    }
}

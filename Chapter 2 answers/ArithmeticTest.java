import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ArithmeticTest{

    @Test
    public void testThatArithmeticMethodReturnsSumOFSquare(){
        Arithmetic getSquare = new Arithmetic();
		  	int actual = getSquare.SumOfSquare(2, 5);
		  int expected = 29;
        assertEquals(expected, actual);
    }
	 @Test
    public void testThatArithmeticMethodReturnsDifference(){
        Arithmetic getSquare = new Arithmetic();
		  	int actual = getSquare.DifferenceOfSum(5, 2);
		   int expected = 21;
        assertEquals(expected, actual);
    }
}

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class StatementsTests{
	@Test
	public void testThatTenthElementPrints(){
		Statements getTenth = new Statements();
		int[] actual = {53,63,87,23,98,36,254,909,03,57,35,284,173,4};
		int expected = 57;
      assertEquals(expected,getTenth.tenthValue(actual));
	}
	
	@Test
	public void testThatArrayHasNegativeInteger(){
		Statements getTenth = new Statements();
		int[] actual = {53,63,87,23,98};
		int[] expected = {-1, -1, -1, -1, -1};
      assertArrayEquals(expected,getTenth.negativeArray(actual));
	}
		
	@Test
	public void testThatFunctionReturnsMaximum(){
		Statements getMaximum = new Statements();
		int[] actual = {
    512, 93, 867, 210, 364, 129, 987, 234, 715, 601,
    45, 336, 752, 284, 990, 176, 493, 627, 80, 355,
    432, 901, 247, 384, 66, 529, 738, 412, 307, 158,
    802, 223, 540, 777, 689, 342, 580, 957, 430, 20,
    125, 664, 791, 356, 509, 47, 982, 310, 860, 119,
    411, 275, 613, 887, 95, 305, 746, 170, 293, 822,
    678, 350, 467, 56, 789, 932, 103, 652, 245, 218,
    399, 710, 84, 561, 933, 157, 298, 484, 630, 422,
    790, 145, 367, 258, 500, 794, 612, 902, 175, 287,
    459, 343, 776, 389, 134, 960, 523, 88, 714, 991
};
		int expected = 991;
      assertEquals(expected,getMaximum.getMax(actual));
	}@Test
	public void testThatFunctionReturnsProduct(){
		Statements getProduct = new Statements();
		int[] actual = {
    512, 93, 867, 210, 364, 12, 987, 23, 715, 601,
    45, 336, 752, 284, 990, 17, 493, 627, 80, 355,
    432, 901, 247, 384, 66, 529, 738, 412, 307, 158,
    802, 223, 540, 777, 689, 342, 580, 957, 430, 20,
    125, 664, 791, 356, 509, 47, 982, 310, 860, 119,
    411, 275, 613, 887, 95, 305, 746, 170, 293, 822,
    678, 350, 467, 56, 789, 932, 103, 652, 245, 218,
    399, 710, 84, 561, 933, 157, 298, 484, 630, 422,
    790, 145, 367, 258, 500, 794, 612, 902, 175, 287,
    459, 343, 776, 389, 134, 960, 523, 88, 714, 991
};
		int expected = -1522430048;
      assertEquals(expected,getProduct.compute(actual));
	}
}
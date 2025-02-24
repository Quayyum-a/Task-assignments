import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ExpenseTrackerTest {
    
    @Test
    public void testThatFunctionExist() { 
        ExpenseTracker tracker = new ExpenseTracker();
        String actual = tracker.getHeader("Welcome to Semicolon Expense Tracker App"); 
        String expected = "Welcome to Semicolon Expense Tracker "; 
        
        assertEquals(expected, actual);
    }
}

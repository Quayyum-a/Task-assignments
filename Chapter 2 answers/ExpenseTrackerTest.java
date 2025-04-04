import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

public class ExpenseTrackerTest {
    @Test
    public void testThatFunctionExists() {
        // Removed unused variable tracker
        String actual = ExpenseTracker.getHeader();
        String expected = "Welcome to Semicolon Expense Tracker App";
        assertEquals(expected, actual);
    }

    @Test
    public void testThatFunctionGetsMenu() {
        String actual = ExpenseTracker.getMenu();
        String expected = "\n1. Add an expense\n2. View all expenses\n3. Calculate total expenses\n4. Exit";
        assertEquals(expected, actual);
    }

    @Test
    public void testThatFunctionReturnsChoiceOne() {
        int actual = ExpenseTracker.getChoice(1);
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void testThatFunctionReturnsChoiceInvalid() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ExpenseTracker.getChoice(5);  // Fixed error: passing int instead of string
        });
        assertEquals("Invalid choice. Please enter a number between 1 and 4.", exception.getMessage());
    }

    @Test
    public void testThatFunctionReturnsDate() {
        Scanner scanner = new Scanner("2023-04-12");
        String actual = ExpenseTracker.getDate(scanner);
        String expected = "2023-04-12";
        assertEquals(expected, actual);
    }

    @Test
    public void testThatFunctionReturnsDescription() {
        String actual = ExpenseTracker.getDescription("Buy groceries");
        String expected = "Buy groceries";
        assertEquals(expected, actual);
    }

    @Test
    public void testThatFunctionReturnsAmount() {
        double actual = ExpenseTracker.getAmount(2000.00);
        double expected = 2000.00;
        assertEquals(expected, actual);
    }

    @Test
    public void testThatFunctionViewExpenses() {
        ExpenseTracker.addExpense(new String[]{"2025-02-26", "Groceries", "500.00"});
        ExpenseTracker.addExpense(new String[]{"2025-02-27", "Transport", "200.00"});

        String actual = ExpenseTracker.viewExpenses();
        String expected = "Expenses:\n"
                + "Date: 2025-02-26, Description: Groceries, Amount: ₦500.00\n"
                + "Date: 2025-02-27, Description: Transport, Amount: ₦200.00";
        assertEquals(expected, actual);
    }

    @Test
    public void testThatFunctionCalculateExpenses() {
        ExpenseTracker.addExpense(new String[]{"2025-02-26", "Groceries", "500.00"});
        ExpenseTracker.addExpense(new String[]{"2025-02-27", "Transport", "200.00"});

        float actual = ExpenseTracker.calculateExpenses();
        assertEquals(700.0, actual);
    }

    @Test
    public void testThatFunctionExitApp(){
        String actual = ExpenseTracker.exitApp();
        assertEquals("\nExiting the app. Goodbye!", actual);
    }
}

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MenstrualCycleTest {
    @Test
    public void test_UserEntersValidStartDate() {
        MenstrualCycle cycle = new MenstrualCycle();
        cycle.setStartDate("2022-01-01");
        assertEquals("2022-01-01", cycle.getStartDate());
    }

    @Test
    public void test_UserEntersInvalidDateFormat() {
        MenstrualCycle cycle = new MenstrualCycle();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cycle.setStartDate("02-2020-8");
        });
        assertEquals("Invalid date format. Please use YYYY-MM-DD format.", exception.getMessage());
    }

    @Test
    public void test_UserEntersAverageCycleLength() {
        MenstrualCycle cycle = new MenstrualCycle();
        cycle.setAverageCycleLength(28);
        assertEquals(28, cycle.getAverageCycleLength());
    }
    @Test
    public void test_UserEntersTooShortCycleLength() {
        MenstrualCycle cycle = new MenstrualCycle();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cycle.setAverageCycleLength(20);
        });
        assertEquals("Invalid cycle length. Cycle length must be between 21 and 35 days.", exception.getMessage());
        assertEquals(28, cycle.getAverageCycleLength());
    }

    @Test
    public void test_UserEntersTooLongCycleLength() {
        MenstrualCycle cycle = new MenstrualCycle();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cycle.setAverageCycleLength(36);
        });
        assertEquals("Invalid cycle length. Cycle length must be between 21 and 35 days.", exception.getMessage());
        assertEquals(28, cycle.getAverageCycleLength());
    }

    @Test
    public void test_DefaultCycleLength() {
        MenstrualCycle cycle = new MenstrualCycle();
        assertEquals(28, cycle.getAverageCycleLength());
    }

    @Test
    public void test_UserEntersPeriodDuration() {
        MenstrualCycle cycle = new MenstrualCycle();
        cycle.setPeriodDuration(7);
        assertEquals(7, cycle.getPeriodDuration());
    }

    @Test
    public void test_UserEntersShortPeriodDuration(){
        MenstrualCycle cycle = new MenstrualCycle();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cycle.setPeriodDuration(9);
        });
        assertEquals("Invalid period duration. Period duration must be between 2 and 8 days.", exception.getMessage());
        assertEquals(5, cycle.getPeriodDuration());
    }

    @Test
    public void test_UserEntersLongPeriodDuration(){
        MenstrualCycle cycle = new MenstrualCycle();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cycle.setPeriodDuration(0);
        });
        assertEquals("Invalid period duration. Period duration must be between 2 and 8 days.", exception.getMessage());
        assertEquals(5, cycle.getPeriodDuration());
    }
    @Test
    public void test_DefaultPeriodDuration(){
        MenstrualCycle cycle = new MenstrualCycle();
        assertEquals(5, cycle.getPeriodDuration());
    }

    @Test
    public void test_CalculateNextPeriodDate(){
        MenstrualCycle cycle = new MenstrualCycle();
        cycle.setStartDate("2022-01-01");
        cycle.setAverageCycleLength(28);
        cycle.setPeriodDuration(7);
        assertEquals("2022-01-29", cycle.calculateNextPeriodDate());
    }

    @Test
    public void test_CalculateNextPeriodDateWith35DayCycle() {
        MenstrualCycle cycle = new MenstrualCycle();
        cycle.setStartDate("2022-01-01");
        cycle.setAverageCycleLength(35);
        assertEquals("2022-02-05", cycle.calculateNextPeriodDate());
    }

    @Test
    public void testUsingDefault_CalculationWithShortCycleLength(){
        MenstrualCycle cycle = new MenstrualCycle();
        cycle.setStartDate("2022-01-01");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cycle.setAverageCycleLength(20);
        });
        assertEquals("Invalid cycle length. Cycle length must be between 21 and 35 days.", exception.getMessage());
        cycle.setPeriodDuration(7);
        assertEquals("2022-01-29", cycle.calculateNextPeriodDate());
    }

    @Test
    public void testUsingDefault_CalculationWithLongCycleLength(){
        MenstrualCycle cycle = new MenstrualCycle();
        cycle.setStartDate("2022-01-01");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cycle.setAverageCycleLength(36);
        });
        assertEquals("Invalid cycle length. Cycle length must be between 21 and 35 days.", exception.getMessage());
        cycle.setPeriodDuration(7);
        assertEquals("2022-01-29", cycle.calculateNextPeriodDate());
    }

    @Test
    public void test_CalculateOvulationDate(){
        MenstrualCycle cycle = new MenstrualCycle();
        cycle.setStartDate("2022-01-01");
        cycle.setAverageCycleLength(28);
        assertEquals("2022-01-15", cycle.calculateOvulationDate());
    }

    @Test
    public void test_CalculateOvulationDateWith35DayCycle() {
        MenstrualCycle cycle = new MenstrualCycle();
        cycle.setStartDate("2022-01-01");
        cycle.setAverageCycleLength(35);
        assertEquals("2022-01-22", cycle.calculateOvulationDate());
    }


    @Test
    public void test_ThrowExceptionWithoutStartDate(){
        MenstrualCycle cycle = new MenstrualCycle();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cycle.setStartDate("");
        });
        assertEquals("Date cannot be null or empty", exception.getMessage());
    }

    @Test
    public void test_ThrowExceptionWhenStartDateIsNull(){
        MenstrualCycle cycle = new MenstrualCycle();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cycle.setStartDate(null);
        });
        assertEquals("Date cannot be null or empty", exception.getMessage());
    }

    @Test
    public void test_CalculateNextPeriodWithoutStartDate(){
        MenstrualCycle cycle = new MenstrualCycle();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cycle.setStartDate("");
        });
        assertEquals("Date cannot be null or empty", exception.getMessage());
        Exception exception2 = assertThrows(IllegalStateException.class, () -> {
            cycle.calculateNextPeriodDate();
        });
        assertEquals("Start date must be set first", exception2.getMessage());
    }

    @Test
    public void test_CalculateOvulationWithoutStartDate(){
        MenstrualCycle cycle = new MenstrualCycle();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cycle.setStartDate("");
        });
        assertEquals("Date cannot be null or empty", exception.getMessage());
        Exception exception2 = assertThrows(IllegalStateException.class, () -> {
            cycle.calculateOvulationDate();
        });
        assertEquals("Start date must be set first", exception2.getMessage());
    }

    @Test
    public void test_CalculateFertileWindow(){
        MenstrualCycle cycle = new MenstrualCycle();
        cycle.setStartDate("2022-01-01");
        cycle.setAverageCycleLength(28);
        cycle.setPeriodDuration(7);

        assertEquals("2022-01-11", cycle.calculateFertileWindow());
    }

    @Test
    public void test_CalculateFertileWindowWithoutStartDate(){
        MenstrualCycle cycle = new MenstrualCycle();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cycle.setStartDate(null);
        });
        assertEquals("Date cannot be null or empty", exception.getMessage());
        Exception exception2 = assertThrows(IllegalStateException.class, () -> {
            cycle.calculateFertileWindow();
        });
        assertEquals("Start date must be set first", exception2.getMessage());
    }

}
package daySeven.menstrualWahala;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CycleTrackerTest {
    private CycleTracker tracker;

    @BeforeEach
    public void setup() {
        tracker = new CycleTracker();
        tracker.createCycle("user1", "2022-01-01");
    }

    @Test
    public void testCreateCycle() {
        assertEquals(1, tracker.getUserCount());
        tracker.login("user1");
        assertEquals("2022-01-01", tracker.getStartDate());
    }

    @Test
    public void testLoginInvalidUser() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            tracker.login("user2");
        });
        assertEquals("User ID not found", exception.getMessage());
    }

    @Test
    public void testSetCycleLength() {
        tracker.login("user1");
        tracker.setAverageCycleLength(30);
        assertEquals(30, tracker.getAverageCycleLength());
    }

    @Test
    public void testSetInvalidCycleLength() {
        tracker.login("user1");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            tracker.setAverageCycleLength(20);
        });
        assertEquals("Cycle length must be between 21 and 35 days.", exception.getMessage());
    }

    @Test
    public void testCalculateNextPeriod() {
        tracker.login("user1");
        assertEquals("2022-01-29", tracker.calculateNextPeriodDate());
    }

    @Test
    public void testCalculateOvulation() {
        tracker.login("user1");
        assertEquals("2022-01-15", tracker.calculateOvulationDate());
    }

    @Test
    public void testCalculateFertileWindow() {
        tracker.login("user1");
        assertEquals("2022-01-11", tracker.calculateFertileWindow());
    }

    @Test
    public void testOperationWithoutLogin() {
        tracker.logout();
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            tracker.calculateNextPeriodDate();
        });
        assertEquals("No active cycle selected", exception.getMessage());
    }
}
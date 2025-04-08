package daySeven.menstrualWahala;

import java.util.HashMap;
import java.util.Map;

public class CycleTracker {
    private final Map<String, MenstrualCycle> users = new HashMap<>();
    private MenstrualCycle activeCycle;

    public String createCycle(String userId, String startDate) {
        if (userId == null || userId.trim().isEmpty()) {
            throw new IllegalArgumentException("User ID cannot be null or empty");
        }
        MenstrualCycle cycle = new MenstrualCycle();
        cycle.setStartDate(startDate);
        users.put(userId, cycle);
        activeCycle = cycle;
        return userId;
    }

    public void login(String userId) {
        MenstrualCycle cycle = users.get(userId);
        if (cycle == null) {
            throw new IllegalArgumentException("User ID not found");
        }
        activeCycle = cycle;
    }

    public void logout() {
        activeCycle = null;
    }

    public void setAverageCycleLength(int length) {
        checkActiveCycle();
        activeCycle.setAverageCycleLength(length);
    }

    public void setPeriodDuration(int duration) {
        checkActiveCycle();
        activeCycle.setPeriodDuration(duration);
    }

    public String getStartDate() {
        checkActiveCycle();
        return activeCycle.getStartDate();
    }

    public int getAverageCycleLength() {
        checkActiveCycle();
        return activeCycle.getAverageCycleLength();
    }

    public int getPeriodDuration() {
        checkActiveCycle();
        return activeCycle.getPeriodDuration();
    }

    public String calculateNextPeriodDate() {
        checkActiveCycle();
        return activeCycle.calculateNextPeriodDate();
    }

    public String calculateOvulationDate() {
        checkActiveCycle();
        return activeCycle.calculateOvulationDate();
    }

    public String calculateFertileWindow() {
        checkActiveCycle();
        return activeCycle.calculateFertileWindow();
    }

    public int getUserCount() {
        return users.size();
    }

    private void checkActiveCycle() {
        if (activeCycle == null) {
            throw new IllegalStateException("No active cycle selected");
        }
    }
}
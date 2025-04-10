package daySeven.menstrualWahala;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MenstrualCycle {
    private LocalDate startDate;
    private int averageCycleLength = 28;
    private int periodDuration = 5;
    private final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");


    public void setStartDate(String date) {
        if (date == null || date.trim().isEmpty()) {
            throw new IllegalArgumentException("Date cannot be null or empty");
        }
        try {
            this.startDate = LocalDate.parse(date, DATE_FORMATTER);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid date format. Use YYYY-MM-DD.");
        }
    }

    public String getStartDate() {

        return startDate != null ? startDate.format(DATE_FORMATTER) : null;
    }

    public void setAverageCycleLength(int cycleLength) {
        if (cycleLength < 21 || cycleLength > 35) {
            throw new IllegalArgumentException("Cycle length must be between 21 and 35 days.");
        }
        this.averageCycleLength = cycleLength;
    }

    public int getAverageCycleLength() {
        return averageCycleLength;
    }

    public void setPeriodDuration(int period) {
        if (period < 2 || period > 8) {
            throw new IllegalArgumentException("Period duration must be between 2 and 8 days.");
        }
        this.periodDuration = period;
    }

    public int getPeriodDuration() {
        return periodDuration;
    }

    public String calculateNextPeriodDate() {
        if (startDate == null) {
            throw new IllegalStateException("Start date must be set first");
        }
        return startDate.plusDays(averageCycleLength).format(DATE_FORMATTER);
    }

    public String calculateOvulationDate() {
        if (startDate == null) {
            throw new IllegalStateException("Start date must be set first");
        }
        LocalDate nextPeriod = LocalDate.parse(calculateNextPeriodDate(), DATE_FORMATTER);
        return nextPeriod.plusDays(14).format(DATE_FORMATTER);
    }

    public String calculateFertileWindow() {
        if (startDate == null) {
            throw new IllegalStateException("Start date must be set first");
        }
        LocalDate ovulation = LocalDate.parse(calculateOvulationDate(), DATE_FORMATTER);
        return ovulation.minusDays(4).format(DATE_FORMATTER);
    }
}
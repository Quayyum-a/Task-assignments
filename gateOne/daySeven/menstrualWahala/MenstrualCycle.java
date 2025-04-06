package daySeven.menstrualWahala;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class MenstrualCycle {
    private String startDate;
    private int averageCycleLength = 28;
    private int periodDuration = 5;
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public void setStartDate(String date) throws IllegalArgumentException {
        if (date == null || date.trim().isEmpty()) {
            throw new IllegalArgumentException("Date cannot be null or empty");
        }
        try {
            LocalDate parsedDate = LocalDate.parse(date, DATE_FORMATTER);
            this.startDate = date;
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date format. Please use YYYY-MM-DD format.");
        }
    }

    public String getStartDate() {
        return startDate;
    }

    public void setAverageCycleLength(int cycleLength) throws IllegalArgumentException {
        if (cycleLength < 21 || cycleLength > 35) {
            throw new IllegalArgumentException("Invalid cycle length. Cycle length must be between 21 and 35 days.");
        }
        this.averageCycleLength = cycleLength;
    }

    public int getAverageCycleLength() {
        return averageCycleLength;
    }

    public void setPeriodDuration(int period) throws IllegalArgumentException {
        if (period < 2 || period > 8) {
            throw new IllegalArgumentException("Invalid period duration. Period duration must be between 2 and 8 days.");
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
        LocalDate currentDate = LocalDate.parse(startDate, DATE_FORMATTER);
        return currentDate.plusDays(averageCycleLength).format(DATE_FORMATTER);
    }

    public String calculateOvulationDate() {
        if (startDate == null) {
            throw new IllegalStateException("Start date must be set first");
        }
        LocalDate ovulation = LocalDate.parse(calculateNextPeriodDate(), DATE_FORMATTER);
        return ovulation.minusDays(14).format(DATE_FORMATTER);
    }

    public String calculateFertileWindow() {
        if (startDate == null) {
            throw new IllegalStateException("Start date must be set first");
        }
        LocalDate feterlity = LocalDate.parse(calculateOvulationDate(), DATE_FORMATTER);
        return feterlity.minusDays(4).format(DATE_FORMATTER);
    }
}
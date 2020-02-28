package com.example.project;

import java.time.LocalDate;

public final class DateRange {

    private final LocalDate startedOn;
    private final LocalDate completedOn;

    public DateRange(LocalDate startedOn, LocalDate completedOn) {
        this.startedOn = startedOn;
        this.completedOn = completedOn;
    }

    public LocalDate getStartedOn() {
        return startedOn;
    }

    public LocalDate getCompletedOn() {
        return completedOn;
    }
}

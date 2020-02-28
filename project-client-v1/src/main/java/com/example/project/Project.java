package com.example.project;

import java.time.LocalDate;

public final class Project {

    private final String code;
    private final LocalDate startedOn;
    private final LocalDate completedOn;

    public Project(String code, LocalDate startedOn, LocalDate completedOn) {
        this.code = code;
        this.startedOn = startedOn;
        this.completedOn = completedOn;
    }

    public String getCode() {
        return code;
    }

    public LocalDate getStartedOn() {
        return startedOn;
    }

    public LocalDate getCompletedOn() {
        return completedOn;
    }
}

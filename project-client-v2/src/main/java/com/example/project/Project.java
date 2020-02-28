package com.example.project;

public final class Project {

    private final String code;
    private final DateRange dateRange;

    public Project(String code, DateRange dateRange) {
        this.code = code;
        this.dateRange = dateRange;
    }

    public String getCode() {
        return code;
    }

    public DateRange getDateRange() {
        return dateRange;
    }
}

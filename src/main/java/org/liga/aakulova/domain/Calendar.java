package org.liga.aakulova.domain;

import java.util.List;

public class Calendar {
    private final int year;
    private final List<MonthOfCalendar> months;


    public Calendar(int year, List<MonthOfCalendar> months) {
        this.year = year;
        this.months = months;
    }

    public int getYear() {
        return year;
    }

    public List<MonthOfCalendar> getMonths() {
        return months;
    }
}

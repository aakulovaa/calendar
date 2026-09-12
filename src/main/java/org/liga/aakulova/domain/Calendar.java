package org.liga.aakulova.domain;

import java.util.List;

public class Calendar {
    private final int year;
    private final List<MonthOfCalendar> months;


    public Calendar(int year, List<MonthOfCalendar> months) {
        if (year < 1600) {
            throw new IllegalArgumentException("Год должен быть после 1600");
        }
        if (months == null || months.size()!=12){
            throw new IllegalArgumentException("Год должен содержать 12 месяцев");
        }
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

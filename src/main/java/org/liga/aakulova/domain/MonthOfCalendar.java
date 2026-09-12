package org.liga.aakulova.domain;

public class MonthOfCalendar {
    private final Day day;
    private final Month month;
    private final int countDays;

    public MonthOfCalendar(Day day, Month month, int countDays) {
        this.day = day;
        this.month = month;
        this.countDays = countDays;
    }

    public Day getDay() {
        return day;
    }

    public Month getMonth() {
        return month;
    }

    public int getCountDays() {
        return countDays;
    }
}

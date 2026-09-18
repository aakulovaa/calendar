package org.liga.aakulova.domain;

import java.util.List;

public class Calendar {
    private final int year;
    private final List<MonthOfCalendar> months;


    public Calendar(int year, List<MonthOfCalendar> months) {
        if (months == null || months.size()!=12){
            throw new IllegalArgumentException("Год должен содержать 12 месяцев");
        }
        this.year = year;
        this.months = List.copyOf(months);
    }

    public int getYear() {
        return year;
    }

    public List<MonthOfCalendar> getMonths() {
        return months;
    }

    public MonthOfCalendar getMonth(Month month){
        if (month == null){
            throw new IllegalArgumentException("Месяц не может быть null");
        }

        for (MonthOfCalendar monthOfCalendar : months){
            if (monthOfCalendar.getMonth() == month){
                return monthOfCalendar;
            }
        }

        throw new IllegalArgumentException("Месяц не найден: " + month);
    }

    public int getDaysCount(Month month){
        return getMonth(month).getCountDays();
    }

    public Day getFirstDay(Month month){
        return getMonth(month).getDay();
    }
}

package org.liga.aakulova.service;

import org.liga.aakulova.domain.*;

import java.util.ArrayList;
import java.util.List;

public class CalendarServiceImpl implements CalendarService{

    private final CalendarInterface calendar;

    public CalendarServiceImpl(CalendarInterface calendar) {
        this.calendar = calendar;
    }

    @Override
    public Calendar createCalendar(int year) {
        List<MonthOfCalendar> months = new ArrayList<>();

        for (Month month : Month.values()){
            int countOfDays = calendar.getDaysCount(year, month);
            Day firstDayOfMonth = calendar.getFirstDayOfWeek(year, month);

            months.add(
                    new MonthOfCalendar(firstDayOfMonth, month, countOfDays)
            );
        }
        return new Calendar(year, months);
    }
}

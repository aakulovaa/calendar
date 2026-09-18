package org.liga.aakulova.service;

import org.liga.aakulova.domain.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalendarServiceImpl implements CalendarService{

    private static final int FIRST_YEAR = 1600;
    private static final int GREGORIAN_CYCLE = 400;

    private final CalendarInterface calendar;
    
    private final Map<TypeOfYear, List<MonthOfCalendar>> uniqueCalendars;

    public CalendarServiceImpl(CalendarInterface calendar) {
        this.calendar = calendar;
        this.uniqueCalendars = createUniqueCalendars();
    }

    private Map<TypeOfYear, List<MonthOfCalendar>> createUniqueCalendars() {
        Map<TypeOfYear, List<MonthOfCalendar>> uniqueCalendars = new HashMap<>();

        for(int year = FIRST_YEAR; year < FIRST_YEAR + GREGORIAN_CYCLE; year++){
            TypeOfYear typeOfYear =  getTypeOfYear(year);

            if(uniqueCalendars.containsKey(typeOfYear)){
                continue;
            }

            List<MonthOfCalendar> months = createMonth(year);

            uniqueCalendars.put(typeOfYear, months);
        }
        return  Map.copyOf(uniqueCalendars);
    }

    private List<MonthOfCalendar> createMonth(int year) {
        List<MonthOfCalendar> months = new ArrayList<>();

        for (Month month : Month.values()){
            int countOfDays = calendar.getDaysCount(year, month);
            Day firstDay = calendar.getFirstDayOfWeek(year, month);
            months.add(new MonthOfCalendar(firstDay, month, countOfDays));
        }
        return List.copyOf(months);
    }

    @Override
    public Calendar createCalendar(int year) {
        TypeOfYear typeOfYear = getTypeOfYear(year);
        List<MonthOfCalendar> months = uniqueCalendars.get(typeOfYear);
        return new Calendar(year, months);
    }

    private TypeOfYear getTypeOfYear(int year) {
        Day firstDay = calendar.getFirstDayOfWeek(year, Month.JANUARY);
        int countDaysOfFebruary = calendar.getDaysCount(year, Month.FEBRUARY);

        boolean isLeapYear = countDaysOfFebruary == 29;

        return  new TypeOfYear(firstDay, isLeapYear);
    }

    @Override
    public String getDayOfWeek(int day, int month, int year) {
        return calendar.getDayOfWeek(day,month,year);
    }

    @Override
    public int getUniqueCalendarCount() {
        return uniqueCalendars.size();
    }
}

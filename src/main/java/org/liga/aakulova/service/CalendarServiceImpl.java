package org.liga.aakulova.service;

import org.liga.aakulova.domain.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
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

            List<MonthOfCalendar> months = createMonths(year);

            uniqueCalendars.put(typeOfYear, months);
        }
        return  Map.copyOf(uniqueCalendars);
    }

    private List<MonthOfCalendar> createMonths(int year) {
        List<MonthOfCalendar> months = new ArrayList<>();

        for (Month month : Month.values()){
            months.add(createMonth(year,month));
        }
        return List.copyOf(months);
    }

    private MonthOfCalendar createMonth(int year, Month month) {
        int countOfDays = calendar.getDaysCount(year, month);
        Day firstDay = calendar.getFirstDayOfWeek(year, month);

        return new MonthOfCalendar(firstDay,month,countOfDays);
    }

    @Override
    public Calendar createCalendar(int year) {
        checkCorrectYear(year);

        TypeOfYear typeOfYear = getTypeOfYear(year);
        List<MonthOfCalendar> months = uniqueCalendars.get(typeOfYear);
        return new Calendar(year, months);
    }

    private TypeOfYear getTypeOfYear(int year) {
        Day firstDay = calendar.getFirstDayOfWeek(year, Month.JANUARY);

        boolean isLeapYear = calendar.isLeapYear(year);

        return  new TypeOfYear(firstDay, isLeapYear);
    }

    @Override
    public String getDayOfWeek(int day, int month, int year) {
        checkCorrectYear(year);
        return calendar.getDayOfWeek(day,month,year);
    }

    private void checkCorrectYear(int year){
        if(year < FIRST_YEAR){
            throw new IllegalArgumentException("Год должен быть после 1600!");
        }
    }
}

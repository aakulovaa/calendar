package org.liga.aakulova.infrastructure;

import org.liga.aakulova.domain.Day;
import org.liga.aakulova.domain.Month;
import org.liga.aakulova.domain.MonthOfCalendar;
import org.liga.aakulova.service.CalendarInterface;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.Year;
import java.time.YearMonth;

/**
 * Класс для расчетов построения календаря
 */
@Component
public class CalendarCalculator implements CalendarInterface {

    @Override
    public int getDaysCount(int year, Month month) {
        YearMonth yearMonth = YearMonth.of(year, month.getMonthNumber());

        return yearMonth.lengthOfMonth();
    }

    @Override
    public Day getFirstDayOfWeek(int year, Month month) {
        YearMonth yearMonth = YearMonth.of(year, month.getMonthNumber());
        DayOfWeek dayOfWeek = yearMonth.atDay(1).getDayOfWeek();

        return Day.getDayOfWeekByNumber(dayOfWeek.getValue());
    }

    @Override
    public String getDayOfWeek(int day, int month, int year) {
        Month sealedMonth = Month.getMonthByNumber(month);
        int countOfDays = getDaysCount(year, sealedMonth);

        Day firstDay = getFirstDayOfWeek(year,sealedMonth);
        MonthOfCalendar monthOfCalendar = new MonthOfCalendar(firstDay,sealedMonth,countOfDays);

        int dayNumber = monthOfCalendar.getDayOfWeek(day);

        Day resultDay = Day.getDayOfWeekByNumber(dayNumber);
        return resultDay.getDayName();
    }

    @Override
    public boolean isLeapYear(int year) {
        return Year.of(year).isLeap();
    }
}

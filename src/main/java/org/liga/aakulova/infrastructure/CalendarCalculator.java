package org.liga.aakulova.infrastructure;

import org.liga.aakulova.domain.Day;
import org.liga.aakulova.domain.Month;
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
    public boolean isLeapYear(int year) {
        return Year.of(year).isLeap();
    }
}

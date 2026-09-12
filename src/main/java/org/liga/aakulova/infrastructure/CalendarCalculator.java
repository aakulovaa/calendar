package org.liga.aakulova.infrastructure;

import org.liga.aakulova.domain.CalendarInterface;
import org.liga.aakulova.domain.Day;
import org.liga.aakulova.domain.Month;

import java.time.DayOfWeek;
import java.time.YearMonth;

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

        return Day.values()[dayOfWeek.getValue() - 1];
    }
}

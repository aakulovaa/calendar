package org.liga.aakulova.service;


import org.liga.aakulova.domain.Day;
import org.liga.aakulova.domain.Month;

public interface CalendarInterface {
    int getDaysCount(int year, Month month);

    Day getFirstDayOfWeek(int year, Month month);

    String getDayOfWeek(int day, int month, int year);

    boolean isLeapYear(int year);
}

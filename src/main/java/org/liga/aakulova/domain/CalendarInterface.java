package org.liga.aakulova.domain;


public interface CalendarInterface {
    int getDaysCount(int year, Month month);

    Day getFirstDayOfWeek(int year, Month month);

}

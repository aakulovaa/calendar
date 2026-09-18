package org.liga.aakulova.service;

import org.liga.aakulova.domain.Calendar;

public interface CalendarService {
    Calendar createCalendar(int year);

    String getDayOfWeek(int day, int month, int year);

    int getUniqueCalendarCount();
}

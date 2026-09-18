package org.liga.aakulova.service;

import org.liga.aakulova.domain.Calendar;

/**
 * Сервис для работы с календарем
 */
public interface CalendarService {
    /**
     * Метод создания календаря
     * @param year - год, календарь которого нужно создать
     * @return календарь
     */
    Calendar createCalendar(int year);

    /**
     * Метод для отображения названия дня недели по дате
     * @param day - день
     * @param month - месяц
     * @param year - год
     * @return день недели полученной даты
     */
    String getDayOfWeek(int day, int month, int year);
}

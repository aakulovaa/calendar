package org.liga.aakulova.domain;

import java.util.List;

/**
 * Класс календаря нужного года
 */
public class Calendar {
    private final int year;
    private final List<MonthOfCalendar> months;

    /**
     * Конструктор класса
     * @param year - год календаря
     * @param months - список месяцев нужного года
     */
    public Calendar(int year, List<MonthOfCalendar> months) {
        if (months == null || months.size()!=12){
            throw new IllegalArgumentException("Год должен содержать 12 месяцев");
        }
        this.year = year;
        this.months = List.copyOf(months);
    }

    public int getYear() {
        return year;
    }

    public List<MonthOfCalendar> getMonths() {
        return months;
    }

    /**
     * Метод нахождения месяца в календаре
     * @param month - искомый месяц
     * @return объект месяца календаря
     */
    public MonthOfCalendar getMonth(Month month){
        return months.stream()
                .filter(monthOfCalendar -> monthOfCalendar.getMonth() == month)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Месяц не найден: " + month));
    }
}

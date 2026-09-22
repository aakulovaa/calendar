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

    /**
     * Метод получения первого дня недели в указанном месяце
     * @param month - месяц
     * @return день недели месяца
     */
    public Day getFirstDayOfWeek(Month month){
        return getMonth(month).getDay();
    }

    /**
     * Метод получения дня недели указанного дня в месяце
     * @param day - нужный нам день
     * @param month - нужного месяца
     * @return день недели
     */
    public Day getDayOfWeek(int day, Month month){
        return getMonth(month).getDayOfWeek(day);
    }
}

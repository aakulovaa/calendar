package org.liga.aakulova.service;


import org.liga.aakulova.domain.Day;
import org.liga.aakulova.domain.Month;

/**
 * Интерфейс для расчета календаря
 */
public interface CalendarInterface {
    /**
     * Метод получения количества дней месяца
     * @param year - год
     * @param month - месяц
     * @return количество дней в указанном месяце нужного года
     */
    int getDaysCount(int year, Month month);

    /**
     * Метод получения дня недели для первого дня
     * @param year - год
     * @param month - месяц
     * @return день недели первого дня месяца нужного года
     */
    Day getFirstDayOfWeek(int year, Month month);

    /**
     * Метод получения дня недели для введенной даты
     * @param day - день (число)
     * @param month - месяц
     * @param year - год
     * @return день недели указанной даты
     */
    String getDayOfWeek(int day, int month, int year);

    /**
     * Метод проверки года на високосность
     * @param year - год
     * @return вернет true, если год високосный, false - иначе
     */
    boolean isLeapYear(int year);
}

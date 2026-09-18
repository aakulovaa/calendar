package org.liga.aakulova.domain;

/**
 * Класс, определяющий тип года (високосный/ не високосный) для подсчета уникальных календарей
 * @param day - день недели первого дня года
 * @param isLeapYear - признак високосности года
 */
public record TypeOfYear(
        Day day,
        boolean isLeapYear
) {
}

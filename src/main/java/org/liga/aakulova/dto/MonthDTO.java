package org.liga.aakulova.dto;

import java.util.List;

/**
 * Класс-DTO с информацией о месяце
 * @param monthName - название месяца
 * @param daysByWeeks - разбивка дней по неделям
 */
public record MonthDTO(
        String monthName,
        List<List<String>> daysByWeeks
) {
}

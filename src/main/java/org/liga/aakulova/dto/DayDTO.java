package org.liga.aakulova.dto;

/**
 * Класс-DTO с информацией о дне недели
 * @param date - дата
 * @param dayOfWeek - название дня недели
 */
public record DayDTO(
        String date,
        String dayOfWeek
) {
}

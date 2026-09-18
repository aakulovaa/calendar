package org.liga.aakulova.dto;

import java.util.List;

/**
 * Класс-DTO с информацией о календаре
 * @param year - год календаря
 * @param months - список месяцев
 */
public record CalendarDTO(
        int year,
        List<MonthDTO> months
) {
}

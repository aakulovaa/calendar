package org.liga.aakulova.dto;

import java.util.List;

public record CalendarDTO(
        int year,
        List<MonthDTO> months
) {
}

package org.liga.aakulova.dto;

import java.util.List;

public record MonthDTO(
        String monthName,
        List<List<String>> daysByWeeks
) {
}

package service;

import org.junit.jupiter.api.Test;
import org.liga.aakulova.domain.Calendar;
import org.liga.aakulova.infrastructure.CalendarCalculator;
import org.liga.aakulova.service.CalendarServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Класс для тестирования service/CalendarService
 */
public class CalendarServiceTest {
    private final CalendarServiceImpl service = new CalendarServiceImpl(new CalendarCalculator());

    /**
     * Тест создания календаря
     */
    @Test
    void testCreateCalendar() {
        Calendar calendar = service.createCalendar(2025);

        assertEquals(2025, calendar.getYear());
        assertEquals(12, calendar.getMonths().size());
    }

    /**
     * Тест срабатывания ошибки при year < 1600
     */
    @Test
    void testExceptionCreateCalendarWithUncorrectYear() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> service.createCalendar(1599));
        assertEquals("Год должен быть после 1600!", exception.getMessage());
    }

    /**
     * Тест получения дня недели введенной даты
     */
    @Test
    void testGetDayOfWeek() {
        assertEquals("Пятница", service.getDayOfWeek(25, 9, 2026));
    }
}

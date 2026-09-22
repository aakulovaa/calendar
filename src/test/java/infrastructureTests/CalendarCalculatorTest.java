package infrastructureTests;

import org.junit.jupiter.api.Test;
import org.liga.aakulova.domain.Day;
import org.liga.aakulova.domain.Month;
import org.liga.aakulova.infrastructure.CalendarCalculator;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Класс для тестирования infrastructure/CalendarCalculator
 */
public class CalendarCalculatorTest {
    private final CalendarCalculator calendarCalculator = new CalendarCalculator();

    /**
     * Тест получения количества дней месяца
     */
    @Test
    void testGetDaysCount(){
        assertEquals(31, calendarCalculator.getDaysCount(2026, Month.MAY));
        assertEquals(29, calendarCalculator.getDaysCount(2028, Month.FEBRUARY));
        assertEquals(28, calendarCalculator.getDaysCount(2027, Month.FEBRUARY));
    }

    /**
     * Тест получения дня недели первого дня указанного месяца
     */
    @Test
    void testGetFirstDayOfWeek(){
        assertEquals(Day.FRIDAY, calendarCalculator.getFirstDayOfWeek(2026,Month.MAY));
        assertEquals(Day.TUESDAY, calendarCalculator.getFirstDayOfWeek(2024,Month.OCTOBER));
    }

    /**
     * Тест проверки на високосность
     */
    @Test
    void testIsLeapYear(){
        assertTrue(calendarCalculator.isLeapYear(2028));
        assertFalse(calendarCalculator.isLeapYear(2031));
    }
}

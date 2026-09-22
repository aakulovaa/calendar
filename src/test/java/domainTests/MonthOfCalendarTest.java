package domainTests;

import org.junit.jupiter.api.Test;
import org.liga.aakulova.domain.Day;
import org.liga.aakulova.domain.Month;
import org.liga.aakulova.domain.MonthOfCalendar;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Класс тестирования работы domain/MonthOfCalendar
 */
public class MonthOfCalendarTest {
    /**
     * Тест, проверяющий корректное создание месяца для календаря
     */
    @Test
    void testCreateMonthOfCalendar(){
        MonthOfCalendar monthOfCalendar = new MonthOfCalendar(Day.FRIDAY, Month.APRIL, 30);

        assertEquals(Day.FRIDAY, monthOfCalendar.getDay());
        assertEquals(Month.APRIL, monthOfCalendar.getMonth());
        assertEquals(30, monthOfCalendar.getCountDays());
    }

    /**
     * Тест для проверки срабатывания исключений
     */
    @Test
    void testExceptionForCreateMonthOfCalendar(){
        IllegalArgumentException dayException = assertThrows(IllegalArgumentException.class, ()-> new MonthOfCalendar(null, Month.FEBRUARY, 30));
        assertEquals("Первый день не может быть null!", dayException.getMessage());
        IllegalArgumentException monthException = assertThrows(IllegalArgumentException.class, ()-> new MonthOfCalendar(Day.SUNDAY, null, 31));
        assertEquals("Месяц не может быть null", monthException.getMessage());
        IllegalArgumentException countDaysException = assertThrows(IllegalArgumentException.class, ()-> new MonthOfCalendar(Day.WEDNESDAY, Month.JULY, 40));
        assertEquals("Некорректное количество дней!", countDaysException.getMessage());
    }

    /**
     * Тест проверки корректности вводимого дня
     * true, если соблюдается enterDay >= 1 && enterDay <= countDays
     * false - иначе
     */
    @Test
    void testIsCorrectDay(){
        MonthOfCalendar monthOfCalendar = new MonthOfCalendar(Day.WEDNESDAY, Month.FEBRUARY, 30);

        assertTrue(monthOfCalendar.isCorrectDay(1));
        assertTrue(monthOfCalendar.isCorrectDay(30));

        assertFalse(monthOfCalendar.isCorrectDay(-2));
        assertFalse(monthOfCalendar.isCorrectDay(31));
    }

    /**
     * Тест корректности сопоставления принимаемого
     * дня месяца его дню недели в календаре
     */
    @Test
    void testGetDayOfWeek(){
        MonthOfCalendar monthOfCalendar = new MonthOfCalendar(Day.THURSDAY, Month.JANUARY, 31);

        assertEquals(Day.THURSDAY, monthOfCalendar.getDayOfWeek(1));
        assertEquals(Day.SUNDAY, monthOfCalendar.getDayOfWeek(11));
        assertEquals(Day.FRIDAY, monthOfCalendar.getDayOfWeek(23));
    }

    /**
     * Тест проверки срабатывания исключения при вводе некорректного дня
     */
    @Test
    void testExceptionForIncorrectDayOfMonth(){
        MonthOfCalendar monthOfCalendar = new MonthOfCalendar(Day.THURSDAY, Month.JANUARY, 31);

        assertThrows(IllegalArgumentException.class, ()->monthOfCalendar.getDayOfWeek(34));
        assertThrows(IllegalArgumentException.class, ()->monthOfCalendar.getDayOfWeek(-5));
    }
}

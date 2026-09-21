package domainTests;

import org.junit.jupiter.api.Test;
import org.liga.aakulova.domain.Day;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Класс для тестирования domain/Day
 */
public class DayTest {

    /**
     * Тест, проверяющий корректность работы метода
     * получения дня недели по его порядковому номеру
     */
    @Test
    void testGetDayOfWeekByNumber(){
        assertEquals(Day.FRIDAY, Day.getDayOfWeekByNumber(5));
        assertEquals(Day.TUESDAY, Day.getDayOfWeekByNumber(2));
    }

    /**
     * Тест, проверяющий выбрасывание ошибки
     * при некорректном номере дня недели
     */
    @Test
    void testThrowExceptionForInvalidDayNumber(){
        assertThrows(IllegalArgumentException.class, ()-> Day.getDayOfWeekByNumber(40));
        assertThrows(IllegalArgumentException.class, ()-> Day.getDayOfWeekByNumber(-2));
    }
}

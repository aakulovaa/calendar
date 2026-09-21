package domainTests;

import org.junit.jupiter.api.Test;
import org.liga.aakulova.domain.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Класс для тестирования domain/Month
 */
public class MonthTest {

    /**
     * Тест проверки корректного получения месяца по его порядковому номеру
     */
    @Test
    void testGetMonthByNumber(){
        assertEquals(Month.AUGUST, Month.getMonthByNumber(8));
        assertEquals(Month.DECEMBER, Month.getMonthByNumber(12));
    }

    /**
     * Тест проверки выбрасывания исключения
     * при получении некорректного номера месяца
     */
    @Test
    void testThrowExceptionForInvalidMonthNumber(){
        assertThrows(IllegalArgumentException.class, ()-> Month.getMonthByNumber(40));
        assertThrows(IllegalArgumentException.class, ()-> Month.getMonthByNumber(-11));
        assertThrows(IllegalArgumentException.class, ()-> Month.getMonthByNumber(13));
    }
}

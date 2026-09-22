package domainTests;

import org.junit.jupiter.api.Test;
import org.liga.aakulova.domain.Calendar;
import org.liga.aakulova.domain.Day;
import org.liga.aakulova.domain.Month;
import org.liga.aakulova.domain.MonthOfCalendar;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Класс для тестирования domain/Calendar
 */
public class CalendarTest {

    List<MonthOfCalendar> months = createMonths();

    Calendar calendar = new Calendar(2026, months);

    /**
     * Тест корректного создания календаря
     */
    @Test
    void testCreateCalendar(){
        assertEquals(2026, calendar.getYear());
        assertEquals(12, calendar.getMonths().size());
    }

    /**
     * Тест срабатывания исключения если количество месяцев != 12
     */
    @Test
    void testExceptionCreateCalendar(){
        assertThrows(IllegalArgumentException.class, ()-> new Calendar(2026, List.of()));
    }

    /**
     * Тест получения конкретного месяца из календаря
     */
    @Test
    void testGetMonth(){
        MonthOfCalendar may = calendar.getMonth(Month.MAY);
        assertEquals(Month.MAY, may.getMonth());
    }

    /**
     * Тест выбрасывания ошибки
     */
    @Test
    void testExceptionGetMonth(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()-> calendar.getMonth(null));
        assertEquals("Месяц не найден: " + null, exception.getMessage());
    }

    /**
     * Тест получения дня недели первого дня месяца
     */
    @Test
    void testGetFirstDayOfWeek(){
        assertEquals(Day.TUESDAY, calendar.getFirstDayOfWeek(Month.SEPTEMBER));
        assertEquals(Day.SUNDAY, calendar.getFirstDayOfWeek(Month.MARCH));
    }

    /**
     * Тест получения дня недели указанного дня месяца
     */
    @Test
    void testGetDayOfWeek(){
        assertEquals(Day.WEDNESDAY, calendar.getDayOfWeek(15,Month.APRIL));
        assertEquals(Day.FRIDAY, calendar.getDayOfWeek(20, Month.FEBRUARY));
    }

    /**
     * Метод создания списка месяцев
     * @return список из 12 месяцев
     */
    private List<MonthOfCalendar> createMonths() {
        return List.of(
                new MonthOfCalendar(Day.THURSDAY, Month.JANUARY, 31),
                new MonthOfCalendar(Day.SUNDAY, Month.FEBRUARY, 28),
                new MonthOfCalendar(Day.SUNDAY, Month.MARCH, 31),
                new MonthOfCalendar(Day.WEDNESDAY, Month.APRIL, 30),
                new MonthOfCalendar(Day.FRIDAY, Month.MAY, 31),
                new MonthOfCalendar(Day.MONDAY, Month.JUNE, 30),
                new MonthOfCalendar(Day.WEDNESDAY, Month.JULY, 31),
                new MonthOfCalendar(Day.SATURDAY, Month.AUGUST, 31),
                new MonthOfCalendar(Day.TUESDAY, Month.SEPTEMBER, 30),
                new MonthOfCalendar(Day.THURSDAY, Month.OCTOBER, 31),
                new MonthOfCalendar(Day.SUNDAY, Month.NOVEMBER, 30),
                new MonthOfCalendar(Day.TUESDAY, Month.DECEMBER, 31)
        );
    }

}


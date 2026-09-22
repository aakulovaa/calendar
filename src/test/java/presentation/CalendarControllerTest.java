package presentation;

import org.junit.jupiter.api.Test;
import org.liga.aakulova.CalendarApp;
import org.liga.aakulova.domain.Calendar;
import org.liga.aakulova.domain.Day;
import org.liga.aakulova.domain.Month;
import org.liga.aakulova.domain.MonthOfCalendar;
import org.liga.aakulova.presentation.CalendarController;
import org.liga.aakulova.service.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Класс для тестирования работы с сервером presentation/CalendarController
 */
@WebMvcTest(
        controllers = CalendarController.class
)
@ContextConfiguration(classes = CalendarApp.class)
public class CalendarControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockitoBean
    private CalendarService calendarService;

    /**
     * Тест запроса к серверу для получения календаря нужного года
     * вернет код 200 и данные 12 месяцев
     * @throws Exception
     */
    @Test
    void testGetCalendar() throws Exception {

        Calendar calendar = new Calendar(2026, createMonths());

        when(calendarService.createCalendar(2026)).thenReturn(calendar);

        mockMvc.perform(get("/api/calendar/2026"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.year").value(2026))
                .andExpect(jsonPath("$.months.length()").value(12));
    }

    /**
     * Тест получения дня недели по дате
     * вернет код 200 и день недели
     * @throws Exception
     */
    @Test
    void testGetDayOfWeek() throws Exception {

        when(calendarService.getDayOfWeek(1, 1, 2026)).thenReturn("Четверг");

        mockMvc.perform(
                        get("/api/calendar/day-of-week")
                                .param("day", "1")
                                .param("month", "1")
                                .param("year", "2026")
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.date").value("01/01/2026"))
                .andExpect(jsonPath("$.dayOfWeek").value("Четверг"));
    }

    /**
     * Тест срабатывания исключения
     * @throws Exception
     */
    @Test
    void testExceptionForInvalidData() throws Exception {
        when(calendarService.getDayOfWeek(32, 1, 2026))
                .thenThrow(new IllegalArgumentException("Введен некорректный день!")
        );

        mockMvc.perform(
                        get("/api/calendar/day-of-week")
                                .param("day", "32")
                                .param("month", "1")
                                .param("year", "2026")
                )
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message")
                        .value("Введен некорректный день!"));
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

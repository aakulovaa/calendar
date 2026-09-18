package org.liga.aakulova.presentation;

import org.liga.aakulova.domain.Calendar;
import org.liga.aakulova.domain.Day;
import org.liga.aakulova.domain.MonthOfCalendar;
import org.liga.aakulova.dto.CalendarDTO;
import org.liga.aakulova.dto.DayDTO;
import org.liga.aakulova.dto.MonthDTO;
import org.liga.aakulova.service.CalendarService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * REST-контроллер для работы с календарем
 */
@RestController
@RequestMapping("/api/calendar")
public class CalendarController {
    private final CalendarService calendarService;

    public CalendarController(
            CalendarService calendarService
    ) {
        this.calendarService = calendarService;
    }

    /**
     * Метод для календаря указанного года
     * @param year - получаемый с сервера год
     * @return календарь указанного года
     */
    @GetMapping("/{year}")
    public CalendarDTO getCalendar(
            @PathVariable int year
    ) {

        Calendar calendar =
                calendarService.createCalendar(year);

        List<MonthDTO> months =
                calendar.getMonths()
                        .stream()
                        .map(this::createMonthDTO)
                        .toList();

        return new CalendarDTO(
                year,
                months
        );
    }

    /**
     * Метод для отображения дня недели по дате
     * @param day - день, получаемый с сервера
     * @param month - месяц, получаемый с сервера
     * @param year - год, получаемый с сервера
     * @return день недели полученной даты
     */
    @GetMapping("/day-of-week")
    public DayDTO getDayOfWeek(@RequestParam int day, @RequestParam int month, @RequestParam int year){
        String dayOfWeek = calendarService.getDayOfWeek(day, month, year);

        String date = String.format("%02d/%02d/%04d", day, month, year);
        return new DayDTO(date, dayOfWeek);
    }

    /**
     * Метод для создания месяцев с разбивкой чисел по дням недели
     * @param month - месяц календаря
     * @return DTO месяца
     */
    private MonthDTO createMonthDTO(MonthOfCalendar month) {
        List<List<String>> daysByWeeks = new ArrayList<>();

        List<String> currentWeek = new ArrayList<>();

        Day firstDay = month.getDay();

        int firstDayPosition = firstDay.getDayNumber() - 1;

        for (int i = 0; i < firstDayPosition; i++) {
            currentWeek.add("");
        }
        for (int day = 1; day <= month.getCountDays(); day++) {

            currentWeek.add(
                    String.valueOf(day)
            );

            if (currentWeek.size() == 7) {

                daysByWeeks.add(currentWeek);

                currentWeek =
                        new ArrayList<>();
            }
        }

        while (currentWeek.size() < 7) {
            currentWeek.add("");
        }

        daysByWeeks.add(currentWeek);

        return new MonthDTO(month.getMonth().getMonthName(), daysByWeeks);
    }

}

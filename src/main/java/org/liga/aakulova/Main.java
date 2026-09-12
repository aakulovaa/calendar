package org.liga.aakulova;


import org.liga.aakulova.domain.Calendar;
import org.liga.aakulova.domain.MonthOfCalendar;
import org.liga.aakulova.infrastructure.CalendarCalculator;
import org.liga.aakulova.service.CalendarService;
import org.liga.aakulova.service.CalendarServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CalendarService calendarService = new CalendarServiceImpl(new CalendarCalculator());

        System.out.println("Введите год: ");

        int year = scanner.nextInt();
        
        Calendar calendar = calendarService.createCalendar(year);

        System.out.println("Введенный год: " + calendar.getYear());
        System.out.println("Количество месяцев: " + calendar.getMonths().size());

        System.out.println("Месяца: ");
        for (MonthOfCalendar month : calendar.getMonths()){
            System.out.println(month.getMonth().getMonthName());
        }

    }
}
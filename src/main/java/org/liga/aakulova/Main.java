package org.liga.aakulova;


import org.liga.aakulova.infrastructure.CalendarCalculator;
import org.liga.aakulova.presentation.CalendarDisplay;
import org.liga.aakulova.presentation.CalendarDisplayInterface;
import org.liga.aakulova.service.CalendarService;
import org.liga.aakulova.service.CalendarServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CalendarService calendarService = new CalendarServiceImpl(new CalendarCalculator());
        CalendarDisplayInterface displayCalendar = new CalendarDisplay();

        System.out.println(
                "Количество уникальных календарей: "
                        + calendarService
                        .getUniqueCalendarCount()
        );

        boolean isRunning = true;
        while (isRunning){
            System.out.println();
            System.out.println("1. Вывести календарь введенного года");
            System.out.println("2. Узнать день недели по дате");
            System.out.println("3. Завершить программу");

            int choice = scanner.nextInt();
            int year = 0;
            if (choice == 1 || choice == 2){
                System.out.println("Введите год: ");
                year = scanner.nextInt();
            }

            try {

                switch (choice) {

                    case 1 -> displayCalendar.display(calendarService.createCalendar(year));
                    case 2 -> {
                        System.out.println("Введите день: ");
                        int day = scanner.nextInt();
                        System.out.println("Введите месяц (число от 1 до 12): ");
                        int month = scanner.nextInt();

                        String dayOfWeek = calendarService.getDayOfWeek(day, month, year);
                        System.out.printf("Дате %02d/%02d/%04d соответствует день недели: %s%n", day, month, year, dayOfWeek);
                    }
                    case 3 -> {
                        System.out.println("Программа завершена");
                        isRunning = false;
                    }
                    default -> System.out.println("Некорректная команда!");
                }
            } catch (IllegalArgumentException e){
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
        scanner.close();
    }
}
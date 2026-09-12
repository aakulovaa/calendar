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

        boolean isRunning = true;
        while (isRunning){
            System.out.println("1. Вывести календарь введенного года");
            System.out.println("2. Завершить программу");

            int choice = scanner.nextInt();
            switch (choice){
                case 1 -> {
                    System.out.println("Введите год: ");

                    int year = scanner.nextInt();

                    if (year < 1600){
                        System.out.println("Вводимый год должен быть после 1600!\n");
                        break;
                    }

                    displayCalendar.display(calendarService.createCalendar(year));
                }
                case 2 -> {
                    System.out.println("Программа завершена");
                    isRunning = false;
                }
            }
        }
        scanner.close();
    }
}
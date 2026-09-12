package org.liga.aakulova;


import org.liga.aakulova.domain.Calendar;
import org.liga.aakulova.domain.Day;
import org.liga.aakulova.domain.Month;
import org.liga.aakulova.domain.MonthOfCalendar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите год: ");

        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();

        List<MonthOfCalendar> months = new ArrayList<>();

        for (Month month : Month.values()){
            months.add(
                    new MonthOfCalendar(
                            Day.MONDAY,
                            month,
                            30
                    )
            );
        }

        Calendar calendar = new Calendar(year, months);

        System.out.println("Введенный год: " + calendar.getYear());
        System.out.println("Количество месяцев: " + calendar.getMonths().size());

        System.out.println("Месяца: ");
        for (MonthOfCalendar month : calendar.getMonths()){
            System.out.println(month.getMonth().getMonthName());
        }

    }
}
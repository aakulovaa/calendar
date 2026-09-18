package org.liga.aakulova.presentation;

import org.liga.aakulova.domain.Calendar;
import org.liga.aakulova.domain.Day;
import org.liga.aakulova.domain.Month;

public class CalendarDisplay implements CalendarDisplayInterface{
    @Override
    public void display(Calendar calendar) {
        System.out.println();
        System.out.println("Календарь " + calendar.getYear() + " года: ");

        for (Month month : Month.values()) {
            displayMonth(calendar, month);
        }
    }

    private void displayMonth(Calendar calendar, Month month) {
        int daysCount = calendar.getDaysCount(month);
        Day firstDay = calendar.getFirstDay(month);

        System.out.println();
        System.out.println(month.getMonthName());
        System.out.println("Пн Вт Ср Чт Пт Сб Вс");

        for (int i = 1; i < firstDay.getDayNumber(); i++) {
            System.out.print("   ");
        }

        for (int day = 1; day <= daysCount; day++) {
            System.out.printf("%2d ", day);
            int currentPosition = firstDay.getDayNumber() + day - 1;

            if (currentPosition % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }
}

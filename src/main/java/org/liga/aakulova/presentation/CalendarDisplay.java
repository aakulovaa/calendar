package org.liga.aakulova.presentation;

import org.liga.aakulova.domain.Calendar;
import org.liga.aakulova.domain.MonthOfCalendar;

public class CalendarDisplay implements CalendarDisplayInterface{
    @Override
    public void display(Calendar calendar) {
        System.out.println();
        System.out.println("Календарь " + calendar.getYear() + " года: ");

        for(MonthOfCalendar month : calendar.getMonths()){
            displayMonth(month);
        }
    }

    private void displayMonth(MonthOfCalendar month) {
        System.out.println();
        System.out.println(month.getMonth().getMonthName());
        System.out.println("Пн Вт Ср Чт Пт Сб Вс");

        int firstDay = month.getDay().getDayNumber();

        for (int i = 1; i < firstDay; i++){
            System.out.print("   ");
        }

        for (int day = 1; day <= month.getCountDays(); day++){
            System.out.printf("%2d ", day);
            if((day + firstDay - 1) % 7 == 0){
                System.out.println();
            }
        }
        System.out.println();
    }
}

package org.liga.aakulova.domain;

public class MonthOfCalendar {
    private final Day day;
    private final Month month;
    private final int countDays;

    public MonthOfCalendar(Day day, Month month, int countDays) {
        if (month == null) {
            throw new IllegalArgumentException("Месяц не может быть null");
        }

        if (countDays < 28 || countDays > 31){
            throw new IllegalArgumentException("Некорректное количество дней!");
        }

        if (day == null){
            throw  new IllegalArgumentException("Первый день не может быть null!");
        }

        this.day = day;
        this.month = month;
        this.countDays = countDays;
    }

    public Day getDay() {
        return day;
    }

    public Month getMonth() {
        return month;
    }

    public int getCountDays() {
        return countDays;
    }

    public boolean isCorrectDay(int enterDay){
        return enterDay >= 1 && enterDay <= countDays;
    }

    public int getDayOfWeek(int dayOfMonth){
        if(!isCorrectDay(dayOfMonth)){
            throw new IllegalArgumentException("Введен некорректный день!");
        }

        return (day.getDayNumber() + dayOfMonth - 2) % 7 + 1;
    }
}

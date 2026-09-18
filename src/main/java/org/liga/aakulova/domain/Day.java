package org.liga.aakulova.domain;

public enum Day {
    MONDAY(1, "Понедельник"),
    TUESDAY(2,"Вторник"),
    WEDNESDAY(3,"Среда"),
    THURSDAY(4,"Четверг"),
    FRIDAY(5,"Пятница"),
    SATURDAY(6,"Суббота"),
    SUNDAY(7,"Воскресенье");

    private final int dayNumber;
    private final String dayName;

    Day(int dayNumber, String dayName) {
        this.dayNumber = dayNumber;
        this.dayName = dayName;
    }

    public int getDayNumber() {
        return dayNumber;
    }

    public String getDayName() {
        return dayName;
    }

    public static Day getDayOfWeekByNumber(int dayNumber){
        for(Day day : values()){
            if (day.dayNumber == dayNumber){
                return day;
            }
        }
        throw new IllegalArgumentException("День месяца должен быть корректен!");
    }
}

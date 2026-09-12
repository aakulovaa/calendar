package org.liga.aakulova.domain;

public enum Date {
    MONDAY(1, "Пн"),
    TUESDAY(2,"Вт"),
    WEDNESDAY(3,"Ср"),
    THURSDAY(4,"Чт"),
    FRIDAY(5,"Пт"),
    SATURDAY(6,"Сб"),
    SUNDAY(7,"Вс");

    private final int dayNumber;
    private final String dayName;

    Date(int dayNumber, String dayName) {
        this.dayNumber = dayNumber;
        this.dayName = dayName;
    }

    public int getDayNumber() {
        return dayNumber;
    }

    public String getDayName() {
        return dayName;
    }
}

package org.liga.aakulova.domain;

/**
 * Класс-перечисление дней недели
 */
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

    /**
     * Конструктор класса
     * @param dayNumber - поле, отвечающее за порядковый номер дня недели
     * @param dayName - поле, отвечающее за название дня недели
     */
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

    /**
     * Метод получения дня недели по порядковому номеру дня
     * @param dayNumber - день недели от 1 до 7
     * @return день недели, соответствующий порядковому номеру
     */
    public static Day getDayOfWeekByNumber(int dayNumber){
        for(Day day : values()){
            if (day.dayNumber == dayNumber){
                return day;
            }
        }
        throw new IllegalArgumentException("День месяца должен быть корректен!");
    }
}

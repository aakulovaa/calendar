package org.liga.aakulova.domain;

/**
 * Класс, отвечающий за отображения месяца в календаре
 */
public class MonthOfCalendar {
    private final Day day;
    private final Month month;
    private final int countDays;

    /**
     * Конструктор класса
     * @param day - поле, отвечающее за первый день месяца
     * @param month - поле, отвечающее за месяц года
     * @param countDays - поле, отвечающее за количество дней в месяце
     */
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

    /**
     * Метод, отвечающий за проверку корректности вводимого дня
     * @param enterDay - поле, хранящее день
     * @return true, если день >= 1 и <= количеству дней соответствующего месяца, false - иначе
     */
    public boolean isCorrectDay(int enterDay){
        return enterDay >= 1 && enterDay <= countDays;
    }

    /**
     * Метод, определяющий какому дню недели соответствует первый день месяца
     * @param dayOfMonth - номер дня месяца
     * @return номер дня недели (от 1 до 7)
     */
    public Day getDayOfWeek(int dayOfMonth){
        if(!isCorrectDay(dayOfMonth)){
            throw new IllegalArgumentException("Введен некорректный день!");
        }

        int dayNumber = (day.getDayNumber() + dayOfMonth - 2) % 7 + 1;

        return Day.getDayOfWeekByNumber(dayNumber);
    }
}

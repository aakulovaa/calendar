package org.liga.aakulova.domain;

/**
 * Класс-перечисление месяцев
 */
public enum Month {
    JANUARY (1, "Январь"),
    FEBRUARY (2, "Февраль"),
    MARCH (3, "Март"),
    APRIL (4, "Апрель"),
    MAY (5, "Май"),
    JUNE (6,"Июнь"),
    JULY (7, "Июль"),
    AUGUST (8, "Август"),
    SEPTEMBER (9, "Сентябрь"),
    OCTOBER (10, "Октябрь"),
    NOVEMBER (11, "Ноябрь"),
    DECEMBER (12, "Декабрь");

    private final int monthNumber;
    private final String monthName;


    /**
     * Конструктор класса
     * @param monthNumber - поле, отвечающее за порядковый номер месяца
     * @param monthName - поле, отвечающее за название месяца
     */
    Month(int monthNumber, String monthName) {
        this.monthNumber = monthNumber;
        this.monthName = monthName;
    }

    public int getMonthNumber() {
        return monthNumber;
    }

    public String getMonthName() {
        return monthName;
    }

    /**
     * Метод получения месяца по его порядковому номеру
     * @param monthNumber - порядковый номер месяца
     * @return месяц, соответствующий порядковому месяцу
     */
    public static Month getMonthByNumber(int monthNumber){
        for (Month month : values()){
            if (month.monthNumber == monthNumber){
                return month;
            }
        }

        throw new IllegalArgumentException("Номер месяца должен входить в диапазон от 1 до 12!");
    }
}

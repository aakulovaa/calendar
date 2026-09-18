package org.liga.aakulova;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Класс, отвечающий за запуск сервера
 */
@SpringBootApplication
public class CalendarApp {
    public static void main(String[] args){
        SpringApplication.run(CalendarApp.class, args);
    }
}

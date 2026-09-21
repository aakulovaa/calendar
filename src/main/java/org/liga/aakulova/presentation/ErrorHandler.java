package org.liga.aakulova.presentation;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

/**
 * Класс, отвечающий за обработку исключений и вывод их на сервер
 */
@RestControllerAdvice
public class ErrorHandler {
    /**
     * Метод, обрабатывающий ошибки данных (IllegalArgumentException)
     * @param exception вызываемое исключение
     * @return текст ошибки
     */
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleIllegalArgumentException(
            IllegalArgumentException exception
    ) {

        return Map.of(
                "message",
                exception.getMessage()
        );
    }

    /**
     * Метод обработки исключений
     * @param exception - другие исключения
     * @return текст ошибки, общий для такого поведения
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, String> handleException(
            Exception exception
    ) {

        return Map.of(
                "message",
                "Ошибка!"
        );
    }
}

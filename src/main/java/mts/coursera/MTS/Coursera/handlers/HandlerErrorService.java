package mts.coursera.MTS.Coursera.handlers;

import mts.coursera.MTS.Coursera.dto.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

/**
 * Глобальный обработчик ошибок REST
 *
 * @author Dmitry Stepanov, user Dmitry
 * @since 09.02.2024
 */
@RestControllerAdvice
public class HandlerErrorService {
    @ExceptionHandler(value = {NoSuchElementException.class})
    public ResponseEntity<ApiError> noSuchElementExceptionHandler(Exception ex) {
        return new ResponseEntity<>(
                new ApiError("Course not found GLOBAL", ex.getMessage(), ex.getClass().toString()),
                HttpStatus.NOT_FOUND
        );
    }
}

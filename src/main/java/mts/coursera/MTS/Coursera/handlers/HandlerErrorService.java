package mts.coursera.MTS.Coursera.handlers;

import lombok.extern.slf4j.Slf4j;
import mts.coursera.MTS.Coursera.dto.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.NoSuchElementException;

/**
 * Глобальный обработчик ошибок REST
 *
 * @author Dmitry Stepanov, user Dmitry
 * @since 09.02.2024
 */
@ControllerAdvice
@Slf4j
public class HandlerErrorService {
    @ExceptionHandler
    public ResponseEntity<ApiError> noSuchElementExceptionHandler(NoSuchElementException ex) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        ex.printStackTrace(writer);
        log.error(stringWriter.toString());
        return new ResponseEntity<>(
                new ApiError(ex.getMessage(), ex.getClass().toString()),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler
    public ResponseEntity<ApiError[]> handlerValidator(MethodArgumentNotValidException ex) {
        ApiError[] array = ex.getFieldErrors().stream()
                .map(f -> new ApiError(f.getDefaultMessage(), f.getField()))
                .toArray(ApiError[]::new);
        return new ResponseEntity<>(array, HttpStatus.BAD_REQUEST);
    }
}

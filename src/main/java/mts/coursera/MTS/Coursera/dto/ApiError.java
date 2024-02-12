package mts.coursera.MTS.Coursera.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

/**
 * DTO модель для отображения деталей исключения.
 *
 * @author Dmitry Stepanov, user Dmitry
 * @since 09.02.2024
 */
@NoArgsConstructor
@Getter
@Setter
public class ApiError {
    private OffsetDateTime dateOccurred = OffsetDateTime.now();
    private String message;
    private String type;
    public ApiError(String message, String type) {
        this.message = message;
        this.type = type;
    }

    @Override
    public String toString() {
        return "ApiError{"
               + "dateOccurred=" + dateOccurred.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
               + ", message='" + message + '\''
               + ", type='" + type + '\''
               + '}';
    }
}

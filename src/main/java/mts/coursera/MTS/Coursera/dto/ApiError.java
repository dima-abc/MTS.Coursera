package mts.coursera.MTS.Coursera.dto;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

/**
 * DTO модель для отображения деталей исключения.
 *
 * @author Dmitry Stepanov, user Dmitry
 * @since 09.02.2024
 */
public class ApiError {
    private OffsetDateTime dateOccurred = OffsetDateTime.now();
    private String message;
    private String type;

    public ApiError() {
    }

    public ApiError(String message, String type) {
        this.message = message;
        this.type = type;
    }

    public OffsetDateTime getDateOccurred() {
        return dateOccurred;
    }

    public void setDateOccurred(OffsetDateTime dateOccurred) {
        this.dateOccurred = dateOccurred;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ApiError apiError = (ApiError) o;

        if (!Objects.equals(dateOccurred, apiError.dateOccurred))
            return false;
        if (!Objects.equals(message, apiError.message)) return false;
        return Objects.equals(type, apiError.type);
    }

    @Override
    public int hashCode() {
        int result = dateOccurred != null ? dateOccurred.hashCode() : 0;
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ApiError{" +
               "dateOccurred=" + dateOccurred.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME) +
               ", message='" + message + '\'' +
               ", type='" + type + '\'' +
               '}';
    }
}

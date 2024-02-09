package mts.coursera.MTS.Coursera.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * DTO модель для отображения деталей исключения.
 *
 * @author Dmitry Stepanov, user Dmitry
 * @since 09.02.2024
 */
@Data
@AllArgsConstructor
public class ApiError {
    private String message;
    private String details;
    private String type;
}

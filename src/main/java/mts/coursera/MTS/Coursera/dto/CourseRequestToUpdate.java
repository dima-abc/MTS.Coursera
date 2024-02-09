package mts.coursera.MTS.Coursera.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * DTO модель для редактирования Course
 *
 * @author Dmitry Stepanov, user Dmitry
 * @since 09.02.2024
 */
@Data
@AllArgsConstructor
public class CourseRequestToUpdate {
    private String author;
    private String title;
}

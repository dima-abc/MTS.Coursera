package mts.coursera.MTS.Coursera.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Dmitry Stepanov, user Dmitry
 * @since 09.02.2024
 */
@Data
@AllArgsConstructor
public class CourseRequestToCreate {
    private String author;
    private String title;
}

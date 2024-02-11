package mts.coursera.MTS.Coursera.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Dmitry Stepanov, user Dmitry
 * @since 09.02.2024
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseRequestToCreate {
    @NotBlank(message = "Course author has to be filled")
    private String author;
    @NotBlank(message = "Course title has to be filled")
    private String title;
}

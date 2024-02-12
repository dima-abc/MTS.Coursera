package mts.coursera.MTS.Coursera.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mts.coursera.MTS.Coursera.validation.TitleCase;

/**
 * DTO модель для редактирования Course
 *
 * @author Dmitry Stepanov, user Dmitry
 * @since 09.02.2024
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseRequestToUpdate {
    @TitleCase(titleLang = "EN", message = "Field error language")
    private String author;
    @NotBlank(message = "Course title has to be filled")
    private String title;
}

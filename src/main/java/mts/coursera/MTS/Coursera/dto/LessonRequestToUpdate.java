package mts.coursera.MTS.Coursera.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * LessonRequestToUpdate DTO модель для обновления урока
 *
 * @author Dmitry Stepanov, user Dmitry
 * @since 20.02.2024
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LessonRequestToUpdate {
    private String title;
    private String description;
    private String content;
    private Long themeId;
}

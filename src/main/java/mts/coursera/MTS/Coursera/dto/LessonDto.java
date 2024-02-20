package mts.coursera.MTS.Coursera.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * LessonDto DTO модель для работы с DAO Lesson
 *
 * @author Dmitry Stepanov, user Dmitry
 * @since 20.02.2024
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LessonDto {
    private Long id;
    private String title;
    private String description;
    private String content;
    private Long themeId;

    public LessonDto(Long id) {
        this.id = id;
    }
}

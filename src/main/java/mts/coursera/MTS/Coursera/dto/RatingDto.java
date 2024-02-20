package mts.coursera.MTS.Coursera.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Dmitry Stepanov, user Dmitry
 * @since 20.02.2024
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RatingDto {
    private Long id;
    private Long userId;
    private Long courseId;
    private int rating;

    public RatingDto(Long id) {
        this.id = id;
    }
}

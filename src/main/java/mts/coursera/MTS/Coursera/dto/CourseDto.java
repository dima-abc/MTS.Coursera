package mts.coursera.MTS.Coursera.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

/**
 * @author Dmitry Stepanov, user Dmitry
 * @since 20.02.2024
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDto {
    private Long id;
    private String title;
    private String description;
    private Set<Long> usersId;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate create;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate change;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate remove;
    private int rating;
    private List<Long> modulesId;
    private String tag;

    public CourseDto(Long id) {
        this.id = id;
    }
}

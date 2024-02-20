package mts.coursera.MTS.Coursera.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Dmitry Stepanov, user Dmitry
 * @since 20.02.2024
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ThemeDto {
    private Long id;
    private String title;
    private String description;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate create;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate change;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate remove;
    private String content;
    private Long moduleId;
    private List<Long> lessonsId;

    public ThemeDto(Long id) {
        this.id = id;
    }
}

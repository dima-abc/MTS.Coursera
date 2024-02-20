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
public class ModuleDto {
    private Long id;
    private String title;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate create;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate change;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate remove;
    private Long courseId;
    private List<Long> themesId;

    public ModuleDto(Long id) {
        this.id = id;
    }
}

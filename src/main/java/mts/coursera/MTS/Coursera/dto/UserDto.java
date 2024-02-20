package mts.coursera.MTS.Coursera.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

/**
 * @author Dmitry Stepanov, user Dmitry
 * @since 20.02.2024
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String nickName;
    private String password;
    private String nameSurname;
    private String email;
    private String avatar;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate create;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate change;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate remove;
    private Set<Long> coursesId;
    private boolean accessAdmin;

    public UserDto(Long id) {
        this.id = id;
    }
}

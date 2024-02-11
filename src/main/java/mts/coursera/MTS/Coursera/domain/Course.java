package mts.coursera.MTS.Coursera.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author Dmitry Stepanov, user Dmitry
 * @since 08.02.2024
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Course {
    @EqualsAndHashCode.Include
    private long id;
    private String author;
    private String title;
}

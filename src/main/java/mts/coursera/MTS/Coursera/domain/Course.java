package mts.coursera.MTS.Coursera.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Dmitry Stepanov, user Dmitry
 * @since 08.02.2024
 */
@Data
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Course {
    @EqualsAndHashCode.Include
    private long id;
    private String author;
    private String title;
}

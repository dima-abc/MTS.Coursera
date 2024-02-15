package mts.coursera.MTS.Coursera.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * DateUser - дата автор
 * LocalDateTime - дата
 * User - автор
 *
 * @author Dmitry Stepanov, user Dmitry
 * @since 15.02.2024
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "date_user")
public class DateUser {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "date_time", nullable = false)
    private LocalDateTime dateTime;
    @ManyToOne(optional = false)
    private User author;
}


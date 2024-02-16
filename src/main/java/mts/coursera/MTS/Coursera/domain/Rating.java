package mts.coursera.MTS.Coursera.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * !!! Модель Rating - Рейтинг курса: !!!
 * User - Пользователи,
 * Course course - фильтр по курсам,
 * Int rating - оценка
 *
 * @author Dmitry Stepanov, user Dmitry
 * @since 15.02.2024
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "rating")
public class Rating {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    @ManyToOne(optional = false)
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    private Course course;
    @Column(name = "rating")
    private int rating;
}

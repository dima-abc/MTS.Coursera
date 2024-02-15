package mts.coursera.MTS.Coursera.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Модель Lesson - урок в модуле (задание).
 * String title - название.
 * String text - описание.
 * DateUser create - дата и автор создания.
 * DateUser change - дата и время изменения.
 * DateUser remove - дата и время удаления.
 * String content - контент.
 *
 * @author Dmitry Stepanov, user Dmitry
 * @since 13.02.2024
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "lesson")
public class Lesson implements Serializable {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title")
    private String title;
    @Lob
    @Column(name = "text")
    private String text;
    @ManyToOne(optional = false)
    private Course course;
}

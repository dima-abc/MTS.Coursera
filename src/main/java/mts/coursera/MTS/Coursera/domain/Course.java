package mts.coursera.MTS.Coursera.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * !!! Модель Course - курс !!!
 * String title - название.
 * String description - описание.
 * DateUser create - дата и автор создания.
 * DateUser change - дата и время изменения.
 * DateUser remove - дата и время удаления.
 * Int rating - рейтинг курса.
 * Module[] modules - модули входящие в курс.
 * String teg - прописывается вручную, может быть любым.
 * Enum category - создается преподавателем, выбирается из списка создается преподавателем, выбирается из списка
 *
 * @author Dmitry Stepanov, user Dmitry
 * @since 08.02.2024
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "course", schema = "my_course")
public class Course implements Serializable {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "description")
    private String description;
    @ManyToOne()
    private DateUser create;
    @ManyToOne()
    private DateUser change;
    @ManyToOne()
    private DateUser remove;
    @Column(name = "rating")
    private int rating;
    @OneToMany(mappedBy = "course", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Module> modules;
    @Column(name = "author", nullable = false)
    private String author;
}

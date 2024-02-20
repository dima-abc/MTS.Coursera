package mts.coursera.MTS.Coursera.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

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
@Table(name = "course", schema = "my_courses")
public class Course implements Serializable {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "description")
    private String description;
    @ManyToMany
    @JoinTable(
            name = "courses_users", schema = "my_courses",
            joinColumns = {@JoinColumn(name = "course_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")}
    )
    private Set<User> users;
    @Column(name = "create", nullable = false)
    private LocalDate create;
    @Column(name = "change")
    private LocalDate change;
    @Column(name = "remove")
    private LocalDate remove;
    @Column(name = "rating")
    private int rating;
    @OneToMany(mappedBy = "course", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Module> modules;
    @Column(name = "tag")
    private String tag;
}

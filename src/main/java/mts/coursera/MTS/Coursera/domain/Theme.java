package mts.coursera.MTS.Coursera.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * !!! Модель Theme - тема. !!!
 * String title - название.
 * String description - описание.
 * DateUser create - дата и автор создания.
 * DateUser change - дата и время изменения.
 * DateUser remove - дата и время удаления.
 * String content - контент.
 *
 * @author Dmitry Stepanov, user Dmitry
 * @since 15.02.2024
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "theme")
public class Theme implements Serializable {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "create", nullable = false)
    private LocalDate create;
    @Column(name = "change")
    private LocalDate change;
    @Column(name = "remove")
    private LocalDate remove;
    @Column(name = "content")
    private String content;
    @ManyToOne(optional = false)
    @JoinColumn(name = "module_id", referencedColumnName = "id")
    private Module module;
    @OneToMany(mappedBy = "theme", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Lesson> lesson;

}

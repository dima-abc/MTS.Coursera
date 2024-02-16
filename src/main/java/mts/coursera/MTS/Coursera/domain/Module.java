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
 * !!! Модель Module - модуль !!!
 * String title - название.
 * String description - описание.
 * DateUser create - дата автор создания
 * DateUser change - дата автор изменения
 * DateUser remove - дата и время удаления.
 *
 * @author Dmitry Stepanov, user Dmitry
 * @since 15.02.2024
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "module")
public class Module implements Serializable {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title")
    private String title;
    @Lob
    @Column(name = "description")
    private String description;
    @Column(name = "create", nullable = false)
    private LocalDate create;
    @Column(name = "change")
    private LocalDate change;
    @Column(name = "remove")
    private LocalDate remove;
    @ManyToOne(optional = false)
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    private Course course;
    @OneToMany(mappedBy = "module", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Theme> themes;
}

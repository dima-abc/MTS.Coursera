package mts.coursera.MTS.Coursera.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

/**
 * !!! Модель User - пользователь: !!!
 * String nickname - никнейм,
 * String password - пароль,
 * String nameSurname - имя и фамилия,
 * String email - электронная почта,
 * String avatar - аватарка,
 * LocalDate create - дата создания
 * DateUser change - дата автор изменения
 * DateUser remove - дата и время удаления.
 * Course[] courses - принадлежность к курсу,
 * boolean accessAdmin - право доступа к админке,
 *
 * @author Dmitry Stepanov, user Dmitry
 * @since 15.02.2024
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "user")
public class User implements Serializable {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nick_name", nullable = false)
    private String nickName;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "name_surname")
    private String nameSurname;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "avatar")
    private String avatar;
    @Column(name = "create", nullable = false)
    private LocalDate create;
    @Column(name = "change")
    private LocalDate change;
    @Column(name = "remove")
    private LocalDate remove;
    @ManyToMany(mappedBy = "users")
    private Set<Course> courses;
    @Column(name = "access_admin")
    private boolean accessAdmin;
}

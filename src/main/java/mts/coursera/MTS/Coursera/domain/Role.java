package mts.coursera.MTS.Coursera.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * Role класс определяет роли пользователей Spring Security
 *
 * @author Dmitry Stepanov, user Dmitry
 * @since 21.02.2024
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "roles", schema = "my_courses")
public class Role {
    @EqualsAndHashCode.Include
    @Id
    private Long id;
    private String name;
    @ManyToMany
    private Set<UserPrincipal> userPrincipal;
}

package mts.coursera.MTS.Coursera.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Dmitry Stepanov, user Dmitry
 * @since 21.02.2024
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "users", schema = "my_courses")
public class UserPrincipal {
    @EqualsAndHashCode.Include
    @Id
    private Long id;
    @Column(name = "username")
    private String userName;
    private String password;
    @ManyToMany(mappedBy = "userPrincipal")
    private Set<Role> roles = new HashSet<>();
}

package mts.coursera.MTS.Coursera.repository;

import mts.coursera.MTS.Coursera.domain.UserPrincipal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Dmitry Stepanov, user Dmitry
 * @since 21.02.2024
 */
@Repository
public interface UserPrincipalRepository extends CrudRepository<UserPrincipal, Long> {
    Optional<UserPrincipal> findByUserName(String userName);
}

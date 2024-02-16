package mts.coursera.MTS.Coursera.repository;

import mts.coursera.MTS.Coursera.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository модели UserRepositoryDB
 *
 * @author Dmitry Stepanov, user Dmitry
 * @since 16.02.2024
 */
public interface UserRepositoryDB extends CrudRepository<User, Long> {
}

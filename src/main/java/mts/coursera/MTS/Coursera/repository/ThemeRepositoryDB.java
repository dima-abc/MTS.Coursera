package mts.coursera.MTS.Coursera.repository;

import mts.coursera.MTS.Coursera.domain.Theme;
import org.springframework.data.repository.CrudRepository;

/**
 * ThemeRepositoryDB слой репозитория для работы с базой данных модели Theme
 *
 * @author Dmitry Stepanov, user Dmitry
 * @since 20.02.2024
 */
public interface ThemeRepositoryDB extends CrudRepository<Theme, Long> {
}

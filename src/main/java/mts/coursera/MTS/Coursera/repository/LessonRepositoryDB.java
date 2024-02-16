package mts.coursera.MTS.Coursera.repository;

import mts.coursera.MTS.Coursera.domain.Lesson;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository модели Lesson
 *
 * @author Dmitry Stepanov, user Dmitry
 * @since 16.02.2024
 */
public interface LessonRepositoryDB extends CrudRepository<Lesson, Long> {
}

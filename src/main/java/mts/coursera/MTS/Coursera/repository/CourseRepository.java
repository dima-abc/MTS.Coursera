package mts.coursera.MTS.Coursera.repository;

import mts.coursera.MTS.Coursera.domain.Course;

import java.util.List;
import java.util.Optional;

/**
 * @author Dmitry Stepanov, user Dmitry
 * @since 08.02.2024
 */
public interface CourseRepository {

    Course save(Course course);

    List<Course> findAll();

    Optional<Course> findById(Long id);

    boolean delete(Long id);
}

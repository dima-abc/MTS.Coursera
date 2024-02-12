package mts.coursera.MTS.Coursera.service;

import mts.coursera.MTS.Coursera.domain.Course;

import java.util.List;
import java.util.Optional;

/**
 * @author Dmitry Stepanov, user Dmitry
 * @since 08.02.2024
 */
public interface CourseService {

    Course save(Course course);

    List<Course> findAll();

    Optional<Course> findById(Long id);

    List<Course> findByTitleWithPrefix(String prefix);

    void delete(Long id);
}

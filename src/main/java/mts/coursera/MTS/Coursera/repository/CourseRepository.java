package mts.coursera.MTS.Coursera.repository;

import mts.coursera.MTS.Coursera.domain.Course;

import java.util.List;

/**
 * @author Dmitry Stepanov, user Dmitry
 * @since 08.02.2024
 */
public interface CourseRepository {
    List<Course> findAll();
}

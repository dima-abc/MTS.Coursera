package mts.coursera.MTS.Coursera.service;

import mts.coursera.MTS.Coursera.domain.Course;

import java.util.List;

/**
 * @author Dmitry Stepanov, user Dmitry
 * @since 08.02.2024
 */
public interface CourseService {
    List<Course> findAll();
}

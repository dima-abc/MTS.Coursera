package mts.coursera.MTS.Coursera.repository;

import mts.coursera.MTS.Coursera.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Dmitry Stepanov, user Dmitry
 * @since 12.02.2024
 */
@Repository
public interface CourseRepositoryDB extends JpaRepository<Course, Long> {

    List<Course> findByTitleLike(String title);
}

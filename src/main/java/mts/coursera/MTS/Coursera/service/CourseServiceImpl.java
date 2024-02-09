package mts.coursera.MTS.Coursera.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mts.coursera.MTS.Coursera.domain.Course;
import mts.coursera.MTS.Coursera.repository.CourseRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Dmitry Stepanov, user Dmitry
 * @since 08.02.2024
 */
@Service("courseServiceImpl")
@Primary
@AllArgsConstructor
@Slf4j
public class CourseServiceImpl implements CourseService {
    private final CourseRepository repository;

    @Override
    public Course save(Course course) {
        return repository.save(course);
    }

    @Override
    public List<Course> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Course> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Course> findByTitleWithPrefix(String prefix) {
        return repository.findByTitlePrefix(prefix);
    }

    @Override
    public boolean delete(Long id) {
        return repository.delete(id);
    }
}
